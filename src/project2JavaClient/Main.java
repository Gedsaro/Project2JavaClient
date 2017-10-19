package project2JavaClient;

import java.io.*;
import java.net.*;
import java.util.*;
//THIS IS FOR TESTING A JAVA CLIENT
public class Main {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String hostName = "";
		int portNumber = 8000;
		String fromServer = "";
		String fromUser = "";
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

		Socket kkSocket = new Socket(hostName, portNumber);
		PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
		BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));

		
		while((fromServer = in.readLine()) != null) {
			System.out.println("Server: " + fromServer);
			if(fromServer.equals("Bye."))
				break;
			
			fromUser = stdIn.readLine();
			if(fromUser != null) {
				System.out.println("Client: " + fromUser);
				out.println(fromUser);
			
			}
		}
	}

}
