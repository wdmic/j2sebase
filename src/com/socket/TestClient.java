package com.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8888);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			dos.writeUTF("��");
			dos.flush();
			System.out.println("����");
			String string = null;
			if ((string = dis.readUTF()) != null) {
				System.out.println(string);
			}
			dis.close();
			dos.close();
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
