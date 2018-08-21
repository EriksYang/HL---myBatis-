package cn.hl.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hl.service.MailService;
import cn.hl.service.UserService;
import cn.hl.vo.Mail;
import cn.hl.vo.Recive;
import cn.hl.vo.User;

public class MailServlet extends HttpServlet {
	MailService service = new MailService();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String op= req.getParameter("op");
		
		if("send".equals(op)){	
			send(req,resp);
		}
		else if("save".equals(op)){
			save(req,resp);
		}
	}

	/**
	 * 保存发送的邮件
	 * @param req
	 * @param resp
	 */
	private void save(HttpServletRequest req, HttpServletResponse resp) {
		//获取Session对象
		User user = (User)req.getSession().getAttribute("user");
		//实例化Mail对象
		Mail mail = new Mail();
		mail.setContent(req.getParameter("content"));
		mail.setTitle(req.getParameter("title"));
		mail.setSenderId(user.getUserId());
		
		System.out.println("reciver=" + req.getParameter("reciver"));
		
		
		//实例化Recive对象
		String[] arr = req.getParameter("reciver").split(",");
		List<Recive> recive = new ArrayList<Recive>();
		for(int i = 0;i<arr.length;i++){
			//获取名为reciver的请求参数并转为int类型
			int reciverId = Integer.parseInt(arr[i]);
			//将reciver赋值给对象recive
			recive.add(new Recive(reciverId,0,0));
		}
		
	
		service.sendMail(mail,recive);
	}

	/**
	 * 跳转到发送页面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void send(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//通过Session获取当前用户
		User user =(User)req.getSession().getAttribute("user");
		//通过Service获取收件人列表
		UserService userService = new UserService();
		//将收件人列表添加到request作用域
		req.setAttribute("list", userService.getRecivers(user));
		//跳转到发件页面
		req.getRequestDispatcher("WEB-INF/send.jsp").forward(req, resp);
	}

}
