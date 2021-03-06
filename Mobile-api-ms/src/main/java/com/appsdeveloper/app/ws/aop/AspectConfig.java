package com.appsdeveloper.app.ws.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AspectConfig {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Before(value="execution(* com.appsdeveloper.app.ws.*.*.*(..))")
	public void beforeAdvice(JoinPoint joinPoint) {
		logger.debug("inside before advice");
	}

}
