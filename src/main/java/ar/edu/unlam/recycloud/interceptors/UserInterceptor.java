package ar.edu.unlam.recycloud.interceptors;

import ar.edu.unlam.recycloud.web.pages.login.LoginModel;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class UserInterceptor implements HandlerInterceptor {

    private final ObjectFactory<HttpSession> httpSessionFactory;

    public UserInterceptor(ObjectFactory<HttpSession> httpSessionFactory) {
        this.httpSessionFactory = httpSessionFactory;
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        HttpSession session = httpSessionFactory.getObject();
        LoginModel login = (LoginModel) session.getAttribute("usuario");
        //if (login == null || login.getRol() != 1) {
        //    response.sendRedirect("/");
        //    return false;
        //}
        return true;
    }

}
