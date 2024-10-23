package TestPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import UtilityFunction.CommonFuntion;

public class MMBItineraryPage {

	private static MMBItineraryPage mmbitineraryPage;

	private MMBItineraryPage() {
		// TODO Auto-generated constructor stub
	}

	public static MMBItineraryPage getItineraryPage() {
		if (mmbitineraryPage == null) {
			mmbitineraryPage = new MMBItineraryPage();
		}
		return mmbitineraryPage;
	}

	@FindBy(xpath = "//input[@id='bodycontent_chkConfirm']")
	public static WebElement checkbox;

	@FindBy(xpath = "//input[@id='bodycontent_btnConfirm']")
	public static WebElement confirmbutton;

	public void getcheckbox() {

		checkbox.click();
	}

	public void getconfirmbutton() {
		confirmbutton.click();
	}

}
