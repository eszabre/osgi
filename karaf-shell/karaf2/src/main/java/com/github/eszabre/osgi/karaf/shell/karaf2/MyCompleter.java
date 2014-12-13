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

import java.util.List;

import org.apache.karaf.shell.console.Completer;
import org.apache.karaf.shell.console.completer.StringsCompleter;

public class MyCompleter implements Completer {
	@Override
	public int complete(String buffer, int cursor, List candidates) {
		StringsCompleter delegate = new StringsCompleter();
		delegate.getStrings().add("option1");
		delegate.getStrings().add("option2");
		return delegate.complete(buffer, cursor, candidates);
	}
}
