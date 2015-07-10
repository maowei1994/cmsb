package com.hj.test;


import com.google.common.collect.Maps;
import org.jivesoftware.smack.*;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.packet.Packet;
import org.jivesoftware.smack.packet.Presence;
import org.jivesoftware.smackx.Form;
import org.jivesoftware.smackx.FormField;
import org.jivesoftware.smackx.muc.MultiUserChat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/**
 * smack��ܲ���ͨ�ţ��������¼��㣺
 * 1.�����˻�
 * 2.�����˻�
 * 3.���Է�����Ϣ�ͽ�����Ϣ
 * @author tinglang (editice@gmail.com)
 * @since 2014/10/28  23:03
 */
public class SmackXMPPTest {

    private Connection connection;
    private ConnectionConfiguration config;
    private final static String server = "121.41.29.72";
    private final static String serverJID = "iz23m8u2jf9z";
    private final static String conferenceServerJID="@conference.iz23m8u2jf9z";
    private final static int port = 5222;


    Logger logger = LoggerFactory.getLogger(SmackXMPPTest.class);


    public void init() {
        /**
         * �˿�5222���ͻ���ʹ�ñ�׼�˿����ӵ������������ӿ���û�м��ܣ������ֶ��ڿ���̨���ã�
         */
        config = new ConnectionConfiguration(server, port);
        //����ѹ��
        config.setCompressionEnabled(true);
        //����SASL��ȫ��֤
        config.setSASLAuthenticationEnabled(true);
        //����debug
        config.setDebuggerEnabled(false);


        try {
            /**
             * ����xmpp����
             */
            connection = new XMPPConnection(config);
            /**
             * ��������
             */
            connection.connect();
        }
        catch (Exception e) {
            logger.error("create xmpp connect fail: ", e);
        }

    }

    public void destroy() {
        if (connection != null) {
            connection.disconnect();
            connection = null;
        }
    }

    /**
     * �û���������������û����޸������
     */
    public void handleAccountManager() {
        AccountManager accountManager = connection.getAccountManager();
        System.out.println("�Ƿ�֧���û�����:\n" + accountManager.supportsAccountCreation());

        /**
         * ���ÿ�ѡ����
         */
        Map<String, String> map = Maps.newHashMap();
        map.put("email", "editice1@gmail.com");
        map.put("name", "������");
        try {
            accountManager.createAccount("zj2", "1223", map);
//            accountManager.changePassword("4526");
            System.out.println("�����û��ɹ�");
        }
        catch (Exception e) {
            logger.error("create account fail: ", e);
            e.printStackTrace();
        }
    }

