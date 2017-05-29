package it.germesoft.web_service.utilities;



import it.germesoft.web_service.dto.ResultDTO;

import java.io.InputStream;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Utilities {
	
	public static Properties readConfigProperties(String propertiesName) throws Exception {

		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//		InputStream resourceAsStream = classLoader.getResourceAsStream("../config.properties");
		InputStream resourceAsStream = classLoader.getResourceAsStream(propertiesName);
		Properties properties = new Properties();
		properties.load(resourceAsStream);
		return properties;

	}
	
	
	public static String resultDtoToStringJson(ResultDTO result) throws Exception{
        String response = "";
        try {
        	
			ObjectMapper mapperObj = new ObjectMapper();
			response =  mapperObj.writeValueAsString(result);
			
		} catch (Exception e) {
			throw e;
		}
        
        return response;
    }
	
	
	public static String objectToStringJson(Object obj) throws Exception{
        String response = "";
        try {
        	
			ObjectMapper mapperObj = new ObjectMapper();
			response =  mapperObj.writeValueAsString(obj);
			
		} catch (Exception e) {
			throw e;
		}
        
        return response;
    }
}
