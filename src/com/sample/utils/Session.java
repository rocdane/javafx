package com.sample.utils;

import com.sample.views.Gui;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.Random;

public class Session extends Thread {
	private String token;
	private int timer;

	public Session(){
		Random random = new Random();

		String generatedToken = random.ints(48, 122 + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
				.limit(29)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
				.toString();

		this.setToken(generatedToken);
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token){
		this.token = token;
	}

	public int getTimer() {
		return this.timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	@Override
	public void run() {
		while (this.getTimer()>0){
			this.timer--;
			pause(999);
			Session.yield();
		}
		this.sessionDestroy();
	}

	public void pause(long chrono) {
		try {
			Thread.sleep(chrono);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sessionDestroy() {
		try {
			Gui.getGui().setTitle("APP NAME | Se connecter");
			Gui.getGui().setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/auth.fxml"))));
			Gui.getGui().centerOnScreen();
			this.setToken("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}