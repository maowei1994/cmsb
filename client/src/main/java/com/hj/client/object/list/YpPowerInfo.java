package com.hj.client.object.list;

/**
 * ҩƷ����������
 * @author tinglang (editice@gmail.com)
 * @since 2015/2/8  11:21
 */
public class YpPowerInfo {
    /**
     * ����ҩƷ���ƣ���Ӧcpmc
     */
    String cnName;

    String tym;

    /**
     * ���Ƽ���
     */
    String disease;


    /**
     * �Ƿ��ǻ���ҩ��
     */
    boolean isJbyw;

    /**
     * ҽ������
     */
    String ybfl;

    String otc;

    String zldl;

    String zlxl;

    public String getZldl() {
        return zldl;
    }

    public void setZldl(String zldl) {
        this.zldl = zldl;
    }

    public String getZlxl() {
        return zlxl;
    }

    public void setZlxl(String zlxl) {
        this.zlxl = zlxl;
    }

    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getTym() {
        return tym;
    }

    public void setTym(String tym) {
        this.tym = tym;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public boolean isJbyw() {
        return isJbyw;
    }

    public void setJbyw(boolean isJbyw) {
        this.isJbyw = isJbyw;
    }

    public String getYbfl() {
        return ybfl;
    }

    public void setYbfl(String ybfl) {
        this.ybfl = ybfl;
    }

    public String getOtc() {
        return otc;
    }

    public void setOtc(String otc) {
        this.otc = otc;
    }

    @Override
    public String toString() {
        return "YpPowerInfo{" +
               "cnName='" + cnName + '\'' +
               ", tym='" + tym + '\'' +
               ", disease='" + disease + '\'' +
               ", isJbyw=" + isJbyw +
               ", ybfl='" + ybfl + '\'' +
               ", otc='" + otc + '\'' +
               ", zldl='" + zldl + '\'' +
               ", zlxl='" + zlxl + '\'' +
               '}';
    }
}
