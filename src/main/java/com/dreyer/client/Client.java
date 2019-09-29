package com.dreyer.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.dreyer.connection.Connection;
import com.dreyer.connection.FactoryConnection;
import com.dreyer.game.Forca;

/**
 * 
 * GameClient.java
 *
 * @author <a href="henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 29 de set de 2019
 *
 */
public class Client {
	
	private static Connection con;

	public static void main(String[] args) {

		try {
			con = FactoryConnection.getInstace();

		} catch (Exception ex) {
			Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
		}

		try {
			Forca game = new Forca(con);
			game.start();
			
		} catch (Exception ex) {
			Logger.getLogger(Client.class.getCanonicalName()).log(Level.SEVERE, "MAIN", ex);
		}
	}

}
