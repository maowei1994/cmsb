package com.hj.client.object.list;

/**
 * @author tinglang (editice@gmail.com)
 * @since 2015/2/2  22:44
 */
public class YpBasicInfo {
    @Override
    public String toString() {
        return "YpBasicInfo{" +
               "cnName='" + cnName + '\'' +
               ", enName='" + enName + '\'' +
               ", isJbyw=" + isJbyw +
               ", isYbyw=" + isYbyw +
               ", pwCj=" + pwCj +
               '}';
    }

    /**
     * ����ҩƷ���ƣ���Ӧcpmc
     */
    String cnName;

    /**
     * Ӣ��ҩƷ����
     */
    String enName;

    /**
     * �Ƿ��ǻ���ҩ��
     */
    boolean isJbyw;

    /**
     * �Ƿ���ҽ��ҩ��
     */
    boolean isYbyw;

    /**
     * ҽ������
     */
    String ybfl;
    /**
     * �������ĳ�����
     */
    int pwCj;

    String otc;

    /**
     * ���Ƽ���
     */
    String disease;



    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName;
    }

    public boolean isJbyw() {
        return isJbyw;
    }

    public void setJbyw(boolean isJbyw) {
        this.isJbyw = isJbyw;
    }

    public boolean isYbyw() {
        return isYbyw;
    }

    public void setYbyw(boolean isYbyw) {
        this.isYbyw = isYbyw;
    }

    public int getPwCj() {
        return pwCj;
    }

    public void setPwCj(int pwCj) {
        this.pwCj = pwCj;
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

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof YpBasicInfo)) return false;

        YpBasicInfo that = (YpBasicInfo) o;

        if (cnName != null ? !cnName.equals(that.cnName) : that.cnName != null) return false;
        if (enName != null ? !enName.equals(that.enName) : that.enName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cnName != null ? cnName.hashCode() : 0;
        result = 31 * result + (enName != null ? enName.hashCode() : 0);
        return result;
    }
}
