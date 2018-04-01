package com.edu.whu.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

class Card {
	int cardId;
	String type;
	String pictureUrl;
}

public class Player {

	private List<Card> mMyCurrentCards;
	private List<Card> mCardsOnTable;
	
	public int askCards(Socket socket) throws IOException{
		DataInputStream is = new DataInputStream(socket.getInputStream());
		DataOutputStream os = new DataOutputStream(socket.getOutputStream());
		String s = "<message><body type=\"identify\" id=\"Leon\"></body></message>";
		os.writeChars(s);
		s = "<message><body type=\"short_message\" id=\"Leon\" mid=\"1\"><target>AdaWang</target><content> aaaa </content></body></message>";
		os.writeChars(s);
		os.flush();
		byte[] buffer = new byte[1024];
        int len = 0;
		while((len = is.read(buffer)) != -1){
			System.out.println(new String(buffer, 0, len));
		}
		os.close();
		return 0;
	}
	
	public int getOneCard(Socket socket) throws IOException {
		DataInputStream is = new DataInputStream(socket.getInputStream());
		DataOutputStream os = new DataOutputStream(socket.getOutputStream());
		return 0;
	}
	
	public int sendCard(Socket socket, int cardId) throws IOException {
		DataInputStream is = new DataInputStream(socket.getInputStream());
		DataOutputStream os = new DataOutputStream(socket.getOutputStream());
		return 0;
	}
	
	public int sendCard(Socket socket, int cardId, String description) throws IOException {
		DataInputStream is = new DataInputStream(socket.getInputStream());
		DataOutputStream os = new DataOutputStream(socket.getOutputStream());
		return 0;
	}
	
	public int chooseCard(Socket socket, int cardId) throws IOException {
		DataInputStream is = new DataInputStream(socket.getInputStream());
		DataOutputStream os = new DataOutputStream(socket.getOutputStream());
		return 0;
	}
	
}
