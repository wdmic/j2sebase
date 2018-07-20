package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9999);
			Socket socket = ss.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader bir = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
//			if (bir.readLine() != null) {
				System.out.println("对方:" + bir.readLine());
//			}
			
			String string = br.readLine();
			while (!string.equals("bye")) {
				pw.println(string);
				pw.flush();
				System.out.println("\t\t\t自己:" + string);
				System.out.println("对方:" + bir.readLine());
				string = br.readLine();
			}
			
			br.close();
			bir.close();
			pw.close();
			socket.close();
			ss.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
