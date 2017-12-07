package com.arnold.web.filter;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.internal.util.logging.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class CacheFilter implements Filter{

	//private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

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
			//log.info("当前请求被缓存：" + requestURL + queryString);
		} else {
			key = requestURL;
			//log.info("当前请求被缓存：" + requestURL);
		}

		String pageContent = getHtmlFromCache(key);
		if (null == pageContent) {
			//缓存中没有
			//截取生成的html并放入缓存
			//log.info("缓存不存在，生成缓存");
			ResponseWrapper wrapper = new ResponseWrapper(resp);

			chain.doFilter(request, wrapper);

			//resp.getOutputStream()

			pageContent = wrapper.getResult();
			putIntoCache(key, pageContent);
		}

		resp.setContentType("text/html; charset=utf-8");
		ServletOutputStream outputStream = resp.getOutputStream();
		outputStream.print(pageContent);
	}

	@Override
	public void destroy() {

	}

	private String getHtmlFromCache(String key) {
		/*StringRedisTemplate redis = ctx.getBean(StringRedisTemplate.class);
		return redis.opsForValue().get(key);*/
		return "";
	}

	private void putIntoCache(String key, String html) {
		/*StringRedisTemplate redis = ctx.getBean(StringRedisTemplate.class);
		redis.opsForValue().set(key, html, 5000, TimeUnit.MILLISECONDS);*/
		return;
	}
}
