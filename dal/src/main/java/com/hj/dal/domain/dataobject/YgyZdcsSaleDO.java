package com.hj.dal.domain.dataobject;

/**
 * �������ԣ��ֶ������ݿⱣ��һ��
 *
 * @author tinglang (editice@gmail.com)
 * @since 2015/1/31  14:09
 */
public class YgyZdcsSaleDO {
    long id;

    String ROWKEY;
    /**
     * ����
     */
    String jx;
    /**
     * ����С��
     */
    String zldl_2;
    /**
     * ��װ
     */
    String bz;
    /**
     * ����װ
     */
    String dbz;
    /**
     * ҩƷ������
     */
    String cpmc_ch;
    /**
     * ����
     */
    String sl;
    /**
     * ���۽��(Ԫ)
     */
    String xse;
    /**
     * ��ҵ����
     */
    String qymc;
    /**
     * ����
     */
    String city;
    /**
     * ���
     */
    String year;
    /**
     * ���ƴ���
     */
    String zldl_1;
    /**
     * ���
     */
    String gg;
    /**
     * ����
     */
    String jd;
    /**
     * ��ҩ;��
     */
    String yytj;

    String f16;

    public String getF16() {
        return f16;
    }

    public void setF16(String f16) {
        this.f16 = f16;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getROWKEY() {
        return ROWKEY;
    }

    public void setROWKEY(String ROWKEY) {
        this.ROWKEY = ROWKEY;
    }

    public String getJx() {
        return jx;
    }

    public void setJx(String jx) {
        this.jx = jx;
    }

    public String getZldl_2() {
        return zldl_2;
    }

    public void setZldl_2(String zldl_2) {
        this.zldl_2 = zldl_2;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz;
    }

    public String getDbz() {
        return dbz;
    }

    public void setDbz(String dbz) {
        this.dbz = dbz;
    }

    public String getCpmc_ch() {
        return cpmc_ch;
    }

    public void setCpmc_ch(String cpmc_ch) {
        this.cpmc_ch = cpmc_ch;
    }

    public String getSl() {
        return sl;
    }

    public void setSl(String sl) {
        this.sl = sl;
    }

    public String getXse() {
        return xse;
    }

    public void setXse(String xse) {
        this.xse = xse;
    }

    public String getQymc() {
        return qymc;
    }

    public void setQymc(String qymc) {
        this.qymc = qymc;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getZldl_1() {
        return zldl_1;
    }

    public void setZldl_1(String zldl_1) {
        this.zldl_1 = zldl_1;
    }

    public String getGg() {
        return gg;
    }

    public void setGg(String gg) {
        this.gg = gg;
    }

    public String getJd() {
        return jd;
    }

    public void setJd(String jd) {
        this.jd = jd;
    }

    public String getYytj() {
        return yytj;
    }

    public void setYytj(String yytj) {
        this.yytj = yytj;
    }

    @Override
    public String toString() {
        return "YgyZdcsSaleDO{" +
               "id=" + id +
               ", ROWKEY='" + ROWKEY + '\'' +
               ", jx='" + jx + '\'' +
               ", zldl_2='" + zldl_2 + '\'' +
               ", bz='" + bz + '\'' +
               ", dbz='" + dbz + '\'' +
               ", cpmc_ch='" + cpmc_ch + '\'' +
               ", sl='" + sl + '\'' +
               ", xse='" + xse + '\'' +
               ", qymc='" + qymc + '\'' +
               ", city='" + city + '\'' +
               ", year='" + year + '\'' +
               ", zldl_1='" + zldl_1 + '\'' +
               ", gg='" + gg + '\'' +
               ", jd='" + jd + '\'' +
               ", yytj='" + yytj + '\'' +
               '}';
    }
}
