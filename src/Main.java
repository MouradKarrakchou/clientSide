import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("localhost",2001);
        Distante d = (Distante)reg.lookup("MonOD");
        Service service= (Service) d.getRMIRerence();
        service.setValue(5);
        System.out.println(service.getValue());
    }
}
