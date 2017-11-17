import java.io.*;
import java.net.*;
import java.util.Scanner;

//this is a server using Java Sockets
public class Server {

	
	public static void main(String[] args){
		
	
	
	try {
		//create a server socket on port 42108
		ServerSocket socket1 = new ServerSocket(42108);
		//block server until client makes connection
		Socket s1 = socket1.accept();
		
		
		DataInputStream input = new DataInputStream(s1.getInputStream());
		DataOutputStream output = new DataOutputStream(s1.getOutputStream());	
		//message to send
		
		Scanner scan1 = new Scanner(System.in);
		String incoming = "";
		String outgoing = "";
		while(!incoming.equals("end")){
			System.out.println("Write 'end' to end chat: ");
			outgoing = scan1.nextLine();
			//write UTF writes to output stream
			output.writeUTF("Server said: " + outgoing);
			//print input stream
			incoming = input.readUTF();
			System.out.println(incoming);
		}
		
		s1.close(); 
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
