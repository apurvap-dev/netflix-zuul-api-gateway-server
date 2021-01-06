package com.microservices.netflixzuulapigatewayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;


@Component
public class ZuulLogingFilter extends ZuulFilter{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Override
	public boolean shouldFilter() {
		// You can make paticular request to filter
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// Print whatever you want for the each call
		 HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		 logger.info("request -> {} and requesturi -> {}", request,request.getRequestURI());
		return null;
	}

	@Override
	public String filterType() {
		// Type of filter like pre,post, error
		return "pre";
	}

	@Override
	public int filterOrder() {
		// Giving priority to this fillet
		return 1;
	}

}
