package io.github.ketao1989.subclazz;

/**
 * @author tao.ke Date: 2017/7/16 Time: 下午9:33
 */
public abstract class AbstractClazz {

    public AbstractClazz() {

        // 抽象类初始化
        doOtherThing();
        System.out.println("abstract class init done");
    }

    protected abstract void doOtherThing();
}
