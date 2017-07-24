package io.github.ketao1989.jdk8;

import java.util.function.Supplier;

/**
 * @author tao.ke Date: 2017/7/23 Time: 下午10:04
 */
public class TemplateProcessor<T> {

  /**
   * 核心的执行方法，获取执行结果
   */
  private Supplier<T> coreProcessor;

  /**
   * 执行参数校验
   */
  private EmptyParamProcessor checkParams = ()->{
    System.out.println("exe......");
  };

  /**
   * 执行事后资源处理等
   */
  private EmptyParamProcessor beforeProcess = ()->{System.out.println("exe......");};

  /**
   * 执行事后资源处理等
   */
  private EmptyParamProcessor afterProcess = ()->{System.out.println("exe......");};

  public TemplateProcessor() {
  }

  public TemplateProcessor<T> buildCoreProcessor(Supplier<T> coreProcessor){
    this.coreProcessor = coreProcessor;
    return this;
  }

  public Supplier<T> getCoreProcessor() {
    return coreProcessor;
  }

  public EmptyParamProcessor getCheckParams() {
    return checkParams;
  }

  public TemplateProcessor<T> buildCheckParams(EmptyParamProcessor checkParams) {
    this.checkParams = checkParams;
    return this;
  }

  public EmptyParamProcessor getBeforeProcess() {
    return beforeProcess;
  }

  public TemplateProcessor<T> buildBeforeProcess(EmptyParamProcessor beforeProcess) {
    this.beforeProcess = beforeProcess;
    return this;
  }

  public EmptyParamProcessor getAfterProcess() {
    return afterProcess;
  }

  public TemplateProcessor<T> buildAfterProcess(EmptyParamProcessor afterProcess) {
    this.afterProcess = afterProcess;
    return this;
  }


  public TemplateProcessor<T> build(){
    return this;
  }

}
