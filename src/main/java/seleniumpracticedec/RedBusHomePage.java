package seleniumpracticedec;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RedBusHomePage {
	
	
	@FindBy(how = How.XPATH,using="//input[@id='from']")
	public WebElement input_from;
	
	
	@FindBy(how = How.XPATH,using="//input[@id='dest']")
	public WebElement input_to;
	
	
	@FindBy(how = How.XPATH,using="//div[@id='platforms_div']/following::div[@class='dib']")
	public List<WebElement> div_footertexts;
	
	

}
