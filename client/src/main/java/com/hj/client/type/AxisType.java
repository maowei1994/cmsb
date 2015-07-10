package com.hj.client.type;

/**
 * ���������ͣ���Ŀ����Ϊcategory��ֵ����Ϊvalue
 *
 * @author tinglang (editice@gmail.com)
 * @since 2015/2/1  12:52
 */
public enum AxisType {

    CATEGORY("category"),

    TIME("time"),

    VALUE("value");

    String desc;

    AxisType(String desc) {
        this.desc = desc;
    }

    public AxisType of(String desc) {
        for (AxisType axisType : AxisType.values()) {
            if (axisType.desc.equals(desc)) {
                return axisType;
            }
        }
        return AxisType.VALUE;
    }
}
