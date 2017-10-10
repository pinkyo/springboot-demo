package my.pinkyo.demo;

import org.eclipse.jetty.util.thread.ExecutorThreadPool;
import org.springframework.boot.context.embedded.jetty.JettyEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.concurrent.TimeUnit;

/**
 * Created by yinkn on 2017/7/9.
 */
@Configuration
@EnableAspectJAutoProxy
public class MyConfiguration {
    @Bean
    public JettyEmbeddedServletContainerFactory factory() {
        JettyEmbeddedServletContainerFactory factory =
                new JettyEmbeddedServletContainerFactory();
        factory.setThreadPool(new ExecutorThreadPool(
                50, 200, 5, TimeUnit.MINUTES));
        return factory;
    }
}
