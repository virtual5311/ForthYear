package com.vvs.webserver.unittest.http;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.StringBufferInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import com.vvs.webserver.HTTP.HttpGetResponse;
import com.vvs.webserver.HTTP.HttpRequest;

public class HttpGetResponseTest {
	private HttpRequest request;
	private Path base;
	private File f;
	
	@Before
	public void setUp() {
		@SuppressWarnings("deprecation")
		StringBufferInputStream s = new StringBufferInputStream("GET / HTTP/1.1\r\nHost: www.example.com\r\nConnection: closed");
		 try {
			request = new HttpRequest(s);
		} catch (IllegalArgumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testHttpGetResponseNullBase()
		 {
		

		new HttpGetResponse(request, base);

		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHttpGetResponseNullRequest()
		 {
		
		 new HttpGetResponse(null, base);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHttpGetResponseNullAll() {
		new HttpGetResponse(null, null);
	}

	/**
	 * Run the void send(OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/3/15 4:40 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testSend_1()
		throws Exception {
		HttpGetResponse fixture = new HttpGetResponse(request, base);
		OutputStream out = new ByteArrayOutputStream();

		fixture.send(out);

		// add additional test code here
	}

	/**
	 * Run the void send(OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/3/15 4:40 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testSend_2()
		throws Exception {
		HttpGetResponse fixture = new HttpGetResponse(new HttpRequest(new PipedInputStream()), (Path) null);
		OutputStream out = new ByteArrayOutputStream();

		fixture.send(out);

		// add additional test code here
	}

	/**
	 * Run the void send(OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/3/15 4:40 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testSend_3()
		throws Exception {
		HttpGetResponse fixture = new HttpGetResponse(new HttpRequest(new PipedInputStream()), (Path) null);
		OutputStream out = new ByteArrayOutputStream();

		fixture.send(out);

		// add additional test code here
	}

	/**
	 * Run the void send(OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/3/15 4:40 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testSend_4()
		throws Exception {
		HttpGetResponse fixture = new HttpGetResponse(new HttpRequest(new PipedInputStream()), (Path) null);
		OutputStream out = new ByteArrayOutputStream();

		fixture.send(out);

		// add additional test code here
	}

	/**
	 * Run the void send(OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/3/15 4:40 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testSend_5()
		throws Exception {
		HttpGetResponse fixture = new HttpGetResponse(new HttpRequest(new PipedInputStream()), (Path) null);
		OutputStream out = new ByteArrayOutputStream();

		fixture.send(out);

		// add additional test code here
	}

	/**
	 * Run the void send(OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/3/15 4:40 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testSend_6()
		throws Exception {
		HttpGetResponse fixture = new HttpGetResponse(new HttpRequest(new PipedInputStream()), (Path) null);
		OutputStream out = new ByteArrayOutputStream();

		fixture.send(out);

		// add additional test code here
	}

	/**
	 * Run the void send(OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/3/15 4:40 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testSend_7()
		throws Exception {
		HttpGetResponse fixture = new HttpGetResponse(new HttpRequest(new PipedInputStream()), (Path) null);
		OutputStream out = new ByteArrayOutputStream();

		fixture.send(out);

		// add additional test code here
	}

	/**
	 * Run the void send(OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/3/15 4:40 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testSend_8()
		throws Exception {
		HttpGetResponse fixture = new HttpGetResponse(new HttpRequest(new PipedInputStream()), (Path) null);
		OutputStream out = new ByteArrayOutputStream();

		fixture.send(out);

		// add additional test code here
	}

	/**
	 * Run the void send(OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/3/15 4:40 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testSend_9()
		throws Exception {
		HttpGetResponse fixture = new HttpGetResponse(new HttpRequest(new PipedInputStream()), (Path) null);
		OutputStream out = new ByteArrayOutputStream();

		fixture.send(out);

		// add additional test code here
	}

	/**
	 * Run the void send(OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/3/15 4:40 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testSend_10()
		throws Exception {
		HttpGetResponse fixture = new HttpGetResponse(new HttpRequest(new PipedInputStream()), (Path) null);
		OutputStream out = new ByteArrayOutputStream();

		fixture.send(out);

		// add additional test code here
	}

	/**
	 * Run the void send(OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/3/15 4:40 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testSend_11()
		throws Exception {
		HttpGetResponse fixture = new HttpGetResponse(new HttpRequest(new PipedInputStream()), (Path) null);
		OutputStream out = new ByteArrayOutputStream();

		fixture.send(out);

		// add additional test code here
	}

	/**
	 * Run the void send(OutputStream) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/3/15 4:40 PM
	 */
	@Test(expected = java.io.IOException.class)
	public void testSend_12()
		throws Exception {
		HttpGetResponse fixture = new HttpGetResponse(new HttpRequest(new PipedInputStream()), (Path) null);
		OutputStream out = new ByteArrayOutputStream();

		fixture.send(out);

		// add additional test code here
	}

}