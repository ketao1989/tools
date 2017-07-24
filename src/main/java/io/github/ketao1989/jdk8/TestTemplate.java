package io.github.ketao1989.jdk8;

/**
 * @author tao.ke Date: 2017/7/23 Time: 下午10:42
 */
public class TestTemplate {

  public static void main(String[] args) {

    String res = ProcessTemplate.execute(new TemplateProcessor<String>().buildCoreProcessor(()->{
      System.out.println("excute core process");
      return "testCore";
    }).buildAfterProcess(()->{
      System.out.println("after process");
    }));

    System.out.println(res);

  }

}
