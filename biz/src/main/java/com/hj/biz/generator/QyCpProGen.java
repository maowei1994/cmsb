package com.hj.biz.generator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hj.biz.GraphGenerator;
import com.hj.biz.GraphIn;
import com.hj.biz.util.GraphUtil;
import com.hj.client.object.ValuePair1;
import com.hj.client.object.list.QyPwBasicInfo;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @author tinglang (editice@gmail.com)
 * @since 2015/2/8  14:20
 */
public class QyCpProGen extends GraphGenerator{

    public static final BizKey QyJxProGen=new BizKey(33,"��ҵ��Ʒ����������ռ��","pie");

    Map<String,Integer> map = Maps.newHashMap();

    public QyCpProGen(GraphIn graphIn) {
        super(graphIn);
        logger.info(QyJxProGen.toString());
    }

    @Override
    protected void init() {
        List<QyPwBasicInfo> pws=graphIn.getQyPwBasicInfos();
        if(CollectionUtils.isEmpty(pws)){
            return;
        }
        for(QyPwBasicInfo ypPwBasicInfo:pws){
            String cplx=ypPwBasicInfo.getCplx();
            if(map.containsKey(cplx)){
                map.put(cplx, map.get(cplx)+1);
            }else{
                map.put(cplx, 1);
            }
        }
        map= GraphUtil.extra1(map);
    }

    @Override
    protected void genTitle() {
        title.setText("��Ʒ����ռ��");
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
        List<ValuePair1>  list=Lists.newArrayList();
        for(String s: map.keySet())
        {
            ValuePair1 pair1=new ValuePair1();
            pair1.setName(s);
            pair1.setValue(map.get(s));
            list.add(pair1);
        }
        series.setData(list);
    }

    @Override
    protected void genDataTip() {

    }
}
