package com.spdb.study.design.pattern.proxy.dynamicproxy.spdbproxy;
import com.spdb.study.design.pattern.proxy.staticproxy.Person;
import java.lang.reflect.*;
public class $Proxy0 implements com.spdb.study.design.pattern.proxy.dbroute.OrderService{
SpdbInvocationHandler h;
public $Proxy0(SpdbInvocationHandler h) {
this.h = h;
}
@Override
public int createOrder() {
try {
Method m = com.spdb.study.design.pattern.proxy.dbroute.OrderService.class.getMethod("createOrder",new Class[]{com.spdb.study.design.pattern.proxy.dbroute.Order.class});
this.h.invoke(this,m,null);
}catch(Throwable e) {
e.printStackTrace();
return 0}
}}