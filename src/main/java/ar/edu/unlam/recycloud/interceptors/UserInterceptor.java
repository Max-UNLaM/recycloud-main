package ar.edu.unlam.recycloud.interceptors;

import ar.edu.unlam.recycloud.app.statistics.MetricsService;
import ar.edu.unlam.recycloud.conf.MetricsConstants;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import static ar.edu.unlam.recycloud.conf.SessionConstants.USER_IP_KEY;

@Component
public class UserInterceptor implements HandlerInterceptor {

    private final ObjectFactory<HttpSession> httpSessionFactory;
    private final MetricsService metricsService;

    public UserInterceptor(ObjectFactory<HttpSession> httpSessionFactory, MetricsService metricsService) {
        this.httpSessionFactory = httpSessionFactory;
        this.metricsService = metricsService;
    }

    @Override
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler) throws Exception {
        HttpSession session = httpSessionFactory.getObject();
        Optional<Object> optIp = Optional.ofNullable(session.getAttribute(USER_IP_KEY));
        CompletableFuture.runAsync(() -> {
            if (!optIp.isPresent()) {
                session.setAttribute(USER_IP_KEY, request.getRemoteAddr());
                metricsService.count(MetricsConstants.VISITOR_METRIC, request.getRemoteAddr());
            }
        });
        return true;
    }

}
