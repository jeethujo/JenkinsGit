package pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Set;
import java.util.Iterator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class WindowHandlePOM extends BaseClass {
 	@FindBy(linkText="Gmail") WebElement GmailLink;
 	
    public WindowHandlePOM(){
        PageFactory.initElements(driver,this);
    }
    public void rightClickGmailKeyPressDown() throws AWTException, InterruptedException{
        Actions action;
        action=new Actions(driver);
		action.contextClick(GmailLink).perform();
		Robot robot = new Robot();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_DOWN);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
    }
    public void SwitchToNewTab() throws InterruptedException{
        //ArrayList<String> NewTab=new ArrayList<String>(driver.getWindowHandles());
        //driver.switchTo().window(NewTab.get(1));
        //Thread.sleep(1000);
    	String parentWindow=driver.getWindowHandle();
    	Set<String> allWindows=driver.getWindowHandles();
    	Iterator<String> iterate=allWindows.iterator();
    	while(iterate.hasNext()){
    	String childWindow=iterate.next();
    	if(!parentWindow.equalsIgnoreCase(childWindow)) {
    		driver.switchTo().window(childWindow);
    		Thread.sleep(2000);
    	}
    	}
    }
    public void SwitchToOldTab() throws InterruptedException{
        //ArrayList<String> OldTab=new ArrayList<String>(driver.getWindowHandles());
       // driver.switchTo().window(OldTab.get(0));
    	String parentWindow=driver.getWindowHandle();
    	Set<String> allWindows=driver.getWindowHandles();
    	Iterator<String> iterate=allWindows.iterator();
    	while(iterate.hasNext()){
    	String childWindow=iterate.next();
    	if(!parentWindow.equalsIgnoreCase(childWindow)) {
    		driver.switchTo().window(parentWindow);
    		Thread.sleep(2000);
    }
}
    }
}
