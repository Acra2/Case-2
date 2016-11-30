package services.impl;

import entities.ErrorLog;
import services.ILogService;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Sander on 28-11-2016.
 */
@Stateful
@Remote(ILogService.class)
public class LogService implements ILogService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void log(ErrorLog errorLog) {
        em.merge(errorLog);
    }
}
