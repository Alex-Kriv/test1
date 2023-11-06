package openApp

import TypeOS
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.IOSMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import screens.Onboarding
import java.util.concurrent.TimeUnit


object StartMainPage {

    fun getCapabilities(
        paramPlatformName: TypeOS, paramPlatformVersion: String,
        paramDeviceName: String, paramUDID: String,
        paramTimeToSearchElement: Long, paramPathToApp: String
    ) : DesiredCapabilities {
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

        return capabilities
    }

    fun startMainPage() {
        val onboarding = Onboarding
        try {

            onboarding.clickSelectRusButton()
            onboarding.clickNextButton()

            try { // не работает при типе локатора DEFAULT, lateinit property element has not been initialized

                onboarding.clickIosEnableNotificationWindow()
                onboarding.clickIosTrackYourActivityWindow()

            } catch (err: org.openqa.selenium.NoSuchElementException) {
                println("Тест запущен на андроиде, окно уведомлений пропущенно")
            }

            TimeUnit.SECONDS.sleep(5)
            onboarding.clickPickupButton()

        } catch (err: org.openqa.selenium.NoSuchElementException) {
            println("Поймана ошибка поиска одного из элементов при прохождении этапа открытия главного экрана приложения")
        }

        TimeUnit.SECONDS.sleep(5)
    }

}