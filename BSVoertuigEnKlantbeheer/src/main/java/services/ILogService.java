package services;

import entities.ErrorLog;

import javax.ejb.Remote;

/**
 * Created by Sander on 28-11-2016.
 */
@Remote
public interface ILogService {
    void log(ErrorLog errorLog);
}
