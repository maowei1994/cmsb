package com.hj.biz.error;

/**
 * ��ע���ڴ����У�������Ҫ�ڶദʹ��ͬһ��error code��������֤ÿһ��error codeֻ��һ��ʹ��
 * @author tinglang (editice@gmail.com)
 * @since 2014/10/1  22:10
 */
public enum  ErrorCode {
    /**
     * ����Ϊ���쳣
     */
    NULL_PARAMETER_ERROR,

    /**
     * �ͻ��˲�������ʧ��
     */
    INPUT_PARSE_FAIL,

    /**
     * ��½ʧ�ܣ������û������벻ƥ��
     */
    ACCOUNT_PASSWORD_WRONG,

    /**
     * �û�������
     */
    ACCOUNT_NOT_EXIST,

    /**
     * �û����Ѵ��ڣ���ʹ�������û���
     */
    ACCOUNT_NAME_ALREADY_EXIST,

    /**
     * �û�ע��ʧ��
     */
    ACCOUNT_CREATED_FAILED,

    /**
     * ��������ʧ��
     */
    RESET_PASSWORD_FAILED,

    /**
     * ��Ȧ�������Ѿ�����
     */
    CIRCLE_TITLE_ALREADY_EXIST,

    /**
     * ��Ȧ�Ӳ�����
     */
    CIRCLE_NOT_EXIST,

    /**
     * ���˻�û��Ȩ��
     */
    ACCOUNT_NO_PERMISSION,

    /**
     * �û������
     */
    ACTIVITY_NOT_EXIST,

    /**
     * �����Ѿ��ﵽ����
     */
    MEMBER_ENOUGH,

    /**
     * ���˻�û��Ȩ�ޱ༭�
     */
    ACCOUNT_NO_PERMISSION_HANDLE_ACTIVITY,

    /**
     * ϵͳ�쳣���ûû�г�Ա
     */
    ACIIVITY_HAS_NO_ACCOUNT,

    /**
     * �˻�δ�μӸû
     */
    ACCOUNT_NOT_IN_ACTIVITY,

    /**
     * ���Ͷ�����֤��ʧ��
     */
    SEND_SMS_CODE_FAIL,

    /**
     * �洢������֤��ʧ��
     */
    INSERT_SMS_CODE_FAIL,

    /**
     * ������֤��У��ʧ��
     */
    SMS_CODE_VERTIFY_FAIL,

    /**
     * ϵͳ��æ�����Ժ�����
     */
    SYSTEM_ERROR,

    /**
     * ����״̬ʧ��
     */
    PUBLISH_STATUS_FAILED,

    CIRCLE_TITLE_ALREADY_BEEN_APPLYED,

    MAXIUM_CIRCLE_PEOPLE_NUM,

    CREATE_OPENFIRE_ACCOUNT_FAILED,

    ACCOUNT_NOT_SET_NEW_PASSWORD,

    ACCOUNT_CHANGE_OPENFIRE_PASSWD_FAILED, ACCOUNT_NO_PERMISSION_HANDLE_ANNOUNCE, RECORD_NOT_EXIST, GET_TOKEN_FAIL, CIRCLE_OWNER_CANNOT_DELETE, STATUS_NOT_EXIST, PROVIDER_NOT_EXIST;


    public String getUserText() {
        return ErrorUtils.getError(name()).getErrorMsg();
    }
}
