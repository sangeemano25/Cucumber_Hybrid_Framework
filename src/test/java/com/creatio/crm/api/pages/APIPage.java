package com.creatio.crm.api.pages;

import org.json.JSONObject;

public class APIPage {
	
	//method to create a request body to create new repo
	public static String createRequestBody(String name, String desc, String visibility) {
		JSONObject body = new JSONObject();
		body.put("name", name);
		body.put("description", desc);
		body.put("private", Boolean.parseBoolean(visibility));
		return body.toString();
		
	}

	public static String updateRepoRequestBody(String visibility) {
		JSONObject body = new JSONObject();
		body.put("private", Boolean.parseBoolean(visibility));
		return body.toString();
		
	}
}
