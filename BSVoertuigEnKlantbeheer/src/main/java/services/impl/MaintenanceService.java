package services.impl;

import entities.Maintenance;
import services.IMaintenanceService;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Sander on 22-11-2016.
 */
@Stateful
@Remote(IMaintenanceService.class)
public class MaintenanceService implements IMaintenanceService{

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Maintenance> getAll() {
        return em.createNamedQuery("getAllMaintenance").getResultList();
    }

    @Override
    public Maintenance getOne(Long id) {
        return null;
    }

    @Override
    public void add(Maintenance maintenance) {
        em.persist(maintenance);
    }
}
