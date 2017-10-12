package my.pinkyo.demo.advice;


import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.SharedMetricRegistries;
import com.codahale.metrics.Timer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
@Aspect
public class PerformanceAdvice {

    @PostConstruct
    public void setUp() {
        MetricRegistry registry = SharedMetricRegistries.getOrCreate("demo");
        final ConsoleReporter reporter = ConsoleReporter.forRegistry(registry)
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .build();
        reporter.start(1, TimeUnit.MINUTES);
    }

    @Around("execution(* my.pinkyo.demo.controller.TestController.*(..))")
    public void recordMetricsData(ProceedingJoinPoint pjp) {
        MetricRegistry registry = SharedMetricRegistries.getOrCreate("demo");
        final Timer timer = registry.timer(pjp.getSignature().getDeclaringTypeName());
        Timer.Context context = timer.time();

        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            if (context != null) {
                context.close();
            }
        }
    }
}
