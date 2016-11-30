package services.impl;

import entities.Mechanic;
import services.IMechanicService;
import javax.persistence.EntityManager;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;
import interceptors.LogInterceptorBinding;

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
        if (mechanic.getId() != null)
            em.merge(mechanic);
        else
            em.persist(mechanic);

        return mechanic;
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
