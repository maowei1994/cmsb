package com.hj.dal.domain.dataobject;

import java.util.Date;

/**
 * ����ҩƷ��׼�ĺ�������ݶ���������Դʳҩ���ܾ�-sfda
 * �������������������ݿ������������һ��
 *
 * @author tinglang (editice@gmail.com)
 * @since 2015/1/31  13:31
 */
public class SfdaGcypDO {

    /**
     * ����
     */
    long ID;

    String ROWKEY;

    /**
     * ������ݿ��ѯ
     */
    String relate_database_query;

    /**
     * ��׼����
     */
    Date pzrq;

    /**
     * ����
     */
    String jx;

    /**
     * ҩƷ��λ�뱸ע
     */
    String medicine_standardcode_remarks;

    /**
     * Ӣ������
     */
    String cpmc_en;

    /**
     * ԭ��׼�ĺ�
     */
    String ypzwh;

    /**
     * ��׼�ĺ�
     */
    String pzwh;

    /**
     * ������λ
     */
    String scdw;

    /**
     * ������ַ
     */
    String scdz;

    /*
    ��Ʒ����
     */
    String cpmc_ch;

    /**
     * ҩƷ��λ��
     */
    String ypbwm;

    /**
     * ���
     */
    String gg;

    /**
     * ��Ʒ���
     */
    String cplb;

    /**
     * ע
     */
    String note;

    String spm;

    public String getSpm() {
        return spm;
    }

    public void setSpm(String spm) {
        this.spm = spm;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getROWKEY() {
        return ROWKEY;
    }

    public void setROWKEY(String ROWKEY) {
        this.ROWKEY = ROWKEY;
    }

    public String getRelate_database_query() {
        return relate_database_query;
    }

    public void setRelate_database_query(String relate_database_query) {
        this.relate_database_query = relate_database_query;
    }

    public Date getPzrq() {
        return pzrq;
    }

    public void setPzrq(Date pzrq) {
        this.pzrq = pzrq;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getMedicine_standardcode_remarks() {
        return medicine_standardcode_remarks;
    }

    public void setMedicine_standardcode_remarks(String medicine_standardcode_remarks) {
        this.medicine_standardcode_remarks = medicine_standardcode_remarks;
    }

    public String getCpmc_en() {
        return cpmc_en;
    }

    public void setCpmc_en(String cpmc_en) {
        this.cpmc_en = cpmc_en;
    }

    public String getYpzwh() {
        return ypzwh;
    }

    public void setYpzwh(String ypzwh) {
        this.ypzwh = ypzwh;
    }

    public String getPzwh() {
        return pzwh;
    }

    public void setPzwh(String pzwh) {
        this.pzwh = pzwh;
    }

    public String getScdw() {
        return scdw;
    }

    public void setScdw(String scdw) {
        this.scdw = scdw;
    }

    public String getScdz() {
        return scdz;
    }

    public void setScdz(String scdz) {
        this.scdz = scdz;
    }

    public String getCpmc_ch() {
        return cpmc_ch;
    }

    public void setCpmc_ch(String cpmc_ch) {
        this.cpmc_ch = cpmc_ch;
    }

    public String getYpbwm() {
        return ypbwm;
    }

    public void setYpbwm(String ypbwm) {
        this.ypbwm = ypbwm;
    }

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public String getCplb() {
        return cplb;
    }

    public void setCplb(String cplb) {
        this.cplb = cplb;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
