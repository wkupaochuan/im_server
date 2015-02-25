package com.cplatform.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * web���촦�� <br>
 * <p>
 * Copyright: Copyright (c) Mar 3, 2014 9:33:37 AM
 * <p>
 * Company: ��������ʮ�����ּ������޹�˾
 * <p>
 * 
 * @author wuxc@c-platform.com
 * @version 1.0.0
 */
public class ChatServlet extends HttpServlet {
	private static String ENTER = "\r\n";
	private static String FLAG_ANSWER = "����һ����ᣬ�����Ӧ����ô�ش�ɣ�����ȷ�𰸻ظ����Ҿ����ˣ��ҿ���һѧ�ͻ�ġ�";
	/** ������ */
	private static byte[] lockObj = new byte[0];

	/** ��־ */
	private static Logger log = Logger.getLogger(ChatServlet.class);

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
		PrintWriter out = null;
		StringBuffer result = new StringBuffer();
		String userId = "-1000";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			HttpSession session = request.getSession();

			result.append(sdf.format(new Date()));

			response.setCharacterEncoding("GBK");
			response.setContentType("text/html;charset=GBK");
			// ��ȡ���������
			out = response.getWriter();
			out.print(result.toString());
		} catch (Exception ex) {
			log.error("�������", ex);
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

}
