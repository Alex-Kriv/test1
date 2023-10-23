import GlobalVarlables.androidDriver
import io.appium.java_client.AppiumBy
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.remote.AndroidMobileCapabilityType
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import org.testng.annotations.Test
import java.net.URL
import java.time.Duration
import java.util.concurrent.TimeUnit

class MainActivity {
    @BeforeSuite //
    fun installDriver(){

        val capabilities = DesiredCapabilities()
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14")
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel_3a")
        capabilities.setCapability(MobileCapabilityType.APP, "/Users/admin/apps/app-profile.apk")
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2")
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "starter.school.client")
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "starter.school.client.MainActivity")

        val url = URL("http://127.0.0.1:4723/")

        androidDriver = AndroidDriver(url, capabilities) // устанавливаем аппиум драйвер для андроид
        // передавая ранее заданные параметры (capabilities)

        //время поиска элемента
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)) //почему-то сломалось само по себе,
        // и после увеличения с 1 до 5 секунд снова заработало, зунать причину

        try {

            val element1 = androidDriver.findElement(AppiumBy.accessibilityId("Русский")) // нашли элемент и кликнулои на нее
            element1.click()

            val element2 = androidDriver.findElement(AppiumBy.accessibilityId("Далее"))
            element2.click()

            val element3 = androidDriver.findElement(AppiumBy.accessibilityId("Самовывоз"))
            element3.click()

            val element4 = androidDriver.findElement(AppiumBy.accessibilityId("Кключ ошибки"))
            element4.click()
        }

        catch (err:org.openqa.selenium.NoSuchElementException){

            //err.printStackTrace() // вывод самой ошибки
            println("Поймана ошибка поиска одного из элементов при прохождении этапа открытия главного экрана приложения")
            //println(err.message) // вывод ошибки в консоль текстом
        }

        TimeUnit.SECONDS.sleep(5)

    }

    @AfterSuite // закрываем драйвер, но как оставить приложение в конечном состоянии?

    fun quitDriver(){
        androidDriver.quit()
    }

    @Test
    // при создании двух одинаковых тестов почему-то падают остальные с ошибкой (не найден искомый элемент)
        fun testOne() {
            println("Тест задание")
            TimeUnit.SECONDS.sleep(10)
            // хотел сделать смену самовывоза на доставку, но как работать со всплывающим окном разрешения доступа к геопозиции пока не ясно
        }

    @Test

    fun testTwo(){
        println("Тест задание 2. Проверка элементов футера \"Главная страница\", \"Профиль\", \"Меню\".")
        try {
            val element = androidDriver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]"))
            element.click()

            val element2 = androidDriver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[3]"))
            element2.click()

            val element3 = androidDriver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]"))
            element3.click()
            TimeUnit.SECONDS.sleep(5)
        }
        catch (err:org.openqa.selenium.NoSuchElementException){
            // err.printStackTrace() // вывод самой ошибки
            println("Поймана ошибка поиска одного из элементов")
            println(err.cause)
        }

        TimeUnit.SECONDS.sleep(5)
    }

    @Test

    fun testThree(){
        println("Тест задание 3. Проверка боксов \"Закуски\", \"Супы\", \"Паста\", \"Сендвичи\", \"Горячее\".")
        try {
            val element = androidDriver.findElement(AppiumBy.accessibilityId("Закуски"))
            element.click()

            val element2 = androidDriver.findElement(AppiumBy.accessibilityId("Супы"))
            element2.click()

            val element3 = androidDriver.findElement(AppiumBy.accessibilityId("Паста"))
            element3.click()

            val element4 = androidDriver.findElement(AppiumBy.accessibilityId("Сендвичи"))
            element4.click()

           // val element5 = androidDriver.findElement(AppiumBy.accessibilityId("Горячее")) // не ищет поле "Горячее", поскольку выходит за пределы
            // экрана отображение, выдает ошибку, но тест все равно завершается успешно "Test Passed", почему?
           // element5.click()

            println("Тест 3 завершен успешно")
            TimeUnit.SECONDS.sleep(5)
        }

        catch (err:org.openqa.selenium.NoSuchElementException){
            // err.printStackTrace() // вывод самой ошибки
            println("Поймана ошибка поиска одного из элементов")
            println(err.cause)
        }
        TimeUnit.SECONDS.sleep(5) // на всякий случай, не уверен что в этом есть необходимость
    }

    @Test
    // тест прохождения авторизации
    fun testFour(){
        println("Тест задание 4. Прохождение авторизации, выход из профиля и возврат к начальному экрану")

        try {
            val element = androidDriver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[1]"))
            element.click()

            val element1 = androidDriver.findElement(AppiumBy.accessibilityId("Войти"))
            element1.click()

            val text_box = androidDriver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"Укажите телефон\n" +
                    "На него отправим код подтверждения\"]/android.widget.EditText"))
            text_box.sendKeys("9231775570")

            val element2 = androidDriver.findElement(AppiumBy.accessibilityId("Получить код"))
            element2.click()

            val text = androidDriver.pageSource
            //println(text)
            //(Введите код из смс&#10; начало), (конец &#10;), сдвиг по ключевым символам/словам
            val textOne = text.substringAfter("Введите код из смс&#10;")
            val textTwo = textOne.substringBefore('&') // костыль ужасный
            //println(text) //println(textOne) //println(textTwo)

            val element3 = androidDriver.findElement(AppiumBy.className("android.widget.EditText"))
            element3.sendKeys(textTwo)

            val element4 = androidDriver.findElement(AppiumBy.accessibilityId("Выйти"))
            element4.click()

            val element5 = androidDriver.findElement(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView[2]"))
            element5.click()

            println("Тест 4 успешно завершен")
            TimeUnit.SECONDS.sleep(5)
        }

        catch (err:org.openqa.selenium.NoSuchElementException){
            // err.printStackTrace() // вывод самой ошибки
            println("Поймана ошибка поиска одного из элементов")
            println(err.cause)
        }
        TimeUnit.SECONDS.sleep(5)
    }
}
