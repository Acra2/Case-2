import lombok.Data;
import lombok.NoArgsConstructor;
import services.ICarService;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 * Created by paisanrietbroek on 23/11/2016.
 */
@Named("car")
@SessionScoped
@NoArgsConstructor
@Data
public class CarService implements Serializable {

    @EJB
    private ICarService carService;

    public List getAllCars() {
        return carService.getAllCars();
    }
}
