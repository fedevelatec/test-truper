package com.fve.truper.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogExecutionTimeAspect {

    @Around("@annotation(com.fve.truper.aop.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object[] args = joinPoint.getArgs();
        Object proceed = joinPoint.proceed();
        log.info("Metodo {} con args: {} ejecutado en {} ms",
                joinPoint.getSignature(),
                args.length > 0 ? args[0] : "null",
                (System.currentTimeMillis() - startTime));
        //log.info(proceed.toString());
        return proceed;
    }
}
