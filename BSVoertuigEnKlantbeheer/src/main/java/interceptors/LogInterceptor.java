package interceptors;

import entities.Log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InterceptorBinding;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;

/**
 * Created by Gebruiker on 28-11-2016.
 */

@Interceptor
@LogInterceptorBinding
public class LogInterceptor {

    @PersistenceContext
    private EntityManager em;

    @AroundInvoke
    public Object intercept(InvocationContext context) throws Exception {
        Log log1 = new Log();
        log1.setMessage("log called");
        log1.setDateTime(LocalDateTime.now());

        em.persist(log1);
        Object result = null;
        try {
            result = context.proceed();
        } catch (Exception e) {
            Log log = new Log();
            log.setMessage(context.getMethod().toString());
            log.setDateTime(LocalDateTime.now());

            em.persist(log);
        }
        return result;

    }
}
