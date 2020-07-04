package com.spdb.study.design.pattern.proxy.dynamicproxy.spdbproxy;
import com.spdb.study.design.pattern.proxy.staticproxy.Person;
import java.lang.reflect.*;
public class $Proxy0 implements com.spdb.study.design.pattern.proxy.staticproxy.Person{
    SpdbInvocationHandler h;
    public $Proxy0(SpdbInvocationHandler h) {
        this.h = h;
    }
    @Override
    public void findLove() {
        try {
            Method m = com.spdb.study.design.pattern.proxy.staticproxy.Person.class.getMethod("findLove",new Class[]{});
            this.h.invoke(this,m,new Object[]{});
        }catch(Error _ex) {
        }catch(Throwable e) {
            throw new UndeclaredThrowableException(e);
        }
    }
}