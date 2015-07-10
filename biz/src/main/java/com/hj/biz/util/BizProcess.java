package com.hj.biz.util;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * ͼ��ӳ����
 * @author tinglang (editice@gmail.com)
 * @since 2015/2/7  20:42
 */
public class BizProcess {

    public static final String BASE_PACKAGE = "com.hj.biz.generator.";

    public static final String YAO_PW_RANK_GEN="YaoPwRankGen";
    public static final String YAO_JX_PRO_GEN="YaoJxProGen";
    public static final String YAO_CP_PRO_GEN="YaoCpProGen";

    public static final String POWER_QY_PRO_GEN="PowerQyProGen";
    public static final String POWER_JX_PRO_GEN="PowerJxProGen";
    public static final String POWER_INCR_PRO_GEN="PowerIncrProGen";

    public static final String QY_PW_RANK_GEN="QyPwRankGen";
    public static final String QY_JX_PRO_GEN="QyJxProGen";
    public static final String QY_CP_PRO_GEN="QyCpProGen";

    public static final String QY_POWER_CP_PRO_GEN = "QyPowerCpProGen";
    public static final String QY_POWER_ZL_PRO_GEN = "QyPowerZlProGen";
    public static final String QY_POWER_JY_PRO_GEN = "QyPowerJyProGen";
    public static final String QY_POWER_YB_PRO_GEN = "QyPowerYbProGen";
    public static final String QY_POWER_OTC_PRO_GEN = "QyPowerOTCProGen";
    public static final String QY_POWER_SALE_ZONE_PRO_GEN = "QyPowerSaleZoneProGen";
    public static final String QY_POWER_SALE_TREND_PRO_GEN = "QyPowerSaleTrendProGen";

    public static final String QX_GCJK_PRO_GEN="QxGcjkProGen";

    public static final String QX_QY_RANK_PRO_GEN="QxQyRankProGen";

    public static final String YY_CWS_ALL_RANK_GEN="YyCwsAllRankGen";
    public static final String YY_CWS_PROVINCE_RANK_GEN="YyCwsProvinceRankGen";
    public static final String YY_RMZL_ALL_RANK_GEN="YyRmzlAllRankGen";
    public static final String YY_RMZL_PROVINCE_RANK_GEN="YyRmzlProvinceRankGen";

    public static final String ZC_POWER_RANK_PRO_GEN="ZcPowerRankProGen";
    public static final String ZC_YPLX_PRO_GEN="ZcYplxProGen";
    public static final String ZC_SQLX_PRO_GEN="ZcSqlxProGen";
    public static final String ZC_ZCFL_PRO_GEN="ZcZcflProGen";
    public static final String ZC_PSZT_PRO_GEN="ZcPsztProGen";

    public static final String ZC_QY_YPLX_PRO_GEN="ZcQyYplxProGen";
    public static final String ZC_QY_SQLX_PRO_GEN="ZcQySqlxProGen";
    public static final String ZC_QY_PSZT_PRO_GEN="ZcQyPsztProGen";


    public static final int UP_COUNT = 10;


    static Map<String,String> map= Maps.newHashMap();
    static{
        //ҩƷ������Ϣ
        map.put("base_yppwLine", YAO_PW_RANK_GEN);   //ҩƷ������������
        map.put("base_jxPie", YAO_JX_PRO_GEN);   // ����ռ��
        map.put("base_pcPie",YAO_CP_PRO_GEN);//��Ʒ����ռ��

        //ҩƷ����������
        map.put("power_ypqyPie",POWER_QY_PRO_GEN);//ҩƷ����ҵ����ռ��
        map.put("power_ypjxPie",POWER_JX_PRO_GEN);//ҩƷ����������ռ��
        map.put("power_qyLine",POWER_INCR_PRO_GEN); //��ҵ����

        //��ҵ���ĺ���Ϣ
        map.put("piwen_rank",QY_PW_RANK_GEN);//��ҵ��������
        map.put("piwen_jxPie",QY_JX_PRO_GEN);//��ҵ��������ռ��
        map.put("piwen_qyPie",QY_CP_PRO_GEN); //��ҵ��Ʒ����ռ��

        //��ҵ��Ʒ�߾���������
        map.put("qypower_cpPie",QY_POWER_CP_PRO_GEN); //��ҩƷ����ռ��
        map.put("qypower_zlPie",QY_POWER_ZL_PRO_GEN); //��ҩƷ������������ռ��
        map.put("qypower_jyPie",QY_POWER_JY_PRO_GEN);//�Ƿ��ҩ����ռ��
        map.put("qypower_ybPie",QY_POWER_YB_PRO_GEN);//ҽ���������ռ��
        map.put("qypower_otcPie",QY_POWER_OTC_PRO_GEN); //OTC�������ռ��
        map.put("qypower_salezone",QY_POWER_SALE_ZONE_PRO_GEN);//���������ͼ
        map.put("qypower_saleline",QY_POWER_SALE_TREND_PRO_GEN); //������������

        //ҽ����е��Ʒ��ѯ
        map.put("qx_from",QX_GCJK_PRO_GEN);

        //ҽ����е��ҵ��Ʒ�ṹ��ѯ
        map.put("qxQy_rank",QX_QY_RANK_PRO_GEN);

        //ȫ���ȼ�ҽԺ��ѯ
        map.put("yy_cws_all_rank",YY_CWS_ALL_RANK_GEN);
        map.put("yy_cws_province_rank",YY_CWS_PROVINCE_RANK_GEN);
        map.put("yy_rmzl_all_rank",YY_RMZL_ALL_RANK_GEN);
        map.put("yy_rmzl_province_rank",YY_RMZL_PROVINCE_RANK_GEN);

        //ҩƷע���걨��ѯ
        map.put("zc_power_rank",ZC_POWER_RANK_PRO_GEN);
        map.put("zc_yplx",ZC_YPLX_PRO_GEN);
        map.put("zc_sqlx",ZC_SQLX_PRO_GEN);
        map.put("zc_zcfl",ZC_ZCFL_PRO_GEN);
        map.put("zc_pszt",ZC_PSZT_PRO_GEN);

        //ҩ��ע���걨��ѯ
        map.put("zc_qy_yplx",ZC_QY_YPLX_PRO_GEN);
        map.put("zc_qy_sqlx",ZC_QY_SQLX_PRO_GEN);
        map.put("zc_qy_pszt",ZC_QY_PSZT_PRO_GEN);

    }

    public static String getBizClass(String bizKey){
        return map.get(bizKey);
    }

}
