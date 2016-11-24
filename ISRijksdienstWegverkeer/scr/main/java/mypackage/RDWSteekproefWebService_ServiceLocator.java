/**
 * RDWSteekproefWebService_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mypackage;

public class RDWSteekproefWebService_ServiceLocator extends org.apache.axis.client.Service implements mypackage.RDWSteekproefWebService_Service {

    public RDWSteekproefWebService_ServiceLocator() {
    }


    public RDWSteekproefWebService_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public RDWSteekproefWebService_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for RDWSteekproefWebServicePort
    private java.lang.String RDWSteekproefWebServicePort_address = "http://localhost:23011/rdw/RDWSteekproefWebService";

    public java.lang.String getRDWSteekproefWebServicePortAddress() {
        return RDWSteekproefWebServicePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String RDWSteekproefWebServicePortWSDDServiceName = "RDWSteekproefWebServicePort";

    public java.lang.String getRDWSteekproefWebServicePortWSDDServiceName() {
        return RDWSteekproefWebServicePortWSDDServiceName;
    }

    public void setRDWSteekproefWebServicePortWSDDServiceName(java.lang.String name) {
        RDWSteekproefWebServicePortWSDDServiceName = name;
    }

    public mypackage.RDWSteekproefWebService_PortType getRDWSteekproefWebServicePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(RDWSteekproefWebServicePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getRDWSteekproefWebServicePort(endpoint);
    }

    public mypackage.RDWSteekproefWebService_PortType getRDWSteekproefWebServicePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mypackage.RDWSteekproefWebServicePortBindingStub _stub = new mypackage.RDWSteekproefWebServicePortBindingStub(portAddress, this);
            _stub.setPortName(getRDWSteekproefWebServicePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setRDWSteekproefWebServicePortEndpointAddress(java.lang.String address) {
        RDWSteekproefWebServicePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mypackage.RDWSteekproefWebService_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                mypackage.RDWSteekproefWebServicePortBindingStub _stub = new mypackage.RDWSteekproefWebServicePortBindingStub(new java.net.URL(RDWSteekproefWebServicePort_address), this);
                _stub.setPortName(getRDWSteekproefWebServicePortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("RDWSteekproefWebServicePort".equals(inputPortName)) {
            return getRDWSteekproefWebServicePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://steekproef.rdw/", "RDWSteekproefWebService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://steekproef.rdw/", "RDWSteekproefWebServicePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("RDWSteekproefWebServicePort".equals(portName)) {
            setRDWSteekproefWebServicePortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
