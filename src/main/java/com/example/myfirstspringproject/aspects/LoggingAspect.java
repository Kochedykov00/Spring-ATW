package com.example.myfirstspringproject.aspects;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;
import java.util.Date;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Before(value = "execution(* com.example.myfirstspringproject.service.*.*(*))")
    public void logging(JoinPoint joinPoint) {
        CodeSignature signature = (CodeSignature) joinPoint.getSignature();
        Date date = new Date();
        String methodName = signature.getName();
        String methodClass = signature.getDeclaringTypeName();
        StringBuilder args = new StringBuilder();
        for (Object arg : joinPoint.getArgs()) {
            String argClassName = arg.getClass().getSimpleName();
            args.append(argClassName).append(": ").append(joinPoint.getArgs()[0]);
        }
        log.info("\n" + date + ": method {" + methodName + "} from {" + methodClass + "}, args {" + args.toString() + "}");
    }
}
