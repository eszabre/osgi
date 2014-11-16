package com.github.eszabre.osgi.weaving;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import java.util.Hashtable;


public class Activator implements BundleActivator {
	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("Starting: " + Activator.class.getName());

		bundleContext.registerService(
				org.osgi.framework.hooks.weaving.WeavingHook.class,
				new Weaver(), new Hashtable<String, Object>() );
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("Stopping: " + Activator.class.getName());
	}
}
