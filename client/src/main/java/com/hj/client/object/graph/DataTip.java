package com.hj.client.object.graph;

import java.util.List;

/**
 * @author tinglang (editice@gmail.com)
 * @since 2015/3/5  22:29
 */
public class DataTip {

    List<String> data;//����

    List<String> value; //��������


    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
