package lt.vu.interceptor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Logged
@Interceptor
public class LoggingInterceptor implements Serializable {

    @AroundInvoke
    public Object logMethod(InvocationContext invocationContext) throws Exception {
        System.out.println("---[LoggingInterceptor]--- Called method: "
                + invocationContext.getMethod().getName() + " in class "
                + invocationContext.getMethod().getDeclaringClass().getName());

        return invocationContext.proceed();
    }
}
