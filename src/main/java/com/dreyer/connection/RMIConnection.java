package com.dreyer.connection;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * RMIConnection.java
 *
 * @author <a href="henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 29 de set de 2019
 *
 */
public class RMIConnection implements Connection{
    
    private RIMensagem remoteObject;
    private Registry registry;
    private String message = " ";
    
    public RMIConnection() throws RemoteException{
        registry = LocateRegistry.getRegistry(1099);
    }

    public void sendMessage(String msg) throws Exception {
        try {
            remoteObject = (RIMensagem) registry.lookup("MensagemRMI");
            message = remoteObject.mensagem(msg);
            
        } catch (Exception ex) {
            Logger.getLogger(RMIConnection.class.getName()).log(Level.SEVERE, "SEND MESSAGE", ex);
        }
    }

    public String reciveMessage() throws Exception {
        return message;
    }

	public void closeConection() throws Exception {}  

}


