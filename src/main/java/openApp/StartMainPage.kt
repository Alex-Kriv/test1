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
    ) {
        val capabilities = DesiredCapabilities()

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, paramPlatformName)
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, paramPlatformVersion)
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, paramDeviceName)
        capabilities.setCapability(MobileCapabilityType.APP, paramPathToApp)
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true)

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

        platformType = paramPlatformName

        if (paramPlatformName == TypeOS.IOS) {
            iosDriver = IOSDriver(url, capabilities)
            iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(paramTimeToSearchElement))
        } else {
            androidDriver = AndroidDriver(url, capabilities)
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(paramTimeToSearchElement))
        }

    }
    fun startMainPage() {
        try {

            clickToElement(
                locatorAndroid =  selectRusButton.androidAccessibilityId,
                locatorTypeAndroid =  LocatorType.ACCESSIBILITY_ID,
                locatorIOS = selectRusButton.iosAccessibilityId,
                locatorTypeIOS =  LocatorType.ACCESSIBILITY_ID,
            ) //выбор кнопки рус

            clickToElement(
                locatorAndroid = nextButton.androidAccessibilityId,
                locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                locatorTypeIOS = LocatorType.ACCESSIBILITY_ID,
                locatorIOS = nextButton.iosAccessibilityId
            )

            try { // не работает при типе локатора DEFAULT, lateinit property element has not been initialized
                clickToElement(
                    locatorAndroid = "1",
                    locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                    locatorIOS = iosEnableNotificationWindow.iosAccessibilityId,
                    locatorTypeIOS = LocatorType.ACCESSIBILITY_ID
                )
                clickToElement(
                    locatorAndroid = "1",
                    locatorTypeAndroid = LocatorType.ACCESSIBILITY_ID,
                    locatorIOS = iosTrackYourActivityWindow.iosAccessibilityId,
                    locatorTypeIOS = LocatorType.ACCESSIBILITY_ID
                )
            } catch (err: org.openqa.selenium.NoSuchElementException) {
                println("Тест запущен на андроиде, окно уведомлений пропущенно")
            }

            // clickToElement(locator = "Далее", locatorType = LocatorType.ACCESSIBILITY_ID) // то же что и выше, только для андроида

            TimeUnit.SECONDS.sleep(5)

            clickToElement(
                pickupButton.androidAccessibilityId,
                LocatorType.ACCESSIBILITY_ID,
                pickupButton.iosAccessibilityId,
                LocatorType.ACCESSIBILITY_ID
            ) // нажать на кноку самовывоз

        } catch (err: org.openqa.selenium.NoSuchElementException) {
            println("Поймана ошибка поиска одного из элементов при прохождении этапа открытия главного экрана приложения")
        }

        TimeUnit.SECONDS.sleep(5)
    }

}