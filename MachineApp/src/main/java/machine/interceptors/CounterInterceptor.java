package machine.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CounterInterceptor extends HandlerInterceptorAdapter {
	
	private long counter;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		this.counter ++;
		request.setAttribute("counter", counter);
		return true;
	}
	
	

}
