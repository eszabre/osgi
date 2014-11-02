package com.github.eszabre.osgi.ds.impl;


import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;
import aQute.bnd.annotation.component.Reference;
import com.github.eszabre.osgi.ds.HelloService;

@Component
public class BasicComponent {


	private HelloService helloService;

	@Activate
	public void sayHello() {
		System.out.println("Hello");
		if (helloService == null) {
			System.out.println("helloService is null");
		} else {
			System.out.println("helloService is NOT null");
			helloService.doSomething();
		}


	}

	@Deactivate
	public void sayBye() {
		System.out.println("Bye");
	}

	@Reference
	public void setHelloService(HelloService helloService) {
		this.helloService = helloService;
	}
}
