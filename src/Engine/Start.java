package Engine;
import java.util.ArrayList;
import java.util.List;

import it.app.daemon.ListenerDirectory;
import it.app.datalayer.tables.daos.ParameterDao;
import it.app.datalayer.tables.pojos.Parameter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
	
	
//	@Autowired
//	public static ListenerDirectory listener;

	public static void main(String[] args) {

		ApplicationContext context=null;
		//listener.startListener("/home/sergiop/Downloads/","/home/sergiop/Downloads/Dump/");
		try{
		      context = new ClassPathXmlApplicationContext("applicationContext.xml");
		}catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
		
		ListenerDirectory ls = context.getBean("listener", ListenerDirectory.class);
		if(ls!=null){
			System.out.println(ls.toString());
		}
	      
	      /*ParameterDao dao = new ParameterDao();
	      List<Parameter> list = dao.findAll();


	      Parameter p=null;
	      for(int i=0; i<list.size(); i++){
	    	  
	    	  p=list.get(i);
	    	  System.out.println(p.getSrcPath());
	    	  System.out.println(p.getDstPath());
	    	  System.out.println(p.getDescrizione());
	    	  
	      }*/
	      
	    

	}

}
