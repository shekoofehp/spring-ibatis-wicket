package com.shekoofeh.pages;

import org.apache.wicket.PageParameters; //version 1.4.17
//import org.apache.wicket.request.mapper.parameter.PageParameters;// version 7.2.0
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.shekoofeh.Jsr;
import com.shekoofeh.JsrService;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.PropertyModel;

public class addJsr extends WebPage {
    @SpringBean 
	private JsrService jsrService;
    
	private Jsr jsr ;


	public addJsr(final PageParameters parameters) {

		add(new FeedbackPanel("feedback"));
		if ( parameters.containsKey("currentId"))
			jsr = jsrService.getJsr (parameters.getString("currentId"));
		
		else
			jsr= new Jsr();
			
		final TextField<String> tId = new TextField<String>("id",
				new PropertyModel<String>(jsr, "id"));
		
		final TextField<String> tName = new TextField<String>("name",
				new PropertyModel<String>(jsr, "name"));
	
		
		final TextField<String> tDescription = new TextField<String>("description",
				new PropertyModel<String>(jsr, "description"));
		
		final TextField<String> tSpecLead = new TextField<String>("specLead",
				new PropertyModel<String>(jsr, "specLead"));

		Form<?> form = new Form<Void>("jsrForm") {

			@Override
			protected void onSubmit() {

				PageParameters pageParameters = new PageParameters();
				/*pageParameters.add("id", jsr.getId());
				pageParameters.add("name", jsr.getName());
		
				pageParameters.add("description", jsr.getDescription());
				pageParameters.add("specLead", jsr.getSpecLead());
				*/
				if ( jsrService.getJsr(jsr.getId()) == null){
					pageParameters.add("resultStr", jsr.toString() + " added successfully.");		
									jsrService.insertJsr(jsr);	
				}
				else{
					pageParameters.add("resultStr", jsr.toString() + " updated successfully.");
					jsrService.updateJsr(jsr);
				}
		
				setResponsePage(SuccessPage.class, pageParameters);

			}

		};

		add(form);
		form.add(tId);
		form.add(tName);

		form.add(tDescription);
		form.add(tSpecLead);

	}
}
