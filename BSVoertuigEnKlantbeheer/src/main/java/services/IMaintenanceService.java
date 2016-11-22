package services;

import entities.Maintenance;
import sun.applet.Main;

import java.util.List;

/**
 * Created by Sander on 22-11-2016.
 */
public interface IMaintenanceService {
    List<Maintenance> getAll();
    Maintenance getOne(Long id);
    void add(Maintenance maintenance);
}
