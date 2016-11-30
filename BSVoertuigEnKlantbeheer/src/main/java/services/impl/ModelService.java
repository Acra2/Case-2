package services.impl;

import entities.Model;
import services.IModelService;
import java.util.List;
import javax.persistence.EntityManager;

import interceptors.LogInterceptorBinding;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

/**
 * Created by paisanrietbroek on 23/11/2016.
 */
@Stateless
@Remote(IModelService.class)
@LogInterceptorBinding
public class ModelService implements IModelService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Model add(Model model) {
        if (model.getId() != null)
            em.merge(model);
        else
            em.persist(model);

        return model;
    }

    @Override
    public List getAllModels() {
        return em.createNamedQuery("getAllModels", Model.class).getResultList();
    }
}
