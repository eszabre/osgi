package com.github.eszabre.osgi.ds.impl;

import aQute.bnd.annotation.component.Component;
import com.github.eszabre.osgi.ds.HelloService;

@Component
public class HelloServiceImpl implements HelloService {

	@Override
	public void doSomething() {
		System.out.println("doing something");
	}
}
