package cn.hl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hl.service.UserService;
import cn.hl.vo.User;

public class UserServlet extends HttpServlet {
	UserService service = new UserService();
	/**
	 * 执行请求控制
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取操作类型
		String op = req.getParameter("op");
		
		if("login".equals(op)){
			login(req,resp);
		}
		else if("reg".equals(op)){
			reg(req,resp);
		}
		else if("1".equals(op)){
			toReg(req,resp);
		}
	}

	/**
	 * 服务器端跳转到注册页面
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void toReg(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("yes");
		req.getRequestDispatcher("WEB-INF/register.jsp").forward(req, resp);
		//resp.sendRedirect("WEB-INF/register.jsp");
	}

	/**
	 * 实现用户注册
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void reg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User();
		//获取请求信息并封装到user对象
		user.setAccount(req.getParameter("account"));
		user.setPwd(req.getParameter("pwd"));
		
		//调用register()方法执行用户注册
		if(service.register(user)>0)
			req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
	}

	/**
	 * 执行登录验证
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取请求参数
		User user = new User();
		user.setAccount(req.getParameter("account"));
		user.setPwd(req.getParameter("pwd"));
		
		//通过数据库执行登录验证
		try{
			//登录成功（未产生异常）
			//将用户信息添加到作用域中
			req.getSession().setAttribute("user", service.Login(user));
			//跳转到首页
			req.getRequestDispatcher("WEB-INF/index.jsp").forward(req, resp);
		}
		catch(Exception e){
			//出现异常则跳转回登录页面
			req.getRequestDispatcher("WEB-INF/login.jsp").forward(req, resp);
		}
		
	}



}
