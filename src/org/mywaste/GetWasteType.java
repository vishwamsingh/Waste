package org.mywaste;

import java.io.IOException;
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
 * Servlet implementation class GetWasteType
 */

public class GetWasteType extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<WasteType> wasteTypeList=WasteTypeListFactory.getWasteTypeList(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetWasteType() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		JSONArray jsonArray = new JSONArray();
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
		System.out.println("------"+jsonArray.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
