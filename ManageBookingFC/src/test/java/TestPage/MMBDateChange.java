package TestPage;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Testcase.MMBChangeDateSelectionmethod;
import UtilityFunction.CommonFuntion;

public class MMBDateChange {

	private static MMBDateChange mmbdatechange;
	Logger logger=Logger.getLogger(MMBDateChange.class);
	private MMBDateChange() {

	}

	public static MMBDateChange getmmbdatechange() {
		if (mmbdatechange == null) {
			mmbdatechange = new MMBDateChange();
		}
		return mmbdatechange;
	}

	@FindBy(xpath = "//div[@id='bodycontent_divAERBookingActions']/input")
	public static List<WebElement> bookingactionitems;

	@FindBy(xpath = "//div[@id='bodycontent_RGFlightDetails_pnlSelectFlightCtrl_0']")
	public static WebElement ChangeflightOutboundsegment;
	@FindBy(xpath = "//div[@id='bodycontent_RGFlightDetails_pnlSelectFlightCtrl_1']")
	public static WebElement Changeflightinboundsegment;

	@FindBy(xpath = "//input[@id='bodycontent_btnContinue']")
	public static WebElement mmbchange_btnContinue;

	// Method to select flight segments based on index
	public void Changeflightsegment(int index) {
		String Segment = "//div[@id='bodycontent_RGFlightDetails_pnlSelectFlightCtrl_" + index + "']";
		CommonFuntion.getDriver().findElement(By.xpath(Segment)).click();
	}

