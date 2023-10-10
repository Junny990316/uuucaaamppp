package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import vo.UserVO;

/**
 * Servlet implementation class UserListServlet
 */
//@WebServlet("/UserList")
public class UserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserDAO userDao;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
    	System.out.println(">> init");
    	String driver = config.getInitParameter("driverClass");
    	String url = config.getInitParameter("dbUrl");
    	String username = config.getInitParameter("dbUsername");
    	String password = config.getInitParameter("dbPassword");
    	
    	userDao = new UserDAO(driver, url, username, password);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">> doGet");
		response.setContentType("text/html;charset=UTF-8");
		// UserDAO�� ȣ���ؼ� DB �����͸� ��������
		List<UserVO> userList = userDao.getUserList();
		// Request��ü�� userList�� �����ϱ�
		request.setAttribute("users", userList);
		// RequestDispatcher �����ϱ�
		RequestDispatcher dispatcher = request.getRequestDispatcher("userList.jsp");
		// userList.jsp �������� �������ϱ�
		dispatcher.forward(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println(">> destroy");
		userDao.connectionClose();
	}

}
