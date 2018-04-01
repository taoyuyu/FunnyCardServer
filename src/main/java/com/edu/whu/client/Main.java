package com.edu.whu.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
	
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("123.207.4.30",7682);
			Player p = new Player();
			int statusCode = p.askCards(socket);
			loop:while (true) {
				switch (statusCode) {
					case 0:{//描述并出牌
						int cardId = 0;
						String description = null;
						p.sendCard(socket, cardId, description);
						break;
					}
					case 1:{//跟牌
						int cardId = 0;
						p.sendCard(socket, cardId);
						break;
					}
					case 2:{//选牌
						int cardId = 0;
						p.chooseCard(socket, cardId);
						break;
					}
					case 3:{//本局结束
						break loop;
					}
					default: break loop;//异常退出
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
