package com.persado.oss.quality.stevia.spring;

/*
 * #%L
 * Stevia QA Framework - Core
 * %%
 * Copyright (C) 2013 - 2014 Persado
 * %%
 * Copyright (c) Persado Intellectual Property Limited. All rights reserved.
 *  
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *  
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *  
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *  
 * * Neither the name of the Persado Intellectual Property Limited nor the names
 * of its contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *  
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.persado.oss.quality.stevia.selenium.core.Constants;
import com.persado.oss.quality.stevia.selenium.core.SteviaContext;
import com.persado.oss.quality.stevia.selenium.core.SteviaContextSupport;
import com.persado.oss.quality.stevia.selenium.core.WebController;
import com.persado.oss.quality.stevia.selenium.core.controllers.SteviaWebControllerFactory;
import com.persado.oss.quality.stevia.selenium.listeners.ConditionsListener;
import com.persado.oss.quality.stevia.selenium.listeners.ControllerMaskingListener;
import com.persado.oss.quality.stevia.selenium.listeners.TestListener;

/**
 * The base class that is responsible for initializing Stevia contexts on start and shutting down on
 * test ends. It is parallel-aware and has options to start RC server locally if needed via XML 
 * configuration parameters.
 */
@ContextConfiguration(locations = { "classpath:META-INF/spring/stevia-boot-context.xml" })
public class SteviaTestBase implements Constants {

    /**
     * suite-global output directory.
     */
    private static String suiteOutputDir;

	protected ApplicationContext applicationContext;

	/**
	 * Initialize driver.
	 * 
	 * @param params
	 * @throws Exception
	 */
	protected void initializeStevia(Map<String,String> params) throws Exception {
		if (applicationContext == null) {
			applicationContext = new ClassPathXmlApplicationContext("META-INF/spring/stevia-boot-context.xml");
		}

		SteviaContext.registerParameters(SteviaContextSupport.getParameters( params ));
		if (applicationContext == null) {
			throw new IllegalStateException("ApplicationContext not set - Stevia cannot continue"); 
		}
		SteviaContext.attachSpringContext(applicationContext);
		
		WebController controller = SteviaWebControllerFactory.getWebController(applicationContext);
		SteviaContext.setWebController(controller);
		
	}

    /**
     * Gets the suite output dir.
     *
     * @return the suite output dir
     */
    public static String getSuiteOutputDir() {
        return suiteOutputDir;
    }


    /**
     * Sets the suite output dir.
     *
     * @param suiteOutputDir the new suite output dir
     */
    public final static void setSuiteOutputDir(String suiteOutputDir) {
        SteviaTestBase.suiteOutputDir = suiteOutputDir;
    }

}
