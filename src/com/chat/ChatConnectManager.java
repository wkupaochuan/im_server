package com.chat;

import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

public class ChatConnectManager {
	public static ConnectionConfiguration connConfig;
    public static XMPPConnection xmppConnection;
    public static ChatManager chatManager;
    public static String UserId;
    public static String User;
    public static Chat chat ;

    public static String serverIP = "182.92.130.192";
    public static int serverPort = 5222;
    public static String password = "ijnUHB";


    /**
     * ��½
     * @param Username
     */
    public static void sendMessage (final String FromUser, final String password, final String toUser, final String msg)
    {
    	connConfig = new ConnectionConfiguration(ChatConnectManager.serverIP, ChatConnectManager.serverPort);

        /** �Ƿ�����ѹ�� */ 
        ChatConnectManager.connConfig.setCompressionEnabled(true);
        /** �Ƿ����ð�ȫ��֤ */
        ChatConnectManager.connConfig.setSASLAuthenticationEnabled(true);
        /** �Ƿ����õ��� */
        ChatConnectManager.connConfig.setDebuggerEnabled(false);
        
//        // �رհ�ȫģʽ������
//        ChatConnectManager.connConfig.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);

        ChatConnectManager.xmppConnection = new XMPPConnection(connConfig);

        try {
            ChatConnectManager.xmppConnection.connect();
            ChatConnectManager.xmppConnection.login(FromUser, password);

//            ChatConnectManager.RegisterMessageListener();
            
            
        	ChatConnectManager.chatManager = ChatConnectManager.xmppConnection.getChatManager();
            ChatConnectManager.chat = chatManager.createChat(toUser + "@iz255gm1qk6z", new MyMessageListeners());
            
            ChatConnectManager.chat.sendMessage(msg);
        }
        catch (Exception ex) {
        	System.out.println(ex.getMessage());
        }
    }


    
    public static class MyMessageListeners implements MessageListener {
        public void processMessage(Chat chat, Message message) {
            try {
                /** ������Ϣ */
                chat.sendMessage("dingding����" + message.getBody());
                System.out.println(message.getBody());
            } catch (XMPPException e) {
                e.printStackTrace();
            }
        }
    }

}
