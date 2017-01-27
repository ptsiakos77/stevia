package com.persado.oss.quality.stevia.selenium.core;

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

public interface Constants {

	/** The Constant FIREFOX. */
	public static final String FIREFOX = "*firefox";
	
	/** The Constant CHROME. */
	public static final String CHROME = "*googlechrome";
	
	/** The Constant IEXPLORER. */
	public static final String IEXPLORER = "*iexplore";
	
	/** The Constant SAFARI. */
	public static final String SAFARI = "*safari";
	
	/** The Constant OPERA. */
	public static final String OPERA = "*opera";
	
	/** The parameter that determines the browser type. */
	public static final String BROWSER = "browser";
	
	/** The parameter that determines the Selenium RC host. */
	public static final String RC_HOST = "rcHost";
	
	/** The parameter that determines the Selenium RC port. */
	public static final String RC_PORT = "rcPort";
	
	/** The parameter that determines the application URL. */
	public static final String TARGET_HOST_URL = "targetHostUrl";
	
	/** The parameter that determines the driver type (WebDriver or Selenium RC). */
	public static final String DRIVER_TYPE = "driverType";
	
	/** The parameter that determines the test mode. */
	public static final String DEBUGGING = "debugging";
	
	/** The parameter that determines if actions will be logged in TestNG report. */
	public static final String ACTIONS_LOGGING = "actionsLogging";
	
	/** The parameter that determines the browser profile. */
	public static final String PROFILE = "profile";
	
	public static final String WRONG_BROWSER_PARAMETER = "Wrong value for 'browser' parameter was defined";
	
	public static final String TRUE = "true";

	/** The parameter that determines the mobile platform IOS or Android **/
	public static final String MOBILE_PLATFORM_NAME = "mobilePlatformName";

	/** The parameter that determines the mobile platfor version **/
	public static final String MOBILE_PLATFORM_VERSION = "mobilePlatformVersion";

	/** The parameter that determined the mobile device name **/
	public static final String MOBILE_DEVICE_NAME = "mobileDeviceName";

	/** The parameter that determines the path to mobile application **/
	public static final String MOBILE_APP = "mobileApp";

	/** The parameter that determines the mobile application package **/
	public static final String MOBILE_APP_PACKAGE = "mobileAppPackage";

	/** The parameter that determined the mobile application activity **/
	public static final String MOBILE_APP_ACTIVITY = "mobileAppActivity";

	/** The parameter that determined the mobile application activity **/
	public static final String MOBILE_APP_WAIT_ACTIVITY = "mobileAppWaitActivity";

	/** The parameter that determined the auto web view activity **/
	public static final String AUTO_WEB_VIEW = "autoWebview";

	/** The parameter that determined the mobile device UUID **/
	public static final String MOBILE_DEVICE_UUID = "mobileDeviceUUID";

	/** The parameter that determined the mobile automation name **/
	public static final String MOBILE_AUTOMATION_NAME = "automationName";

	/** The parameter that determined the new command timeout **/
	public static final String NEW_COMMAND_TIMEOUT = "newCommandTimeout";

	/** The parameter that determined the real device logger **/
	public static final String REAL_DEVICE_LOGGER = "realDeviceLogger";

	/** The parameter that determined the new config file for WebDriverAgent **/
	public static final String XCODE_CONFIG_FILE = "xcodeConfigFile";

	/** The parameter that determined if prebuilt WebDriverAgent will be used **/
	public static final String USE_PREBUILT_WDA = "usePrebuiltWDA";

	/** The WebDriverAgent local port **/
	public static final String WDA_LOCAL_PORT = "wdaLocalPort";

	/** The adb local port **/
	public static final String ADB_PORT = "adbPort";

	/** The uiautomator 2 local port **/
	public static final String UIAUTOMATOR2_PORT = "systemPort";

}
