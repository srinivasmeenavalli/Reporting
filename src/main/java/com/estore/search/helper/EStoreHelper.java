package com.estore.search.helper;

import java.io.InputStream;
import java.util.Properties;


import org.springframework.core.io.ClassPathResource;

import com.estore.search.constants.EStoreConstants;

/****
 * 
 * @author Your First Name, Surname {eclipse.ini}
 * 
 *         Helper class used r
 * 
 * ****/
public class EStoreHelper {



	/**
	 * 
	 * This method is reads host url from properties file
	 * 
	 * @return String
	 * 
	 * */
	public static String getCameraStoreHost() {

		System.out.println("#Enter EStoreHelper.getCameraStoreHost ");
		ClassPathResource classPathResource = new ClassPathResource(EStoreConstants.ESTORE_PROPERTIES);
		Properties prop = new Properties();
		String hostURL = "";
		try {
			InputStream inputStream = classPathResource.getInputStream();
			prop.load(inputStream);
			hostURL = prop.getProperty(EStoreConstants.ESTORE_HOST_URL);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		System.out.println("#Return/Exit EStoreHelper.getCameraStoreHost ");
		return hostURL;
	}

}
