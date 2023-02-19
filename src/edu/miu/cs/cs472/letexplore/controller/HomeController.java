package edu.miu.cs.cs472.letexplore.controller;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.miu.cs.cs472.letexplore.model.UserModel;
import edu.miu.cs.cs472.letexplore.service.ServiceWrapper;
import edu.miu.cs.cs472.letexplore.service.UsersService;

/**
 * Servlet implementation class AuthenticationController
 */
@WebServlet(description = "This is home folder" , urlPatterns = {"/HomeController" , ""})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UsersService service = ServiceWrapper.getUsersService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 if(service.Login(request.getParameter("username") , request.getParameter("password"))) {
         	request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
         }
	}

}
