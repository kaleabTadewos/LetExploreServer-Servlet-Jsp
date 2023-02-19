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

import edu.miu.cs.cs472.letexplore.model.TourGuideModelList;
import edu.miu.cs.cs472.letexplore.model.TourLocationModel;
import edu.miu.cs.cs472.letexplore.model.TourLocationModelList;
import edu.miu.cs.cs472.letexplore.model.UserModel;
import edu.miu.cs.cs472.letexplore.service.ImageUploder;
import edu.miu.cs.cs472.letexplore.service.ServiceWrapper;
import edu.miu.cs.cs472.letexplore.service.TourLocationService;
import edu.miu.cs.cs472.letexplore.service.UsersService;

/**
 * Servlet implementation class TourLocationController
 */
@WebServlet(urlPatterns = {"/tourlocationcontrollerlist"})
public class TourLocationControllerList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TourLocationService service = ServiceWrapper.getTourLocationService();
	ImageUploder imageUploader = ServiceWrapper.getImageUploder();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TourLocationControllerList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<TourLocationModelList> tourLocations = service.getAllTourLocationDatasList();
		ServletContext context = request.getServletContext();
		context.setAttribute("tourLocations", tourLocations);
		request.getRequestDispatcher("/WEB-INF/views/tour_locationlist.jsp").forward(request, response);
	}
}
