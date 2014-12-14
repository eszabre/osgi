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

package com.github.eszabre.osgi.karaf.shell.karaf2.head;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.apache.felix.gogo.commands.Argument;
import org.apache.felix.gogo.commands.Command;
import org.apache.felix.gogo.commands.Option;
import org.apache.karaf.shell.console.OsgiCommandSupport;

@Command(scope = "eszabre", name = "head", description="Reads the first n lines of a file")
public class MyHeadCommand extends OsgiCommandSupport {

	@Argument(name = "number", description = "The argument", required = true, multiValued = false,valueToShowInHelp = "10")
	private String number = "10";

	@Option(name = "-f", aliases = "--file", description = "The file to read", required = false, multiValued = false)
	private String file = "Hello";

	@Override
	protected Object doExecute() throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
		String line = null;
		int i = 0;
		while ((line = reader.readLine()) != null
				&& i < Integer.parseInt(number)) {
			System.out.println(line);
			++i;
		}
		return null;
	}
}
