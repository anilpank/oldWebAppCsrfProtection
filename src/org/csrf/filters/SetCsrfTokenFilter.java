package org.csrf.filters;

import java.io.IOException;
import java.security.SecureRandom;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Add this filter to your web.xml and map all the urls you want to protect.
 * @author Anil Verma
 *
 */
public class SetCsrfTokenFilter implements Filter {	
	private static SecureRandom random = new SecureRandom();	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain next) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		String randomLong = ""+random.nextLong();
		Cookie cookie = new Cookie("csrfToken", randomLong);		
		httpRes.addCookie(cookie);
		next.doFilter(request, response);				
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {		
	}

}
