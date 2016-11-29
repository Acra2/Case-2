package rdw;

import java.rmi.RemoteException;

/**
 * Created by Sander on 29-11-2016.
 */
public class RDWSteekproefMock implements RDWSteekproefWebService_PortType {

    @Override
    public Boolean steekproef(String kenteken) throws RemoteException {
        return true;
    }
}
