package com.hj.biz.error;


/**
 * �����������
 * @author null.zj
 */
public class Error {
    /**�������*/
    private String errorCode;

    /**������ϸ��Ϣ*/
    private String errorMsg;

    /**������ת���ⲿ�ض���*/
    private String redirectUrl;

    /**������ת���ڲ��ض���*/
    private String redirectTarget;

    /*�������ͣ�1��ʾ�ͻ��˴���2��ʾ�����ϵͳ����3����ʾ�����������ϵͳ����*/
    private String errorType;

    public Error() {

    }

    public Error(String errorCode, String errorMsg, String redirectUrl, String redirectTarget, String errorType) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.redirectUrl = redirectUrl;
        this.redirectTarget = redirectTarget;
        this.errorType = errorType;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public String getRedirectTarget() {
        return redirectTarget;
    }

    public void setRedirectTarget(String redirectTarget) {
        this.redirectTarget = redirectTarget;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
}
