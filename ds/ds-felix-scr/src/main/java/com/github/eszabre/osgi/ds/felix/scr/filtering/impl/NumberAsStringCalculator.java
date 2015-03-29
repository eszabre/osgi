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

package com.github.eszabre.osgi.ds.felix.scr.filtering.impl;

import com.github.eszabre.osgi.ds.felix.scr.filtering.Calculator;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.Service;


@Component
@Service
@Property(name = "myPropertyName", value = "myPropertyValue")
public class NumberAsStringCalculator implements Calculator {
	@Override
	public int add(int a, int b) {
		System.out.println("NumberAsStringCalculator: add called: " + a + " + " + b);
		return Integer.parseInt("" + a + b);
	}
}
