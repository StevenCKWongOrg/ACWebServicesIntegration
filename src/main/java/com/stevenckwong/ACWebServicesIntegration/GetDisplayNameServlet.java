package com.stevenckwong.ACWebServicesIntegration;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rallydev.rest.RallyRestApi;


/**
 * Servlet implementation class GetDisplayNameServlet
 */
public class GetDisplayNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetDisplayNameServlet() {
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

		MyUtility myUtil = new MyUtility();
		
		String username = request.getParameter("username");
		// String apikey = request.getParameter("apikey");
		String apikey = myUtil.getReadOnlyApiKey();
		
		/*  // Refactored this part into MyUtility
		 * 
		RallyRestApi rally = myUtil.connectToRallyUsingAPIKey(apikey);
		
		String QueryString = "(UserName%20%3D%20"+username+")&start=1&pagesize=20";
		String queryURL = "/user?query=" + QueryString + "&order=";	
		String result = new String();
		boolean authenticated = true;
		try {
			result = rally.getClient().doGet(queryURL);
		} catch (java.io.IOException ioe) {
			String err = ioe.getMessage();
			result = err;
			// Full error message should be: HTTP/1.1 401 Full authentication is required to access this resource
			if (err.contains("401")) {
				authenticated = false;
			}
		}
		*/
		
		boolean authenticated = true;
		String result = new String();
		int totalResultCount = -1; // changed this to -1 as a zero value will cause all errors to be reported as User Not Found. 
		// TODO: Fix the above approach to track user not found.
		
		try {
			// result = myUtil.queryForDisplayName(apikey, username);
			result = myUtil.queryForUserDetails(apikey, username);
			totalResultCount = myUtil.parseJSONResultForTotalResultsCount(result);
		}
		catch (ACWebServicesException ace) {
			authenticated = false;
		}
		
		// String jsonResult = result;
		String displayName = "";
		String firstName = "";
		String lastName = "";
		
		// String lastName = "";
		// String displayNameJSON = "";
		
		if (authenticated) {
			displayName = myUtil.parseJSONResultForDisplayName(result);
			firstName = myUtil.parseJSONResultForFirstName(result);
			lastName = myUtil.parseJSONResultForLastName(result);
			
			// lastName = myUtil.parseJSONResultForLastName(result);
			
			// displayNameJSON = myUtil.parseJSONResultForDisplayName(jsonResult);
			
		} else {
			displayName = "unauthenticated";
			firstName = "unauthenticated";
			lastName = "unauthenticated";
			// lastName = "unauthenticated";
		}
		
		boolean noResults = false;
		String bUserDoesNotExist = "false";
		
		// if (displayName.contentEquals("0") || firstName.contentEquals("0") || lastName.contentEquals("0")) {
		if (totalResultCount==0) {
			noResults = true;
			bUserDoesNotExist = "true";
		} 
		
		
		// rally.close();
		
		response.getWriter().append("<html><head><title>Agile Central Get Display Name Service</title></head><body>");
		
		// Added code to handle a username that does not exist.
		if (noResults) {
			response.getWriter().append("<h1>User does not exist</h1>\n");
			displayName = "NotFound";
			firstName = "NotFound";
			lastName = "NotFound";
		} else if (displayName.equals("unauthenticated")) {
			/*
			response.getWriter().append("<h1>API Key is not valid</h1>\n");
			displayName = "unauthenticated";
			firstName = "unauthenticated";
			lastName = "unauthenticated";
			*/
			
			RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
			request.setAttribute("ErrorTitle","API Key is not valid");
			StringBuffer errorDetailedMessage = new StringBuffer();
			
			errorDetailedMessage.append("The API Key you provided to make this request is invalid.<br><br>");
			errorDetailedMessage.append("API Key Provided is: <br>" + apikey + "<br><br>");
			errorDetailedMessage.append("You can get your API Key by clicking <a href=\"https://rally1.rallydev.com/login\" target=\"_blank\">here</a><br><br><br>");
			
			request.setAttribute("ErrorDetailedMessage", errorDetailedMessage.toString());
			
			displayName = "unauthenticated";
			firstName = "unauthenticated";
			lastName = "unauthenticated";
			
			rd.forward(request, response);
			
		}
		else {
			response.getWriter().append("<h1>Display Name is " + displayName + "</h1>\n");
			// response.getWriter().append("<h1>Display Name (using JSON Parser) is " + displayNameJSON + "</h1>\n");
			response.getWriter().append("<h1>First Name is " + firstName + "</h1>\n");
			response.getWriter().append("<h1>Last Name is " + lastName + "</h1>\n");
		}

		response.getWriter().append("<input type=\"hidden\" id=\"displayName\" value=\"" + displayName + "\" />");
		response.getWriter().append("<input type=\"hidden\" id=\"firstName\" value=\"" + firstName + "\" />");
		response.getWriter().append("<input type=\"hidden\" id=\"lastName\" value=\"" + lastName + "\" />");
		response.getWriter().append("<input type=\"hidden\" id=\"userDoesNotExist\" value=\"" + bUserDoesNotExist + "\" />");

		response.getWriter().append("<br><br>Watch this space... we are rolling out more features soon...<br><br>");

		response.getWriter().append("Raw Result: <br>");
		response.getWriter().append("<span style=\"font-style:italics\">"+result+" </span><br><br>");
		
		response.getWriter().append("</body></html>");
		
		doGet(request, response);	
	
	}

}
