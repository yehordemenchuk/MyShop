package org.myshop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class LoggerAspect {
    private final Logger logger = Logger.getLogger(LoggerAspect.class.getName());

    @Around("execution(* org.myshop..*.*(..))")
    public Object log(ProceedingJoinPoint jointPoint) throws Throwable {
        logger.info(String.format("%s starts execution", jointPoint.getSignature().toShortString()));

        Instant start = Instant.now();

        Object proceedingRes = jointPoint.proceed();

        Instant end = Instant.now();

        long duration = Duration.between(start, end).toMillis();

        logger.info(String.format("Execution time: %s ms", duration));

        logger.info(jointPoint.getSignature().toShortString() + " ends execution");

        return proceedingRes;
    }

    @AfterThrowing(value = "execution(* org.myshop..*.*(..))", throwing = "ex")
    public void log(JoinPoint joinPoint, Exception ex) {
        logger.log(Level.SEVERE, String.format("%s the exception was throwing due %s",
                        joinPoint.getSignature().toShortString(), ex.getMessage()));
    }

    @AfterReturning(value = "execution(* org.myshop..*.*(..))", returning = "retVal")
    public void log(JoinPoint joinPoint, Object retVal) {
        logger.log(Level.INFO, String.format("%s returns %s", joinPoint.getSignature().toShortString(),
                retVal));
    }
}
