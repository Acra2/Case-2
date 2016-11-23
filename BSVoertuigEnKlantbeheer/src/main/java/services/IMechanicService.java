package services;

import entities.Mechanic;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by paisanrietbroek on 23/11/2016.
 */
@Remote
public interface IMechanicService {
    void add(Mechanic mechanic);
    Mechanic getMechanic(Long id);
    List<Mechanic> getAllMechanics();

}
