import GlobalVariables.androidDriver
import GlobalVariables.platformType
import GlobalVariables.iosDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.IOSMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import openApp.StartMainPage.startMainPage
import openApp.StartMainPage.installDriverOne
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.*
import org.testng.annotations.AfterClass
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeClass
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Parameters
import java.net.URL
import java.time.Duration
import java.util.concurrent.TimeUnit

open class MainActivity {
    @BeforeSuite //
    @Parameters(
        value = ["paramPlatformName", "paramPlatformVersion", "paramDeviceName",
            "paramUDID", "paramTimeToSearchElement", "paramPathToApp"]
    )

    fun installDriver(
        paramPlatformName: TypeOS, paramPlatformVersion: String,
        paramDeviceName: String, paramUDID: String,
        paramTimeToSearchElement: Long, paramPathToApp: String
    ) {
        // ну это как-то ужасно выглядит, уточнить как лучше сделать
        installDriverOne(
            paramPlatformName, paramPlatformVersion,
            paramDeviceName, paramUDID,
            paramTimeToSearchElement, paramPathToApp
        )

        startMainPage()

        // данная конструкция для того чтобы каждый раз открывалось приложение заново, временный костыль для дебагинга
       // if (paramPlatformName == TypeOS.ANDROID) {androidDriver.terminateApp(BUNDLE_ID)} else iosDriver.terminateApp(
            //BUNDLE_ID)
    }

    @AfterSuite // закрываем драйвер, но как оставить приложение в конечном состоянии?

    fun quitDriver() {
        if (platformType == TypeOS.ANDROID ) {androidDriver.quit()} else iosDriver.quit()
    }

    @BeforeClass
    fun beforeClass(){

    }

    @AfterClass
    fun afterClass(){

    }

    @BeforeMethod
    fun launceApp(){
        if (platformType == TypeOS.ANDROID ) {androidDriver.activateApp(BUNDLE_ID)} else {
            iosDriver.activateApp(BUNDLE_ID)
        }
        TimeUnit.SECONDS.sleep(5)
    }

    @AfterMethod
    fun closeApp() {
        if (platformType == TypeOS.ANDROID) {androidDriver.terminateApp(BUNDLE_ID)} else iosDriver.terminateApp(
            BUNDLE_ID)
        TimeUnit.SECONDS.sleep(5)
    }

    companion object{
        const val BUNDLE_ID = "starter.school.client"
    }
}