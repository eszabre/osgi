/*
 * Copyright 2015 Szabolcs Balazs Beres.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

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
