import java.io.*;
import java.net.*;
import java.util.Scanner;


public class Client {


	
	public static void main(String[] args){
		String host="localhost";
		int port=42108;
		
		try{
			Socket s1 = new Socket(host,port);
			DataInputStream input = new DataInputStream(s1.getInputStream());
			DataOutputStream output = new DataOutputStream(s1.getOutputStream());	
			Scanner scan1 = new Scanner(System.in);
			
			String incoming = "";
			String outgoing = "";
			while(!incoming.equals("end")){
				System.out.println("Write 'end' to end chat: ");
				outgoing = scan1.nextLine();
				//write UTF writes to output stream
				output.writeUTF("Client said: " + outgoing);
				//print input stream
				incoming = input.readUTF();
				System.out.println(incoming);
			}
			//message to send
			
			s1.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

