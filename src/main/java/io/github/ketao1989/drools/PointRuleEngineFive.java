/*
* Copyright (c) 2015 taocoder.com. All Rights Reserved.
*/
package io.github.ketao1989.drools;


import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tao.ke Date: 16/4/22 Time: 上午11:32
 */
public class PointRuleEngineFive implements RuleEngine<PointEntity> {

  private static final Logger logger = LoggerFactory.getLogger(PointRuleEngineFive.class);


  protected KnowledgeBase knowledgeBase;

  public void loadEngine() {

    System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");

    KnowledgeBuilder builder = KnowledgeBuilderFactory.newKnowledgeBuilder();

    builder.add(ResourceFactory.newClassPathResource("billPoint.drl"),ResourceType.DRL);

    if (builder.hasErrors()) {
      logger.error("init rule drools error.{}", builder.getErrors());
      throw new IllegalStateException("init rule drools error");
    }

    knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
    knowledgeBase.addKnowledgePackages(builder.getKnowledgePackages());
  }

  public void executeEngine(PointEntity entity) {

    StatefulKnowledgeSession knowledgeSession = knowledgeBase.newStatefulKnowledgeSession();
    knowledgeSession.insert(entity);
    knowledgeSession.dispose();

  }

  public void reloadEngine() {

  }
}
