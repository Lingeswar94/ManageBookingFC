package TestPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageBookingPage {

	private static ManageBookingPage manageBookingPage;

	private ManageBookingPage() {

	}

	public static ManageBookingPage getManageBookingPage() {
		if (manageBookingPage == null) {
			manageBookingPage = new ManageBookingPage();
		}
		return manageBookingPage;
	}

	@FindBy(xpath = "//input[@id='txtPNR']")
	public static WebElement bookingPNR;

	@FindBy(xpath = "//input[@id='txtFirstName']")
	public static WebElement FirstName;

	@FindBy(xpath = "//input[@id='txtLastName']")
	public static WebElement LastName;

	@FindBy(xpath = "//input[@id='btnRetreiveDetails']")
	public static WebElement RetreiveDetails;

	public void BookingPNR(String PNR) {
		bookingPNR.sendKeys(PNR);
	}

	public void Firstname(String firstname) {
		FirstName.sendKeys(firstname);
	}

	public void Lastname(String lastname) {
		LastName.sendKeys(lastname);
	}

	public void RetreiveDetailscontinue() {
		RetreiveDetails.click();
	}
}
