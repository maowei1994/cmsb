package com.hj.client;

/**
 * @author tinglang (editice@gmail.com)
 * @since 2015/3/7  16:27
 */
public class FR implements Comparable {

    //���ȵ�����
    String detailJD;

    //ʱ���ʾ����������
    int time;

    //��ǰ���ȵ����۶�
    long xse;

    //������
    String rate;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDetailJD() {
        return detailJD;
    }

    public void setDetailJD(String detailJD) {
        this.detailJD = detailJD;
    }

    public long getXse() {
        return xse;
    }

    public void setXse(long xse) {
        this.xse = xse;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(time, ((FR) o).time);
    }
}
