package rdw;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sander on 29-11-2016.
 */
public class RDWSteekproefMock implements RDWSteekproefWebService_PortType {

    private  List<String> licenseplates = new ArrayList<String>(){{
        add("G-546-GA");
        add("KE-90-PA");
    }};

    @Override
    public Boolean steekproef(String kenteken) throws RemoteException {
        return licenseplates.contains(kenteken);
    }
}
