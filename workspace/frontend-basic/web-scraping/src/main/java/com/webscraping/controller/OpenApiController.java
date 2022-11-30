package com.webscraping.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@Controller
@RequestMapping(path = "/openapi")
public class OpenApiController {
	
	@GetMapping(path = { "/covid19" })
	public String showCovid19Form(Model model) {
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String today = sdf.format(new Date());
			
			StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1352000/ODMS_COVID_02/callCovid02Api"); /*URL*/
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=R%2BBEwJ49XVmTutdoCAdNq4m7wjOsdFNhVtlzkxWVeZJPhwQqWbGcD7CNeQPipFzIWAanQVw%2FrPLsGkfcYvD4AQ%3D%3D"); /*Service Key*/
	        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
	        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("500", "UTF-8")); /*한 페이지 결과 수*/
	        urlBuilder.append("&" + URLEncoder.encode("apiType","UTF-8") + "=" + URLEncoder.encode("xml", "UTF-8")); /*결과형식(xml/json)*/
	        urlBuilder.append("&" + URLEncoder.encode("status_dt","UTF-8") + "=" + URLEncoder.encode(today, "UTF-8")); /*기준일자*/
	        
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        
	        System.out.println("Response code: " + conn.getResponseCode());
	        
//	        BufferedReader rd;
//	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
//	            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//	        } else {
//	            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
//	        }
//	        StringBuilder sb = new StringBuilder();
//	        String line;
//	        while ((line = rd.readLine()) != null) {
//	            sb.append(line);
//	        }
//	        rd.close();
//	        conn.disconnect();
//	        System.out.println(sb.toString());
	        
	        
	        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder builder = factory.newDocumentBuilder();
	        
	        Document doc = builder.parse(conn.getInputStream()); // xml 문자열 -> 객체 트리
	        
	        NodeList items = doc.getElementsByTagName("item");
	        
	        ArrayList<HashMap<String, Object>> data = new ArrayList<>();
	        
	        for (int i = 0; i < items.getLength(); i++) {
	        	Node node = items.item(i); // Node : tag, text, cdatasection, pi, declaration,
	        	//System.out.println("Node Type : " + node.getNodeType());
	        	//System.out.println("Node Name : " + node.getNodeName());
	        	
	        	HashMap<String, Object> tmp = new HashMap<>();
	        	NodeList children = node.getChildNodes();
	        	for (int j = 0; j < children.getLength(); j++) {
	        		Node child = children.item(j);
	        		//System.out.print(j + ". Node Type : " + child.getNodeType() + " / ");
	        		//System.out.print("Node Name : " + child.getNodeName() + " / ");
	        		//System.out.println("Node Value : " + child.getTextContent());
	        		if (child.getNodeType() == 1) {
	        			tmp.put(child.getNodeName(), child.getTextContent());
	        		}
	        	}
	        	data.add(tmp);
	        }
	        
	        model.addAttribute("data", data);
	        
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return "openapi/covid19";
	}

}
