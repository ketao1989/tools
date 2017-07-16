/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.drools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tao.ke Date: 16/4/15 Time: 下午4:23
 */
public class DroolsTest {

  private static final Logger logger = LoggerFactory.getLogger(DroolsTest.class);

  public static void main(String[] args) throws InterruptedException {
    // String binaryNum = Integer.toBinaryString(16);
    // System.out.println(binaryNum);
    // System.out.println(binaryNum.matches("1(00)*"));

    RuleEngine<PointParams,PointResult> pointRuleEngine = new PointRuleEngineFive();
    pointRuleEngine.loadEngine();

    PointParams entity = new PointParams();
    entity.setBirthdayMouth(true);
    entity.setBuyMoney(1200);

    PointResult result= new PointResult();
    result.setChecked(false);
    result.setPoint(10);

    pointRuleEngine.executeEngine(entity,result);

    System.out.println(result.getPoint());

    //Thread.sleep(10000);
    //pointRuleEngine.reloadEngine();

    logger.info("--------============");

  }
}
