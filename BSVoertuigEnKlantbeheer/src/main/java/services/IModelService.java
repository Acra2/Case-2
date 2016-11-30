package services;

import entities.Model;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by paisanrietbroek on 23/11/2016.
 */

@Remote
public interface IModelService {
    public Model add(Model model);

    public List getAllModels();
}
