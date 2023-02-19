package edu.miu.cs.cs472.letexplore.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.miu.cs.cs472.letexplore.service.ServiceWrapper;
import edu.miu.cs.cs472.letexplore.service.TourLocationService;

@WebServlet("/TourLocationControllerJSON")
public class TourLocationControllerJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TourLocationService service = ServiceWrapper.getTourLocationService(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TourLocationControllerJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		setAccessControlHeaders(response);
		writer.write(service.getAllTourLocationDatas());
	}
	
	@Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        resp.setHeader("Access-Control-Allow-Headers", "*");
    }

}
