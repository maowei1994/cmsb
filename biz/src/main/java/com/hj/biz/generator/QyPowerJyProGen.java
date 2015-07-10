package com.hj.biz.generator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hj.biz.GraphGenerator;
import com.hj.biz.GraphIn;
import com.hj.biz.util.GraphUtil;
import com.hj.client.object.ValuePair1;
import com.hj.client.object.ValuePair2;
import com.hj.client.object.list.QyPowerDetailInfo;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @author tinglang (editice@gmail.com)
 * @since 2015/2/15  15:48
 */
public class QyPowerJyProGen extends GraphGenerator {
    public static final BizKey QyPowerJyProGen=new BizKey(43,"��ҵ�Ƿ��ҩ������۶�ռ��","pie");

    Map<String,Long> map= Maps.newHashMap();

    public QyPowerJyProGen(GraphIn graphIn) {
        super(graphIn);
        logger.info(QyPowerJyProGen.toString());
    }

    @Override
    protected void init() {
        List<QyPowerDetailInfo> sales = graphIn.getQyPowerDetailInfos();
        if (CollectionUtils.isEmpty(sales)) {
            return;
        }
        for (QyPowerDetailInfo saleDO : sales) {
            String name = saleDO.getIsJy();
            long sale = saleDO.getSale();
            if (map.containsKey(name)) {
                map.put(name, map.get(name) + sale);
            }
            else {
                map.put(name, sale);
            }
        }
        map= GraphUtil.extra2(map);
    }

    @Override
    protected void genTitle() {
        title.setText("�Ƿ��ҩ����ռ��");
    }

    @Override
    protected void genToolTip() {

    }

    @Override
    protected void genLegend() {
        List<String> list= Lists.newArrayList();
        for(String s: map.keySet()){
            list.add(s);
        }
        legend.setData(list);
    }

    @Override
    protected void genXAxis() {

    }

    @Override
    protected void genYAxis() {

    }

    @Override
    protected void genSeries() {
        List<ValuePair2>  list=Lists.newArrayList();
        for(String s: map.keySet())
        {
            ValuePair2 pair1=new ValuePair2();
            pair1.setName(s);
            long v= map.get(s);
            pair1.setValue(v);
            list.add(pair1);
        }
        series.setData(list);
    }

    @Override
    protected void genDataTip() {

    }
}
