package com.phani.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	@After("allGetters() && allTriangleMethods()")
	public void LoggingAdvice(JoinPoint jp) {
		System.out.println("Logging aspect before name called");
		System.out.println("the object called: "+jp.getTarget());
	}
	@AfterReturning(pointcut="args(name)",returning="myStr")
	public void SecondAdvice(String name,String myStr) {
		System.out.println("Second advice called.");
		System.out.println("STring passed is: "+name);
		System.out.println("String returned is "+myStr);
	}
	@AfterThrowing(pointcut="args(name)",throwing="ex")
	public void Third(String name, Exception ex) {
		System.out.println("exception thrown is "+ex);
	}
	
	@Pointcut("execution(public * get*(..))") //@PointCut("within(com.phani..*)") -- classes in phani and its sub packages too
	public void allGetters() {}
	
	@Pointcut("execution(* com.phani.Triangle.*(..))")
	public void allTriangleMethods() {}
	
	@Pointcut("within(com.phani.Circle)")
	public void allCircleMethods() {}
	
	@After("@annotation(com.phani.aspect.Loggable)")
	public void customAnno() {
		System.out.println("custom annoation for triangle getName()");
	}
}
