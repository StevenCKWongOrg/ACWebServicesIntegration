package com.stevenckwong.ACWebServicesIntegration;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stevenckwong.ACWebServicesIntegration.dom.RallyTestCase;

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
		
			if (request.getParameter("getTestCaseDetailsByIDButton")!=null) {
				this.processTestCaseDetailsQueries(request, response);
			} else if (request.getParameter("getTestCaseDetailsByNameButton")!=null) {
				this.processTestCaseDetailsQueries(request, response);
			} else if (request.getParameter("getTestCaseByOwnerUserNameButton")!=null) {
				this.processTestCaseListQueries(request, response);
			} else if (request.getParameter("getTestCaseDetailsByPartialNameButton") != null) {
				this.processTestCaseListQueries(request, response);
			} else if (request.getParameter("getTestCaseListByWorkProductID") != null) {
				this.processTestCaseListQueries(request, response);
			} else {
				// a dummy search - Tech Debt here that needs to be cleaned up later
				// This case shouldn't run at all.
				System.out.println("Error - This is unreachable code");
			}

	}

	public void processTestCaseDetailsQueries(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MyUtility myUtil = new MyUtility();
		
		String tcid = (String)request.getParameter("testcaseid");
		String tcName = (String)request.getParameter("testcasename");
		//String apikey = (String)request.getParameter("apikeyForTC");
		String apikey = myUtil.getReadOnlyApiKey();
		String panelColour = (String)request.getParameter("panelColour");
		
		String result = "No Result";
		RallyTestCase tcObject = new RallyTestCase();
		
		
		
		try {
			// check which Get Test Case button is clicked...
			
			if (request.getParameter("getTestCaseDetailsByIDButton")!=null) {
				result = myUtil.queryForTestCaseDetailsByID(apikey, tcid);
			} else if (request.getParameter("getTestCaseDetailsByNameButton")!=null) {
				result = myUtil.queryForTestCaseDetailsByName(apikey, tcName);
			} else {
				// a dummy search - Tech Debt here that needs to be cleaned up later
				// This case shouldn't run at all.
				result = myUtil.queryForTestCaseDetailsByID(apikey, "TC0");
			}
			
			ArrayList<RallyTestCase> rallyTestCases = myUtil.parseJSONResultForListOfTestCases(result);
			
			tcObject = rallyTestCases.get(0);
			
		} catch (ACWebServicesException ace) {
			result = ace.getErrorMessage();
		}
		
		request.setAttribute("testcaseid", tcid);
		request.setAttribute("apikey", apikey);
		request.setAttribute("testCaseObject", tcObject);
		request.setAttribute("rawResult", result);
		request.setAttribute("panelColour", panelColour);
		
		request.getRequestDispatcher("testcasedetails.jsp").forward(request, response);
		
		// response.getWriter().append("Searching for " + tcid + "<br>");
		// doGet(request, response);	
	
	}
	
	public void processTestCaseListQueries(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MyUtility myUtil = new MyUtility();
		
		// TODO Auto-generated method stub
		String tcid = (String)request.getParameter("testcaseid");
		String tcName = (String)request.getParameter("testcasename");
		String partialTCName = (String)request.getParameter("partialtestcasename");
		// String apikey = (String)request.getParameter("apikeyForTC");
		String apikey = myUtil.getReadOnlyApiKey();
		String panelColour = (String)request.getParameter("panelColour");
		String ownerUsername = (String)request.getParameter("ownerUsername");
		String workProductID = (String)request.getParameter("workproductid");
		
		String result = "No Result";
		ArrayList<RallyTestCase> rallyTestCases = new ArrayList<RallyTestCase>();
		
		
		
		try {
			// check which Get Test Case button is clicked...
			
			if (request.getParameter("getTestCaseByOwnerUserNameButton")!=null) {
				result = myUtil.queryForTestCasesByOwnerUsername(apikey, ownerUsername);
			} else if (request.getParameter("getTestCaseDetailsByPartialNameButton")!=null) {
				result = myUtil.queryForTestCaseDetailsByName(apikey, partialTCName);
			} else if (request.getParameter("getTestCaseListByWorkProductID")!=null) {
				result = myUtil.queryForTestCaseListByWorkProductID(apikey, workProductID);
			}
			else {
				// a dummy search - Tech Debt here that needs to be cleaned up later
				// This case shouldn't run at all.
				result = myUtil.queryForTestCaseDetailsByID(apikey, "TC0");
			}
				
			// int noOfResults = myUtil.parseJSONResultForTotalResultsCount(result);
			
			rallyTestCases = myUtil.parseJSONResultForListOfTestCases(result);
				
			
		} catch (ACWebServicesException ace) {
			result = ace.getErrorMessage();
		}
		
		request.setAttribute("testcaseid", tcid);
		// request.setAttribute("apikey", apikey);
		request.setAttribute("testCases", rallyTestCases);
		request.setAttribute("rawResult", result);
		request.setAttribute("panelColour", panelColour);
		request.setAttribute("owner",ownerUsername);
		
		request.getRequestDispatcher("testcaselist.jsp").forward(request, response);
		
		// response.getWriter().append("Searching for " + tcid + "<br>");
		// doGet(request, response);	
	
	}
	
	
}
