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

import dao.CustomerDAO;
import dao.UserDAO;
import vo.CustomerVO;
import vo.UserVO;

/**
 * Servlet implementation class UserListServlet
 */
//@WebServlet("/CustomerList")
public class CustomerListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CustomerDAO customerDAO;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerListServlet() {
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
    	
    	customerDAO = new CustomerDAO(driver, url, username, password);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">> doGet");
		response.setContentType("text/html;charset=UTF-8");
		// UserDAO를 호출해서 DB 데이터를 가져오기
		List<CustomerVO> customerList = customerDAO.getCustomerList();
		// Request객체에 userList를 저장하기
		request.setAttribute("users", customerList);
		// RequestDispatcher 생성하기
		RequestDispatcher dispatcher = request.getRequestDispatcher("customerList.jsp");
		// userList.jsp 페이지로 포워딩하기
		dispatcher.forward(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println(">> destroy");
		customerDAO.connectionClose();
	}

}
