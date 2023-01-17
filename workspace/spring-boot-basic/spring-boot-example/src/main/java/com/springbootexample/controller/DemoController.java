package com.springbootexample.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class DemoController {

	@GetMapping(path = { "/", "/home" })
	public String home() {
		
		return "demo-home";
	}
	
	@GetMapping(path = { "/get-greetings" })
	@ResponseBody
	public String getGreetings(String name) {
	
		try {
			String path = "http://localhost:5000/demo/get-greetings" + ( name != null ? "?name=" + URLEncoder.encode(name, "utf-8") : "");
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			int respCode = conn.getResponseCode();
			if (respCode == HttpURLConnection.HTTP_OK) {
				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String message = "";
				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}
					message += line;
				}
		
				return "MESSAGE FROM FLASK : " + message;
			} else {
				return "fail to receive data 1";
			}
		} catch (Exception ex) {
			return "fail to receive data 2";
		}
		
	}


	@GetMapping(path = { "/get-winning-numbers" })
	@ResponseBody
	public String getWinningNumbers() {
		
		try {
			String path = "http://localhost:5000/demo/get-winning-numbers";
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			
			int respCode = conn.getResponseCode();
			if (respCode == HttpURLConnection.HTTP_OK) {
				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String message = "";
				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}
					message += line;
				}
		
				return message;
			} else {
				return "fail to receive data 1";
			}
		} catch (Exception ex) {
			return "fail to receive data 2";
		}
	}
	
	@PostMapping(path = { "/login" })
	@ResponseBody
	public String login(String memberId, String passwd) {
		
		try {
			String path = "http://localhost:5000/auth/find-member-to-login?id=" + memberId + "&passwd=" + passwd;
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("GET");
			
			int respCode = conn.getResponseCode();
			if (respCode == HttpURLConnection.HTTP_OK) {
				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String message = "";
				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}
					message += line;
				}
		
				return message;
			} else {
				return "fail to receive data 1";
			}
		} catch (Exception ex) {
			return "fail to receive data 2";
		}
	}
	
	@PostMapping(path = { "/login2" })
	@ResponseBody
	public String login2(String memberId, String passwd) {
		
		try {
			String path = "http://localhost:5000/auth/find-member-to-login";
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			
			conn.setDoOutput(true); // 요청 스트림에 데이터 쓰기 가능
			OutputStream os = conn.getOutputStream();
			os.write(String.format("id=%s&passwd=%s",  memberId, passwd).getBytes("utf-8")); // id=...&passwd=...
			os.flush();
			os.close();
			
			int respCode = conn.getResponseCode();
			if (respCode == HttpURLConnection.HTTP_OK) {
				InputStream is = conn.getInputStream();
				InputStreamReader isr = new InputStreamReader(is, "utf-8");
				BufferedReader br = new BufferedReader(isr);
				String message = "";
				while (true) {
					String line = br.readLine();
					if (line == null) {
						break;
					}
					message += line;
				}
		
				return message;
			} else {
				return "fail to receive data 1";
			}
		} catch (Exception ex) {
			return "fail to receive data 2";
		}
	}
	
	@PostMapping(path = { "/upload-file" })
	@ResponseBody
	public String uploadFile(MultipartFile file1, MultipartFile file2) {
		
		if (file1 == null || file2 == null || 
			file1.getOriginalFilename() == null || file1.getOriginalFilename().length() == 0 ||
			file2.getOriginalFilename() == null || file2.getOriginalFilename().length() == 0) {
			return "file not uploaded";
		}
		
		try {
			String boundary = UUID.randomUUID().toString();
			
			// 1. 연결 설정
			URL url = new URL("http://localhost:5000/demo/upload-file");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);		// POST
			conn.setDoInput(true);
			conn.setUseCaches(false);
			conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/109.0.0.0 Safari/537.36 Edg/109.0.1518.52");
			
			// 2. 전송 준비
			OutputStream os = conn.getOutputStream();
			PrintWriter writer = new PrintWriter(os, true, Charset.forName("utf-8"));
			
			//3-1. 전송1 (전송 데이터에 대한 정보)
			writer.append("--").append(boundary).append("\r\n");
			writer.append("Content-Disposition: form-data; name=\"file1\"; filename=\"" + file1.getOriginalFilename() + "\"").append("\r\n");
			writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(file1.getOriginalFilename())).append("\r\n");
			writer.append("Content-Transfer-Encoding: binary").append("\r\n");
			writer.append("\r\n");
			writer.flush();
			
			//3-2. 전송2 (데이터)
			InputStream is = file1.getInputStream();
			byte[] buffer = new byte[4096];
			while (true) {
				int count = is.read(buffer, 0, buffer.length);
				if (count == -1) { // End of File
					break;
				}
				os.write(buffer, 0, count); // 읽은 갯수만큼 쓰기
			}
			os.flush();
			is.close();
			writer.append("\r\n");
			writer.flush();
			
			
			// 4. 전송 종료
			writer.append("--").append(boundary).append("--").append("\r\n"); // --boundary-- : 전송 끝
			writer.close();
			// os.close();
			
			// 5. 응답 수진
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				// do nothing				
			} else {
				return "fail 1";
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		
		return "success";
		
	}
}













