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
     * 登陆
     * @param Username
     */
    public static void sendMessage (final String FromUser, final String password, final String toUser, final String msg)
    {
    	connConfig = new ConnectionConfiguration(ChatConnectManager.serverIP, ChatConnectManager.serverPort);

        /** 是否启用压缩 */ 
        ChatConnectManager.connConfig.setCompressionEnabled(true);
        /** 是否启用安全验证 */
        ChatConnectManager.connConfig.setSASLAuthenticationEnabled(true);
        /** 是否启用调试 */
        ChatConnectManager.connConfig.setDebuggerEnabled(false);
        
//        // 关闭安全模式，必须
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
                /** 发送消息 */
                chat.sendMessage("dingding……" + message.getBody());
                System.out.println(message.getBody());
            } catch (XMPPException e) {
                e.printStackTrace();
            }
        }
    }

}
