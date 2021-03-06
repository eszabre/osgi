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

package com.github.eszabre.osgi.ds.felix.scr.hello.impl;

import com.github.eszabre.osgi.ds.felix.scr.hello.HelloService;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Reference;

@Component
public class BasicComponent {

	@Reference
	private HelloService helloService;

	@Activate
	public void sayHello() {
		System.out.println("Hello");
		if (helloService == null) {
			System.out.println("helloService is null");
		} else {
			System.out.println("helloService is NOT null");
			helloService.add(1, 2);
		}
	}

	@Deactivate
	public void sayBye() {
		System.out.println("Bye");
	}

}
