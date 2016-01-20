package com.persado.oss.quality.stevia.selenium.core.controllers.factories;

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

import com.persado.oss.quality.stevia.selenium.core.SteviaContext;
import com.persado.oss.quality.stevia.selenium.core.WebController;
import com.persado.oss.quality.stevia.selenium.core.controllers.AppiumWebController;
import com.persado.oss.quality.stevia.selenium.core.controllers.SteviaWebControllerFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumWebControllerFactoryImpl implements WebControllerFactory {
    private static final Logger LOG = LoggerFactory.getLogger(AppiumWebControllerFactoryImpl.class);

    @Override
    public WebController initialize(ApplicationContext context, WebController controller) {
        AppiumWebController appiumController = (AppiumWebController) controller;
        AppiumDriver driver = null;

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, SteviaContext.getParam(SteviaWebControllerFactory.MOBILE_PLATFORM_NAME));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, SteviaContext.getParam(SteviaWebControllerFactory.MOBILE_PLATFORM_VERSION));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, SteviaContext.getParam(SteviaWebControllerFactory.MOBILE_DEVICE_NAME));
        if (!StringUtils.isEmpty(SteviaContext.getParam(SteviaWebControllerFactory.BROWSER))) {
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, SteviaContext.getParam(SteviaWebControllerFactory.BROWSER));
        }
        if (!StringUtils.isEmpty(SteviaContext.getParam(SteviaWebControllerFactory.MOBILE_APP))) {
            capabilities.setCapability(MobileCapabilityType.APP, SteviaContext.getParam(SteviaWebControllerFactory.MOBILE_APP));
        }
        if (!StringUtils.isEmpty(SteviaContext.getParam(SteviaWebControllerFactory.MOBILE_APP_PACKAGE))) {
            capabilities.setCapability(MobileCapabilityType.APP_PACKAGE, SteviaContext.getParam(SteviaWebControllerFactory.MOBILE_APP_PACKAGE));
        }
        if (!StringUtils.isEmpty(SteviaContext.getParam(SteviaWebControllerFactory.MOBILE_APP_ACTIVITY))) {
            capabilities.setCapability(MobileCapabilityType.APP_ACTIVITY, SteviaContext.getParam(SteviaWebControllerFactory.MOBILE_APP_ACTIVITY));
        }
        if (!StringUtils.isEmpty(SteviaContext.getParam(SteviaWebControllerFactory.AUTO_WEB_VIEW))) {
            capabilities.setCapability(SteviaWebControllerFactory.AUTO_WEB_VIEW, SteviaContext.getParam(SteviaWebControllerFactory.AUTO_WEB_VIEW));
        }

        if (SteviaContext.getParam(SteviaWebControllerFactory.MOBILE_PLATFORM_NAME).compareTo("Android") == 0) {
            try {
                driver = new AndroidDriver(new URL("http://" + SteviaContext.getParam(SteviaWebControllerFactory.RC_HOST) + ":" + SteviaContext.getParam(SteviaWebControllerFactory.RC_PORT) + "/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            }
        }

        if (SteviaContext.getParam(SteviaWebControllerFactory.MOBILE_PLATFORM_NAME).compareTo("iOS") == 0) {
            try {
                driver = new IOSDriver(new URL("http://" + SteviaContext.getParam(SteviaWebControllerFactory.RC_HOST) + ":" + SteviaContext.getParam(SteviaWebControllerFactory.RC_PORT) + "/wd/hub"), capabilities);
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException(e.getMessage(), e);
            }
        }
        driver.setFileDetector(new LocalFileDetector());

        if (!StringUtils.isEmpty(SteviaContext.getParam(SteviaWebControllerFactory.TARGET_HOST_URL))) {
            driver.get(SteviaContext.getParam(SteviaWebControllerFactory.TARGET_HOST_URL));
        }
        appiumController.setDriver(driver);
        return appiumController;
    }

    @Override
    public String getBeanName() {
        return "appiumController";
    }


}