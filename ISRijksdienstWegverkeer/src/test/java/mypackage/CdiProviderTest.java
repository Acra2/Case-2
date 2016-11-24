package mypackage;

import org.junit.Test;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Sander on 24-11-2016.
 */
public class CdiProviderTest {


    @Test
    public void RDWSteekProefWebService_PortTypeProvider() throws ServiceException, RemoteException {
        CdiProvider cdiProvider = new CdiProvider();
        RDWSteekproefWebService_PortType provide = null;

        provide = cdiProvider.provide();
        assertNotNull(provide);
        Boolean abc = provide.steekproef("abc");
        assertNotNull(abc);
    }
}