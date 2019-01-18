package com.example.demo.domain.Proxy;

import com.example.demo.domain.Proxy.impl.UserManagerImpl;

public class ProxyTest {
    public static void main(String[] args) {
        /*UserManagerImpl userManager = new UserManagerImpl();
        UserManager user =(UserManager) Proxy.newProxyInstance(userManager.getClass().getClassLoader(), userManager.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("JDK动态代理，监听开始！");
                Object result = method.invoke(userManager, args);
                System.out.println("JDK动态代理，监听结束！");
                return result;
            }
        });*/
        UserManagerImpl userManager = new UserManagerImpl();
        UserManager proxy =(UserManager) new CglibProxyHandler().getProxyInstance(userManager);
        proxy.addUser("admin", "123123");//执行新增方法
    }
}
