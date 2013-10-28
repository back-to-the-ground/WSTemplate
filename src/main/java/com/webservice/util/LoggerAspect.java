package com.webservice.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggerAspect {
	private static final Logger logger = Logger.getLogger(LoggerAspect.class);
	private static boolean DETAILREQUESTANDRESPONSE = false;
	
	@Before("execution(public * com.webservice.webservice.*.*(..)) & execution(public * com.webservice.dao.*.*(..))")
	public void logRequest(JoinPoint joinPoint){
		String methodName = "logRequest";
		logger.debug(methodName + ", Caller class " + joinPoint);
		Object[] argumentList = joinPoint.getArgs();
		if (argumentList != null) {
			for (Object argument : argumentList) {
				if(!DETAILREQUESTANDRESPONSE){
					if(argument instanceof List<?>){
						List<?> listArgument = (List<?>)argument;
						logger.debug("Request list argument size = " + listArgument.size());
					}else if(argument instanceof Collection<?>){
						Collection<?> collectionArgument = (Collection<?>)argument;
						logger.debug("Request collection argument size = " + collectionArgument.size());
					}else if(argument instanceof Map<?,?>){
						Map<?,?> mapArgument = (Map<?,?>)argument;
						logger.debug("Request map argument size = " + mapArgument.size());
					}else{
						logger.debug("Request argument = " + argument);
					}
				}else{
					logger.debug("Request argument = " + argument);
				}
			}
		}
	}
	
	@AfterReturning(pointcut = "execution(public * com.webservice.webservice.*.*(..)) & execution(public * com.webservice.dao.*.*(..))", returning = "result")
	public void logResponse(JoinPoint joinPoint, Object result){
		String methodName = "logResponse";
		logger.debug(methodName + ", Caller class " + joinPoint);
		if(!DETAILREQUESTANDRESPONSE){
			if(result instanceof List<?>){
				List<?> listArgument = (List<?>)result;
				logger.debug("Response list size = " + listArgument.size());
			}else if(result instanceof Collection<?>){
				Collection<?> collectionArgument = (Collection<?>)result;
				logger.debug("Response collection size = " + collectionArgument.size());
			}else if(result instanceof Map<?,?>){
				Map<?,?> mapArgument = (Map<?,?>)result;
				logger.debug("Response map size = " + mapArgument.size());
			}else{
				logger.debug("Response = " + result);
			}
		}else{
			logger.debug("Response = " + result);
		}
	}
}
