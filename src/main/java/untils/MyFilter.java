package untils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MyFilter implements Filter {
    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpSession session=request.getSession();
        String path=request.getRequestURI();
        if(path.indexOf("/LoginServlet")>-1){
            try {
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(path.indexOf("/registerFrom.jsp")>-1){//注册页面不过滤
            try {
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(path.indexOf("/loginForm.jsp")>-1){//登录页面不过滤
            try {
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if(session.getAttribute("userName")==null){
            try {
                response.sendRedirect("loginForm.jsp");
                return;
            }catch (Exception e){
                e.printStackTrace();
            }
        }else{
            try {
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void init(FilterConfig filterConfig) {

    }
}
