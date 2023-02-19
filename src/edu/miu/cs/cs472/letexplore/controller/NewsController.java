package edu.miu.cs.cs472.letexplore.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.miu.cs.cs472.letexplore.model.NewsModel;
import edu.miu.cs.cs472.letexplore.model.TourLocationModel;
import edu.miu.cs.cs472.letexplore.service.ImageUploder;
import edu.miu.cs.cs472.letexplore.service.NewLineRemoverService;
import edu.miu.cs.cs472.letexplore.service.NewsService;
import edu.miu.cs.cs472.letexplore.service.ServiceWrapper;
import edu.miu.cs.cs472.letexplore.service.TourLocationService;

/**
 * Servlet implementation class NewsController
 */
@WebServlet(description = "This is news servlet file", urlPatterns = { "/newscontroller" })
public class NewsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY_NEWS = System.getProperty("user.dir") + "/LetExploreProject/WebContent/images/news/";
	NewsService service = ServiceWrapper.getNewsService();
	ImageUploder imageUploader = ServiceWrapper.getImageUploder();
	NewLineRemoverService removeNewLine = ServiceWrapper.getNewLineRemoverService();
	// private  TourLocationService tourLocationServiceObj = new TourLocationService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/news.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    try {
		    	if(imageUploader.imageUploaderFunctionForNews(request, response, UPLOAD_DIRECTORY_NEWS, "images/news/")) {
	    		String[] input = imageUploader.inputFiledsForNews();
		    	service.addNewsWithParameter(input[0], removeNewLine.newLineRemover(input[1]), input[2], LocalDate.now());
		    	
		    	System.out.println(service.getAllNewsDatas());
		    	
	            request.getRequestDispatcher("/WEB-INF/views/thank_you.jsp").forward(request, response);
		    	}
		    }
		catch (Exception e) {
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
//	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
//	 */
//	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}
//
//	/**
//	 * @see HttpServlet#doOptions(HttpServletRequest, HttpServletResponse)
//	 */
//	protected void doOptions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

}
