package filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

	public EncodingFilter() {}
 
	public void destroy(){}
 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("utf-8"); // 将编码改为utf-8
		response.setContentType("text/html;charset=utf-8");
		chain.doFilter(request, response);
	}
 
	public void init(FilterConfig arg0) throws ServletException {

	}
}
