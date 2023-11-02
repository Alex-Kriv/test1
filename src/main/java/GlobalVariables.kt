import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver

object GlobalVariables {

    lateinit var platformType: TypeOS
    lateinit var androidDriver: AndroidDriver
    lateinit var iosDriver: IOSDriver
}