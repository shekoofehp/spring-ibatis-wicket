package com.shekoofeh;

import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.IResourceSettings;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;

import com.shekoofeh.pages.SimplePage;
import com.shekoofeh.pages.WelcomeJsr;
import com.shekoofeh.pages.addJsr;


public class WicketApplication extends WebApplication {

	@Override
	public Class<WelcomeJsr> getHomePage() {

		//return SimplePage.class; // return default page
		return WelcomeJsr.class; // return default page
	}
	
	@Override
	protected void init() {
		
		super.init();
		addComponentInstantiationListener(new SpringComponentInjector(this));  //version 1.4.17
		//getComponentInstantiationListeners().add(new SpringComponentInjector(this));	 // version 7.2.0
			IResourceSettings resourceSettings = getResourceSettings();
	                resourceSettings.addResourceFolder("pages");
	       getResourceSettings().setResourceStreamLocator(new MyOwnStreamLocator());
	                
		
	}

}