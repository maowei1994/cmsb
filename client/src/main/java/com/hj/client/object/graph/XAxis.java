package com.hj.client.object.graph;

import java.util.List;

/**
 * @author tinglang (editice@gmail.com)
 * @since 2015/2/1  13:54
 */
public class XAxis<T> {
    /**
     * ����������
     */
    String name;

    /**
     * ����������
     */
    String type;

    /**
     * ����������
     */
    List<T> data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
