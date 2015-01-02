package com.vvs.webserver;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.util.Date;

import javax.activation.MimetypesFileTypeMap;

public class HttpGetResponse {
	private String httpCode_;
	private String date_;
	private String server_;
	private String contentLength_;
	private String contentType_;
	private String connection_;
	private String body_;
	
	public HttpGetResponse (HttpRequest request, Path base) {
		server_ = "Server: vvs webserver (Mac)\r\n";
		connection_ = "Connection: Keep-Alive\r\n\r\n";
		contentType_ = "text/html; charset=UTF-8\r\n";
		date_ = "Date: " + new Timestamp(new Date().getTime()).toString() + "\r\n";
		
		File f;
		if (request.getPath().isEmpty()) {
			f = base.resolveSibling("index.html").toFile();
		}
		else {
			f = base.resolveSibling(request.getPath()).toFile();
		}
		
		if (!"GET".equals(request.getHttpMethod())) {
			httpCode_ = "HTTP/1.1 501 Not implemented\r\n";
			body_ = "<!DOCTYPE html>" +
					"<html>" +
						"<head>" +
							"<title> 501 Not implemented </title>" +
						"</head>" +
						"<body>" +
							"<p> The Http method used in request is not supported by this server ! </p>" +
						"</body>" +
					"</html>";
			contentLength_ = "Content-Length: " + body_.length() + "\r\n";
			connection_ = "Connection: closed\r\n\r\n";
		}
		else if (!f.exists()) {
			httpCode_ = "HTTP/1.1 404 Not Found\r\n";
			body_ = "<!DOCTYPE html>" +
					"<html>" +
						"<head>" +
							"<title> 404 Not Found </title>" +
						"</head>" +
						"<body>" +
							"<p> The file was not found on the server ! </p>" +
						"</body>" +
					"</html>";
			contentLength_ = "Content-Length: " + body_.length() + "\r\n";
			connection_ = "Connection: closed\r\n\r\n";
		}
		else {
			httpCode_ = "HTTP/1.1 200 OK";
			String encoding = "UTF-8";
			try (InputStreamReader input = new InputStreamReader(new FileInputStream(f));) {
				encoding = input.getEncoding();	
				for (int ch = input.read(); -1 != ch; ch = input.read()) {
					body_ = String.format("%c%s", ch, body_);
				}
			} catch (Exception e) {
			}
			
			contentType_ =  new MimetypesFileTypeMap().getContentType(f) + "; " + encoding + "\r\n";
			contentLength_ = "Content-Length: " + body_.length() + "\r\n";
		}
	}
	
	public void send(OutputStream out) {
		String response = httpCode_ +
						  date_ +
						  server_ +
						  "Accept-Ranges: bytes" +
						  contentLength_ +
						  contentType_ +
						  connection_ +
						  body_;
		new PrintWriter(out).write(response);
	}
}
