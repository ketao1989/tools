package io.github.ketao1989.subclazz;

/**
 * @author tao.ke Date: 2017/7/16 Time: 下午9:35
 */
public class SubClazz extends AbstractClazz {

    private int configNum = 512;// 类属性，初始值为0，在父类构造函数运行，子类没初始化完成之前，这个赋值操作是不会生效的。

    public SubClazz() {
        super();
        System.out.println("sub clazz init done");
    }

    @Override
    protected void doOtherThing() {

        System.out.println(configNum);
    }
}
