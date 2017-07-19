package io.github.ketao1989.spring;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author tao.ke Date: 2017/7/19 Time: 下午10:38
 */
public class AopAdvice {

  public void before(JoinPoint point) {

    Object target = point.getTarget();
    String method = point.getSignature().getName();

    Class<?>[] classz = target.getClass().getInterfaces();
    if (classz.length == 0){
      classz = new Class<?>[]{target.getClass()};
    }

    Class<?>[]
        parameterTypes =
        ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
    try {

      Method m = classz[0].getDeclaredMethod(method, parameterTypes);

      if (m != null && m.isAnnotationPresent(AnnotationPoint.class)) {

        System.out.println("before invoke ------------");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  public void after(JoinPoint point) {
    Object target = point.getTarget();
    String method = point.getSignature().getName();

    Class<?>[] classz = target.getClass().getInterfaces();
    if (classz.length == 0){
      classz = new Class<?>[]{target.getClass()};
    }

    Class<?>[]
        parameterTypes =
        ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
    try {
      Method m = classz[0].getDeclaredMethod(method, parameterTypes);
      if (m != null && m.isAnnotationPresent(AnnotationPoint.class)) {
        System.out.println("after invoke ------------");
      }

    } catch (Exception e) {
      System.out.println("=======================AOP注册拦截失败了！" + e);
    }

  }

}
