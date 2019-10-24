package rpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * 
 * @author w2150
 *
 */
public class RpcHelper {
	//Write a JSONArray to http response
	/**
	 * 
	 * @param response
	 * @param array
	 * @throws IOException
	 */
	public static void writeJsonArray(HttpServletResponse response, JSONArray array) throws IOException{
		//Set the content type to JSON in the response
		response.setContentType("application/json");
		//Set header for front end
		response.setHeader("Access-Control-Allow-Origin","*");
		//Initialize a PrintWriter of the response to write data to the body of response
		PrintWriter out = response.getWriter();
		//Write the array to response
		out.print(array);
		//Close the PrintWriter
		out.close();
	}
	//Write a JSONObject to http response
	/**
	 * 
	 * @param response
	 * @param obj
	 * @throws IOException
	 */
	public static void writeJsonObject(HttpServletResponse response, JSONObject obj) throws IOException{
		//This follows the same procedure of writeJsonArray()
		response.setContentType("application/json");
		response.setHeader("Access-Control-Allow-Origin","*");
		PrintWriter out = response.getWriter();
		out.print(obj);
		out.close();
	}
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static JSONObject readJSONObject(HttpServletRequest request) {
		//
		StringBuilder sBuilder = new StringBuilder();
		try(BufferedReader reader = request.getReader()){
			String line = null;
			while((line = reader.readLine())!=null) {
				sBuilder.append(line);
			}
			return new JSONObject(sBuilder.toString());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return new JSONObject();
	}
}
