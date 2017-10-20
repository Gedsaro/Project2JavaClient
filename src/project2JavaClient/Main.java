package project2JavaClient;

import java.io.*;
import java.net.*;
import java.util.*;
//THIS IS FOR TESTING A JAVA CLIENT
public class Main {

	public static void main(String[] args) throws UnknownHostException, IOException {
		String hostName = "localhost";
		int portNumber = 8000;
		String fromServer = "";
		String fromUser = "";
		
		System.out.println("Begining");
		BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("buffered reader stdIn set up");

		Socket kkSocket = new Socket(hostName, portNumber);
		System.out.println("Connected?");
		PrintWriter out = new PrintWriter(kkSocket.getOutputStream(), true);
		System.out.println("Made printwriter uising socket outputstream");
		BufferedReader in = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));
		System.out.println("Made beffered reader out of in from inputsreamreader for socket");
		
		System.out.println("Please type something");
		out.println("I AM A TEST");
		//fromUser = stdIn.readLine();
		//System.out.println("You have typed: " + fromUser);
		
		//out.println(fromUser);
		
		while((fromServer = in.readLine()) != null) {

			System.out.println("Server: " + fromServer);

			if(fromServer.equals("Bye."))
			{
				System.out.println("fromServer = " + fromServer);
				break;
			}
			
			fromUser = stdIn.readLine();
			if(fromUser != null) {
				System.out.println("Client: " + fromUser);
				out.println(fromUser);
			}
			
			
		}
	}

}
