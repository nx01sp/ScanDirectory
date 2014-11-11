package Engine;

import Controller.ListenerDirectory;

public class Start {

	public static void main(String[] args) {
		
		ListenerDirectory listener = new ListenerDirectory();
		listener.startListener("/home/sergiop/Downloads/");

	}

}
