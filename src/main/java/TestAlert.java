import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestAlert {

	@Test
	public void IntegirComAlertSimples() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(900, 765));
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.findElement(By.id("alert")).click();
		Alert alert =driver.switchTo().alert(); //foca na janela o alerta
		String texto  = alert.getText(); //grava o texto numa varíavel
		Assert.assertEquals("Alert Simples", alert.getText()); 
		alert.accept(); //pressiona ok da mensagem de alerta
		driver.findElement(By.id("elementosForm:nome")).sendKeys(texto);//alimenta o campo nome com a mensagem de alerta
		driver.quit();
	}
	@Test
	public void IntegirComAlertYesNO() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(900, 765));
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.findElement(By.id("confirm")).click();
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples",alert.getText());
		alert.accept();
		Assert.assertEquals("Confirmado", alert.getText());
		alert.accept();

		
		driver.findElement(By.id("confirm")).click();
		Alert alerta = driver.switchTo().alert();
		Assert.assertEquals("Confirm Simples", alerta.getText());
		alerta.dismiss();
	    Assert.assertEquals("Negado", alerta.getText());
	    alerta.accept();
		driver.quit();
		
	}
	
	@Test
	public void IntegirButunPrompt() {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(900, 765));
		driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
		driver.findElement(By.id("prompt")).click();
	    Alert alerta =driver.switchTo().alert();
	    Assert.assertEquals("Digite um numero",alerta.getText());
	    alerta.sendKeys("12");
	    alerta.accept();
	    Assert.assertEquals("Era 12?", alerta.getText());
	    alerta.accept();
	    Assert.assertEquals(":D", alerta.getText());
	    alerta.accept();
	    driver.quit();

	}
}
