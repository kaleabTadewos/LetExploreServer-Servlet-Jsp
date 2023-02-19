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

import edu.miu.cs.cs472.letexplore.model.TourGuideModel;
import edu.miu.cs.cs472.letexplore.model.TourLocationModel;
import edu.miu.cs.cs472.letexplore.service.ImageUploder;
import edu.miu.cs.cs472.letexplore.service.ServiceWrapper;
import edu.miu.cs.cs472.letexplore.service.TourGuideService;
import edu.miu.cs.cs472.letexplore.service.TourLocationService;

/**
 * Servlet implementation class TourGuideController
 */
@WebServlet(description = "This is tour guide servlet file", urlPatterns = { "/tourguidecontroller" })
public class TourGuideController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TourGuideService service = ServiceWrapper.getTourGuideService();
	private final String UPLOAD_DIRECTORY_TOUR_GUIDE = System.getProperty("user.dir") + "/LetExploreProject/WebContent/images/tourGuideLogo/";
	ImageUploder imageUploader = ServiceWrapper.getImageUploder();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TourGuideController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/tour_guides.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    try {
		    	if(imageUploader.imageUploaderFunctionForTourGuide(request, response, UPLOAD_DIRECTORY_TOUR_GUIDE, "images/tourGuideLogo/")) {
	    		String[] input = imageUploader.inputFiledsForTourGuides();
	    		service.addTourGuideWithParameter(input[0], input[1], input[2], input[3], input[4], input[5], input[6], input[7], input[8]);
	    		System.out.println(service.getAllTourGuideDatas());
	    		request.getRequestDispatcher("/WEB-INF/views/thank_you.jsp").forward(request, response);
		    	}
		    }
		catch (Exception e) {
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
	}
}
