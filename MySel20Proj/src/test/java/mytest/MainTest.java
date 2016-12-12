package mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class MainTest {
	@Test
	    public void executeChrome() throws Exception {
		System.out.println( "Executing firefox tests...");
	        this.execute(DesiredCapabilities.firefox());
	    }

	
    private void execute(final DesiredCapabilities capability) throws Exception {       // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
		//System.setProperty("webdriver.gecko.driver", "/Users/gtanzi/geckodriver");
    	//System.setProperty("webdriver.chrome.driver", "/Users/gtanzi/chromedriver");
    	
        //WebDriver driver = new FirefoxDriver();
		WebDriver driver = new RemoteWebDriver(new java.net.URL("http://jenkins-jenkins-cluster.apps.gtanzi.local/wd/hub"), DesiredCapabilities.firefox());
        //		
		// And now use this to visit Google
        driver.get("http://www.google.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is now: " + driver.getTitle());
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
/*        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });
*/
        // Should see: "cheese! - Google Search"
        driver.navigate().to("http://www.github.com");
        System.out.println( driver.getCurrentUrl() );
        assert( driver.getTitle() != "test" );
    /*    java.util.List<WebElement> elements = driver.findElements(By.className("header-search-scope"));
        System.out.println( elements.size()); */
        //Close the browser
        driver.quit();
    }
}
