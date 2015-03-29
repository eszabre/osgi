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
import com.github.eszabre.osgi.ds.felix.scr.filtering.UberCalculator;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.apache.felix.scr.annotations.Service;

@Component (immediate = true)
@Service
public class CalculatorComponent implements UberCalculator {

	@Reference
			(target = "(component.name=com.github.eszabre.osgi.ds.felix.scr.filtering.impl.NumberCalculator)")
	private Calculator numberCalculator;

	/**
	 * Filter by property
	 */
	@Reference
			(target = "(myPropertyName=myPropertyValue)")
	private Calculator numberAsStringCalculator;

	@Reference
			(target = "(myPropertyName=*)")
	private Calculator numberAsStringCalculator2;

	@Override
	public int addAsNumber(int a, int b) {
		return numberCalculator.add(a, b);
	}

	@Override
	public int addAsString(int a, int b) {
		return numberAsStringCalculator.add(a, b);
	}
}
