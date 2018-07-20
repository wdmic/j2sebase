package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TalkClient {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 9999);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			BufferedReader bir = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			String string = bir.readLine();
			
			while (!string.equals("bye")) {
				pw.println(string);
				pw.flush();
				System.out.println("\t\t\t自己:" + string);
				System.out.println("对方:" + br.readLine());
				string = bir.readLine();
			}		
			br.close();
			bir.close();
			pw.close();
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
