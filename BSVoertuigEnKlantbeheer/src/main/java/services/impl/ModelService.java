package services.impl;

import entities.Model;
import services.IModelService;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by paisanrietbroek on 23/11/2016.
 */
@Stateful
@Remote(IModelService.class)
public class ModelService implements IModelService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Model model) {
        em.persist(model);
    }

    @Override
    public List getAllModels() {
        return em.createNamedQuery("getAllModels", Model.class).getResultList();
    }
}
