package com.shekoofeh.pages;

import org.apache.wicket.PageParameters; //version 1.4.17
import org.apache.wicket.markup.html.basic.Label;
//import org.apache.wicket.request.mapper.parameter.PageParameters;// version 7.2.0
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.shekoofeh.HelloService;

public class SimplePage extends WebPage {

	@SpringBean
	private HelloService helloService;
	
	public SimplePage(final PageParameters parameters) {

		add(new Label("msg", helloService.getHelloWorldMsg()));

	}

}