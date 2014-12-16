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

package com.github.eszabre.osgi.events;

import com.google.common.base.Joiner;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public class FrameworkEventSubscriber implements EventHandler {

	@Override
	public void handleEvent(Event event) {
		System.out.println("FrameworkEventSubscriber.handleEvent: " + eventToString(event));
	}

	private String eventToString(Event event) {
		return event.getTopic() + "\tproperties: " + Joiner.on(",").join(event.getPropertyNames());
	}
}
