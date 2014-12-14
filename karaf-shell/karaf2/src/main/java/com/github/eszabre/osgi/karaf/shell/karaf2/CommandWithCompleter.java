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

package com.github.eszabre.osgi.karaf.shell.karaf2;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;

@Command(scope = "eszabre", name = "helloComp", description="Says hello")
public class CommandWithCompleter extends OsgiCommandSupport {

	@Argument(index = 0, name = "argName", description = "The argument", required = true, multiValued = false)
	private String name = null;

	@Override
	protected Object doExecute() throws Exception {
		System.out.println("Hello " + name);
		return null;
	}
}
