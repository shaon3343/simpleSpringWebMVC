package com.shaon.spring.webmvc.context;

import org.springframework.web.WebApplicationInitializer;
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
}
