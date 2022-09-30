package com.demoweb.view;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractView;

//public class DownloadView implements View {
//	@Override
//	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//	}
//}

public class DownloadView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, // 컨트롤러에서 전달한 데이터 수신 
										   HttpServletRequest request,
										   HttpServletResponse response) throws Exception {
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();		
		out.write("<h2>Hello, Spring User Defined View !!!!!</h2>");
		out.write(model.get("now").toString());
		
		
	}

}









