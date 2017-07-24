package io.github.ketao1989.jdk8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author tao.ke Date: 2017/7/23 Time: 下午10:02
 */
public class ProcessTemplate {

  private static final Logger logger = LoggerFactory.getLogger(ProcessTemplate.class);

  public static <T> T execute(TemplateProcessor<T> processor){


    T result = null;

    long startTime = System.currentTimeMillis();

    try {
      {
        processor.getBeforeProcess().process();
      }
      {
        processor.getCheckParams().process();
      }
      {
        result = (T) processor.getCoreProcessor().get();

      }
//      {
//        action.succ(result, System.currentTimeMillis() - startTime);
//      }
    } catch (Exception e) {


    } finally {
      try {

        {
          processor.getAfterProcess().process();
        }

      } catch (Exception e) {
        logger.error("finally中调用方法出现异常！", e);
      }

    }
    return result;

  }

}
