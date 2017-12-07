package com.arnold.entity;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Project: pagecache
 * Description:
 *
 * @author: xwszt
 * @version: 1.0
 * Create Date: 2017/9/15
 */
public class ResponseWrapper extends HttpServletResponseWrapper {

    private PrintWriter cacheWriter;
	private ByteArrayOutputStream outputStream;

    /**
     * Constructs a response adaptor wrapping the given response.
     *
     * @param response
     * @throws IllegalArgumentException if the response is null
     */
    public ResponseWrapper(HttpServletResponse response) {
        super(response);
        outputStream = new ByteArrayOutputStream();
        cacheWriter = new PrintWriter(outputStream, true);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return cacheWriter;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
    	//用ServletOutputStream写就是用outputStream写。
        return new ServletOutputStream() {
            @Override
            public void write(int b) throws IOException {
                outputStream.write(b);
            }
        };
    }

    public ByteArrayOutputStream getByteArrayOutputStream() {
        return outputStream;
    }

    /**
     * 获取原始的HTML页面内容
     * @return
     */
    public String getResult() {
        flush();
        return outputStream.toString();
    }

    public void flush() {
        try {
            cacheWriter.flush();
            cacheWriter.close();
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}