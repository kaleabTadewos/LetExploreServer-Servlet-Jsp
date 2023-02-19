package edu.miu.cs.cs472.letexplore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.miu.cs.cs472.letexplore.model.NewsModelList;
import edu.miu.cs.cs472.letexplore.service.NewsService;
import edu.miu.cs.cs472.letexplore.service.ServiceWrapper;

/**
 * Servlet implementation class NewsController
 */
@WebServlet(description = "This is news servlet file", urlPatterns = { "/newscontrollerlist" })
public class NewsControllerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	NewsService service = ServiceWrapper.getNewsService();
	// private  TourLocationService tourLocationServiceObj = new TourLocationService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsControllerList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<NewsModelList> news = service.getAllNewsDatasList();
		ServletContext context = request.getServletContext();
		context.setAttribute("news", news);
		request.getRequestDispatcher("/WEB-INF/views/newslist.jsp").forward(request, response);
	}
}
