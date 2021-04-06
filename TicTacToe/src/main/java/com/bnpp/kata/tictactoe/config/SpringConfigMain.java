package com.bnpp.kata.tictactoe.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.bnpp.kata.tictactoe.bean.TicTacToe;

@Configuration
@ComponentScan({ "com.bnpp.kata.tictactoe.bean" })
public class SpringConfigMain {

	public static void main(String a[]) {

		ApplicationContext appContext = new AnnotationConfigApplicationContext(SpringConfigMain.class);
		TicTacToe ticTacToe = (TicTacToe) appContext.getBean("ticTacToe");
		ticTacToe.addPlayer(0, 0);

	}
}
