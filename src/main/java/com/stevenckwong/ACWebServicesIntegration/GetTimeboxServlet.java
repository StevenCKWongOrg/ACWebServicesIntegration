package com.stevenckwong.ACWebServicesIntegration;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stevenckwong.ACWebServicesIntegration.dom.RallyTimebox;

/**
 * Servlet implementation class GetTimeboxServlet
 */
public class GetTimeboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTimeboxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String apiKey = request.getParameter("apikey");
		String projectName = request.getParameter("projectName");
		String timeboxType = request.getParameter("timeboxType");
		ArrayList<RallyTimebox> rallyTimeboxes = new ArrayList<RallyTimebox>();
		RallyTimebox dummyTimebox = new RallyTimebox();
		dummyTimebox.setType("iteration");
		dummyTimebox.setName("dummy");
		dummyTimebox.setStartDate("no_start_date");
		dummyTimebox.setEndDate("no_end_date");
		rallyTimeboxes.add(dummyTimebox);
		
		if (projectName.equalsIgnoreCase("")) {
			request.setAttribute("ErrorTitle", "No Project Name");
			request.setAttribute("ErrorDetaiedMessage", "You have to provide a Project Name. Please go back and try again");
			request.getRequestDispatcher("error.jsp").forward(request, response);
		}
		
		MyUtility util = new MyUtility();
		try {
			if (timeboxType.equals("milestone")) {
				rallyTimeboxes = util.queryMilestonesForProject(apiKey, projectName);
			} else {
				rallyTimeboxes = util.queryTimeboxes(apiKey, projectName, timeboxType);
			}
		} catch (ACWebServicesException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			request.setAttribute("ErrorTitle", "An Exception Occured");
			request.setAttribute("ErrorDetailedMessage", e.getErrorMessage());
			request.getRequestDispatcher("error.jsp").forward(request, response);		
		}
		
		request.setAttribute("RallyTimeboxes", rallyTimeboxes);
		request.setAttribute("projectName", projectName);
		request.getRequestDispatcher("timeboxdetails.jsp").forward(request, response);
		// doGet(request, response);
	}

}
