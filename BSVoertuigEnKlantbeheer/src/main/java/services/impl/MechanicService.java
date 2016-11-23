package services.impl;

import entities.Mechanic;
import services.IMechanicService;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by paisanrietbroek on 23/11/2016.
 */
@Stateful
@Remote(IMechanicService.class)
public class MechanicService implements IMechanicService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Mechanic mechanic) {
        em.persist(mechanic);
    }
}
