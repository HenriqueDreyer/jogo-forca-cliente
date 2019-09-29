package com.dreyer.connection;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 
 * RMIImObjeto.java
 *
 * @author <a href="henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 29 de set de 2019
 *
 */
public class RMIImObjeto extends UnicastRemoteObject implements RIMensagem {

	private static final long serialVersionUID = 1339058780047345880L;

	public RMIImObjeto() throws RemoteException {
		super();
	}

	public String mensagem(String m) throws RemoteException {
		return m;
	}
}
