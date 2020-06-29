package com.spdb.study.design.pattern.proxy.dynamicproxy.spdbproxy;
import com.spdb.study.design.pattern.proxy.staticproxy.Person;
import java.lang.reflect.*;
public class $Proxy0 implements Person{
SpdbInvocationHandler h;
public $Proxy0(SpdbInvocationHandler h) {
this.h = h;
}
@Override
public void findLove() {
try {
Method m = Person.class.getMethod("findLove",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e) {
e.printStackTrace();
}
}}