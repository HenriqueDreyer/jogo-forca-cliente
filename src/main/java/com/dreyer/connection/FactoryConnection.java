package com.dreyer.connection;

/**
 * 
 * FactoryConnection.java
 *
 * @author <a href="henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 29 de set de 2019
 *
 */
public class FactoryConnection {    

    public static Connection getInstace() throws Exception {
    	return new RMIConnection();
    }

}
