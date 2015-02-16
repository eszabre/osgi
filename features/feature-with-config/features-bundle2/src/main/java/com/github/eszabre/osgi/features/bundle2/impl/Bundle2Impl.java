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
