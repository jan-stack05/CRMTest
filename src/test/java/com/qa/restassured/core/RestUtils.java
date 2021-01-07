package com.qa.restassured.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.jayway.restassured.response.Response;

public class RestUtils {

	/**
	 * Create JSONObject and change the value for given key
	 * 
	 * @param jsonFile
	 * @param key
	 * @return
	 */
	public static JSONObject createJSONObjWithKey(String jsonFile,
			String bsName, String val) {
		JSONObject jsonObject = null;
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(jsonFile));
			jsonObject = (JSONObject) obj;
			JSONObject jsonObjtmp = (JSONObject) jsonObject.get("data");
			JSONArray jsonObjtmp1 = (JSONArray) jsonObjtmp.get("cmdb.item");
			JSONObject jsonObjName = (JSONObject) jsonObjtmp1.get(0);
			jsonObjName.put("name", bsName);
			JSONObject jsonObjId = (JSONObject) jsonObjtmp1.get(1);
			jsonObjId.put("id", val);
			try {
				File f = new File(jsonFile);
				FileWriter file = new FileWriter(jsonFile);
				file.write(jsonObject.toJSONString());
				file.flush();
				file.close();
			} catch (IOException e) {
				e.fillInStackTrace().toString();
			}
		} catch (FileNotFoundException e) {
			e.fillInStackTrace().toString();
		} catch (IOException e) {
			e.fillInStackTrace().toString();
		} catch (ParseException e) {
			e.fillInStackTrace().toString();
		}
		return jsonObject;
	}

	// parse the json response
	public static String parseRespWithJSONNode(Response resp) {
		JsonNode jnode = null;
		String id = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonFactory factory = mapper.getJsonFactory();
			JsonParser parser = factory.createJsonParser(resp.asString());
			jnode = mapper.readTree(parser);
			System.out.println("jnode size is:" + jnode.size());
		//	id = jnode.findValue("id").asText();

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return id;
	}

	/**
	 * @param filepath
	 * @param String Json
	 */
	public static void writeJsonInFile(String json, String FilePath){
		try{
		FileWriter file = new FileWriter(FilePath);
		file.write(json);
		file.flush();
		file.close();
	}
	 catch (IOException e) {
			e.printStackTrace();}
		}

}

