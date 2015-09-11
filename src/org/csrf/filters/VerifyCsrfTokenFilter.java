package org.csrf.filters;

import java.io.IOException;

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
 * 
 * @author Anil Verma
 * Add this filter in your web.xml and map to all urls you want to protect
 *
 */
public class VerifyCsrfTokenFilter implements Filter {
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	private String getCsrfTokenFromCookie(HttpServletRequest httpReq) {
		Cookie cookies[] = httpReq.getCookies();
		String tokenFromCookie = null;
		if (cookies!=null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("csrfToken")) {
					tokenFromCookie = cookie.getValue();				
				}
			}
		}
		return tokenFromCookie;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain next) throws IOException, ServletException {
		HttpServletRequest httpReq = (HttpServletRequest) request;
		HttpServletResponse httpRes = (HttpServletResponse) response;
		String path = httpReq.getServletPath();
		System.out.println("VerifyCsrfTokenFilter:" + path);
		if (path.toLowerCase().contains("login")) {
			next.doFilter(request, response);
		}
		else if(httpReq.getMethod().equalsIgnoreCase("POST")){			
			
			String csrfToken = httpReq.getParameter("csrfToken");
			String tokenFromCookie = getCsrfTokenFromCookie(httpReq);
			if (csrfToken == null || !csrfToken.equals(tokenFromCookie)) {
				httpRes.sendError(HttpServletResponse.SC_UNAUTHORIZED);
			}			
			else {
				next.doFilter(request, response);
			}
		}
		else {
			next.doFilter(request, response);
		}


	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {		
	}

}
