import java.util.List;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;

import com.gargoylesoftware.htmlunit.javascript.configuration.WebBrowser;
import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.sun.tools.javac.util.List;

public class TestCampoTreinamento {

		@Test
		public void testeField() {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(900, 765));
			driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
			driver.findElement(By.id("elementosForm:nome")).sendKeys("Rosilei"); //escrevre no campo
			Assert.assertEquals("Rosilei", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));//POsiciona no campo e compara
			driver.quit();
		}
		@Test
		public void TesteArea() {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(900, 765));
			driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
			driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Treinamento\nTeste\nultimalinha");
			Assert.assertEquals("Treinamento\nTeste\nultimalinha", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
			driver.quit();
		}
		@Test
		public void TesteRadionButon() {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(900, 765));
			driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
			driver.findElement(By.id("elementosForm:sexo:0")).click();
			Assert.assertTrue(driver.findElement(By.id("elementosForm:sexo:0")).isSelected());
			driver.quit();
		}
		@Test
		public void TestecheckBox() {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(900,765));
			driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
			driver.findElement(By.id("elementosForm:comidaFavorita:0")).click();
			Assert.assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:0")).isSelected());
			driver.quit();
		}
		@Test
		public void TesteComboBox() {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(900, 765));
			driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
			WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
			Select combo = new Select(element);
			//combo.selectByIndex(3); //pelo Index
			//combo.selectByValue("2graucomp"); //pelo value da opção
			combo.selectByVisibleText("Mestrado");//valor que aparece
		    Assert.assertEquals("Mestrado", combo.getFirstSelectedOption().getText());
		    driver.quit();
		}

		@Test
		public void VerificarValoresCombo() {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(900, 765));
			driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
			WebElement element = driver.findElement(By.id("elementosForm:escolaridade"));
			Select combo = new Select(element);
			List<WebElement> options = combo.getOptions();
			Assert.assertEquals(8,options.size());
			
			boolean encontrou = false;
			for(WebElement option : options) {
				if( option.getText().equals("Mestrado")) {
					encontrou=true;
					break;
				}
			}
			Assert.assertTrue(encontrou);
		}
	//		
		@Test
		public void VerificaValoresComboMultSeleccao () {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(900,765));
			driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
			WebElement element = driver.findElement(By.id("elementosForm:esportes"));
			Select combo = new Select(element);
			combo.selectByVisibleText("Natacao");
			combo.selectByVisibleText("Corrida");
			combo.selectByVisibleText("O que eh esporte?");
			
			List<WebElement> allselectedoptions = combo.getAllSelectedOptions();
			Assert.assertEquals(3,allselectedoptions.size());
			
			combo.deselectByVisibleText("Corrida");
			allselectedoptions = combo.getAllSelectedOptions();
			Assert.assertEquals(2, allselectedoptions.size());
			driver.quit();;
		}
		@Test
		public void InteragirButons () {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(900,765));
			driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
			WebElement botao= driver.findElement(By.id("buttonSimple"));
			botao.click();
			Assert.assertEquals("Obrigado!", botao.getAttribute("value"));
			driver.quit();
		}
		@Test
		//@Ignore //ignora o teste, quando não está finalizado a programaçã do mesmo.
		public void InteragirLinks () {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(900,765));
			driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
			driver.findElement(By.linkText("Voltar")).click();
			//forçar falha no teste
			//Assert.fail();
			Assert.assertEquals("Voltou!",driver.findElement(By.id("resultado")).getText());
			driver.quit();
		}
		@Test
		public void BuscarTextos () {
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().setSize(new Dimension(900,765));
			driver.get("file:///"+System.getProperty("user.dir")+"/src/main/resources/componentes.html");
			driver.findElement(By.tagName("body"));
			System.out.print(driver.findElement(By.tagName("body")).getText());//imprimi todo texto da página
			
			//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
			Assert.assertEquals("Campo de Treinamento", driver.findElement(By.tagName("h3")).getText());
			Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", driver.findElement(By.className("facilAchar")).getText());
		}
}
		

