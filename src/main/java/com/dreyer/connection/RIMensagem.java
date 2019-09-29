package com.dreyer.connection;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * RIMensagem.java
 *
 * @author <a href="henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 29 de set de 2019
 *
 */
public interface RIMensagem extends Remote{
    public String mensagem(String message) throws RemoteException;
}
