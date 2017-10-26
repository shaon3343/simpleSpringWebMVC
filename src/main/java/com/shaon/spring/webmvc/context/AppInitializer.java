package com.shaon.spring.webmvc.context;

import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by ashfak on 10/25/17.
 */
public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) throws ServletException {
        initializeListeners(container);
        initializeServletContext(container);
    }

    private void initializeServletContext(ServletContext container) {
        ServletRegistration.Dynamic dispatcher = container.addServlet("test-spring-mvc", initDispatcherServlet());
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }

    private DispatcherServlet initDispatcherServlet() {
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(AppServletContext.class);

        DispatcherServlet dispatcher = new DispatcherServlet(dispatcherContext);
        dispatcher.setThrowExceptionIfNoHandlerFound(true);
        return dispatcher;
    }

    private void initializeListeners(ServletContext container) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(WebApplicationContext.class);
        container.addListener(new ContextLoaderListener(applicationContext));
        container.addListener(new RequestContextListener());
        container.addListener(new HttpSessionEventPublisher());
    }
}
