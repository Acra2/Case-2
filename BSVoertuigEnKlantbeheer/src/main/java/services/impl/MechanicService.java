package services.impl;

import entities.Mechanic;
import interceptors.LogInterceptorBinding;
import services.IMechanicService;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by paisanrietbroek on 23/11/2016.
 */
@Stateful
@Remote(IMechanicService.class)
@LogInterceptorBinding
public class MechanicService implements IMechanicService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Mechanic mechanic) {
        em.persist(mechanic);
    }

    @Override
    public List<Mechanic> getAllMechanics() {
        return em.createNamedQuery("getAllMechanics").getResultList();
    }

    @Override
    public Mechanic getMechanic(Long id) {
        return em.find(Mechanic.class, id);
    }
}
