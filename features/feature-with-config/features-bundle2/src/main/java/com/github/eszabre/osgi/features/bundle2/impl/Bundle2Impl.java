package com.github.eszabre.osgi.features.bundle2.impl;

import com.github.eszabre.osgi.features.bundle1.Bundle1Service;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Reference;

@Component
public class Bundle2Impl {

	@Reference
	private Bundle1Service bundle1Service;

	@Activate
	public void activate() {
		System.out.println(getClass().getName() + " activated");
		System.out.println("calling doSomething()");
		bundle1Service.doSomething();
	}

	@Deactivate
	public void deactivate() {
		System.out.println(getClass().getName() + " deactivated");
	}
}
