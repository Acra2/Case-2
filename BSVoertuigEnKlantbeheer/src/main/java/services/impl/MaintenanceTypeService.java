package services.impl;

import entities.Maintenance;
import entities.MaintenanceType;
import interceptors.LogInterceptorBinding;
import services.IMaintenanceService;
import services.IMaintenanceTypeService;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Sander on 28-11-2016.
 */
@Stateless
@Remote(IMaintenanceTypeService.class)
public class MaintenanceTypeService implements IMaintenanceTypeService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List getAllTypes() {
        return em.createNamedQuery("getAllMaintenanceTypes").getResultList();
    }

    public MaintenanceType add(MaintenanceType maintenanceType){
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
