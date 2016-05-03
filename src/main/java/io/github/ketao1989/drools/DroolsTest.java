/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.drools;

/**
 * @author tao.ke Date: 16/4/15 Time: 下午4:23
 */
public class DroolsTest {

  public static void main(String[] args) throws InterruptedException {
    // String binaryNum = Integer.toBinaryString(16);
    // System.out.println(binaryNum);
    // System.out.println(binaryNum.matches("1(00)*"));

    RuleEngine<PointEntity> pointRuleEngine = new PointRuleEngineFive();
    pointRuleEngine.loadEngine();

    PointEntity entity = new PointEntity();
    entity.setBirthdayMouth(true);
    entity.setPoint(100);
    entity.setBuyMoney(1200);

    pointRuleEngine.executeEngine(entity);

    System.out.println(entity.getPoint());

    //Thread.sleep(10000);
    //pointRuleEngine.reloadEngine();

  }
}
