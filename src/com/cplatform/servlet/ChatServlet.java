package com.cplatform.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.chat.ChatConnectManager;


public class ChatServlet extends HttpServlet {
	/**
	 * Constructor of the object.
	 */
	public ChatServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	@Override
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fromUser = request.getParameter("from_user").toString();
		String password = request.getParameter("password").toString();
		password = "ijnUHB";
		String toUser = request.getParameter("to_user").toString();
		String msg = request.getParameter("msg").toString();
		PrintWriter out = null;
		StringBuffer result = new StringBuffer();
		try {
			this.doChat(fromUser, password, toUser, msg);
			
			result.append("test");
			result.append(fromUser);
			result.append(password);
			result.append(toUser);
			
			response.setCharacterEncoding("GBK");
			response.setContentType("text/html;charset=GBK");
			// 获取输出数据流
			out = response.getWriter();
			out.print(result);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	@Override
	public void init() throws ServletException {

	}
	
	private void doChat(String fromUser, String password, String toUser, String msg)
	{
		ChatConnectManager.sendMessage(fromUser, password, toUser, msg);
	}
	
	

}
