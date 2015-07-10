package com.hj.biz.generator;

/**
 * ���ڱ�ʶͼ���������ɵ�ҵ��key
 * @author tinglang (editice@gmail.com)
 * @since 2015/2/1  14:31
 */
public class BizKey {

    public  static final BizKey DEFAULT_KEY=new BizKey(-100,"Ĭ������","default");

    final long id;

    final String name;

    final String type;

    public BizKey(long id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "BizKey{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", type='" + type + '\'' +
               '}';
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
