package com.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestTCPServer {

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(6666);
		while (true) {
			Socket s = ss.accept();
			System.out.println("���ӳɹ�");
			DataInputStream dis = new DataInputStream(s.getInputStream());
			System.out.println(dis.readUTF());
		}
		
	}

}
