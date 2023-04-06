import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.Keys as Keys
import io.appium.java_client.android.AndroidDriver as AndroidDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.android.nativekey.AndroidKey as AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent as KeyEvent
import io.appium.java_client.AppiumDriver as AppiumDriver

Mobile.startApplication('C:\\Users\\sreelekshmi.gs\\Downloads\\bounce-staging-release (18).apk', true)

AppiumDriver<?> driver1 = MobileDriverFactory.getDriver()

AndroidDriver<?> driver = MobileDriverFactory.getDriver()

Mobile.tap(findTestObject('Object Repository/android.widget.TextView'), 0)

Mobile.sendKeys(findTestObject('Object Repository/android.widget.EditText - Search country'), 'India')

Mobile.tap(findTestObject('Object Repository/android.view.ViewGroup'), 0)

Mobile.sendKeys(findTestObject('Object Repository/android.widget.EditText - Enter your mobile number (1)'), '1234567788')

//Mobile.tap(findTestObject(''), 0)

//Mobile.tap(findTestObject(''), 0)

Mobile.tap(findTestObject('Object Repository/android.view.ViewGroup (3)'), 0)

Mobile.tap(findTestObject('Object Repository/android.widget.TextView (2)'), 0)
driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_0))

driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_1))

driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_2))

driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_3))

driver.pressKey(new KeyEvent(AndroidKey.ENTER))

Mobile.tap(findTestObject('Object Repository/android.widget.ImageButton (1)'), 0)
Mobile.closeApplication()




