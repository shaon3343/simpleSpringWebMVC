package com.shaon.spring.webmvc.context;

/**
 * Created by ashfak on 10/26/17.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.inject.Inject;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@EnableAspectJAutoProxy(proxyTargetClass = true)
@ComponentScan()
//@Import(value = {ApiClientContext.class})
public class WebApplicationContext {
    @Inject
    private Environment environment;

    public String[] activeProfiles() {
        return environment.getActiveProfiles();
    }

    /*@Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() throws IOException {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setProperties(ApplicationPropertyResource.instance().getMergedProperties());
        return configurer;
    }*/

    /*@Bean
    public ApplicationPropertyResource resource() {
        return ApplicationPropertyResource.instance();
    }

    @Bean
    public ApplicationConfiguration applicationConfiguration() {
        return new ApplicationConfiguration();
    }

    @Bean
    public JsonFactory jsonFactory() {
        return JsonFactory.getInstance();
    }*/

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        return resolver;
    }

   /* @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasenames(LANGUAGE_BASENAME);
        messageSource.setDefaultEncoding(UTF8_ENCODING);
        return messageSource;
    }*/

  /*  @Bean
    @Scope(value = org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public RequestContext requestContext() {
        return new RequestContext();
    }
*/

    @EventListener({ContextRefreshedEvent.class})
    private void contextRefreshedEvent() {
        System.out.println("Active Profile:" + Stream.of(activeProfiles()).collect(Collectors.joining(", ")));
    }
}
