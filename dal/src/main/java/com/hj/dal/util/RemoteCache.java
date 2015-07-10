package com.hj.dal.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Lists.newArrayList;
import static java.util.Collections.emptyList;

/**
 * �˻�����Ҫ�ֹ�ָ�� ID�������Ҫ memoize ������Ҫ�ڴ˻������ٷ�һ�㡣
 */
public final class RemoteCache {
    // class, id => cached instance
    private final Map<Class<?>, Map<Object, Object>> cache = Maps.newHashMap();

    private static final Logger logger=LoggerFactory.getLogger(RemoteCache.class);

    private boolean needHoldRemoteCache = false;

    private static final class Null {
    }

    /**
     * ��������Դ� null����ֹ��ΪԶ�̷��� null ����������Զ�̡�
     */
    private static final Null NULL = new Null();

    // RemoteCache �ǵ��������������ò⡣���Ǽ���һ��ֻ������ʹ�õĹ���������
    RemoteCache() {
    }

    public static RemoteCache instance() {
        return inst.get();
    }

    // һ���̶߳�Ӧһ�� RemoteCache ʵ��
    private static final ThreadLocal<RemoteCache> inst = new ThreadLocal<RemoteCache>() {
        @Override
        protected RemoteCache initialValue() {
            return new RemoteCache();
        }
    };

    /**
     * ��Ҫ����Ķ�����뻺���С�
     *
     * @param klass    Ҫ������������
     * @param id       Ҫ�������� ID
     * @param instance Ҫ��������ʵ��
     * @param <T>      Ҫ������������
     */
    public final <T> void put(Class<? super T> klass, Object id, @Nullable T instance) {
        if (instance != null)
            checkArgument(klass.isInstance(instance), "incompatible class and instance");

        @SuppressWarnings({"MismatchedQueryAndUpdateOfCollection"})
        Map<Object, Object> idToInstanceCache = getIdToInstanceCache(klass);

        if (instance != null) {
            idToInstanceCache.put(id, instance);
        }
        else {
            idToInstanceCache.put(id, NULL);
        }
        if (idToInstanceCache.size() > 1000) {
            logger.warn("RemoteCache: idToInstanceCache too large! size = " + idToInstanceCache.size() + ", class = " + klass);
        }
    }

    /**
     * �������������뻺�档�����������Щʵ����������ͨ�� ID ������ȡ���������ԣ�
     * {@code ids} �� {@code instances} ��ֵ������һһ��Ӧ�ġ�
     *
     * @param klass     Ҫ������������
     * @param ids       Ҫ�������� ID �б�
     * @param instances �� ID �б��Ӧ��ʵ���б�ע��Ҫ����
     * @param <T>       Ҫ������������
     */
    public final <T> void batchPut(Class<? super T> klass, List<?> ids, List<? extends T> instances) {
        checkArgument(ids.size() == instances.size(), "incompatible ids and instances");

        Iterator<?> idsItr = ids.iterator();
        Iterator<? extends T> instancesItr = instances.iterator();

        while (idsItr.hasNext()) {
            Object id = idsItr.next();
            T instance = instancesItr.next();
            if (instance != null)
                checkArgument(klass.isInstance(instance), "incompatible class and instance");

            put(klass, id, instance);
        }
    }

    /**
     * ��ָ�������ͺ� ID ��ȡ�����еĶ������û�У��򷵻� {@code null}��
     *
     * @param klass �������������ͣ������� put ʱһ�£������ò�����
     * @param id    ���������� ID
     * @param <T>   ��������������
     */
    @Nullable
    public final <T> T get(Class<T> klass, Object id) {
        return get(klass, id, null);
    }

    /**
     * ��ָ�������ͺ� ID ��ȡ�����еĶ������û�У��򷵻� {@code callbackOnMiss}
     * �ĵ��ý�����˵��ý���ᱻ�Զ����������������� {@code get/batchGet} ����
     * ����ӻ�����ȡ�����
     *
     * @param klass          �������������ͣ������� put ʱһ�£������ò�����
     * @param id             ���������� ID
     * @param callbackOnMiss �������û������ʱ�Ļص�
     * @param <T>            ��������������
     */
    @Nullable
    public final <T> T get(Class<T> klass, Object id, @Nullable Callable<? extends T> callbackOnMiss) {
        Object ret = get0(klass, id, callbackOnMiss);
        if (ret == NULL) {
            return null;
        }
        //noinspection unchecked
        return (T) ret;
    }

