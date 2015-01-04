package com.vvs.webserver.HTTP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class HttpRequest {
	private String httpMethod_;
	private String httpPath_;
	private String protocol_;
	private String request_;
	private String host;
	private String fullHttpPath_;
	private boolean invalidRequest_ = false;
	
	public HttpRequest (InputStream in) throws IOException, IllegalArgumentException {
		if (null == in) {
			throw new IllegalArgumentException();
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		
		host = "127.0.0.1";
		StringBuilder request = new StringBuilder("");
		for (String line; null != (line = reader.readLine()); ) {
			if (line.trim().isEmpty()) {
				break;
			}
			if (line.startsWith("Host:")) {
				host = line.substring(line.indexOf("Host") + 4).trim();
			}
			request.append(line + "\r\n");
		}
		request_ = request.toString().trim();
		try {
			StringTokenizer tokenizer = new StringTokenizer(request.toString());
			httpMethod_ = tokenizer.nextToken();
			httpPath_ = tokenizer.nextToken();
			protocol_ = tokenizer.nextToken();
			
			if (httpPath_.contains("www.")) {
				httpPath_ = httpPath_.substring(httpPath_.indexOf('/', httpPath_.indexOf("www.") + 4) + 1);
			}
			fullHttpPath_ = httpPath_;
			if (httpPath_.contains("?")) {
				httpPath_ = httpPath_.substring(0, httpPath_.indexOf('?'));
			}
			if (httpPath_.startsWith("/")) {
				httpPath_ = httpPath_.substring(1);
			}
			httpPath_ = URLDecoder.decode(httpPath_, "UTF-8");
		} catch (NoSuchElementException e) {
			invalidRequest_ = true;
			httpMethod_ = "";
			httpPath_ = "}{}{}{";
			protocol_ = "ana are mere multe si frumoase :)";
		}
	}
	
	public String getRequest() {return request_;}
	
	public String getHost()      {return host;}
	
	public boolean isLocalhost() {return host.startsWith("127.0.0.1") || host.startsWith("localhost");}
	
	public String getFullHttpPath() {return fullHttpPath_;}
	
	public String getHttpMethod() {return httpMethod_;}
	
	public String getPath() {return httpPath_;}
	
	public String getProtocol() {return protocol_;}

	public boolean isInvalid() {return invalidRequest_;}
}