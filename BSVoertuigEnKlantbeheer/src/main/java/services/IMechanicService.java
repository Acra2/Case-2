package services;

import entities.Mechanic;

import javax.ejb.Remote;

/**
 * Created by paisanrietbroek on 23/11/2016.
 */
@Remote
public interface IMechanicService {
    public void add(Mechanic mechanic);
}
