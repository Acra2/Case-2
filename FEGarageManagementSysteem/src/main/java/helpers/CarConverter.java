package helpers;

import entities.Customer;

import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.io.Serializable;

/**
 * Created by paisanrietbroek on 23/11/2016.
 */

@Named("carConverter")
@FacesConverter(value = "CarConvert")
@SessionScoped
public class CarConverter implements Converter , Serializable {

    @PersistenceContext
    private transient EntityManager em;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }

        TypedQuery<Customer> query = em.createQuery("SELECT c FROM customer c WHERE c.email = :email", Customer.class)
                .setParameter("email", s);

        Customer singleResult = query.getSingleResult();

        return em.find(Customer.class, new Long(singleResult.getId()));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o == null) {
            return null;
        }
        return ((Customer) o).getEmail().toString();
    }
}
