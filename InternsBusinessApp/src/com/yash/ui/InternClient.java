package com.yash.ui;

import com.yash.view.MainView;

public class InternClient {

	public static void main(String[] args) {
		MainView mainView=new MainView();
		try {
			mainView.mainMenu();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
