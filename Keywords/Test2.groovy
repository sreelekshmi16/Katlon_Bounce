import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import io.appium.java_client.android.AndroidDriver as AndroidDriver
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory as MobileDriverFactory
import io.appium.java_client.android.nativekey.AndroidKey as AndroidKey
import io.appium.java_client.android.nativekey.KeyEvent as KeyEvent
import io.appium.java_client.AppiumDriver as AppiumDriver
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import internal.GlobalVariable

public class Test2 {

	AppiumDriver<?> driver1 = MobileDriverFactory.getDriver()

	AndroidDriver<?> driver = MobileDriverFactory.getDriver()

	String otp;
	@Keyword
	public String getCountryCode(String countryName) {
		String countryCode="";
		try {
			if(countryName.equals("India")) {
				println ("test country name.......")
				countryCode = "91";
			}else if(countryName.equals("Kuwait")) {
				countryCode = "965";
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return countryCode;
	}

	@Keyword
	public String getOTP(String countryName, String number) {
		try {

			println ("test getOTp function.......")

			String countryCode = getCountryCode(countryName);

			//get authorization token
			String POST_PARAMS = "{\n" + "\"email\": \"superadmin@darisni.me\",\r\n"
			+ "    \"password\": \"Strongpassword1\",\r\n" + "    \"rememberMe\": \"false\",\r\n"
			+ "    \"force\": \"true\"" + "\n}";

			URL obj = new URL("https://sso-api.uat.nursery.darsini.com/v1/sso/login");
			HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
			postConnection.setRequestMethod("POST");
			postConnection.setRequestProperty("Content-Type", "application/json");
			postConnection.setDoOutput(true);
			OutputStream os = postConnection.getOutputStream();
			os.write(POST_PARAMS.getBytes());
			os.flush();
			os.close();
			int responseCode = postConnection.getResponseCode();

			String tokenvalue="";
			if (responseCode == 200) {
				BufferedReader Bin = new BufferedReader(new InputStreamReader(postConnection.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = Bin.readLine()) != null) {
					response.append(inputLine);
				}
				Bin.close();
				String token = response.toString();

				JSONObject json = new JSONObject(token);
				JSONObject data = json.getJSONObject("data");
				tokenvalue = data.getString("accessToken");
			} else {
				System.out.println("NOT WORKED");
			}

			//get otp using authorization token
			URL urlForGetRequest = new URL("https://sso-api.uat.nursery.darsini.com/v1/sso/otp-list?offset=0&limit=10&startDate=&endDate=&status=&phoneCode="+countryCode+"&phoneNumber="+number);
			String readLine = null;
			HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
			conection.setRequestMethod("GET");
			conection.setRequestProperty("Authorization", tokenvalue); // set userId its a sample here
			int responseCode1 = conection.getResponseCode();

			if (responseCode1 == HttpURLConnection.HTTP_OK) {

				BufferedReader Bin1 = new BufferedReader(new InputStreamReader(conection.getInputStream()));
				StringBuffer response1 = new StringBuffer();
				while ((readLine = Bin1 .readLine()) != null) {
					response1.append(readLine);
				}
				Bin1 .close();
				String json = response1.toString();

				JSONObject jsonObject = new JSONObject(json);
				JSONArray recs = jsonObject.getJSONArray("data");
				JSONObject rec = recs.getJSONObject(0);
				otp = rec.getString("otp");

			} else {
				System.out.println("NOT WORKED");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return otp;
	}


	@Keyword
	public void otp(String cName, String number) {

		println ("test otp function 111111111.......")


		char[] otp = (new Test2().getOTP("India", "1234567788").toCharArray())

		int[] array = new int[4];

		//int[]ab= {Character.getNumericValue(otp[0]), Character.getNumericValue(otp[1]), Character.getNumericValue(otp[2]), Character.getNumericValue(otp[3])};


		int[]ab1 ={Character.getNumericValue(otp[1])};

		array[0] =Character.getNumericValue(otp[0]);
		array[1] =Character.getNumericValue(otp[1]);
		array[2] =Character.getNumericValue(otp[2]);
		array[3] =Character.getNumericValue(otp[3]);
		println (array[1]);
		println (array[2]);
		println (array[3]);

		Mobile.tap(findTestObject('Object Repository/android.widget.ImageButton'), 0)

		Mobile.tap(findTestObject(''), 0)


		for(int i=0;i<4;i++) {
			if(array[i] == 0){
				driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_0));
			}else if(array[i] == 1) {
				driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_1));
			}else if(array[i] == 2) {
				driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_2))
			}else if(array[i] == 3) {
				driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_3))
			}else if(array[i] == 4) {
				driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_4))
			}else if(array[i] == 5) {
				driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_5))
			}else if(array[i] == 6) {
				driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_6))
			}else if(array[i] == 7) {
				driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_7))
			}else if(array[i] == 8) {
				driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_8))
			}else if(array[i] == 9) {
				driver.pressKey(new KeyEvent(AndroidKey.NUMPAD_9))
			}
		}

		driver.pressKey(new KeyEvent(AndroidKey.ENTER))

	}



}
