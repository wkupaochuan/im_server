package com.cplatform.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

/**
 * 用户名字处理 <br>
 * <p>
 * Copyright: Copyright (c) Mar 3, 2014 9:34:44 AM
 * <p>
 * Company: 北京宽连十方数字技术有限公司
 * <p>
 * 
 * @author wuxc@c-platform.com
 * @version 1.0.0
 */
public class RelationServlet extends HttpServlet {

	/** 日志 */
	private static Logger log = Logger.getLogger(RelationServlet.class);

	/**
	 * Constructor of the object.
	 */
	public RelationServlet() {
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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = null;
		try {
			String str = request.getParameter("name");
			if (str != null) {
				request.getSession().setAttribute("name", str);
			} else {
				request.getSession().setAttribute("name", " ");
			}
			response.setCharacterEncoding("GBK");
			response.setContentType("text/html;charset=GBK");

			out = response.getWriter();
			out.write("1");
			out.flush();
		}
		catch (Exception ex) {
			log.error("设置用户名出错", ex);
			ex.printStackTrace();
		}
		finally {
			if (out != null) {
				out.close();
			}
		}
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	@Override
	public void init() throws ServletException {
		// Put your code here
	}

}
