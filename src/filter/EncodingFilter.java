package filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private FilterConfig config;
    private String encoding;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        System.out.println(encoding);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (encoding==null)
        {
            encoding="utf-8";
            System.out.println("请设置参数");
        }
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        servletResponse.setContentType("text/html;charset=" + encoding);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
