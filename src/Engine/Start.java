package Engine;
import java.util.List;
import it.app.controller.SqlController;
import it.app.datalayer.tables.daos.ParameterDao;
import it.app.datalayer.tables.pojos.Parameter;
import org.jooq.DSLContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
	


	public static void main(String[] args) {

		
		
		
		ApplicationContext context=null;
		DSLContext dslContext = null;
		
		//listener.startListener("/home/sergiop/Downloads/","/home/sergiop/Downloads/Dump/");
		try{
		      context = new ClassPathXmlApplicationContext("applicationContext.xml");
		}catch(Exception e){
			System.out.println(e.getLocalizedMessage());
		}
		
		SqlController sqlc = context.getBean("sqlcontroller", SqlController.class);
		sqlc.test();

		
		
		dslContext = context.getBean("dsl", org.jooq.impl.DefaultDSLContext.class);
	    ParameterDao dao = new ParameterDao();
		dao.setConfiguration(dslContext.configuration());
	    List<Parameter> list = dao.findAll();


	      Parameter p=null;
	      for(int i=0; i<list.size(); i++){
	    	  
	    	  p=list.get(i);
	    	  System.out.println(p.getSrcPath());
	    	  System.out.println(p.getDstPath());
	    	  System.out.println(p.getDescrizione());
	    	  
	      }
	      
	    

	}

}
