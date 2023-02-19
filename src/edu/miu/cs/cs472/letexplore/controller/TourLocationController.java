package edu.miu.cs.cs472.letexplore.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;

import edu.miu.cs.cs472.letexplore.model.TourLocationModel;
import edu.miu.cs.cs472.letexplore.model.UserModel;
import edu.miu.cs.cs472.letexplore.service.ImageUploder;
import edu.miu.cs.cs472.letexplore.service.NewLineRemoverService;
import edu.miu.cs.cs472.letexplore.service.ServiceWrapper;
import edu.miu.cs.cs472.letexplore.service.TourLocationService;
import edu.miu.cs.cs472.letexplore.service.UsersService;

/**
 * Servlet implementation class TourLocationController
 */
@WebServlet(urlPatterns = {"/tourlocationcontroller"})
public class TourLocationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY_TOUR_LOCATION = System.getProperty("user.dir") + "/LetExploreProject/WebContent/images/location/";
	TourLocationService service = ServiceWrapper.getTourLocationService();
	ImageUploder imageUploader = ServiceWrapper.getImageUploder();
	NewLineRemoverService removeNewLine = ServiceWrapper.getNewLineRemoverService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TourLocationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/tour_location.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   try {
			   if(imageUploader.imageUploaderFunctionForTourLocation(request, response, UPLOAD_DIRECTORY_TOUR_LOCATION, "images/location/")) {
				   String[] input = imageUploader.inputFiledsForTourTransportations();
				 service.addTourLocationWithParameter(input[0], removeNewLine.newLineRemover(input[1]), input[2], input[3], input[4], LocalDate.now()); 
			     System.out.println(service.getAllTourLocationDatas());
				 request.getRequestDispatcher("/WEB-INF/views/thank_you.jsp").forward(request, response);
		   }
		  }
		catch (Exception e) {
			request.setAttribute("message", "File Upload Failed due to " + e);
			request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
		}
	}

}
