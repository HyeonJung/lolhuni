package com.hj.lolhuni.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpConnectionUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpConnectionUtil.class);
	
	/**
	 * http get for xml type
	 * @param url
	 * @return
	 */
	public static String connectGetXml(String url) {
		
		String ret = "";
		
//		try {
//			URL connectUrl = new URL(url);
//			
//			HttpURLConnection conn = (HttpURLConnection) connectUrl.openConnection();
//	        
//	        conn.setRequestMethod("GET");
//	        
//
//	        ret = XmlParseUtil.getXmlElement(conn.getInputStream());
//	
//	        logger.debug("### ret in HttpConnectionUtil = {}", ret);
//	        
//	        conn.disconnect();
//	     
//		} catch (Exception e) {
//			logger.error("### error", e);
//		}
		
		return ret;
	}
	
	/**
	 * http get for json type
	 */
	public static String connectGetJson(String url) {
		
		String ret = "";
		
		try {
			URL connectUrl = new URL(url);
			
			HttpURLConnection conn = (HttpURLConnection) connectUrl.openConnection();
			
			conn.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(
			        new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			ret = response.toString();
			
		} catch (Exception e) {
			logger.error("### error", e);
		}
		
		
		return ret;
	}
}
