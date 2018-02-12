package com.stevenckwong.ACWebServicesIntegration;

import java.io.IOException;
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

		String username = request.getParameter("username");
		String apikey = request.getParameter("apikey");
		
		MyUtility myUtil = new MyUtility();
		
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
		
		try {
			result = myUtil.queryForDisplayName(apikey, username);
		}
		catch (ACWebServicesException ace) {
			authenticated = false;
		}
		
		String displayName = "";
		String firstName = "";
		String displayNameJSON = "";
		
		if (authenticated) {
			displayName = myUtil.parseResultForDisplayName(result);
			firstName = myUtil.parseResultForFirstName(result);
			displayNameJSON = myUtil.parseJSONResultForDisplayName(jsonResult);
			
		} else {
			displayName = "unauthenticated";
		}
		
		// rally.close();
		
		response.getWriter().append("<html><head><title>Agile Central Get Display Name Service</title></head><body>");
		
		// Added code to handle a username that does not exist.
		if (displayName.equals("_rallyAPIMajor")) {
			response.getWriter().append("<h1>User does not exist</h1>\n");
			displayName = "NotFound";
			firstName = "NotFound";
		} else if (displayName.equals("unauthenticated")) {
			response.getWriter().append("<h1>API Key is not valid</h1>\n");
			displayName = "unauthenticated";
			firstName = "unauthenticated";
		}
		else {
			response.getWriter().append("<h1>Display Name is " + displayName + "</h1>\n");
			response.getWriter().append("<h1>Display Name (using JSON Parser) is " + displayNameJSON + "</h1>\n");
			response.getWriter().append("<h1>First Name is " + firstName + "</h1>\n");
		}

		response.getWriter().append("<input type=\"hidden\" id=\"displayName\" value=\"" + displayName + "\" />");
		response.getWriter().append("<input type=\"hidden\" id=\"firstName\" value=\"" + firstName + "\" />");

		response.getWriter().append("<br><br>Watch this space... we are rolling out more features soon...<br><br>");

		response.getWriter().append("Raw Result: <br>");
		response.getWriter().append("<span style=\"font-style:italics\">"+result+" </span><br><br>");
		
		response.getWriter().append("</body></html>");
		
		doGet(request, response);	
	
	}

}
