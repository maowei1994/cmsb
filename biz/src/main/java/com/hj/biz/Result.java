package com.hj.biz;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * �ͻ��˵����ⲿ����ʱ���ص�ͨ�����ݶ��󣬰����˷���˵��õķ�������
 * ͨ��success�ֶα�ʶ�����Ƿ�ɹ���ͨ��msgCode��msgInfo��ʾ����ʧ��ʱ�Ĵ��������ϸ�Ĵ�����Ϣ
 * @author tinglang (editice@gmail.com)
 * @since 2014/9/26  17:39
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1905775611728626568L;

    protected boolean success=true;

    /**
     * ���صĶ���
     */
    protected T model;

    /**
     * ������Ϣerror code
     */
    protected String msgCode;

    /**
     * ������Ϣ����
     */
    protected String msgInfo;

    public Result(T model) {
        this.model = model;
    }

    public Result() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }
}
