package dynamicJDK;

import java.io.ObjectStreamException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LoggingHandler implements InvocationHandler {

    private Object target1;
    private Object target2;

    public LoggingHandler(Object target1, Object target2) {
        this.target1 = target1;
        this.target2 = target2;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        switch(method.getName()) {
            case "sendSms" :
                System.out.println("LOGGING BEFORE: " + method.getName());
                result = method.invoke(target1, args);
                break;

            case "sendEmail" :
                result = method.invoke(target1, args);
                System.out.println("LOGGING AFTER: " + method.getName());
                break;

            case "pay" :
                System.out.println("LOGGING BEFORE: " + method.getName());
                result = method.invoke(target2, args);
                System.out.println("LOGGING AFTER: " + method.getName());
                break;
        }
//        System.out.println("LOGGING BEFORE: " + method.getName());
//        Object result = method.invoke(target1, args);
//        System.out.println("LOGGING AFTER: " + method.getName());
        return result;
    }
}
