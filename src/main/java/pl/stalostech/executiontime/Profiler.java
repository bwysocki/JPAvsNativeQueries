package pl.stalostech.executiontime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Profiler {

	private static final Logger log = LoggerFactory.getLogger(Profiler.class);

	@Pointcut("execution(* pl.stalostech..*.*(..))")
	public void profiledMethods() {	}

	@Around("profiledMethods() && @annotation(logTime)")
	public Object profile(ProceedingJoinPoint pjp, LogTime logTime) throws Throwable {
		
		MethodSignature signature = (MethodSignature) pjp.getSignature();
		
		long start = System.currentTimeMillis();
		Object output = pjp.proceed();
		long elapsedTime = System.currentTimeMillis() - start;
		log.info("Method '" + signature.getMethod().getName() + "->" + logTime.value() + "' execution time : " + elapsedTime);
		return output;
	}

}
