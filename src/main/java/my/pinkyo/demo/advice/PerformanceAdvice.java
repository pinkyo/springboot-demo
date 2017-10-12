package my.pinkyo.demo.advice;


import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.SharedMetricRegistries;
import com.codahale.metrics.Timer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.invoke.MethodHandles;
import java.util.concurrent.TimeUnit;

@Order(1)
@Component
@Aspect
public class PerformanceAdvice {
    private static final Log LOG = LogFactory.getLog(MethodHandles.lookup().lookupClass());

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
    public Object recordMetricsData(ProceedingJoinPoint pjp) {
        MetricRegistry registry = SharedMetricRegistries.getOrCreate("demo");
        final Timer timer = registry.timer(pjp.getSignature().getDeclaringTypeName());
        Timer.Context context = timer.time();

        try {
            Object retVal = pjp.proceed();
            return retVal;
        } catch (Throwable throwable) {
            LOG.error(throwable);
            if (context != null) {
                context.close();
            }
        }

        return null;
    }
}
