package cc.conyli.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    private Logger logger = Logger.getLogger(CRMLoggingAspect.class.getName());

    //创建controller包下边的所有类的所有方法+任意参数的切点
    @Pointcut("execution(* cc.conyli.controller.*.*(..))")
    private void forControllerPackage() {}

    //创建dao包下边的所有类的所有方法+任意参数的切点
    @Pointcut("execution(* cc.conyli.dao.*.*(..))")
    private void forDaoPackage() {}

    //创建service包下边的所有类的所有方法+任意参数的切点
    @Pointcut("execution(* cc.conyli.service.*.*(..))")
    private void forServicePackage() {}

    //上边三个切点的合集，即针对整个APP流
    @Pointcut("forControllerPackage() || forDaoPackage() || forServicePackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    private void beforeAppFlow(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toString();
        logger.info("\n======> This is appflow @Before method: " + method);
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Model) {
                logger.info(((Model) arg).asMap().toString());
            } else {
                logger.info("\n======>" + method + " args: " + arg);
            }
        }
    }

    @AfterReturning(pointcut = "forAppFlow()", returning = "result")
    private void afterAppFlowReturning(JoinPoint joinPoint, Object result) {
        String method = joinPoint.getSignature().toString();
        logger.info("\n======> This is appflow @AfterReturnning method: " + method);
        logger.info("\n=====> This is result from " + method + ". Result is " + result);
    }
}
