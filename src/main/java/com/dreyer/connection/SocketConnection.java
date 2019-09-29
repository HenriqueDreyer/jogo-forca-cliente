package com.dreyer.connection;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 
 * SocketConnection.java
 *
 * @author <a href="henriquedreyer@gmail.com">Henrique Dreyer</a>
 *
 * @since 29 de set de 2019
 *
 */
public class SocketConnection implements Connection {

	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	private Socket socket = null;

	public SocketConnection() throws Exception {
		socket = new Socket("localhost", 7696);
		inputStream = new DataInputStream(socket.getInputStream());
		outputStream = new DataOutputStream(socket.getOutputStream());
	}

	public void sendMessage(String msg) throws IOException {
		outputStream.writeUTF(msg);
	}

	public String reciveMessage() throws IOException {
		return inputStream.readUTF();
	}

	public void closeConection() throws IOException {

		if (socket != null) {
			socket.close();
		}
	}

}
