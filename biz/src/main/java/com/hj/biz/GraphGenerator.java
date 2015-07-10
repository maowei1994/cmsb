package com.hj.biz;

import com.hj.client.object.GraphData;
import com.hj.client.object.graph.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ͼ���������ɻ��ָ࣬���������
 *
 * @author tinglang (editice@gmail.com)
 * @since 2015/2/1  14:14
 */
public abstract class GraphGenerator {

    public static final Logger logger = LoggerFactory.getLogger(GraphGenerator.class);

    /**
     * �����ݿ��ѯ����������Ϣ
     */
    protected GraphIn graphIn;

    /**
     * ͼ�������Ϣ
     */
    protected GraphData graphData;

    protected Title title;
    protected ToolTip toolTip;
    protected Legend legend;
    protected XAxis xAxis;
    protected YAxis yAxis;
    protected Series series;

    protected DataTip dataTip;


    public GraphGenerator(GraphIn graphIn) {
        this.graphIn = graphIn;
        this.graphData = new GraphData();
        this.title = new Title();
        this.toolTip = new ToolTip();
        this.legend = new Legend();
        this.xAxis = new XAxis();
        this.yAxis = new YAxis();
        this.series = new Series();
        this.dataTip = new DataTip();
    }

    public GraphData generate() {
        //��ʼ��
        init();

        genTitle();
        genToolTip();
        genLegend();
        genXAxis();
        genYAxis();
        genSeries();
        genDataTip();

        //���ͼ������
        fillBody();
        return graphData;
    }

    private void fillBody() {
        graphData.setTitle(title);
        graphData.setToolTip(toolTip);
        graphData.setLegend(legend);
        graphData.setXAxis(xAxis);
        graphData.setYAxis(yAxis);
        graphData.setSeries(series);
        graphData.setDataTip(dataTip);
    }

    protected abstract void init();

    protected abstract void genTitle();

    protected abstract void genToolTip();

    protected abstract void genLegend();

    protected abstract void genXAxis();

    protected abstract void genYAxis();

    protected abstract void genSeries();

    protected abstract void genDataTip();
}
