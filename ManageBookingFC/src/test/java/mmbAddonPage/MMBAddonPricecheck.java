package mmbAddonPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MMBAddonPricecheck {

	private static MMBAddonPricecheck mmbAddonPricecheck;
	
	private MMBAddonPricecheck() {
		
	}

	public static MMBAddonPricecheck getMmbAddonPricecheck() {
		if(mmbAddonPricecheck==null) {
			mmbAddonPricecheck=new MMBAddonPricecheck();
		}
		return mmbAddonPricecheck;
	}
	
	@FindBy(xpath="//input[@id='bodycontent_chkConfirm']")
	public static WebElement Confirmation;
	

	@FindBy(xpath="//input[@id='bodycontent_btnConfirm']")
	public static WebElement bodycontent_btnConfirm;
	
	public void getConfirmation() {
		Confirmation.click();
	}
	
	public void getbodycontent_btnConfirm() {
		bodycontent_btnConfirm.click();
	}
}
