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
import edu.miu.cs.cs472.letexplore.model.TourGuideModelList;
import edu.miu.cs.cs472.letexplore.model.TourLocationModel;
import edu.miu.cs.cs472.letexplore.service.ImageUploder;
import edu.miu.cs.cs472.letexplore.service.ServiceWrapper;
import edu.miu.cs.cs472.letexplore.service.TourGuideService;
import edu.miu.cs.cs472.letexplore.service.TourLocationService;

/**
 * Servlet implementation class TourGuideController
 */
@WebServlet(description = "This is tour guide servlet file", urlPatterns = { "/tourguidecontrollerlist" })
public class TourGuideControllerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TourGuideService service = ServiceWrapper.getTourGuideService();
	private final String UPLOAD_DIRECTORY_TOUR_GUIDE = System.getProperty("user.dir") + "/LetExploreProject/WebContent/images/tourGuideLogo/";
	ImageUploder imageUploader = ServiceWrapper.getImageUploder();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TourGuideControllerList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TourGuideModelList> tourGuides = service.getAllTourGuideDatasList();
		ServletContext context = request.getServletContext();
		context.setAttribute("tourGuides", tourGuides);
		request.getRequestDispatcher("/WEB-INF/views/tour_locationlist.jsp").forward(request, response);
	}
}
