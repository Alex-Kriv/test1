import GlobalVariables.androidDriver
import GlobalVariables.platformType
import GlobalVariables.iosDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import openApp.StartMainPage.getCapabilities
import openApp.StartMainPage.startMainPage
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
        val capabilities = getCapabilities(
            paramPlatformName, paramPlatformVersion,
            paramDeviceName, paramUDID,
            paramTimeToSearchElement, paramPathToApp
        )

        val url = URL("http://127.0.0.1:4723/")

        platformType = paramPlatformName

        if (paramPlatformName == TypeOS.IOS) {
            iosDriver = IOSDriver(url, capabilities)
            iosDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(paramTimeToSearchElement))
        } else {
            androidDriver = AndroidDriver(url, capabilities)
            androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(paramTimeToSearchElement))
        }

        startMainPage()

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