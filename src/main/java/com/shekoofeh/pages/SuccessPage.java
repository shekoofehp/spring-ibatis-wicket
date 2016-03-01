package com.shekoofeh.pages;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.wicket.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.shekoofeh.Jsr;
import com.shekoofeh.JsrService;

import org.apache.wicket.markup.html.WebPage;

public class SuccessPage extends WebPage {
	 @SpringBean 
		private JsrService jsrService;
	private Jsr jsr;    

	public SuccessPage(final PageParameters parameters) {

		List<Jsr> resultList = jsrService.listJsrs();
		add(new ListView("listview", resultList) {
			
		    protected void populateItem(final ListItem item) {
		    	jsr = (Jsr) item.getModelObject();
		        item.add(new Label("id", jsr.getId()));
		        item.add(new Label("name", jsr.getName()));
		        item.add(new Label("description", jsr.getDescription()));
		        item.add(new Label("specLead", jsr.getSpecLead()));
		        Link deleteJsrLink = new Link("deleteJsrLink"){
		        	 @Override
		        	 public void onClick() {
		        		//item.getIndex(); 
		        		jsr = (Jsr) item.getModelObject();
		       	    	PageParameters pageParameters = new PageParameters();
		        		String result="Jcr (id="+jsr.getId()+" deleted";
     					pageParameters.add("result",result );
     			   	   	jsrService.deleteJsr(jsr.getId());
	        	    	setResponsePage(SuccessPage.class, pageParameters);
		        	    	
	        	    }
	
		        };
		        item.add(deleteJsrLink);
		        Link updateJsrLink = new Link("updateJsrLink"){
		        	 @Override
		        	 public void onClick() {
		        	  	jsr = (Jsr) item.getModelObject();
		       	    	PageParameters pageParameters = new PageParameters();
		        		pageParameters.add("currentId",jsr.getId() );
  	        	    	setResponsePage(addJsr.class, pageParameters);
		        	    	
	        	    }
		        };    
		        item.add(updateJsrLink);
		        
		     
		    }
		});
		
		
		
		final Label resultStr;
		if (parameters.containsKey("resultStr"))
			resultStr = new Label("resultStr", parameters.getString("resultStr"));
		else
			resultStr = new Label("resultStr", "");

		add(resultStr);

	}
}
