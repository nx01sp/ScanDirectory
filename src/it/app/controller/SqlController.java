package it.app.controller;

import org.springframework.beans.factory.annotation.Autowired;

import it.app.daemon.ListenerDirectory;




public class SqlController {

	@Autowired
	private ListenerDirectory ls;
	
	public SqlController() {

		if(ls!=null){
			System.out.println(ls.toString());
		}else{
			System.out.println("E' null");
		}

	}
	
}
