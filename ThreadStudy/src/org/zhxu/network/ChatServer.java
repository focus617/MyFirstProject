package org.zhxu.network;

import java.io.*;
import java.net.*;

public class ChatServer implements Runnable {

	String[] adviceList = { "Take smaller bites", "Go for the tight jeans. No they do NOT make you look fat.",
			"One word: inappropriate", "Just for today, be honest. Tell your boss what you *really* think",
			"You might want to rethink that haircut" };

	public void run() {
		try {
			ServerSocket svrSocket = new ServerSocket(5555);
			System.out.println("Server is ready now");
			
			while (true) {
				System.out.println("Server is listening");
				Socket clntSocket = svrSocket.accept();
				System.out.println("Session start!");

				PrintWriter writer = new PrintWriter(clntSocket.getOutputStream());

				String advice = getAdvice();
				writer.println(advice);
				System.out.println("Server sent: " + advice);
				
				writer.close();
				System.out.println("Session end!");

			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private String getAdvice() {
		int random = (int) (Math.random() * adviceList.length);
		return adviceList[random];
	}
}
