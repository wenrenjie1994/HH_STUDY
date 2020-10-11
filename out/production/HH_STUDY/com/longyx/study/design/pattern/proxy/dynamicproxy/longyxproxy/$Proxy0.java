package com.longyx.study.design.pattern.proxy.dynamicproxy.longyxproxy;
import com.longyx.study.design.pattern.proxy.staticproxy.Person;
import java.lang.reflect.*;
public class $Proxy0 implements com.longyx.study.design.pattern.proxy.staticproxy.Person{
longyxInvocationHandler h;
public $Proxy0(longyxInvocationHandler h) {
this.h = h;
}
@Override
public void findLove() {
try {
Method m = com.longyx.study.design.pattern.proxy.staticproxy.Person.class.getMethod("findLove",new Class[]{});
this.h.invoke(this,m,new Object[]{});
}catch(Error _ex) {
}catch(Throwable e) {
throw new UndeclaredThrowableException(e);
}}}
