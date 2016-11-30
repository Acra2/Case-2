package services.impl;

import entities.Mechanic;
import interceptors.LogInterceptorBinding;
import services.IMechanicService;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by paisanrietbroek on 23/11/2016.
 */
@Stateless
@Remote(IMechanicService.class)
@LogInterceptorBinding
public class MechanicService implements IMechanicService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Mechanic add(Mechanic mechanic) {
        if (mechanic.getId() != null) {
            em.merge(mechanic);
        } else {
            em.persist(mechanic);
        }
        return mechanic;
    }

    @Override
    public List getAllMechanics() {
        return em.createNamedQuery("getAllMechanics").getResultList();
    }

    @Override
    public Mechanic getMechanic(Long id) {
        return em.find(Mechanic.class, id);
    }
}
