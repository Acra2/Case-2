package services.impl;

import entities.MaintenanceType;
import services.IMaintenanceTypeService;
import javax.persistence.EntityManager;
import java.util.List;

import interceptors.LogInterceptorBinding;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

/**
 * Created by Sander on 28-11-2016.
 */
@Stateless
@Remote(IMaintenanceTypeService.class)
@LogInterceptorBinding
public class MaintenanceTypeService implements IMaintenanceTypeService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List getAllTypes() {
        return em.createNamedQuery("getAllMaintenanceTypes").getResultList();
    }

    public MaintenanceType add(MaintenanceType maintenanceType) {
        if (maintenanceType.getId() != null)
            em.merge(maintenanceType);
        else
            em.persist(maintenanceType);

        return maintenanceType;
    }

    @Override
    public MaintenanceType getOneType(Long id) {
        return em.find(MaintenanceType.class, id);
    }
}
