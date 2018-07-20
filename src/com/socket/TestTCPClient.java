package com.socket;

import java.io.DataOutputStream;
import java.net.Socket;

public class TestTCPClient {

	public static void main(String[] args) throws Exception{
		Socket s = new Socket("localhost", 6666);
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		Thread.sleep(3000);
		dos.writeUTF("ÄãºÃ");
		dos.flush();
		dos.close();
		s.close();
	}

}
