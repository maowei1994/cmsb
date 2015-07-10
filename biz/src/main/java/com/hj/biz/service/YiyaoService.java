package com.hj.biz.service;

import com.hj.client.object.GraphData;
import com.hj.client.object.list.*;
import com.hj.dal.domain.dataobject.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * �ṩ��������ҽҩ����ĺ��Ľӿ�
 *
 * @author tinglang (editice@gmail.com)
 * @since 2015/2/1  13:19
 */
public interface YiyaoService {

    /**
     * �����û������ҩƷ����ҵ�����ṩ���빦��
     *
     * @param queryString
     * @return
     */
    String getSearchAssociation(Map<String, String> queryString);

    /**
     * �����û��ύ�������ȡ�ض���ͼ��ʵ��
     */
    GraphData getGraphData(Map<String, String> queryString);

    /**
     * �����û��ύ�Ĳ�ѯ�����ȡ��ϸ��ҩƷ�����б�
     * @param cpmc
     * @param pageIndex
     * @param pageSize
     * @return
     */
    List<YpBasicInfo> getYpBasicInfo(String cpmc, int pageIndex, int pageSize);
    List<YpPwBasicInfo> getYpPwBasicInfo(String cpmc,int pageIndex,int pageSize);
    List<YpPowerInfo> getYpPowerInfo(String cpmc,int pageIndex,int pageSize,boolean blur);

    List<YgyZdcsSaleDO> getZdcsSale(String cpmc,int pageIndex,int pageSize);
    List<YgyZdcsSaleDO> getZdcsSaleByQy(String qy,int pageIndex,int pageSize);

    List<CMSBDO> getYPPwRankInfo(String cpmc,int pageIndex,int pageSize);
    List<CMSBDO> getYpAll(int pageIndex,int pageSize);
    List<CMSBDO> getQyPwRankInfo(String cpmc,int pageIndex,int pageSize);
    List<CMSBDO> getQyAll(int pageIndex,int pageSize);
    List<CMSBDO> getQxQyAll(int pageIndex,int pageSize);

    List<QyBasicInfo> getQyBasicInfo(String qy,int pageIndex,int pageSize);
    List<QyPwBasicInfo> getQyPwBasicInfo(String qy,int pageIndex,int pageSize);

    List<QyPowerInfo> getQyPowerInfo(String qy, int pageIndex, int pageSize);
    List<QyPowerDetailInfo> getQyPowerDetailInfo(String qy,int pageIndex,int pageSize,List<YgyZdcsSaleDO> saleDOs);

    List<SfdaQxDO> getQxInfo(String name,int pageIndex,int pageSize,Map<String,String> attr);
    List<SfdaQxDO> getQxInfoByQy(String name, int pageIndex, int pageSize, Map<String, String> attr);

    List<Integer> getQxQyStructCnt(List<SfdaQxDO> qxDOList);

    List<LawData> getLawInfo(LawData lawData, int idx, int idv, Map<String, String> stringStringMap);
    List<LawData> getLawInfoById(long id, int idx, int idv);
    int insertLawInfo(List<LawData> lawDatas, int idx, int idv, Map<String,String> attr);

    List<RsData> getRsInfo(RsData rsData, int idx, int idv, Map<String, String> attr);
    List<RsData> getRsInfoById(long id, int idx, int idv);
    int insertRsInfo(List<RsData> rsDatas, int idx, int idv, Map<String,String> attr);

    List<YYBasicInfo> getYyBasicInfo(Map<String, Object> query, int idx, int idv);
    List<YYBasicInfo> getYyBasicInfoByYymc(String yymc, int idx, int idv);

    List<YiyuanCntDO> getYiyuanCntDOs(int idx, int idv);

    List<CpmcZcDO> getCpmcZc(Map<String, Object> query, int pageIndex, int pageSize);

    List<CpmcZcDO> getCpmcZcByYpmc(String ypmc, int idx, int idv);

    List<CpmcZcDO> getCpmcZcByQym(String qym, int idx, int idv, Map<String, String> attr);

    List<CMSBDO> getZcYpAll(int idx, int idv);

    List<CMSBDO> getZcQyBasicInfo(String qym, int pageIndex, int pageSize, Map<String, String> attr);
}
