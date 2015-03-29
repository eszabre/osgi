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

package com.github.eszabre.osgi.ds.felix.scr.it;

import com.github.eszabre.osgi.ds.felix.scr.filtering.UberCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Configuration;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.ops4j.pax.exam.spi.reactors.PerClass;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.ops4j.pax.exam.CoreOptions.*;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerClass.class)
public class UberCalculatorTest {

	@Inject
	private UberCalculator uberCalculator;

	@Configuration
	public Option[] config() {

		return options(
//				vmOption("-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5005"), // for debuging
//				systemTimeout(0),
				systemProperty("logback.configurationFile").value(
						"file:src/test/resources/logback.xml"),
				mavenBundle("org.slf4j", "slf4j-api", "1.7.2"),
				mavenBundle("ch.qos.logback", "logback-core", "1.0.4"),
				mavenBundle("ch.qos.logback", "logback-classic", "1.0.4"),
				mavenBundle("com.github.eszabre.osgi", "ds-felix-scr", "1.0-SNAPSHOT").start(),
				mavenBundle("org.apache.felix", "org.apache.felix.scr", "1.8.2"),
				junitBundles()
		);
	}

	@Test
	public void testServiceExists() throws Exception {
		assertNotNull(uberCalculator);
	}

	@Test
	public void testStringCalc() throws Exception {
		assertEquals(35, uberCalculator.addAsString(3,5));
	}

	@Test
	public void testNumberCalc() throws Exception {
		assertEquals(8, uberCalculator.addAsNumber(3,5));
	}

}
