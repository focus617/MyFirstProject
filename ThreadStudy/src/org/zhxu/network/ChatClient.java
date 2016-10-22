package org.zhxu.network;

import java.io.*;
import java.net.*;

public class ChatClient implements Runnable {
	String svrIpAddr = "127.0.0.1";
	int svrPort = 5555;
	Socket sock;
	
	public void run() {
		try {
			sock = new Socket(svrIpAddr, svrPort);

			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			BufferedReader reader = new BufferedReader(streamReader);

			String msg;
			
			while ((msg = reader.readLine())!= null){
				System.out.println("Client received: " + msg);
			}

			reader.close();
			System.out.println("Client quit!");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
