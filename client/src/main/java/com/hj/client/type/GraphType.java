package com.hj.client.type;

/**
 * ͼ�����ͣ�����ͼline����ͼpie������ͼbar������series����
 *
 * @author tinglang (editice@gmail.com)
 * @since 2015/2/1  12:48
 */
public enum GraphType {

    LINE("line"),

    BAR("bar"),

    MAP("map"),

    K("k"),//k��ͼ

    FORCE("force"),//������ͼ

    SCATTER("scatter"),//ɢ��ͼ

    PIE("pie");

    String desc;

    GraphType(String desc) {
        this.desc = desc;
    }

    public GraphType of(String type) {
        for (GraphType graphType : GraphType.values()) {
            if (graphType.desc.equals(type)) {
                return graphType;
            }
        }
        return GraphType.PIE;
    }
}
