package com.arnold.filter;

import com.arnold.entity.ResponseWrapper;
import com.arnold.utils.JedisUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * Project: pagecache
 * Description:
 *
 * @author: xwszt
 * @version: 1.0
 * Create Date: 2017/9/15
 */
public class CacheFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(CacheFilter.class);

    private ApplicationContext ctx;

    @Override
	public void init(FilterConfig filterConfig) throws ServletException {
        this.ctx = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;

        // 返回响应
        String requestURL = req.getRequestURI().toString();
        String queryString = req.getQueryString();

        String key;
        if (!StringUtils.isEmpty(queryString)) {
            queryString = "?" + queryString;
            key = requestURL + queryString;
            log.info("当前请求被缓存：" + requestURL + queryString);
        } else {
            key = requestURL;
            log.info("当前请求被缓存：" + requestURL);
        }

        String pageContent = getHtmlFromCache(key);
        if (null == pageContent) {
            //缓存中没有
            //截取生成的html并放入缓存
            log.info("缓存不存在，生成缓存");
            ResponseWrapper wrapper = new ResponseWrapper(resp);

            chain.doFilter(request, wrapper);

            pageContent = wrapper.getResult();

			//todo ？为什么不能用resp呢
			//pageContent = resp.getOutputStream().toString();

			putIntoCache(key, pageContent);
        }
        
        resp.setContentType("text/html; charset=utf-8");
       /* ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.print(pageContent);*/
		PrintWriter writer = resp.getWriter();
		writer.print(pageContent);
	}

    @Override
    public void destroy() {
        //nothing to do
    }

    private String getHtmlFromCache(String key) {
       /* StringRedisTemplate redis = ctx.getBean(StringRedisTemplate.class);
        return redis.opsForValue().get(key);*/
		return JedisUtils.get(key);
    }

    private void putIntoCache(String key, String html) {
        /*StringRedisTemplate redis = ctx.getBean(StringRedisTemplate.class);
        redis.opsForValue().set(key, html, 5000, TimeUnit.MILLISECONDS);*/
        JedisUtils.set(key, html, 10);
    }
}