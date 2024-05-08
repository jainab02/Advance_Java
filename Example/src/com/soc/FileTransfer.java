package com.soc;
import java.io.*;
import java.net.*;

public class FileTransfer {
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8000); // create server socket on port 8000
			System.out.println("Server started");
			
			while (true) {
				Socket clientSocket = serverSocket.accept(); // accept client connection
				System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());
				
				// create input/output streams
				DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
				DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
				
				// receive file name from client
				String fileName = dis.readUTF();
				System.out.println("Received file name: " + fileName);
				
				// create file output stream to write transformed file
				FileOutputStream fos = new FileOutputStream("transformed_" + fileName);
				
				// read data from input stream and write to file output stream
				byte[] buffer = new byte[1024];
				int bytesRead;
				while ((bytesRead = dis.read(buffer)) != -1) {
					fos.write(buffer, 0, bytesRead);
				}
				
				// close streams and sockets
				fos.close();
				dis.close();
				dos.close();
				clientSocket.close();
				System.out.println("File transformed and saved");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}


