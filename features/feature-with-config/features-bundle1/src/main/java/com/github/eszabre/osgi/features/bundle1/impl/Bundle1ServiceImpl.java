package com.github.eszabre.osgi.features.bundle1.impl;

import java.util.Map;

import com.github.eszabre.osgi.features.bundle1.Bundle1Service;
import com.google.common.base.Joiner;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;

@Component(name = "Bundle1Component")
@Service
@Properties(
		{@Property(name = "booleanProperty", boolValue = true)}
)
public class Bundle1ServiceImpl implements Bundle1Service {

	@Activate
	public void activate(Map<String, Object> properties) {
		System.out.println(getClass().getName() + " activated");
		printProperties(properties);
	}

	@Modified
	public void update(Map<String, Object> properties) {
		System.out.println(getClass().getName() + " updated");
		printProperties(properties);
	}

	private void printProperties(Map<String, Object> properties) {
		System.out.println("Properties");
		String str = Joiner.on(", ").withKeyValueSeparator(": ").join(properties);
		System.out.println(str);
	}

	@Deactivate
	public void deactivate() {
		System.out.println(getClass().getName() + " deactivated");
	}

	@Override
	public void doSomething() {
		System.out.println("com.github.eszabre.osgi.features.bundle1.impl.Bundle1ServiceImpl.doSomething()");
	}
}
