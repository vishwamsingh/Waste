package org.mywaste;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * Servlet implementation class NewWaste
 */


public class NewWaste extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<WasteType> wasteTypeList=WasteTypeListFactory.getWasteTypeList(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewWaste() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("-----------Get is called-----------");
		//System.out.println("typename:"+request.getParameter("typename"));
		//System.out.println("photorequired:"+request.getParameter("photorequired"));
		WasteType wastetype= WasteTypeFactory.getWasteTypeList(request.getParameter("typename"), request.getParameter("photorequired"));
		wasteTypeList.add(wastetype);
		//WasteTypeListFactory.printList();
		
		
		/*
		 * JSONArray jsonArray = new JSONArray();
		 
		for(WasteType iwasteType : wasteTypeList) {
			JSONObject jsonobject = new JSONObject();
			try {
				jsonobject.put("typename", iwasteType.getType());
				jsonobject.put("photorequired", iwasteType.getPhotoRequired());
				jsonArray.put(jsonobject);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.getWriter().write(jsonArray.toString());
		System.out.println(jsonArray.toString());
		*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStreamReader isr = new InputStreamReader(request.getInputStream());
		BufferedReader in = new BufferedReader(isr);
		String line = in.readLine();
		JSONObject json;

		try {

		    json = new JSONObject(line); 
		    //String jsonString = json.toString();
		    String[] names = JSONObject.getNames(json);

		    for (int i=0 ; i < names.length ; i++) {
		        System.out.println(names[i] + " : " + json.getString(names[i]));
		    }

		} catch (JSONException e) { e.printStackTrace(); }
	}

}
