package Tests.Intelligent;

import Pages.Intelligent.LoginPage;
import Tests.TestBase;
import Utilities.TestModeller.TestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Utilities.TestModeller.UseTestModellerId;

//{{{ModelURL}}}
@Listeners(TestNGListener.class)
public class Login_DefaultProfile extends TestBase
{
	
	
@Test  (groups= {"6b886fd8-922d-429f-a7ea-5b882baabdb3","Login","Login - Default Profile"})
@UseTestModellerId(testModellerGuid = "6b886fd8-922d-429f-a7ea-5b882baabdb3")
public void DefaultProfileGoToUrlPositiveEnterunamePositiveEnterpswClickLogin1()
{
		
	LoginPage _LoginPage = new LoginPage(driver);
		_LoginPage.GoToUrl();


		_LoginPage.Enter_uname("eaque");

		_LoginPage.Enter_psw("yRHh0N8pQG");

		_LoginPage.Click_Login();

}


@Test  (groups= {"3017de0d-4812-4d60-a19a-5824f64dfc89","Login","Login - Default Profile"})
@UseTestModellerId(testModellerGuid = "3017de0d-4812-4d60-a19a-5824f64dfc89")
public void DefaultProfileGoToUrlPositiveEnterunameNegativeEnterpswClickLogin2()
{
		
	LoginPage _LoginPage = new LoginPage(driver);
		_LoginPage.GoToUrl();


		_LoginPage.Enter_uname("quia");

		_LoginPage.Enter_psw("#!_ @");

		_LoginPage.Click_Login();

}


@Test  (groups= {"b3707097-1f12-470e-9189-8ee4237796b6","Login","Login - Default Profile"})
@UseTestModellerId(testModellerGuid = "b3707097-1f12-470e-9189-8ee4237796b6")
public void DefaultProfileGoToUrlNegativeEnterunamePositiveEnterpswClickLogin3()
{
		
	LoginPage _LoginPage = new LoginPage(driver);
		_LoginPage.GoToUrl();


		_LoginPage.Enter_uname("389348");

		_LoginPage.Enter_psw("oGUlQCLN6Y");

		_LoginPage.Click_Login();

}


}
