package services.impl;

import entities.Car;
import entities.Maintenance;
import entities.Mechanic;
import java.util.List;
import javax.persistence.EntityManager;
import services.IMaintenanceService;

import interceptors.LogInterceptorBinding;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.PersistenceContext;

/**
 * Created by Sander on 22-11-2016.
 */
@Stateless
@Remote(IMaintenanceService.class)
@LogInterceptorBinding
public class MaintenanceService implements IMaintenanceService {

    @PersistenceContext
    private EntityManager em;

    public List getAll() {
        return em.createNamedQuery("getAllMaintenance").getResultList();
    }

    public Maintenance getOne(Long id) {
        return em.find(Maintenance.class, id);
    }

    public Maintenance add(Maintenance maintenance) {
        if (maintenance.getId() != null)
            em.merge(maintenance);
        else
            em.persist(maintenance);

        return maintenance;
    }

    @Override
    public Maintenance getInMaintenanceForMechanic(Mechanic mechanic) {
        List resultList = em.createNamedQuery("getMaintenanceForMechanicAndState")
                .setParameter("mechanicId", mechanic.getId())
                .getResultList();

        if (!resultList.isEmpty())
            return (Maintenance) resultList.get(0);
        else
            return null;
    }

    @Override
    public List getMaintenanceForCar(Car car) {
        List resultList = em.createNamedQuery("getMaintenanceForCar")
                .setParameter("vehiclenumber", car.getVehicleNumber())
                .getResultList();
        return resultList;
    }

    @Override
    public List getCarsInMaintenance() {
        return em.createNamedQuery("CarsInMaintenance").getResultList();
    }
}
