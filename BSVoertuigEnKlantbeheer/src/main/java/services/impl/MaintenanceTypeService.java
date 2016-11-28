package services.impl;

import entities.Maintenance;
import entities.MaintenanceType;
import services.IMaintenanceService;
import services.IMaintenanceTypeService;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Sander on 28-11-2016.
 */
@Stateful
@Remote(IMaintenanceTypeService.class)
public class MaintenanceTypeService implements IMaintenanceTypeService {

    @PersistenceContext
    private EntityManager em;

    public List<MaintenanceType> getAllTypes() {
        List resultList = em.createNamedQuery("getAllMaintenanceTypes").getResultList();
        return resultList;
    }

    public void add(MaintenanceType maintenanceType){
        em.persist(maintenanceType);
    }

    @Override
    public MaintenanceType getOneType(Long id) {
        return em.find(MaintenanceType.class, id);
    }
}
