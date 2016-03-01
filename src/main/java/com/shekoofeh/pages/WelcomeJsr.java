package com.shekoofeh.pages;

import org.apache.wicket.PageParameters; //version 1.4.17
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
//import org.apache.wicket.request.mapper.parameter.PageParameters;// version 7.2.0
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.shekoofeh.HelloService;
import com.shekoofeh.JsrService;

public class WelcomeJsr extends WebPage {

	@SpringBean
	private HelloService helloService;
	@SpringBean 
	private JsrService jsrService;

	
	public WelcomeJsr(final PageParameters parameters) {

		add(new Label("msg", helloService.getHelloWorldMsg()));
		
		Link addJsrLink = new Link("addJsrLink"){
			@Override
    	    public void onClick() {
				PageParameters pageParameters = new PageParameters();
    	    	setResponsePage(addJsr.class, pageParameters);

			}
    		
		};
        add(addJsrLink);
       
        Link listJsrsLink = new Link("listJsrsLink"){
        	  @Override
        	    public void onClick() {
        			PageParameters pageParameters = new PageParameters();
        	    	setResponsePage(SuccessPage.class, pageParameters);

        	      
        	    }
        };
        
        add(listJsrsLink);
        
        Link batchCreateLink = new Link("batchCreateLink"){
        	 @Override
     	    public void onClick() {
     	 
        	PageParameters pageParameters = new PageParameters();
        	jsrService.createJsrs();
            setResponsePage(SuccessPage.class, pageParameters); 	
        	 }
        };
        
        add(batchCreateLink);

	}

}