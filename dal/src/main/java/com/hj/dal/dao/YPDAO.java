package com.hj.dal.dao;

import com.hj.client.object.list.QyPowerInfo;
import com.hj.dal.domain.dataobject.*;

import java.util.List;
import java.util.Map;

/**
 * ҩƷ��Ϣ����
 *
 * @author tinglang (editice@gmail.com)
 * @since 2015/1/31  14:59
 */
public interface YPDAO {

    /**
     * �����û�����ļ�����ģ��ƥ����ܴ����ҩƷ
     *
     * @param qStr
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<String> getYpSearchStr(String qStr, int pageIndex, int pageSize,Map<String,String>attr);

    public List<CMSBDO> getYpSearchAll(int pageIndex,int pageSize);


    /**
     * �����û�����ļ�����ģ��ƥ����ܴ������ҵ
     *
     * @param qStr
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<String> getQySearchStr(String qStr, int pageIndex, int pageSize,Map<String,String>attr);

    public List<CMSBDO> getQySearchAll(int pageIndex,int pageSize);

    /**
     * �����û�����Ĳ�Ʒ���ƻ�ȡ����ҩƷ��Ϣ
     *
     * @param cpmc
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<SfdaGcypDO> getGcYpByCpmc(String cpmc, int pageIndex, int pageSize, Map<String, String> attr);

    public List<SfdaGcypDO> getGcYpByQy(String qy,int pageIndex,int pageSize,Map<String,String> attr);

    /**
     * �����û�����Ĳ�Ʒ���ƻ�ȡ����ҩƷ��Ϣ
     *
     * @param cpmc
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<SfdaJkypDO> getJkYpByCpmc(String cpmc, int pageIndex, int pageSize, Map<String, String> attr);

    public List<SfdaJkypDO> getJkYpByQy(String qy,int pageIndex,int pageSize,Map<String,String> attr);

    /**
     * �����û�����Ĳ�Ʒ���ƻ�ȡ����ҩ����Ϣ
     *
     * @param cpmc
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<SfdaJbywDO> getJbYwByCpmc(String cpmc, int pageIndex, int pageSize);

    /**
     * �����û�����Ĳ�Ʒ���ƻ�ȡҽ�������Ϣ
     *
     * @param cpmc
     * @param pageIndex
     * @param pageSize
     * @return
     */
    public List<MenetYibaoDO> getYbYwByCpmc(String cpmc, int pageIndex, int pageSize);

    public List<Boolean> isJbYw(List<String> cpmc);

    public List<Boolean> isYbYw(List<String> cpmc);

    public List<String> getYblx(List<String> cpmc);

    public List<String> getOTCfl(List<String> cpmc);

    public List<CMSBDO> getYPPWRank(String cpmc, int pageIndex, int pageSize);

    public List<CMSBDO> getQyPWRank(String qy, int pageIndex, int pageSize);

    public List<XywyJcxxDO> getXywyJcxx(String cpmc, int pageIndex, int pageSize, Map<String, String> attr);

    public List<YgyZdcsSaleDO> getZdcsSale(String cpmc, int pageIndex, int pageSize, Map<String, String> attr);

    public List<YgyZdcsSaleDO> getZdcsSaleByQy(String qy, int pageIndex, int pageSize, Map<String, String> attr);

    List<QyPowerInfo> getQyPowerInfo(String qy, int pageIndex, int pageSize, Map<String, String> attr);

    List<CMSBDO> getZcYpAll(int idx, int idv);
}
