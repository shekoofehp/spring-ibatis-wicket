package com.shekoofeh;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

	public String getHelloWorldMsg() {
		return "........Spring +Wicket+ Ibatis+Jsr.......";
	}

}