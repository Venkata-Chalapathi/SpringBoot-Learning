package in.gvc.InterceptorDemo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Handler;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        System.out.println("Incoming Request -----------");

        System.out.println("HTTP METHOD NAME : " + request.getMethod());
        System.out.println("END POINT (REQUEST URI) : " + request.getRequestURI());
        System.out.println("REQUEST PARAMS : " + request.getQueryString());
        System.out.println("CLIENT IP : " + request.getRemoteAddr());
        System.out.println("TOKEN HEADER : " + request.getHeader("token"));

        if(handler instanceof HandlerMethod method){
            String controllerName = method.getBeanType().getName();
            String methodName = method.getMethod().getName();
            System.out.println("Controller name : " + controllerName);
            System.out.println("Method Name : " + methodName);
        }
        return true;
    }

//    @Override
//    public void postHandle(HttpServletRequest request,
//                           HttpServletResponse response,
//                           Object handler,
//                           @Nullable ModelAndView modelAndView) throws Exception {
//        System.out.println("PostHandle method Called");
//    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                @Nullable Exception ex) throws Exception {
        System.out.println("Response Status : " + response.getStatus());

       }
}