    /**
     * �û���½����ȡ�û����ѣ��û������Ϣ
     */
    public void handleUserLogin() {
        try {
            connection.login("zj2", "1223");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("login user: " + connection.getUser());
        /** �����û��� */
        Roster roster = connection.getRoster();

        /** �����û��飬�������Spark����û����ѣ���������Ϳ��Բ�ѯ����ص����� */
        Collection<RosterEntry> rosterEntiry = roster.getEntries();
        Iterator<RosterEntry> iter = rosterEntiry.iterator();
        while (iter.hasNext()) {
            RosterEntry entry = iter.next();
            System.out.println(entry);
        }

        System.out.println("-------------------------------");
        /** δ������֤���ѣ���ӹ��ĺ��ѣ�û�еõ��Է�ͬ�� */
        Collection<RosterEntry> unfiledEntries = roster.getUnfiledEntries();
        iter = unfiledEntries.iterator();
        while (iter.hasNext()) {
            RosterEntry entry = iter.next();
            System.out.println(entry);
        }
    }

    /**
     * ����������Ϣ������
     */
    public void handleChatManager() throws XMPPException {
        try {
            connection.login("zj", "123");
            System.out.println("login succssfull");
        }
        catch (XMPPException e) {
            e.printStackTrace();
        }

        /** ����״̬ */
        Presence presence = new Presence(Presence.Type.available);
        presence.setStatus("Q�Ұ�");
        connection.sendPacket(presence);

        /** ��ȡ��ǰ��½�û������������ */
        ChatManager chatManager = connection.getChatManager();
        /** Ϊָ���û�����һ��chat��MyMessageListeners���ڼ����Է�����������Ϣ  */
        Chat chat = chatManager.createChat("zj2@" + serverJID, new MyMessageListeners());
        /** ������Ϣ */
        chat.sendMessage("h!~ ���� ����");

        /** ��message��������Ϣ */
        Message message = new Message();
        message.setBody("message");
        message.setProperty("color", "red");
        chat.sendMessage(message);
        System.out.println("������Ϣ�ɹ�");
        try {
            Thread.sleep(5000*20);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * �Զ�����Ϣ���������û������Է����͵���Ϣ��Ҳ������Է�������Ϣ
     */
    class MyMessageListeners implements MessageListener {
        public void processMessage(Chat chat, Message message) {
            try {
                /**
                 * �û���ǰ�����������ʵ��Ϊchat
                 * �û����յ�����Ϣ���弴Ϊmessage
                 */

                /** ���û������Լ����յ�����Ϣ */
                chat.sendMessage("����յ�����Ϣ�ǡ���" + message.getBody());
            }
            catch (XMPPException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ���Դ�������������
     */
    public void createChatRoom() throws XMPPException {
        try {
            connection.login("zj", "123");
            System.out.println("login succssfull");
        }
        catch (XMPPException e) {
            e.printStackTrace();
        }
        MultiUserChat muc = new MultiUserChat(connection, "roomName@"+conferenceServerJID);
        // ����������
        muc.create("room nick 1");
        // ��������ҵ����ñ�
        Form form = muc.getConfigurationForm();
        // ����ԭʼ������һ��Ҫ�ύ���±���
        Form submitForm = form.createAnswerForm();
        // ��Ҫ�ύ�ı����Ĭ�ϴ�
        for (Iterator fields = form.getFields(); fields.hasNext();) {
            FormField field = (FormField) fields.next();
            if (!FormField.TYPE_HIDDEN.equals(field.getType())
                && field.getVariable() != null) {
                // ����Ĭ��ֵ��Ϊ��
                submitForm.setDefaultAnswer(field.getVariable());
            }
        }
        // ���������ҵ���ӵ����
        // �����������ǳ־������ң�����Ҫ����������
        submitForm.setAnswer("muc#roomconfig_persistentroom", true);
        // ������Գ�Ա����
        // �����Ƿ���Ҫ����
        //submitForm.setAnswer("muc#roomconfig_passwordprotectedroom", true);
        // ���ý�������
        //submitForm.setAnswer("muc#roomconfig_roomsecret", "password");
        submitForm.setAnswer("muc#roomconfig_membersonly", false);
        // ����ռ��������������
        submitForm.setAnswer("muc#roomconfig_allowinvites", true);
        // �ܹ�����ռ������ʵ JID �Ľ�ɫ
        // submitForm.setAnswer("muc#roomconfig_whois", "anyone");
        // ��¼����Ի�
        submitForm.setAnswer("muc#roomconfig_enablelogging", true);
        // ������ע����ǳƵ�¼
        submitForm.setAnswer("x-muc#roomconfig_reservednick", true);
        // ����ʹ�����޸��ǳ�
        submitForm.setAnswer("x-muc#roomconfig_canchangenick", false);
        // �����û�ע�᷿��
        submitForm.setAnswer("x-muc#roomconfig_registration", false);
        // ��������ɵı�����Ĭ��ֵ����������������������
        muc.sendConfigurationForm(submitForm);
    }

    /**
     * ���Լ��뷿��
     */
    public void joinChatRoom() throws XMPPException {
        try {
            connection.login("zj2", "1223");
            System.out.println("login succssfull");
        }
        catch (XMPPException e) {
            e.printStackTrace();
        }
        MultiUserChat muc = new MultiUserChat(connection, "roomname"+conferenceServerJID);
        muc.join("zj2","123456");
        System.out.println("join successful");
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * ������������
     */
    public void communicateChatRoom() throws XMPPException {
        try {
            connection.login("zj", "123");
            System.out.println("login succssfull");
        }
        catch (XMPPException e) {
            e.printStackTrace();
        }
        MultiUserChat muc = new MultiUserChat(connection, "roomname"+conferenceServerJID);
        muc.join("zj","123456");
        muc.addMessageListener(new MyMUCListener());

        Message message = new Message();
        message.setBody("my message");
        message.setProperty("color", "red");
        muc.sendMessage(message);
        try {
            Thread.sleep(50000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * �����Ҽ�����
     */
    class MyMUCListener implements PacketListener {

        @Override
        public void processPacket(Packet packet) {
            Message message=(Message)packet;
            System.out.println("�ҽ��յ�����Ϣ�� "+message.getBody());
        }
    }

    public static void main(String[] args) throws XMPPException {
        SmackXMPPTest smackXMPPTest = new SmackXMPPTest();
        smackXMPPTest.init();
//        smackXMPPTest.handleAccountManager();
//        smackXMPPTest.handleUserLogin();
//        smackXMPPTest.handleChatManager();
//        smackXMPPTest.createChatRoom();
//        smackXMPPTest.joinChatRoom();
        smackXMPPTest.communicateChatRoom();
        smackXMPPTest.destroy();
    }

}