    @Nullable
    private <T> Object get0(Class<T> klass, Object id, @Nullable Callable<? extends T> callbackOnMiss) {
        Map<Object, Object> idToInstanceCache = cache.get(klass);
        Object ret = idToInstanceCache == null ? null : idToInstanceCache.get(id);

        if (ret == NULL) {
            return NULL;
        }
        if (ret != null) {
            return ret;
        }

        if (callbackOnMiss != null) {
            try {
                T callbackRet = callbackOnMiss.call();

                put(klass, id, callbackRet);

                return callbackRet;
            }
            catch (Exception ex) {
                throw new CallbackOnMissExecutionException(klass, newArrayList(id), ex);
            }
        }

        return null;
    }

    /**
     * ��ָ�������ͺ� ID �б�������ȡ�����������������в������򷵻� {@code null}��
     * ���صı���������б��� {@code ids} ����˳��һ�¡�
     *
     * @param klass �������������ͣ������� put ʱһ�£������ò�����
     * @param ids   ���������� ID �б�
     * @param <T>   ��������������
     */
    @Nonnull
    public final <T> List<T> batchGet(Class<T> klass, List<?> ids) {
        return batchGet(klass, ids, null);
    }

    /**
     * ��ָ�������ͺ� ID �б�������ȡ��������󡣷��صı���������б��� {@code ids}
     * ����˳��һ�¡���������в���������� {@code callbackOnMiss}�����ҷ��ش˻�
     * ���ķ���ֵ��
     *
     * @param klass          ��������������
     * @param ids            ���������� ID �б�
     * @param callbackOnMiss ����û������ʱ�Ļص�
     * @param <T>            ��������������
     */
    @Nonnull
    public final <T> List<T> batchGet(Class<T> klass,
                                      List<?> ids,
                                      @Nullable Callable<List<T>> callbackOnMiss) {
        List<T> cachedInstances = batchGet0(klass, ids);

        if (cachedInstances.size() > ids.size()) {
            throw new IllegalStateException("incorrect cache size. expected ids.size:" +
                                            ids.size() + "but got size:" +
                                            cachedInstances.size());
        }
        if (cachedInstances.size() == ids.size()) {
            return cachedInstances;
        }

        if (callbackOnMiss != null) {
            try {
                List<T> ret = callbackOnMiss.call();

                batchPut(klass, ids, ret);

                return ret;
            }
            catch (Exception ex) {
                throw new CallbackOnMissExecutionException(klass, ids, ex);
            }
        }

        return Collections.emptyList();
    }

    @Nonnull
    final <T> List<T> batchGet0(@Nonnull Class<T> klass,
                                @Nonnull List<?> ids) {
        Iterator<?> idsItr = ids.iterator();

        List<T> ret = Lists.newArrayListWithCapacity(ids.size());

        while (idsItr.hasNext()) {
            Object id = idsItr.next();

            Object cachedInstance = get0(klass, id, null);
            if (cachedInstance == NULL) {
                ret.add(null);
            }
            else if (cachedInstance != null) {
                //noinspection unchecked
                ret.add((T) cachedInstance);
            }
            else {
                return emptyList();
            }
        }

        return ret;
    }

    @Nonnull
    private Map<Object, Object> getIdToInstanceCache(@Nonnull Class<?> klass) {
        Map<Object, Object> ret = cache.get(klass);
        if (ret == null) {
            ret = Maps.newHashMap();
            cache.put(klass, ret);
        }
        return ret;
    }

    /**
     * ��յ�ǰ�̶߳�Ӧ�Ļ��档
     */
    public final void clear() {
        if (!inst.get().needHoldRemoteCache) {
            inst.remove();
        }
    }

    public static void forceClear() {
        inst.remove();
    }


    public static void flagNeedHoldRemoteCache() {
        inst.get().needHoldRemoteCache = true;
    }

    /**
     * ��յ�ǰ�߳�����ָ�����ͻ���Ķ���
     */
    public final void clear(@Nonnull Class<?> klass) {
        @SuppressWarnings({"MismatchedQueryAndUpdateOfCollection"})
        Map<Object, Object> cacheOfClass = cache.get(klass);
        if (cacheOfClass != null) {
            cache.remove(klass);
        }
    }
}
