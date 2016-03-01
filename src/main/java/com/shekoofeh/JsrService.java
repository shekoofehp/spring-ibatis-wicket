package com.shekoofeh;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


 
public class JsrService {


	JsrDAO jsrDAO;
  

	//DI via Spring
	public void setJsrDAO(JsrDAO jsrDAO) {
		this.jsrDAO = jsrDAO;
	}

	//call DAO to save jsr
	public void createJsrs(){
		
		//jsrDAO.insertJsr(jsr);
		  System.out.println("Inserting JSRs");
		  insertJsrs(jsrDAO);

		
	}
	public void updateJsr( Jsr jsr){
		
		
		  System.out.println("Updating JSR id="+ jsr.getId());
		  
		  jsrDAO.updateJsr(jsr);

		
	}
	public void deleteJsr(String id){
		

		  System.out.println("Deleting JSR id="+id);
		  jsrDAO.deleteJsr(id);

		
	}
	public Jsr getJsr(String id){
		
		//jsrDAO.insertJsr(jsr);
		  System.out.println("Inserting JSRs");
		 return jsrDAO.selectJsrById(id);

		
	}
	
	//call DAO to return people
	public List<Jsr> listJsrs(){
		
		//return jsrDAO.selectAllJsrs();

        System.out.println("Listing all JSRs");
        List<Jsr> allJsrs = jsrDAO.selectAllJsrs();
        for (Jsr aJsr : allJsrs)
        {
            System.out.println(aJsr);
        }
        return allJsrs ;
		
	}

    public  void insertJsrs(JsrDAO jsrDAO)
    {
        Jsr newJsr = createJsr("JSR001", "JMX",
            "Java Management Extension", "McManus");
        jsrDAO.insertJsr(newJsr);   

        newJsr = createJsr("JSR002", "XML",
            "XML Parsing Spec", "Rajiv");
        jsrDAO.insertJsr(newJsr);   

        newJsr = createJsr("JSR003", "JDO",
            "Java Data Objects", "Russell");
     
        jsrDAO.insertJsr(newJsr);   
        newJsr = createJsr("JSR004", "Servlets",
            "Java Servlets and JSP", "Belkin");
        jsrDAO.insertJsr(newJsr);   
    }

    public  void insertJsr(Jsr jsr )
    {
    	jsrDAO.insertJsr(jsr);   
    }
    public  Jsr createJsr(String id, String name, String description, String specLead)
    {
        Jsr newJsr = new Jsr();
        newJsr.setId(id);
        newJsr.setName(name);
        newJsr.setDescription(description);
        newJsr.setSpecLead(specLead);
      
        return newJsr;
    }
	
}
