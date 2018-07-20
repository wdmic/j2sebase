package com.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class TestServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8888);
			while (true) {
				Socket s = ss.accept();
				DataInputStream dis = new DataInputStream(s.getInputStream());
				DataOutputStream dos = new DataOutputStream(s.getOutputStream());
				String string = null;
				if ((string = dis.readUTF()) != null) {
					System.out.println(string);
					System.out.println("来自：" +s.getInetAddress() + ":" + s.getPort());
				}
				System.out.println("发向客户");
				dos.writeUTF("你好");
				dos.flush();
				dis.close();
				dos.close();
				s.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
