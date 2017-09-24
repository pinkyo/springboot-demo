package my.yinkn.sprintboot.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by yinkn on 2017/7/9.
 */
@Configuration
public class MyConfiguration {
    @Value("${jetty.port}")
    private int jettyPort;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }

    @Bean
    public JettyEmbeddedServletContainerFactory jettyConfigurer() {
        return new JettyEmbeddedServletContainerFactory("/demo", jettyPort);
    }
}
