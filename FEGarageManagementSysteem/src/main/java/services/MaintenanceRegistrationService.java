package services;

import lombok.Data;

import javax.faces.flow.FlowScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by paisanrietbroek on 28/11/2016.
 */

@Data
@Named("maintenanceRegistrationService")
@FlowScoped("maintenance_registratoin")
public class MaintenanceRegistrationService implements Serializable {

}
