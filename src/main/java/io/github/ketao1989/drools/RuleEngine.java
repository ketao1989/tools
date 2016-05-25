/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.drools;

/**
 * @author tao.ke Date: 16/4/15 Time: 下午3:11
 */
public interface RuleEngine<P,R> {

  /**
   * 初始化加载rule规则配置
   */
  void loadEngine();

  /**
   * 执行rule规则引擎
   * @param entity
   */
  void executeEngine(P entity,R result);

  /**
   * 重新加载,当有新的rule配置时,调用
   */
  void reloadEngine();

}
