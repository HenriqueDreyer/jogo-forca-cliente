package com.dreyer.connection;

/**
 * 
 * Connection.java
 *
 * @author <a href="henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 29 de set de 2019
 *
 */
public interface Connection {
            
    public void sendMessage(String msg) throws Exception;
    
    public String reciveMessage() throws Exception;
    
    public void closeConection() throws Exception;
    
}
