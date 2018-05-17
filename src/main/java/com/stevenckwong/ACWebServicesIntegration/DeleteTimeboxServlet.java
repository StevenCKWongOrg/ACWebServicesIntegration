package com.stevenckwong.ACWebServicesIntegration;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stevenckwong.ACWebServicesIntegration.dom.RallyTimebox;

/**
 * Servlet implementation class DeleteTimeboxServlet
 */
public class DeleteTimeboxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTimeboxServlet() {
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
		
		String apikey = request.getParameter("apiKey");
		
		Enumeration<String> allParams = request.getParameterNames();
		String currParamName;
		String objectIDToDelete = "";
		while (allParams.hasMoreElements()) {
			currParamName = allParams.nextElement();
			if (currParamName.startsWith("Delete_")) {
				objectIDToDelete = currParamName.substring(7);
				break;
			}
		}
		
		MyUtility util = new MyUtility();
		RallyTimebox timebox = new RallyTimebox();
		timebox.setObjectID(objectIDToDelete);
		timebox.setType(request.getParameter("TimeboxType"));
		
		String deleteIndicator = "PASSED";
		String strReturn = new String();
		try {
			strReturn = util.deleteTimebox(apikey, timebox);
		} catch (ACWebServicesException ace) {
			strReturn = ace.getErrorMessage();
			strReturn = strReturn + "\n\n" + ace.getMessage();
			deleteIndicator = "FAILED";
		}
		
		request.setAttribute("DeleteReturn", strReturn);
		request.setAttribute("DeleteStatus", deleteIndicator);
		
		request.getRequestDispatcher("result-deletetimebox.jsp").forward(request, response);
		
		
	}

}
