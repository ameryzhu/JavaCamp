import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JavaAOP {
    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public TargetClass invoke(Object proxy, Method method, Object[] args) throws Throwable {
                TargetClass targetClass = new TargetClass();
                System.out.println("before do sth");
//                targetClass.doSth();
//                method.invoke(proxy);
//                System.out.println("method:"+method.toString()+","+args.toString());
                method.invoke(proxy,args);
                System.out.println("after do sth");
                return targetClass;
            }
        };
        TargetClassInterface targetClass = (TargetClassInterface) Proxy.newProxyInstance(JavaAOP.class.getClassLoader(), new Class[]{TargetClassInterface.class}, invocationHandler);
        targetClass.doSth();


    }


}
