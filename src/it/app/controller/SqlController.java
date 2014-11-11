package it.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import it.app.daemon.ListenerDirectory;



@Component
public class SqlController {

	@Autowired
	@Qualifier("listener")
	private ListenerDirectory listenerDirectory;
	
	public SqlController() {
	}

	public ListenerDirectory getListenerDirectory() {
		return listenerDirectory;
	}

	public void test(){
		if(listenerDirectory!=null){
			System.out.println(listenerDirectory.toString());
		}else{
			System.out.println("E' null");
		}
	}


	public void setListenerDirectory(ListenerDirectory listenerDirectory) {
		this.listenerDirectory = listenerDirectory;
	}
	
}
