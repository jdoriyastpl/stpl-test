package com.sarvika.automation;

import java.io.File;
import java.util.Hashtable;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.sarvika.automation.exceptions.AutomationException;
import com.sarvika.automation.store.pages.StoreLandingPage;
import com.sarvika.automation.test.TestBase;
import com.sarvika.automation.utils.XMLReader;

public class StoreTestBase extends TestBase {

	private static final Logger LOG = Logger.getLogger(StoreTestBase.class
			.getSimpleName());
//	@Autowired
//	protected StoreLandingPage  storeLandingPage;
	
	public XMLReader xml;

	public XMLReader getDataModel() throws AutomationException {
		final File file = new File(ClassLoader.getSystemResource(
				"test-data/store_data.xml").getFile());
		if (file.exists()) {
			return new XMLReader(file);
		} else {
			throw new AutomationException(String.format(
					"Could not find file in the path %s", file));
		}
	}

	/**
	 * Get SS2 Prod Store Urls
	 * 
	 * @return
	 * @throws AutomationException
	 */
	public Hashtable<String, String> getStoreUri() throws AutomationException {
		xml = getDataModel();
		return xml.getDataAsList("SS2_Prod_Stores").get(0);
	}
}
