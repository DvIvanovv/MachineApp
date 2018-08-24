package machine.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class IpInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String ipAddress = request.getRemoteAddr();
		//String ipAddress = request.getRemoteHost() ;
		request.setAttribute("ipAddress", ipAddress);
		return true;
	}

	
}
