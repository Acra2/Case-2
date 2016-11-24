package mypackage;

import javax.enterprise.inject.Produces;
import javax.xml.rpc.ServiceException;

/**
 * Created by Sander on 24-11-2016.
 */
public class CdiProvider {
    @Produces
    public RDWSteekproefWebService_PortType provide() throws ServiceException {
        RDWSteekproefWebService_ServiceLocator locator = new RDWSteekproefWebService_ServiceLocator();
        try {
            return  locator.getRDWSteekproefWebServicePort();
        } catch (ServiceException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
