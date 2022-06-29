/**
 * Demonstrates the user of Java bean with JSP
**/

package javawebapps;

import java.util.Locale;
import java.util.Map;

public class HelloHelper {

	public String getGreeting(Locale locale){

		// Determine Language to use
		String languageTag = locale.toLanguageTag().substring(0,2);

		// Determine Greeting language
		String greeting;
		switch(languageTag){
			case "fr": // French
				greeting = "Bonjour";
				break;
			case "de": // German
				greeting = "Guten Tag";
				break;
			default: // anything else
				greeting = "Hello";
				languageTag = "en";
		}
		
		return greeting;
	}

}