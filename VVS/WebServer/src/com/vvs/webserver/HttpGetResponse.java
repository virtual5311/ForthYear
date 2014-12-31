package com.vvs.webserver;

import java.io.OutputStream;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.util.Date;
import java.util.StringTokenizer;

public class HttpGetResponse {
	private String response_;
	private String httpCode_;
	private String date_;
	private String server_;
	private String contentLenght_;
	private String contentType_;
	private String connection_;
	private String body_;
	
	public HttpGetResponse (HttpRequest request, Path base) {
		server_ = "Server: vvs webserver (Mac)\r\n";
		connection_ = "Connection: Keep-Alive\r\n\r\n";
		date_ = "Date: " + new Timestamp(new Date().getTime()).toString() + "\r\n";
		
		if ("GET".equals(request.getHttpMethod())) {
			
		}
	}
	
	public void send(OutputStream out) {
		
	}
}