package com.pan.template;

//抽象类，表示豆浆
public abstract class SoyaMilk {

    //模板方法，make，模板方法可以做成final，不让子类去覆盖
    final void make(){
        select();
        add();
        soak();
        beat();
    }

    void select(){
        System.out.println("第一步：选择好的新鲜黄豆");
    }

    //添加不同的配料，抽象方法，让子类具体实现
    abstract void add();

    //浸泡
    public void soak(){
        System.out.println("第三步，黄豆和配料开始浸泡，需要三个小时");
    }

    public void beat(){
        System.out.println("第四步：黄豆和配料放进豆浆机");
    }
}
