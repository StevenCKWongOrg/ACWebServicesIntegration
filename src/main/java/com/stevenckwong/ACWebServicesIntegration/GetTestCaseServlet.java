package com.stevenckwong.ACWebServicesIntegration;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetTestCaseServlet
 */
public class GetTestCaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetTestCaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String tcid = (String)request.getParameter("testcaseid");
		String apikey = (String)request.getParameter("apikey");
		String result = "No Result";
				
		MyUtility myUtil = new MyUtility();
		try {
			result = myUtil.queryForTestCaseDetails(apikey, tcid);
		} catch (ACWebServicesException ace) {
			result = ace.getErrorMessage();
		}
		
		request.setAttribute("testcaseid", tcid);
		request.setAttribute("apikey", apikey);
		request.setAttribute("rawResult", result);
		
		request.getRequestDispatcher("testcasedetails.jsp").forward(request, response);
		
		// response.getWriter().append("Searching for " + tcid + "<br>");
		// doGet(request, response);
	}

}