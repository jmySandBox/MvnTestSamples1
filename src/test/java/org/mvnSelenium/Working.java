package org.mvnSelenium;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class Working {

	private Chrome_Sample chrome = new Chrome_Sample();

	@Test
	public void chromeCalls() {
		assertThat(chrome.srchQuery(), containsString("Famous"));
		System.out.println("Searching for " + chrome.srchQuery() + " in " + chrome.URL());
	}

}
