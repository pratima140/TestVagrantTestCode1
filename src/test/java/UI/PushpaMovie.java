package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.xml.sax.Locator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PushpaMovie {	
	
	public static void main(String[] args) throws InterruptedException {
		 
		final String WIKI_PUSHPA_DATE_XPATH = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[12]/td/div/ul/li";
		final String WIKI_PUSHPA_COUNTRY_XPATH = "//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[14]/td";
		final String IMDB_PUSHPA_DATE_XPATH = "//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[10]/div[2]/ul/li[1]/div/ul/li/a";
		final String IMDB_PUSHPA_COUNTRY_XPATH = "//*[@id=\"__next\"]/main/div/section[1]/div/section/div/div[1]/section[10]/div[2]/ul/li[2]/div/ul/li/a";
		// TODO Auto-generated method stub
		
		final String WIKI_URL = "https://en.wikipedia.org/wiki/Pushpa:_The_Rise";
		final String IMDB_URL = "https://www.imdb.com/title/tt9389998/?ref_=nv_sr_srsg_0";
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// For Wikipedia
		driver.get(WIKI_URL);
		
		WebElement wikiPushpaDate = driver.findElement(By.xpath(WIKI_PUSHPA_DATE_XPATH));
		String wpd= wikiPushpaDate.getText();
		System.out.println(wpd);
		
		WebElement wikiPushpaCountry = driver.findElement(By.xpath(WIKI_PUSHPA_COUNTRY_XPATH));
	    String wpc = wikiPushpaCountry.getText();
		System.out.println(wpc);
		
		//For IMDB
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get(IMDB_URL);
		
		WebElement imdbPushpaDate = driver.findElement(By.xpath(IMDB_PUSHPA_DATE_XPATH));
	     String ipd  = imdbPushpaDate.getText();
		System.out.println(ipd);
		
		WebElement imdbPushpaCountry = driver.findElement(By.xpath(IMDB_PUSHPA_COUNTRY_XPATH));
	     String ipc  = imdbPushpaCountry.getText();
		System.out.println(ipc);
		
		boolean matchFound = true;
		if(!(wpd.equals(ipd))){
			matchFound = false;
		}
		
		if(!(wpc.equals(ipc))){
			matchFound = false;
		}
		if (!matchFound) {
			System.out.println("Test Failed");
		}
		
		
		tearDown(driver);
	
	}
	
	static void tearDown(ChromeDriver driver) {
		driver.quit();
		
	}

}
