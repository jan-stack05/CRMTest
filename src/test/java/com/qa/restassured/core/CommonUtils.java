package com.qa.restassured.core;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.codehaus.jackson.JsonNode;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CommonUtils {

 public static JSONParser parser = new JSONParser();
 public static JsonNode jnode=null;
 public static JSONObject createJSONRequest(String jsonFilePath,String jsonFileNew,ArrayList al){
        JSONObject jsonObject =null;
       // JSONParser parser = new JSONParser();
  try {
   Object obj = parser.parse(new FileReader(jsonFilePath));
   jsonObject = (JSONObject) obj;
   
   for(int i=0;i<al.size();i++){
   Object key=al.get(i);
   String keyVal = (String) jsonObject.get(key);
   System.out.println(keyVal);
            String val= keyVal+CommonUtils.getCurrentTimeStamp();
   jsonObject.put(key,val);
   }
       try {
    FileWriter file = new FileWriter(jsonFileNew);
    file.write(jsonObject.toJSONString());
    file.flush();
    file.close();
   } catch (IOException e) {
    e.printStackTrace();
   }
   System.out.print(jsonObject);
  } catch (FileNotFoundException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  } catch (ParseException e) {
   e.printStackTrace();
  }
                return jsonObject;
    }
 
 
  public static String getCurrentTimeStamp() {
        java.util.Date todayDate = new java.util.Date();
     String timeStamp = new java.sql.Timestamp(todayDate.getTime()).toString();
        timeStamp = timeStamp.substring(0,19);
        timeStamp = timeStamp.replaceAll("(\\s+|:|-|\\.)", "_");
        return "_" + timeStamp;
    }
  
  public static String getcurrentTimeUTC() {

      Calendar cal = Calendar.getInstance();
		Date currenttime = cal.getTime();
		SimpleDateFormat dateFormatUTC = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		dateFormatUTC.setTimeZone(TimeZone.getTimeZone("UTC"));
		String start_time=dateFormatUTC.format(currenttime);
      return start_time;
  }
	
	public static String getfutureTimeUTC(int time) {

      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.MINUTE, +time);
		Date endtime = cal.getTime();
		SimpleDateFormat dateFormatUTC = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		dateFormatUTC.setTimeZone(TimeZone.getTimeZone("UTC"));
		String end_time=dateFormatUTC.format(endtime);
      return end_time;
  }

	public static String getpastTimeUTC(int time) {

	      Calendar cal = Calendar.getInstance();
	      cal.add(Calendar.MINUTE, -time);
			Date endtime = cal.getTime();
			SimpleDateFormat dateFormatUTC = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			dateFormatUTC.setTimeZone(TimeZone.getTimeZone("UTC"));
			String end_time=dateFormatUTC.format(endtime);
	      return end_time;
	  }

	/**
  * @param tcName
  */

 public static void printStartTest(String tcName){
  System.out.println("");
  System.out.println("******Start Test: "+tcName+"  *********************************");
 }

 /**
  * @param tcName
  */
 public static void printEndTest(String tcName){
  System.out.println("****** Test: "+tcName+" Passed  ***************************");
  System.out.println("");
 }
 
 /**
  * @param filepath
  * @param String Json
  */
 public static void writejsoninfile(String json, String FilePath){
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