package com.stevenckwong.ACWebServicesIntegration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stevenckwong.ACWebServicesIntegration.dom.RallyTimebox;

/**
 * Servlet implementation class CreateTimeboxServlet
 */
public class CreateTimeboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTimeboxServlet() {
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
		
		MyUtility util = new MyUtility();
		String apikey = request.getParameter("apikey");
		
		String timeboxType = request.getParameter("timeboxType");
		String timeboxName = request.getParameter("timeboxName");
		String timeboxStartDate = request.getParameter("timeboxStartDate");
		String timeboxEndDate = request.getParameter("timeboxEndDate");
		
		RallyTimebox newTimebox = new RallyTimebox();
		newTimebox.setName(timeboxName);
		newTimebox.setType(timeboxType);
		newTimebox.setStartDate(timeboxStartDate);
		newTimebox.setEndDate(timeboxEndDate);
		// TODO: Fix this hardcoding of project name
		newTimebox.setProjectRef(util.getProjectRefForProjectName("AC Web Services"));
		
		String strRet = "PASSED";
		String errMessage = "";
		
		try {
			
			util.createNewTimebox(apikey, newTimebox);	
			
		} catch (ACWebServicesException ace) {
			strRet = "FAILED";
			errMessage = ace.getErrorMessage();
		}
		
		request.setAttribute("PutStatus", strRet);
		request.setAttribute("ErrorMessage", errMessage);
		request.getRequestDispatcher("result-createtimebox.jsp").forward(request, response);
		
		// doGet(request, response);
	}

}
