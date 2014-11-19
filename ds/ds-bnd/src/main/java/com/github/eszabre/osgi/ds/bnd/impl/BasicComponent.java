/*
 * Copyright 2014 Szabolcs Balazs Beres.
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

package com.github.eszabre.osgi.ds.bnd.impl;


import aQute.bnd.annotation.component.Activate;
import aQute.bnd.annotation.component.Component;
import aQute.bnd.annotation.component.Deactivate;
import aQute.bnd.annotation.component.Reference;

import com.github.eszabre.osgi.ds.bnd.HelloService;

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
