package Tests.Example;

import Pages.Example.CreateNewCustomerAccount;
import Tests.TestBase;
import Utilities.TestModeller.TestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Utilities.TestModeller.UseTestModellerId;

//{{{ModelURL}}}
@Listeners(TestNGListener.class)
public class Registration_DefaultProfile extends TestBase
{
	
	
@Test  (groups= {"55c0bc54-18dd-4a89-8094-7ed8b2ec0b3a","Model","Model - Default Profile"})
@UseTestModellerId(testModellerGuid = "55c0bc54-18dd-4a89-8094-7ed8b2ec0b3a")
public void DefaultProfileGoToUrlPositiveFirstNamePositiveLastNamePositiveEmailPositivePasswordPositiveC1()
{
		
	CreateNewCustomerAccount _CreateNewCustomerAccount = new CreateNewCustomerAccount(driver);
		_CreateNewCustomerAccount.GoToUrl();


		_CreateNewCustomerAccount.Enter_First_Name("Jedidiah");

		_CreateNewCustomerAccount.Enter_Last_Name("Cormier");

		_CreateNewCustomerAccount.Enter_Email("james.walker@curiosity.software");

		_CreateNewCustomerAccount.Enter_Password("t9HZVNtOuL");

		_CreateNewCustomerAccount.Enter_Confirm_Password("8TYjhJ6A6W");

		_CreateNewCustomerAccount.Click_CreateAccount();

}


@Test  (groups= {"91d5c55a-5097-497d-bb2c-87746060e60f","Model","Model - Default Profile"})
@UseTestModellerId(testModellerGuid = "91d5c55a-5097-497d-bb2c-87746060e60f")
public void DefaultProfileGoToUrlPositiveFirstNamePositiveLastNamePositiveEmailPositivePasswordNegativeC2()
{
		
	CreateNewCustomerAccount _CreateNewCustomerAccount = new CreateNewCustomerAccount(driver);
		_CreateNewCustomerAccount.GoToUrl();


		_CreateNewCustomerAccount.Enter_First_Name("Garnet");

		_CreateNewCustomerAccount.Enter_Last_Name("Dach");

		_CreateNewCustomerAccount.Enter_Email("james.walker@curiosity.software");

		_CreateNewCustomerAccount.Enter_Password("dnAK0zcsn9");

		_CreateNewCustomerAccount.Enter_Confirm_Password("#!_ @");

		_CreateNewCustomerAccount.Click_CreateAccount();

}


@Test  (groups= {"4ba90d20-7aed-45ea-a001-7eb85391d8bd","Model","Model - Default Profile"})
@UseTestModellerId(testModellerGuid = "4ba90d20-7aed-45ea-a001-7eb85391d8bd")
public void DefaultProfileGoToUrlPositiveFirstNamePositiveLastNamePositiveEmailNegativePasswordPositiveC3()
{
		
	CreateNewCustomerAccount _CreateNewCustomerAccount = new CreateNewCustomerAccount(driver);
		_CreateNewCustomerAccount.GoToUrl();


		_CreateNewCustomerAccount.Enter_First_Name("Jaleel");

		_CreateNewCustomerAccount.Enter_Last_Name("Morar");

		_CreateNewCustomerAccount.Enter_Email("james.walker@curiosity.software");

		_CreateNewCustomerAccount.Enter_Password("#!_ @");

		_CreateNewCustomerAccount.Enter_Confirm_Password("nV68RwE1YN");

		_CreateNewCustomerAccount.Click_CreateAccount();

}


@Test  (groups= {"5fa93c7f-956c-45ea-b992-c6e8bff3de58","Model","Model - Default Profile"})
@UseTestModellerId(testModellerGuid = "5fa93c7f-956c-45ea-b992-c6e8bff3de58")
public void DefaultProfileGoToUrlPositiveFirstNamePositiveLastNameNegativeEmailPositivePasswordPositiveC4()
{
		
	CreateNewCustomerAccount _CreateNewCustomerAccount = new CreateNewCustomerAccount(driver);
		_CreateNewCustomerAccount.GoToUrl();


		_CreateNewCustomerAccount.Enter_First_Name("Michael");

		_CreateNewCustomerAccount.Enter_Last_Name("Kemmer");

		_CreateNewCustomerAccount.Enter_Email("asd#");

		_CreateNewCustomerAccount.Enter_Password("Erim9GMvL2");

		_CreateNewCustomerAccount.Enter_Confirm_Password("PLPnmVyPly");

		_CreateNewCustomerAccount.Click_CreateAccount();

}


@Test  (groups= {"87c642ad-5262-42af-a010-a8d15321cc75","Model","Model - Default Profile"})
@UseTestModellerId(testModellerGuid = "87c642ad-5262-42af-a010-a8d15321cc75")
public void DefaultProfileGoToUrlPositiveFirstNameNegativeLastNamePositiveEmailPositivePasswordPositiveC5()
{
		
	CreateNewCustomerAccount _CreateNewCustomerAccount = new CreateNewCustomerAccount(driver);
		_CreateNewCustomerAccount.GoToUrl();


		_CreateNewCustomerAccount.Enter_First_Name("Janis");

		_CreateNewCustomerAccount.Enter_Last_Name("");

		_CreateNewCustomerAccount.Enter_Email("james.walker@curiosity.software");

		_CreateNewCustomerAccount.Enter_Password("DTlILr7RiC");

		_CreateNewCustomerAccount.Enter_Confirm_Password("j32sa78Q3H");

		_CreateNewCustomerAccount.Click_CreateAccount();

}


@Test  (groups= {"099e6eaf-8f0a-4837-b3e6-1abaf200d365","Model","Model - Default Profile"})
@UseTestModellerId(testModellerGuid = "099e6eaf-8f0a-4837-b3e6-1abaf200d365")
public void DefaultProfileGoToUrlPositiveFirstNameNegativeLastNamePositiveEmailPositivePasswordPositiveC6()
{
		
	CreateNewCustomerAccount _CreateNewCustomerAccount = new CreateNewCustomerAccount(driver);
		_CreateNewCustomerAccount.GoToUrl();


		_CreateNewCustomerAccount.Enter_First_Name("Wade");

		_CreateNewCustomerAccount.Enter_Last_Name("#!_ @");

		_CreateNewCustomerAccount.Enter_Email("james.walker@curiosity.software");

		_CreateNewCustomerAccount.Enter_Password("N_E0fENx4b");

		_CreateNewCustomerAccount.Enter_Confirm_Password("lVU6ywW6dY");

		_CreateNewCustomerAccount.Click_CreateAccount();

}


@Test  (groups= {"de3cbbd1-4d5d-40e0-92b0-66ef3fad4a55","Model","Model - Default Profile"})
@UseTestModellerId(testModellerGuid = "de3cbbd1-4d5d-40e0-92b0-66ef3fad4a55")
public void DefaultProfileGoToUrlNegativeFirstNamePositiveLastNamePositiveEmailPositivePasswordPositiveC7()
{
		
	CreateNewCustomerAccount _CreateNewCustomerAccount = new CreateNewCustomerAccount(driver);
		_CreateNewCustomerAccount.GoToUrl();


		_CreateNewCustomerAccount.Enter_First_Name("");

		_CreateNewCustomerAccount.Enter_Last_Name("Hoeger");

		_CreateNewCustomerAccount.Enter_Email("james.walker@curiosity.software");

		_CreateNewCustomerAccount.Enter_Password("29mNkWsLBb");

		_CreateNewCustomerAccount.Enter_Confirm_Password("hzpedqPoyC");

		_CreateNewCustomerAccount.Click_CreateAccount();

}


@Test  (groups= {"63cfd23a-6144-4041-98a1-a7633cc6a9af","Model","Model - Default Profile"})
@UseTestModellerId(testModellerGuid = "63cfd23a-6144-4041-98a1-a7633cc6a9af")
public void DefaultProfileGoToUrlNegativeFirstNamePositiveLastNamePositiveEmailPositivePasswordPositiveC8()
{
		
	CreateNewCustomerAccount _CreateNewCustomerAccount = new CreateNewCustomerAccount(driver);
		_CreateNewCustomerAccount.GoToUrl();


		_CreateNewCustomerAccount.Enter_First_Name("#!_ @");

		_CreateNewCustomerAccount.Enter_Last_Name("Weissnat");

		_CreateNewCustomerAccount.Enter_Email("james.walker@curiosity.software");

		_CreateNewCustomerAccount.Enter_Password("MEyul9beXL");

		_CreateNewCustomerAccount.Enter_Confirm_Password("SrlSYNCd45");

		_CreateNewCustomerAccount.Click_CreateAccount();

}


}
