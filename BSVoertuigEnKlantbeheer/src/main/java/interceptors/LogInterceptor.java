package interceptors;

import entities.ErrorLog;
import services.ILogService;

import javax.ejb.EJB;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.time.LocalDateTime;

/**
 * Created by Gebruiker on 28-11-2016.
 */

@Interceptor
@LogInterceptorBinding
public class    LogInterceptor {

    @EJB
    private ILogService logService;

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        Object result = null;
        try {
            result = context.proceed();
        } catch (Exception e) {
            ErrorLog errorLog = new ErrorLog();
            errorLog.setMessage(e.getMessage());
            errorLog.setDateTime(LocalDateTime.now());
            System.out.println(e.getMessage());
            logService.log(errorLog);
        }
        return result;

    }
}
