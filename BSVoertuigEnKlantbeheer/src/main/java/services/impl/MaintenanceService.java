package services.impl;

import entities.Car;
import entities.Maintenance;
import entities.MaintenanceState;
import entities.Mechanic;
import services.ICarService;
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
public class MaintenanceService implements IMaintenanceService {

    @PersistenceContext
    private EntityManager em;

    public List<Maintenance> getAll() {
        return em.createNamedQuery("getAllMaintenance").getResultList();
    }

    public Maintenance getOne(Long id) {
       return em.find(Maintenance.class, id);
    }

    public void add(Maintenance maintenance) {
        em.merge(maintenance);

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
