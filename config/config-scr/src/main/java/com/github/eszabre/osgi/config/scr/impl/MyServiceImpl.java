package com.github.eszabre.osgi.config.scr.impl;

import com.github.eszabre.osgi.config.scr.MyService;
import org.apache.felix.scr.annotations.Activate;
import org.apache.felix.scr.annotations.Component;
import org.apache.felix.scr.annotations.ConfigurationPolicy;
import org.apache.felix.scr.annotations.Deactivate;
import org.apache.felix.scr.annotations.Modified;
import org.apache.felix.scr.annotations.Properties;
import org.apache.felix.scr.annotations.Property;
import org.apache.felix.scr.annotations.PropertyOption;
import org.apache.felix.scr.annotations.Service;

import java.util.Map;

@Component(immediate = true, policy = ConfigurationPolicy.OPTIONAL)
@Service
@Properties({
		@Property(name = "BoolProperty",
				boolValue = true,
				label = "myLabel"),
		@Property(name = "StringProperty", value = "myStringValue",
				options = {
						@PropertyOption(name = "option1", value = "optionValue1")
				}),
		@Property(name = "StringListProperty", value = "myStringValue,mystringvalue2",
				cardinality = Integer.MAX_VALUE),
		@Property(name = "PasswordProperty", passwordValue = "1234")
}
)
public class MyServiceImpl implements MyService {

	@Property(description = "Field annotated property without default value")
	private static final String PROPERTY_NAME = "FieldAnnotatedProperty";


	@Activate
	public void activate(final Map<String, Object> properties) {
		System.out.println(this.getClass().getName() + " activated");
		System.out.println("Properties: ");
		printMap(properties);
	}

	private void printMap(Map<String, Object> properties) {
		System.out.println(properties.toString());
	}

	@Modified
	public void update(final Map<String, Object> properties) {
		System.out.println(this.getClass().getName() + " updated");
		System.out.println("Properties: ");
		printMap(properties);
	}

	@Deactivate
	public void deactivate() {
		System.out.println(this.getClass().getName() + " deactivated");
	}




}
