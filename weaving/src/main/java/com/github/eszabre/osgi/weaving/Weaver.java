package com.github.eszabre.osgi.weaving;

import org.osgi.framework.hooks.weaving.WeavingHook;
import org.osgi.framework.hooks.weaving.WovenClass;

public class Weaver implements WeavingHook {
	@Override
	public void weave(WovenClass wovenClass) {
		System.out.println("Weave: " + wovenClass.getClassName());
		wovenClass.
	}
}