	// Main method to handle booking actions and select a segment
	public void BookingActions(String Flowname) {
		try {
			// Avoid index out-of-bound by using < instead of <=
			int size = bookingactionitems.size();
			for (int i = 0; i < size; i++) {
				String AEBookingname = bookingactionitems.get(i).getAttribute("value");
				if (Flowname.equalsIgnoreCase(AEBookingname)) {
					bookingactionitems.get(i).click();
					// After clicking, exit the loop
					return;
				}
			}
			// Call the method to handle the flow after clicking
			// name( index, Month, date);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Refactored method for flight change actions
	public void getsegmentselection(String indexs, String Month, String date, String OuttargetYear, String reMonth,
			String redate, String IntargetYear) {
		int index = Integer.parseInt(indexs);

		if (index == 0) {
			ChangeflightOutboundsegment.click();
			OutboundselectDate(Month, date, OuttargetYear);
		}

		else if (index == 1) {
			Changeflightinboundsegment.click();
			InboundselectDate(reMonth, redate, IntargetYear);
		} else if (index == 2) {
			ChangeflightOutboundsegment.click();
			OutboundselectDate(Month, date, OuttargetYear);

			Changeflightinboundsegment.click();
			InboundselectDate(reMonth, redate, IntargetYear);
		}
	}

	// Utility method to convert month name to a number (e.g., "January" -> 1,
	// "February" -> 2, etc.)
	private int monthStringToNumber(String month) {
		switch (month.toLowerCase()) {
		case "january":
			return 1;
		case "february":
			return 2;
		case "march":
			return 3;
		case "april":
			return 4;
		case "may":
			return 5;
		case "june":
			return 6;
		case "july":
			return 7;
		case "august":
			return 8;
		case "september":
			return 9;
		case "october":
			return 10;
		case "november":
			return 11;
		case "december":
			return 12;
		default:
			throw new IllegalArgumentException("Invalid month: " + month);
		}
	}

	// Method to determine if you should navigate forward or backward in the date
	// picker
	private boolean shouldNavigateForward(String currentMonth, String currentYear, String targetMonth,
			String targetYear) {
		int currentMonthNumber = monthStringToNumber(currentMonth);
		int targetMonthNumber = monthStringToNumber(targetMonth);

		// Convert year to integers
		int currentYearNumber = Integer.parseInt(currentYear);
		int targetYearNumber = Integer.parseInt(targetYear);

		// If the target year is greater, navigate forward
		if (targetYearNumber > currentYearNumber) {
			return true; // Move forward
		}

		// If the target year is the same, compare the months
		if (targetYearNumber == currentYearNumber && targetMonthNumber > currentMonthNumber) {
			return true; // Move forward
		}

		return false;
	}

	// Refactored method for date selection
	private void OutboundselectDate(String targetMonth, String targetDate, String targetYear) {
		try {
			// Open the date picker
			CommonFuntion.getDriver()
					.findElement(By.xpath("//input[@id='bodycontent_RGFlightDetails_dtpFlightDate_0']")).click();
			WebDriverWait wait = new WebDriverWait(CommonFuntion.getDriver(), Duration.ofSeconds(10));
			// Get the current month and year displayed in the date picker
			String currentMonth = CommonFuntion.getDriver()
					.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = CommonFuntion.getDriver().findElement(By.xpath("//span[@class='ui-datepicker-year']"))
					.getText();

			// Check if we are in the correct month and year
			if (currentMonth.equalsIgnoreCase(targetMonth) && currentYear.equals(targetYear)) {
				// Select the target date directly
				CommonFuntion.getDriver()
						.findElement(
								By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + targetDate + "']"))
						.click();
			} else {
				// Handle month and year navigation if they don't match the target
				while (!currentMonth.equalsIgnoreCase(targetMonth) || !currentYear.equals(targetYear)) {
					if (shouldNavigateForward(currentMonth, currentYear, targetMonth, targetYear)) {
						// Wait and click the "Next" button using JavaScript Executor
						WebElement nextButton = CommonFuntion.getDriver()
								.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));
						wait.until(ExpectedConditions.elementToBeClickable(nextButton));
						// nextButton.click();
						((JavascriptExecutor) CommonFuntion.getDriver()).executeScript("arguments[0].click();",
								nextButton);
					} else {
						// Handle case where "Previous" button might not exist (when in earliest month)
						List<WebElement> prevButtons = CommonFuntion.getDriver()
								.findElements(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']"));
						if (!prevButtons.isEmpty()) {
							WebElement prevButton = prevButtons.get(0);
							try {
								wait.until(ExpectedConditions.visibilityOf(prevButton));
								wait.until(ExpectedConditions.elementToBeClickable(prevButton));
								((JavascriptExecutor) CommonFuntion.getDriver()).executeScript("arguments[0].click();",
										prevButton);
								// prevButton.click();
							} catch (Exception te) {
								//throw new RuntimeException(
										//"Timeout while waiting for the Previous button to be clickable.");
								
								logger.error("Timeout while waiting for the Previous button to be clickable."+te.getMessage());
							}

						} else {
							throw new RuntimeException("Previous button not found, possibly on the earliest month.");
						}
					}

					// Update the current month and year after clicking
					currentMonth = CommonFuntion.getDriver()
							.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
					currentYear = CommonFuntion.getDriver().findElement(By.xpath("//span[@class='ui-datepicker-year']"))
							.getText();
				}

				// Once the correct month and year are found, select the date
				CommonFuntion.getDriver()
						.findElement(
								By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + targetDate + "']"))
						.click();
			}

		} catch (Exception e) {
			logger.error("Error selecting outbound date: " + e.getMessage());
		}
	}

	private void InboundselectDate(String RetargetMonth, String RetargetDate, String RetargetYear) {
		try {
			// Open the date picker
			CommonFuntion.getDriver()
					.findElement(By.xpath("//input[@id='bodycontent_RGFlightDetails_dtpFlightDate_1']")).click();

			// Wait until the calendar is visible
			WebDriverWait wait = new WebDriverWait(CommonFuntion.getDriver(), Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));

			// Get the current month and year displayed in the date picker
			String currentMonth = CommonFuntion.getDriver()
					.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String currentYear = CommonFuntion.getDriver().findElement(By.xpath("//span[@class='ui-datepicker-year']"))
					.getText();

			// Loop until the correct month and year are found
			if (currentMonth.equalsIgnoreCase(RetargetMonth) && currentYear.equals(RetargetYear)) {
				// Select the target date directly
				CommonFuntion.getDriver()
						.findElement(
								By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + RetargetDate + "']"))
						.click();
			} else {
				while (!currentMonth.equalsIgnoreCase(RetargetMonth) || (!currentYear.equals(RetargetYear))) {
					// Call the shouldNavigateForward method to determine which way to navigate
					if (shouldNavigateForward(currentMonth, currentYear, RetargetMonth, RetargetYear)) {

						WebElement next = CommonFuntion.getDriver()
								.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));

						wait.until(ExpectedConditions.elementToBeClickable(next));

						((JavascriptExecutor) CommonFuntion.getDriver()).executeScript("arguments[0].click();", next);

					} else {
						WebElement prev = CommonFuntion.getDriver()
								.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']"));
						wait.until(ExpectedConditions.elementToBeClickable(prev));
						((JavascriptExecutor) CommonFuntion.getDriver()).executeScript("arguments[0].click();", prev);
					}

					// Update the current month and year after clicking next/prev
					currentMonth = CommonFuntion.getDriver()
							.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
					currentYear = CommonFuntion.getDriver().findElement(By.xpath("//span[@class='ui-datepicker-year']"))
							.getText();
				}

				// Once the correct month is found, select the date
				CommonFuntion.getDriver()
						.findElement(
								By.xpath("//table[@class='ui-datepicker-calendar']//a[text()='" + RetargetDate + "']"))
						.click();

			}
		} catch (Exception e) {
			logger.error("Error: " + e.getMessage());
		}
	}
	public void btnContinue() {
		mmbchange_btnContinue.click();
	}
}
