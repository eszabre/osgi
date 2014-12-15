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

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.Reference;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

@Component(immediate = true)
public class Publisher {

	@Reference
	EventAdmin eventAdmin;

	@Activate
	public void init(BundleContext bundleContext) {
		registerSubscriber(bundleContext);

		Map<String, String> properties = new HashMap<String, String>();
		properties.put("myProperty", "myPropertyValue");
		Event event = new Event("myTopic", properties);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		eventAdmin.sendEvent(event);
	}

	private void registerSubscriber(BundleContext bundleContext) {
		String[] topics = new String[] {
				"myTopic"
		};

		Dictionary<String, String[]> props = new Hashtable<String, String[]>();
		props.put(EventConstants.EVENT_TOPIC, topics);
		bundleContext.registerService(EventHandler.class.getName(), new Subscriber() , props);
	}
}
