import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import junit.framework.Assert;

public class TesteGoogle {

		@Test
		public void teste() {
			//System.setProperty("webdriver.grcko.driver, "caminho gecko driver")
			WebDriver driver = new FirefoxDriver();
			//WebDriver driver = new ChromeDriver();
			//WebDriver driver = new InternetExplorerDriver() ;
			driver.manage().window().setSize(new Dimension(600, 765));; //Tamanho da janela
			driver.get("http://www.google.com"); //abrir o link
			System.out.print(driver.getTitle()); //abrir mensagem como o título da página
			Assert.assertEquals("Google", driver.getTitle());
			driver.quit();
		}
}
