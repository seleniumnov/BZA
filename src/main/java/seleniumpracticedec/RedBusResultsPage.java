package seleniumpracticedec;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RedBusResultsPage {
	
	
	@FindBy(how=How.XPATH,using="(//label[@for='bt_NONAC'])[1]")
	public WebElement bustype_nonac;

}
