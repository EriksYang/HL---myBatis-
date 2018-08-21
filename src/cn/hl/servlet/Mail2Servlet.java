package cn.hl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hl.service.Mail2Service;
import cn.hl.vo.Mail2;
import cn.hl.vo.User;

public class Mail2Servlet extends HttpServlet {
	Mail2Service service = new Mail2Service();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String op = req.getParameter("op");
		
		if("recive".equals(op))
			getReciveList(req,resp);
		else if("read".equals(op))
			readMail(req,resp);
		else if("del".equals(op))
			delete(req,resp);
		else if("dustbin".equals(op))
			dustbin(req,resp);
		else if("sendbox".equals(op))
			sendBox(req,resp);
	}

	/**
	 * 获取发件箱列表
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void sendBox(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//当前用户就是收件人
		User u = (User)req.getSession().getAttribute("user");
		//查询收件列表
		List<Mail2> list = service.getSendBox(u.getUserId());
		//将数据添加到作用域
		req.setAttribute("list", list);
		//跳转到发件箱页面
		req.getRequestDispatcher("WEB-INF/sendbox.jsp").forward(req, resp);
	}

	/**
	 * 获取垃圾箱中邮件
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void dustbin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//当前用户就是收件人
		User u = (User)req.getSession().getAttribute("user");
		//查询收件列表
		List<Mail2> list = service.getDustbin(u.getUserId());
		//将数据存储到作用域中
		req.setAttribute("list", list);
		//跳转到WEB-INF/recivebox.jsp页面
		req.getRequestDispatcher("WEB-INF/recivebox.jsp").forward(req, resp);
		
	}

	/**
	 * 删除邮件（删除将转入到垃圾箱）
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取邮件Id
		int id = Integer.parseInt(req.getParameter("id"));
		//获取userId
		User user = (User)req.getSession().getAttribute("user");
		
		service.delete(id, user.getUserId());
		req.getRequestDispatcher("mail2?op=recive").forward(req, resp);
	}

	/**
	 * 读取指定的邮件
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void readMail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取邮件Id
		int id = Integer.parseInt(req.getParameter("id"));
		//获取userId
		User user = (User)req.getSession().getAttribute("user");
		//读取邮件信息
		Mail2 mail = service.readMail(id, user.getUserId());
		
		//将邮件存储到作用域中
		req.setAttribute("mail", mail);
		//跳转到显示页面
		req.getRequestDispatcher("WEB-INF/show.jsp").forward(req, resp);
	}

	/**
	 * 获取收件箱列表
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getReciveList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//当前用户就是收件人
		User u = (User)req.getSession().getAttribute("user");
		//查询收件列表
		List<Mail2> list = service.getReciveList(u.getUserId());
		//将数据存储到作用域中
		req.setAttribute("list", list);
		//跳转到WEB-INF/recivebox.jsp页面
		req.getRequestDispatcher("WEB-INF/recivebox.jsp").forward(req, resp);
	}
	
}
