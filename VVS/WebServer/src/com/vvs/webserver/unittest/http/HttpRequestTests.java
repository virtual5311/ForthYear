package com.vvs.webserver.unittest.http;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringBufferInputStream;

import org.junit.Test;

import com.vvs.webserver.HTTP.HttpRequest;

@SuppressWarnings("deprecation")
public class HttpRequestTests {

	@Test(expected = IllegalArgumentException.class)
	public void testConstructorNull() {
		try {
			new HttpRequest(null);
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test()
	public void testValidGet1() throws Exception {
		StringBufferInputStream s = new StringBufferInputStream("GET / HTTP/1.1\r\nHost: www.example.com\r\nConnection: closed");
		HttpRequest request = new HttpRequest(s);
		assertEquals(request.isInvalid(), false);
		assertEquals(request.getHttpMethod(), "GET");
		assertEquals(request.getPath(), "");
		assertEquals(request.getProtocol(), "HTTP/1.1");
		assertEquals(request.getRequest(), "GET / HTTP/1.1\r\nHost: www.example.com\r\nConnection: closed");
	}
	
	@Test()
	public void testValidGet2() throws Exception {
		StringBufferInputStream s = new StringBufferInputStream("GET www.example.com/a/b/c/merecupere/siterte/a.html?am=pere HTTP/1.1\r\nHost: www.example.com\r\nConnection: closed");
		HttpRequest request = new HttpRequest(s);
		assertEquals(request.isInvalid(), false);
		assertEquals(request.getHttpMethod(), "GET");
		assertEquals(request.getPath(), "a/b/c/merecupere/siterte/a.html");
		assertEquals(request.getProtocol(), "HTTP/1.1");
		assertEquals(request.getRequest(), "GET www.example.com/a/b/c/merecupere/siterte/a.html?am=pere HTTP/1.1\r\nHost: www.example.com\r\nConnection: closed");
	}
	
	@Test()
	public void testValidGet3() throws Exception {
		StringBufferInputStream s = new StringBufferInputStream("GET http://www.example.com/a/b/c/merecupere/siterte/a.html?am=pere HTTP/1.1\r\nHost: www.example.com\r\nConnection: closed");
		HttpRequest request = new HttpRequest(s);
		assertEquals(request.isInvalid(), false);
		assertEquals(request.getHttpMethod(), "GET");
		assertEquals(request.getPath(), "a/b/c/merecupere/siterte/a.html");
		assertEquals(request.getProtocol(), "HTTP/1.1");
		assertEquals(request.getRequest(), "GET http://www.example.com/a/b/c/merecupere/siterte/a.html?am=pere HTTP/1.1\r\nHost: www.example.com\r\nConnection: closed");
	}
	
	@Test()
	public void testInvalidGet1() throws Exception {
		StringBufferInputStream s = new StringBufferInputStream("");
		HttpRequest request = new HttpRequest(s);
		assertEquals(request.isInvalid(), true);
		assertEquals(request.getHttpMethod(), "");
		assertEquals(request.getPath(), "}{}{}{");
		assertEquals(request.getProtocol(), "ana are mere multe si frumoase :)");
		assertEquals(request.getRequest(), "");
	}
	
	@Test()
	public void testInvalidGet2() throws Exception {
		StringBufferInputStream s = new StringBufferInputStream("GET");
		HttpRequest request = new HttpRequest(s);
		assertEquals(request.isInvalid(), true);
		assertEquals(request.getHttpMethod(), "");
		assertEquals(request.getPath(), "}{}{}{");
		assertEquals(request.getProtocol(), "ana are mere multe si frumoase :)");
		assertEquals(request.getRequest(), "GET");
	}
	
	@Test()
	public void testInvalidGet3() throws Exception {
		StringBufferInputStream s = new StringBufferInputStream("GET ??????");
		HttpRequest request = new HttpRequest(s);
		assertEquals(request.isInvalid(), true);
		assertEquals(request.getHttpMethod(), "");
		assertEquals(request.getPath(), "}{}{}{");
		assertEquals(request.getProtocol(), "ana are mere multe si frumoase :)");
		assertEquals(request.getRequest(), "GET ??????");
	}
}
