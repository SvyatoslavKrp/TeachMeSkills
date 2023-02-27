package org.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class BenchmarkAspect {

    @Pointcut("@annotation(org.example.aop.Benchmark))")
    public void pointcutForAnnotation() {
    }

    ;

    @Around("pointcutForAnnotation()")
    public void runAdvise(ProceedingJoinPoint joinPoint) {

        long start = System.currentTimeMillis();

        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        long finish = System.currentTimeMillis();

        long seconds = (finish - start) / 1000;

        System.out.printf("you have been spending %d seconds for the virtual race\n", seconds);

    }

}
