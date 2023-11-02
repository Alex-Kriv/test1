package openApp

import GlobalVariables.androidDriver
import GlobalVariables.iosDriver
import GlobalVariables.platformType
import TestFunctions.clickToElement
import TypeOS
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.IOSMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import screens.Onboarding
import screens.Onboarding.errorCheckButton
import screens.Onboarding.iosEnableNotificationWindow
import screens.Onboarding.iosTrackYourActivityWindow
import screens.Onboarding.nextButton
import screens.Onboarding.pickupButton
import screens.Onboarding.selectRusButton
import java.net.URL
import java.time.Duration
import java.util.concurrent.TimeUnit


object StartMainPage {

    fun installDriverOne(
        paramPlatformName: TypeOS, paramPlatformVersion: String,
        paramDeviceName: String, paramUDID: String,
        paramTimeToSearchElement: Long, paramPathToApp: String
    ) : Pair<DesiredCapabilities, URL> {
        val capabilities = DesiredCapabilities()

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, paramPlatformName)
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, paramPlatformVersion)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, paramDeviceName)
        capabilities.setCapability(MobileCapabilityType.APP, paramPathToApp)
        //capabilities.setCapability(MobileCapabilityType.NO_RESET, true)

        if (paramPlatformName == TypeOS.ANDROID) {
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2")
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "starter.school.client")
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "starter.school.client.MainActivity")

        } else {
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest")
            capabilities.setCapability(IOSMobileCapabilityType.COMMAND_TIMEOUTS, 50000) //
            capabilities.setCapability(IOSMobileCapabilityType.WDA_LAUNCH_TIMEOUT, 80000) // за что отвечат эти значения
        }

        val url = URL("http://127.0.0.1:4723/")

        return Pair(capabilities, url)

    }


}