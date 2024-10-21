package TestPage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MMBFlow {

	private static MMBFlow mmbFlow;

	private MMBFlow() {

	}

	public static MMBFlow getmmbFlow() {
		if (mmbFlow == null) {
			mmbFlow = new MMBFlow();
		}
		return mmbFlow;
	}

	@FindBy(xpath = "//div[@id='bodycontent_divAERBookingActions']/input")
	public static List<WebElement> bookingactionitems;

	public void BookinActions(String Flowname) {

		int size = bookingactionitems.size();

		for (int i = 0; i <= size; i++) {
			String AEBookingname = bookingactionitems.get(i).getAttribute("value");
			if (Flowname.equalsIgnoreCase(AEBookingname)) {
				bookingactionitems.get(i).click();
				return;
			}
			
		}
	}
}
