package my.pinkyo.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by yinkn on 2017/7/9.
 */
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true)
public class MyConfiguration {
}
