package edu.miu.cs.cs472.letexplore.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.miu.cs.cs472.letexplore.model.TourLocationModel;
import edu.miu.cs.cs472.letexplore.model.UserModel;
import edu.miu.cs.cs472.letexplore.service.ServiceWrapper;
import edu.miu.cs.cs472.letexplore.service.UsersService;

/**
 * Servlet implementation class UserController
 */
@WebServlet(description = "This is user servlet file", urlPatterns = { "/usercontroller" })
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	UsersService service = ServiceWrapper.getUsersService();
	
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<UserModel> users = service.getAllUsersDatasList();
		ServletContext context = request.getServletContext();
		context.setAttribute("usersList", users);
		request.getRequestDispatcher("/WEB-INF/views/user_account.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  try {
		    	service.addUserWithParameter(request.getParameter("username"), request.getParameter("password")); 
		    	System.out.println(service.getAllUsersDatas());
	            request.getRequestDispatcher("/WEB-INF/views/thank_you.jsp").forward(request, response);
		    }
		catch (Exception e) {
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
		  
//			StringBuffer stringBuffer = new StringBuffer();
//			String line = null;
//			try(BufferedReader bufferedReader = request.getReader()) {
//				while((line = bufferedReader.readLine()) != null) {
//					stringBuffer.append(line);
//				}
//				System.out.println(stringBuffer.toString());
//				Gson gson = new Gson();
//				UserModel userModel = gson.fromJson(stringBuffer.toString(), UserModel.class);
//	            service.addUser(userModel);
//	            request.getRequestDispatcher("/WEB-INF/thank_you.jsp").forward(request, response);
//				
//			}
//			catch (Exception e) {
//				request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
//			}
	}

}
