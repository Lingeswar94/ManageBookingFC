package mmbAddonPage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import UtilityFunction.CommonFuntion;

public class MMBAddonSelection {

	private static MMBAddonSelection mmbAddonSelection;

	private MMBAddonSelection() {
		// TODO Auto-generated constructor stub
	}

	public static MMBAddonSelection getMmbAddonSelection() {
		if (mmbAddonSelection == null) {
			mmbAddonSelection = new MMBAddonSelection();
		}
		return mmbAddonSelection;
	}

	@FindBy(xpath = "//input[@id='bodycontent_btnAddOnBaggaes']")
	public static WebElement ADDBaggage;

	@FindBy(xpath="//input[@id='btnProceedBooking']")
	public  WebElement btnProceedBooking;
	
	By bagg = By.id("lvPaxBaggages$ctrl0$ucPaxBaggage$ucOBBaggageInformation$0PaxddlOBBaggages0");
	@FindBy(xpath="//select[@id='lvPaxBaggages_ucPaxBaggage_0_ucOBBaggageInformation_0_0PaxddlOBBaggages0_0']")
	public WebElement scjhjhd;
	
	public WebElement getMainPaxBaggage(int index) {
		String MainPaxbagg = "//select[contains(@id,'lvPaxBaggages_ucPaxBaggage_" + index + "_ucOBBaggageInformation_"
				+ index + "')]";
		return CommonFuntion.getDriver().findElement(By.xpath(MainPaxbagg));
	}
	
	public WebElement getMainReturnPaxBaggage(int index) {
		String ReturnPaxbagg = "//select[contains(@id,'lvPaxBaggages_ucPaxBaggage_" + index + "_ucIBBaggageInformation_"
				+ index + "')]";
		return CommonFuntion.getDriver().findElement(By.xpath(ReturnPaxbagg));
	}
	public void selectBaggage(int ADTcount, int Chcount, boolean isReturnTrip, boolean addBaggage,boolean addDepartureBaggage, boolean addReturnBaggage, String Baggagename) {
		
	    // If the user does not want to add baggage, skip the baggage selection process
	    if (!addBaggage) {
	    	
	        System.out.println("No baggage selected for this booking.");
	        return; // Skip the baggage selection if baggage is not needed
	    }else {
	    	ADDBaggage.click();
	    }

	    // Check if departure baggage is needed
	    if (addDepartureBaggage) {
	        DepartureAddBaggage(ADTcount, Chcount,Baggagename);
	    } else {
	        System.out.println("Departure baggage is not selected.");
	    }

	    // Check if return baggage is needed
	    if ( isReturnTrip && addReturnBaggage) {
	        ReturnAddBaggage(ADTcount, Chcount,Baggagename);
	    } else {
	        System.out.println("Return baggage is not selected.");
	    }
	}

	

	public void DepartureAddBaggage(int ADTcount, int Chcount, String Baggage) {

		int adult = ADTcount + 1;
		int totalPassengers = adult + Chcount;
		//System.out.println(totalPassengers);
		//System.out.println("ADTBaggCount: " + (ADTcount + 1) + ", ChBaggcount: " + Chcount);

		int currentADTBagg = 0;
		int currentChBagg = 0;

		for (int index = 0; index < totalPassengers; index++) {
			if (currentADTBagg < adult) {
				if (currentADTBagg == 0) {
					getMainPaxBaggage(index, Baggage);
				} else  {
					getAdultPaxBaggage(index, Baggage);
				
				}
				currentADTBagg++;
			}
			else if (currentChBagg < Chcount) {
				getChildPaxBaggage(index, Baggage);
				currentChBagg++;
			}
			else {
				System.out.println("Departure Addon Baggage is not selected ");
			}
		}
	}


	
	public void ReturnAddBaggage(int ADTcount, int Chcount,String Baggagename) {
		
		//int index=0;
		int adult = ADTcount + 1;
		int totalPassengers = adult + Chcount;
		//System.out.println(totalPassengers);
		//System.out.println("ADTBaggCount: " + (ADTcount + 1) + ", ChBaggcount: " + Chcount);

		int currentADTBagg = 0;
		int currentChBagg = 0;
		for (int index = 0; index < totalPassengers; index++) {
			if (currentADTBagg < adult) {
				if (currentADTBagg == 0) {
					getReturnMainPaxBaggage(index, Baggagename);
				} else  {
					getReturnAdultPaxBaggage(index, Baggagename);
				
				}
				currentADTBagg++;	
			} 
			else if (currentChBagg < Chcount) {
				getReturnChildPaxBaggage(index, Baggagename);
				currentChBagg++;
			}
			else {
				System.out.println("Return Addon Baggage is not selected ");
			}
		}
		
	}
	
	public void getMainPaxBaggage(int index, String SelectBaggage) {

		Select select = new Select(getMainPaxBaggage(index));
		select.selectByVisibleText(SelectBaggage);
	}

	public void getAdultPaxBaggage(int index, String SelectBaggage) {

		Select select = new Select(getMainPaxBaggage(index));
		select.selectByVisibleText(SelectBaggage);
	}

	public void getChildPaxBaggage(int index, String SelectBaggage) {

		Select select = new Select(getMainPaxBaggage(index));
		select.selectByVisibleText(SelectBaggage);
	}
	
	
	
	public void getReturnMainPaxBaggage(int index, String SelectBaggage) {

		Select select = new Select(getMainReturnPaxBaggage(index));
		select.selectByVisibleText(SelectBaggage);
	}

	public void getReturnAdultPaxBaggage(int index, String SelectBaggage) {

		Select select = new Select(getMainReturnPaxBaggage(index));
		select.selectByVisibleText(SelectBaggage);
	}

	public void getReturnChildPaxBaggage(int index, String SelectBaggage) {

		Select select = new Select(getMainReturnPaxBaggage(index));
		select.selectByVisibleText(SelectBaggage);
	}
	
	

	  public void name(String name) {
		Select select=new Select(scjhjhd);
		select.selectByVisibleText(name);
	}
}
