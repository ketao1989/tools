///*
//* Copyright (c) 2015 taocoder.com. All Rights Reserved.
//*/
//package io.github.ketao1989.drools;
//
//import com.google.common.io.Resources;
//
//import org.apache.commons.lang3.tuple.Pair;
//import org.kie.api.KieServices;
//import org.kie.api.builder.KieBuilder;
//import org.kie.api.builder.KieFileSystem;
//import org.kie.api.builder.model.KieBaseModel;
//import org.kie.api.builder.model.KieModuleModel;
//import org.kie.api.builder.model.KieSessionModel;
//import org.kie.api.conf.EqualityBehaviorOption;
//import org.kie.api.conf.EventProcessingOption;
//import org.kie.api.runtime.KieContainer;
//import org.kie.api.runtime.KieSession;
//import org.kie.api.runtime.conf.ClockTypeOption;
//
///**
// * @author tao.ke Date: 16/4/15 Time: 下午3:15
// */
//public class PointRuleEngine implements RuleEngine<PointEntity> {
//
//  private KieSession kSession;
//
//  public void loadEngine() {
//
//    // 有效期格式设置
//    System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");
//
//    KieServices kieServices = KieServices.Factory.get();
//
//    // Create a module model
//    KieModuleModel kieModuleModel = kieServices.newKieModuleModel();
//
//    // Base Model from the module model
//    KieBaseModel kieBaseModel = kieModuleModel.newKieBaseModel("KBase" )
//        .setDefault( true )
//        .setEqualsBehavior(EqualityBehaviorOption.EQUALITY)
//        .setEventProcessingMode(EventProcessingOption.STREAM );
//
//    // Create session model for the Base Model
//    KieSessionModel ksessionModel = kieBaseModel.newKieSessionModel("KSession" )
//        .setDefault( true )
//        .setType( KieSessionModel.KieSessionType.STATEFUL )
//        .setClockType(ClockTypeOption.get("realtime") );
//
//    // Create File System services
//    KieFileSystem kFileSystem = kieServices.newKieFileSystem();
//
////    Resource resource = kieServices.getResources().newClassPathResource("billPoint.drl")
////        .setResourceType(ResourceType.DRL);
////    kFileSystem.write( resource );
//
//    Pair<String,byte[]> stringPair = getDrlStream("billPoint.drl");
//    kFileSystem.write( "src/main/resources/"+stringPair.getLeft(),stringPair.getRight() );
//    stringPair = getDrlStream("billPoint3.drl");
//    kFileSystem.write( "src/main/resources/"+stringPair.getLeft(),stringPair.getRight() );
//
//    KieBuilder kbuilder = kieServices.newKieBuilder(kFileSystem );
//    // kieModule is automatically deployed to KieRepository if successfully built.
//    kbuilder.buildAll();
//
//    if (kbuilder.getResults().hasMessages(org.kie.api.builder.Message.Level.ERROR)) {
//      throw new RuntimeException("Build time Errors: " + kbuilder.getResults().toString());
//    }
//    KieContainer kContainer = kieServices.newKieContainer(kieServices.getRepository().getDefaultReleaseId());
//
//    kSession = kContainer.newKieSession();
//  }
//
//  private Pair<String,byte[]> getDrlStream(String name){
//    // 网络流中获取
//    try {
//      byte[] contents = Resources.toByteArray(Resources.getResource(name));
//      //byte[] contents = Files.toByteArray(new File("/Users/ketao/file/" + name));
//      System.out.println(contents.length);
//      System.out.println(new String(contents));
//      return Pair.of(name,contents);
//    }catch (Exception e){
//
//    }
//    return null;
//  }
//
//
//  public void executeEngine(PointEntity entity) {
//    kSession.insert(entity);
//    kSession.fireAllRules();
//  }
//
//  public void reloadEngine() {
//
//    kSession.dispose();
//    loadEngine();
//  }
//}
