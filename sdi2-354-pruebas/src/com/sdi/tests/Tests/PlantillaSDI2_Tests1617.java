package com.sdi.tests.Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

import com.sdi.tests.utils.SeleniumUtils;

//Ordenamos las pruebas por el nombre del método
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PlantillaSDI2_Tests1617 {
	static String url = "http://localhost:8180/sdi2-354/";
	static WebDriver driver = getDriver();
	List<WebElement> elementos = null;

	public static WebDriver getDriver() {
		File pathToBinary = new File("S:\\firefox\\FirefoxPortable.exe");
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		WebDriver auxDriver = new FirefoxDriver(ffBinary, firefoxProfile);
		auxDriver.get(url);
		return auxDriver;
	}

	public PlantillaSDI2_Tests1617() {
	}

	@Before
	public void setUp() {
		driver.navigate().to(url);
	}

	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public static void end() {

		try {
			driver.findElement(By.id("form:username")).clear();
			driver.findElement(By.id("form:username")).sendKeys("admin1");
			driver.findElement(By.id("form:password")).clear();
			driver.findElement(By.id("form:password")).sendKeys("admin1");
			driver.findElement(By.id("form:login")).click();
			Thread.sleep(500);
			driver.findElement(
					By.cssSelector("span.ui-icon.ui-icon-triangle-1-s"))
					.click();
			driver.findElement(
					By.cssSelector("span.ui-icon.ui-icon-triangle-1-s"))
					.click();
			driver.findElement(
					By.xpath("//div[@id='form-cabecera:j_idt8']/ul/li/ul/li/a/span"))
					.click();
			driver.quit();
		} catch (InterruptedException e) {
		}

	}

	// PRUEBAS
	// ADMINISTRADOR
	// PR01: Autentificar correctamente al administrador.
	@Test
	public void prueba01() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("admin1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("admin1");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(1);
		SeleniumUtils.textoNoPresentePagina(driver,
				"Error: El usuario o la contraseña son incorrectos");
	}

	// PR02: Fallo en la autenticación del administrador por introducir mal el
	// login.
	@Test
	public void prueba02() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("admin");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("admin1");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver,
				"Error: El usuario o la contraseña son incorrectos");

	}

	// PR03: Fallo en la autenticación del administrador por introducir mal la
	// password.
	@Test
	public void prueba03() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("admin1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("admin");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver,
				"Error: El usuario o la contraseña son incorrectos");

	}

	// PR04: Probar que la base de datos contiene los datos insertados con
	// conexión correcta a la base de datos.
	@Test
	public void prueba04() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("admin1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("admin1");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("span.ui-icon.ui-icon-triangle-1-s"))
				.click();
		driver.findElement(By.cssSelector("span.ui-icon.ui-icon-triangle-1-s"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='form-cabecera:j_idt8']/ul/li/ul/li/a/span"))
				.click();
		Thread.sleep(1000);
		SeleniumUtils.textoPresentePagina(driver, "usuario1");
		SeleniumUtils.textoPresentePagina(driver, "usuario2");
		SeleniumUtils.textoPresentePagina(driver, "usuario3");
	}

	// PR05: Visualizar correctamente la lista de usuarios normales.
	@Test
	public void prueba05() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("admin1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("admin1");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver, "usuario1");
		SeleniumUtils.textoPresentePagina(driver, "usuario2");
		SeleniumUtils.textoPresentePagina(driver, "usuario3");
	}

	// PR06: Cambiar el estado de un usuario de ENABLED a DISABLED. Y tratar de
	// entrar con el usuario que se desactivado.
	@Test
	public void prueba06() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("admin1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("admin1");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:0:status")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("span.ui-menuitem-text")).click();
		driver.findElement(By.cssSelector("span.ui-menuitem-text")).click();
		driver.findElement(
				By.xpath("//a[@id='form-cabecera:cerrarSesion']/span")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario1");
		driver.findElement(By.id("form:login")).click();
	}

	// PR07: Cambiar el estado de un usuario a DISABLED a ENABLED. Y Y tratar de
	// entrar con el usuario que se ha activado.
	@Test
	public void prueba07() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("admin1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("admin1");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:0:status")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("span.ui-menuitem-text")).click();
		driver.findElement(By.cssSelector("span.ui-menuitem-text")).click();
		driver.findElement(
				By.xpath("//a[@id='form-cabecera:cerrarSesion']/span")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario1");
		driver.findElement(By.id("form:login")).click();
	}

	// PR08: Ordenar por Login
	@Test
	public void prueba08() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("admin1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("admin1");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "class",
				"ui-sortable-column-icon", 10);
		elementos.get(0).click();
		Thread.sleep(500);
		WebElement element = driver
				.findElement(By.id("form:tablalistado_data")).findElement(
						By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("usuario1"));
		elementos.get(0).click();
		Thread.sleep(500);
		element = driver.findElement(By.id("form:tablalistado_data"))
				.findElement(By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("usuario3"));
	}

	// PR09: Ordenar por Email
	@Test
	public void prueba09() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("admin1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("admin1");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "class",
				"ui-sortable-column-icon", 10);
		elementos.get(1).click();
		Thread.sleep(500);
		WebElement element = driver
				.findElement(By.id("form:tablalistado_data")).findElement(
						By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("usuario1@correo.com"));
		elementos.get(1).click();
		Thread.sleep(500);
		element = driver.findElement(By.id("form:tablalistado_data"))
				.findElement(By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("usuario3@correo.com"));
	}

	// PR10: Ordenar por Status
	@Test
	public void prueba10() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("admin1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("admin1");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:0:status")).click();
		Thread.sleep(500);
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "class",
				"ui-sortable-column-icon", 10);
		elementos.get(2).click();
		Thread.sleep(500);
		WebElement element = driver
				.findElement(By.id("form:tablalistado_data")).findElement(
						By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("usuario2"));
		elementos.get(2).click();
		Thread.sleep(500);
		element = driver.findElement(By.id("form:tablalistado_data"))
				.findElement(By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("usuario1"));
		driver.findElement(By.id("form:tablalistado:0:status")).click();
	}

	// PR11: Borrar una cuenta de usuario normal y datos relacionados.
	@Test
	public void prueba11() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("admin1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("admin1");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:0:eliminarDialog")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:2:eliminar")).click();
		Thread.sleep(500);
		SeleniumUtils.textoNoPresentePagina(driver, "usuario1");

	}

	// PR12: Crear una cuenta de usuario normal con datos válidos.
	@Test
	public void prueba12() throws InterruptedException {
		driver.findElement(By.id("form:register")).click();
		Thread.sleep(500);
		// ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp |
		// _self | 30000]]
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario1");
		driver.findElement(By.id("form:email")).clear();
		driver.findElement(By.id("form:email")).sendKeys("usuario1@correo.com");
		driver.findElement(By.id("form:password1")).clear();
		driver.findElement(By.id("form:password1")).sendKeys("usuario1");
		driver.findElement(By.id("form:password2")).clear();
		driver.findElement(By.id("form:password2")).sendKeys("usuario1");
		driver.findElement(By.id("form:j_idt16")).click();
	}

	// PR13: Crear una cuenta de usuario normal con login repetido.
	@Test
	public void prueba13() throws InterruptedException {
		driver.findElement(By.id("form:register")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp |
		// _self | 30000]]
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario1");
		driver.findElement(By.id("form:email")).clear();
		driver.findElement(By.id("form:email")).sendKeys("usuario1@correo.com");
		driver.findElement(By.id("form:password1")).clear();
		driver.findElement(By.id("form:password1")).sendKeys("usuario1");
		driver.findElement(By.id("form:password2")).clear();
		driver.findElement(By.id("form:password2")).sendKeys("usuario1");
		driver.findElement(By.id("form:j_idt16")).click();
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver,
				"Error: Ya existe un usuario con dicho login");

	}

	// PR14: Crear una cuenta de usuario normal con Email incorrecto.
	@Test
	public void prueba14() throws InterruptedException {
		driver.findElement(By.id("form:register")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp |
		// _self | 30000]]
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario4");
		driver.findElement(By.id("form:email")).clear();
		driver.findElement(By.id("form:email")).sendKeys("usuario4");
		driver.findElement(By.id("form:password1")).clear();
		driver.findElement(By.id("form:password1")).sendKeys("usuario4");
		driver.findElement(By.id("form:password2")).clear();
		driver.findElement(By.id("form:password2")).sendKeys("usuario4");
		driver.findElement(By.id("form:j_idt16")).click();
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver,
				"El formato del correo electrónico es incorrecto");
	}

	// PR15: Crear una cuenta de usuario normal con Password incorrecta.
	@Test
	public void prueba15() throws InterruptedException {
		driver.findElement(By.id("form:register")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp |
		// _self | 30000]]
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario4");
		driver.findElement(By.id("form:email")).clear();
		driver.findElement(By.id("form:email")).sendKeys("usuario4@correo.com");
		driver.findElement(By.id("form:password1")).clear();
		driver.findElement(By.id("form:password1")).sendKeys("bbbb");
		driver.findElement(By.id("form:password2")).clear();
		driver.findElement(By.id("form:password2")).sendKeys("bbbb");
		driver.findElement(By.id("form:j_idt16")).click();
		Thread.sleep(500);
		SeleniumUtils
				.textoPresentePagina(driver,
						"La contraseña debe tener al menos 8 caracteres, letras y números");
	}

	// USUARIO
	// PR16: Comprobar que en Inbox sólo aparecen listadas las tareas sin
	// categoría y que son las que tienen que. Usar paginación navegando por las
	// tres páginas.
	@Test
	public void prueba16() throws InterruptedException {
		assertEquals("GTD Task Manager", driver.getTitle());
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(By.id("form:inbox")).click();
		Thread.sleep(500);
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "id",
				"form:tablalistado_data", 3);
		assertFalse(elementos.get(0).getText().contains("categoría"));
		int count = driver.findElements(
				By.xpath("//table/tbody[@id='form:tablalistado_data']/tr"))
				.size();

		assertEquals(count, 8);
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "class",
				"ui-paginator-next", 3);
		Actions builder = new Actions(driver);
		builder.moveToElement(elementos.get(0)).perform();
		elementos.get(0).click();
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "id",
				"form:tablalistado_data", 3);
		assertFalse(elementos.get(0).getText().contains("categoría"));
		count = driver.findElements(
				By.xpath("//table/tbody[@id='form:tablalistado_data']/tr"))
				.size();

		assertEquals(8, count);
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "class",
				"ui-paginator-next", 3);
		builder = new Actions(driver);
		builder.moveToElement(elementos.get(0)).perform();
		elementos.get(0).click();
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "id",
				"form:tablalistado_data", 3);
		assertFalse(elementos.get(0).getText().contains("categoría"));
		count = driver.findElements(
				By.xpath("//table/tbody[@id='form:tablalistado_data']/tr"))
				.size();
		assertEquals(count, 4);
	}

	// PR17: Funcionamiento correcto de la ordenación por fecha planeada.
	@Test
	public void prueba17() throws InterruptedException {
		assertEquals("GTD Task Manager", driver.getTitle());
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(By.id("form:inbox")).click();
		Thread.sleep(500);
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "class",
				"ui-sortable-column-icon", 10);
		elementos.get(4).click();
		Thread.sleep(500);
		WebElement element = driver
				.findElement(By.id("form:tablalistado_data")).findElement(
						By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("Tarea 11"));
		elementos.get(4).click();
		Thread.sleep(500);
		element = driver.findElement(By.id("form:tablalistado_data"))
				.findElement(By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("Tarea 1"));
	}

	// PR18: Funcionamiento correcto del filtrado.
	@Test
	public void prueba18() throws InterruptedException {
		assertEquals("GTD Task Manager", driver.getTitle());
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(By.id("form:inbox")).click();
		Thread.sleep(500);
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "class",
				"ui-column-filter", 10);
		elementos.get(0).click();
		Actions builder = new Actions(driver);
		builder.sendKeys("Tarea 20").perform();
		Thread.sleep(1000);
		WebElement element = driver
				.findElement(By.id("form:tablalistado_data")).findElement(
						By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("Tarea 20"));
	}

	// PR19: Funcionamiento correcto de la ordenación por categoría.
	@Test
	public void prueba19() throws InterruptedException {
		assertEquals("GTD Task Manager", driver.getTitle());
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@id='form:today']/span")).click();
		Thread.sleep(500);
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "class",
				"ui-sortable-column-icon", 10);
		elementos.get(2).click();
		Thread.sleep(500);
		WebElement element = driver
				.findElement(By.id("form:tablalistado_data")).findElement(
						By.className("ui-datatable-even"));
		assertTrue(element.getText().contains(""));
		elementos.get(2).click();
		Thread.sleep(500);
		element = driver.findElement(By.id("form:tablalistado_data"))
				.findElement(By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("Tarea 27"));
	}

	// PR20: Funcionamiento correcto de la ordenación por fecha planeada.
	@Test
	public void prueba20() throws InterruptedException {
		assertEquals("GTD Task Manager", driver.getTitle());
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@id='form:today']/span")).click();
		Thread.sleep(500);
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "class",
				"ui-sortable-column-icon", 10);
		elementos.get(4).click();
		Thread.sleep(500);
		WebElement element = driver
				.findElement(By.id("form:tablalistado_data")).findElement(
						By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("Tarea 21"));
		elementos.get(4).click();
		Thread.sleep(500);
		element = driver.findElement(By.id("form:tablalistado_data"))
				.findElement(By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("Tarea 11"));
	}

	// PR21: Comprobar que las tareas que no están en rojo son las de hoy y
	// además las que deben ser.
	@Test
	public void prueba21() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@id='form:today']/span")).click();
		Thread.sleep(500);

		testColorToday();

	}

	private void testColorToday() throws InterruptedException {
		for (int i = 0; i < 20; i++) {
			if (i == 8 || i == 16) {
				elementos = SeleniumUtils.EsperaCargaPagina(driver, "class",
						"ui-paginator-next", 3);
				Actions builder = new Actions(driver);
				builder.moveToElement(elementos.get(0)).perform();
				elementos.get(0).click();
				Thread.sleep(500);
			}
			elementos = SeleniumUtils.EsperaCargaPagina(driver, "id",
					"form:tablalistado_data", 2);
			WebElement fila = elementos.get(0);
			WebElement element = fila.findElement(By.id("form:tablalistado:"
					+ i + ":plannedElement"));
			elementos = SeleniumUtils.EsperaCargaPagina(driver, "id",
					"form:tablalistado_data", 2);
			fila = elementos.get(0);

			element = fila.findElement(By.id("form:tablalistado:" + i
					+ ":plannedElement"));
			String color = element.getCssValue("background-color");
			String rgbColor = "rgba(255, 0, 0, 1)";
			Date date = new Date();
			String hoy = new SimpleDateFormat("dd/MM/yyyy").format(date);
			boolean isHoy = hoy.equals(element.getText());// DateUtil.isNotAfter(planned,
			// DateUtil.today())
			// && DateUtil.isNotBefore(planned, DateUtil.today());

			assertTrue((color.contains(rgbColor) && !isHoy)
					|| (!color.contains(rgbColor) && isHoy));
		}
	}

	// PR22: Comprobar que las tareas retrasadas están en rojo y son las que
	// deben ser.
	@Test
	public void prueba22() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@id='form:today']/span")).click();
		Thread.sleep(500);

		testColorRetrasadasToday();
	}

	private void testColorRetrasadasToday() throws InterruptedException {
		for (int i = 0; i < 20; i++) {
			if (i == 8 || i == 16) {
				elementos = SeleniumUtils.EsperaCargaPagina(driver, "class",
						"ui-paginator-next", 3);
				Actions builder = new Actions(driver);
				builder.moveToElement(elementos.get(0)).perform();
				elementos.get(0).click();
				Thread.sleep(500);
			}
			elementos = SeleniumUtils.EsperaCargaPagina(driver, "id",
					"form:tablalistado_data", 2);
			WebElement fila = elementos.get(0);
			WebElement element = fila.findElement(By.id("form:tablalistado:"
					+ i + ":plannedElement"));
			elementos = SeleniumUtils.EsperaCargaPagina(driver, "id",
					"form:tablalistado_data", 2);
			fila = elementos.get(0);

			element = fila.findElement(By.id("form:tablalistado:" + i
					+ ":plannedElement"));
			String color = element.getCssValue("background-color");
			String rgbColor = "rgba(255, 0, 0, 1)";
			Date date = new Date();
			String hoy = new SimpleDateFormat("dd/MM/yyyy").format(date);
			boolean isHoy = hoy.equals(element.getText());// DateUtil.isNotAfter(planned,
			// DateUtil.today())
			// && DateUtil.isNotBefore(planned, DateUtil.today());
			assertFalse(color.contains(rgbColor) && isHoy);

		}
	}

	// PR23: Comprobar que las tareas de hoy y futuras no están en rojo y que
	// son las que deben ser.
	@Test
	public void prueba23() throws InterruptedException, ParseException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@id='form:week']/span")).click();
		Thread.sleep(500);
		for (int i = 0; i < 20; i++) {
			if (i == 8 || i == 16 || i == 24) {
				elementos = SeleniumUtils.EsperaCargaPagina(driver, "class",
						"ui-paginator-next", 3);
				Actions builder = new Actions(driver);
				builder.moveToElement(elementos.get(0)).perform();
				elementos.get(0).click();
				Thread.sleep(500);
			}
			elementos = SeleniumUtils.EsperaCargaPagina(driver, "id",
					"form:tablalistado_data", 2);
			WebElement fila = elementos.get(0);
			WebElement element = fila.findElement(By.id("form:tablalistado:"
					+ i + ":plannedElement"));
			WebElement category = fila.findElement(By.id("form:tablalistado:"
					+ i + ":categoryElement"));
			elementos = SeleniumUtils.EsperaCargaPagina(driver, "id",
					"form:tablalistado_data", 2);
			fila = elementos.get(0);
			element = fila.findElement(By.id("form:tablalistado:" + i
					+ ":plannedElement"));
			category = fila.findElement(By.id("form:tablalistado:" + i
					+ ":categoryElement"));
			String color = category.getCssValue("background-color");
			String rgbColor = "rgba(255, 0, 0, 1)";
			String sDate = new SimpleDateFormat("dd/MM/yyyy")
					.format(new Date());
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
			Date planned = new SimpleDateFormat("dd/MM/yyyy").parse(element
					.getText());
			// String hoy = new SimpleDateFormat("dd/MM/yyyy").format(date);
			boolean isWeek = planned.compareTo(date) > 0
					|| planned.compareTo(date) == 0;
			// DateUtil.isBefore(planned,
			// DateUtil.today());
			assertTrue((!color.contains(rgbColor) && isWeek)
					|| (!isWeek && color.contains(rgbColor)));

		}
	}

	// PR24: Funcionamiento correcto de la ordenación por día.
	@Test
	public void prueba24() throws InterruptedException {
		assertEquals("GTD Task Manager", driver.getTitle());
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@id='form:week']/span")).click();
		Thread.sleep(500);
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "class",
				"ui-sortable-column-icon", 10);
		elementos.get(4).click();
		Thread.sleep(500);
		WebElement element = driver
				.findElement(By.id("form:tablalistado_data")).findElement(
						By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("Tarea 21"));
		elementos.get(4).click();
		Thread.sleep(500);
		element = driver.findElement(By.id("form:tablalistado_data"))
				.findElement(By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("Tarea 1"));
	}

	// PR25: Funcionamiento correcto de la ordenación por nombre.
	@Test
	public void prueba25() throws InterruptedException {
		assertEquals("GTD Task Manager", driver.getTitle());
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@id='form:week']/span")).click();
		Thread.sleep(500);
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "class",
				"ui-sortable-column-icon", 10);
		elementos.get(0).click();
		Thread.sleep(500);
		WebElement element = driver
				.findElement(By.id("form:tablalistado_data")).findElement(
						By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("Tarea 1"));
		elementos.get(0).click();
		Thread.sleep(500);
		element = driver.findElement(By.id("form:tablalistado_data"))
				.findElement(By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("Tarea 9"));
	}

	// PR26: Confirmar una tarea, inhabilitar el filtro de tareas terminadas, ir
	// a la pagina donde está la tarea terminada y comprobar que se muestra.
	@Test
	public void prueba26() throws InterruptedException {
		assertEquals("GTD Task Manager", driver.getTitle());
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(By.id("form:inboxNotFinished")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:0:titleElement")).click();
		Thread.sleep(500);
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(By.id("form:inboxFinished")).click();
		Thread.sleep(500);
	}

	// PR27: Crear una tarea sin categoría y comprobar que se muestra en la
	// lista Inbox.
	@Test
	public void prueba27() throws InterruptedException {
		assertEquals("GTD Task Manager", driver.getTitle());
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("span.ui-icon.ui-icon-triangle-1-s"))
				.click();
		driver.findElement(By.cssSelector("span.ui-icon.ui-icon-triangle-1-s"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='form-cabecera:j_idt8']/ul/li/ul/li/a/span"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.id("form:nombre")).clear();
		driver.findElement(By.id("form:nombre")).sendKeys("Prueba 1");
		driver.findElement(By.id("form:anadir")).click();
		Thread.sleep(500);
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(By.xpath("//a[@id='form:inbox']/span")).click();
		Thread.sleep(500);
		elementos = SeleniumUtils.EsperaCargaPagina(driver, "class",
				"ui-column-filter", 10);
		elementos.get(0).click();
		Actions builder = new Actions(driver);
		builder.sendKeys("Prueba 1").perform();
		Thread.sleep(500);

	}

	// PR28: Crear una tarea con categoría categoria1 y fecha planeada Hoy y
	// comprobar que se muestra en la lista Hoy.
	@Test
	public void prueba28() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("Opciones")).click();
		driver.findElement(By.linkText("Opciones")).click();
		driver.findElement(
				By.xpath("//div[@id='form-cabecera:j_idt8']/ul/li/ul/li/a/span"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.id("form:nombre")).clear();
		driver.findElement(By.id("form:nombre")).sendKeys("Prueba 2");
		driver.findElement(By.xpath("//div[@id='form:category']/div[3]/span"))
				.click();
		driver.findElement(By.id("form:category_1")).click();
		driver.findElement(By.id("form:calendario_input")).clear();
		driver.findElement(By.id("form:calendario_input")).sendKeys(
				new SimpleDateFormat("dd/MM/yy").format(new Date()));
		driver.findElement(By.id("form:anadir")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:title:filter")).clear();
		driver.findElement(By.id("form:tablalistado:title:filter")).sendKeys(
				"Prueba 2");
		Thread.sleep(500);
		WebElement element = driver
				.findElement(By.id("form:tablalistado_data")).findElement(
						By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("Prueba 2"));

	}

	// PR29: Crear una tarea con categoría categoria1 y fecha planeada posterior
	// a Hoy y comprobar que se muestra en la lista Semana.
	@Test
	public void prueba29() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.linkText("Opciones")).click();
		driver.findElement(By.linkText("Opciones")).click();
		driver.findElement(
				By.xpath("//div[@id='form-cabecera:j_idt8']/ul/li/ul/li/a/span"))
				.click();
		Thread.sleep(500);
		driver.findElement(By.id("form:nombre")).clear();
		driver.findElement(By.id("form:nombre")).sendKeys("Prueba 3");
		driver.findElement(By.xpath("//div[@id='form:category']/div[3]/span"))
				.click();
		driver.findElement(By.id("form:category_1")).click();
		driver.findElement(By.id("form:calendario_input")).clear();
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		driver.findElement(By.id("form:calendario_input")).sendKeys(
				new SimpleDateFormat("dd/MM/yy").format(dt));

		driver.findElement(By.id("form:anadir")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:title:filter")).clear();
		driver.findElement(By.id("form:tablalistado:title:filter")).sendKeys(
				"Prueba 3");
		Thread.sleep(500);
		driver.findElement(By.id("form:week")).click();
		Thread.sleep(500);
		WebElement element = driver
				.findElement(By.id("form:tablalistado_data")).findElement(
						By.className("ui-datatable-even"));
		assertTrue(element.getText().contains("Prueba 3"));
	}

	// PR30: Editar el nombre, y categoría de una tarea (se le cambia a
	// categoría1) de la lista Inbox y comprobar que las tres pseudolista se
	// refresca correctamente.
	@Test
	public void prueba30() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(By.id("form:inbox")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:0:editButton")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:nombre")).clear();
		driver.findElement(By.id("form:nombre")).sendKeys("Tarea Cambiada");
		driver.findElement(By.xpath("//div[@id='form:category']/div[3]"))
				.click();
		driver.findElement(By.id("form:category_1")).click();
		driver.findElement(By.id("form:comentario")).click();
		driver.findElement(By.id("form:comentario")).clear();
		driver.findElement(By.id("form:comentario")).sendKeys("");
		driver.findElement(By.id("form:editar")).click();
		Thread.sleep(500);
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(By.id("form:inbox")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:title:filter")).clear();
		driver.findElement(By.id("form:tablalistado:title:filter")).sendKeys(
				"Tarea Cambiada");
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@id='form:today']/span")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:title:filter")).clear();
		driver.findElement(By.id("form:tablalistado:title:filter")).sendKeys(
				"Tarea Cambiada");
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@id='form:week']/span")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:title:filter")).clear();
		driver.findElement(By.id("form:tablalistado:title:filter")).sendKeys(
				"Tarea Cambiada");
		Thread.sleep(500);

	}

	// PR31: Editar el nombre, y categoría (Se cambia a sin categoría) de una
	// tarea de la lista Hoy y comprobar que las tres pseudolistas se refrescan
	// correctamente.
	@Test
	public void prueba31() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@id='form:today']/span")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:0:editButton")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:nombre")).clear();
		driver.findElement(By.id("form:nombre")).sendKeys("Tarea Cambiada 2");
		driver.findElement(By.xpath("//div[@id='form:category']/div[3]"))
				.click();
		driver.findElement(By.id("form:category_0")).click();
		driver.findElement(By.id("form:comentario")).click();
		driver.findElement(By.id("form:comentario")).clear();
		driver.findElement(By.id("form:comentario")).sendKeys("");
		driver.findElement(By.id("form:editar")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@id='form:today']/span")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:title:filter")).clear();
		driver.findElement(By.id("form:tablalistado:title:filter")).sendKeys(
				"Tarea Cambiada 2");
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[@id='form:week']/span")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:title:filter")).clear();
		driver.findElement(By.id("form:tablalistado:title:filter")).sendKeys(
				"Tarea Cambiada 2");
		Thread.sleep(500);
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(By.id("form:inbox")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:title:filter")).clear();
		driver.findElement(By.id("form:tablalistado:title:filter")).sendKeys(
				"Tarea Cambiada 2");
		Thread.sleep(500);
	}

	// PR32: Marcar una tarea como finalizada. Comprobar que desaparece de las
	// tres pseudolistas.
	@Test
	public void prueba32() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:6:marAsFinishedButton"))
				.click();
		Thread.sleep(500);
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(
				By.xpath("//div[@id='form:j_idt16']/ul/li[2]/a/span")).click();
		driver.findElement(By.id("form:inbox")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:title:filter")).clear();
		driver.findElement(By.id("form:tablalistado:title:filter")).sendKeys(
				"Tarea 7");
		driver.findElement(By.xpath("//a[@id='form:today']/span")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:title:filter")).clear();
		driver.findElement(By.id("form:tablalistado:title:filter")).sendKeys(
				"Tarea 7");
		driver.findElement(By.xpath("//a[@id='form:week']/span")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:tablalistado:title:filter")).clear();
		driver.findElement(By.id("form:tablalistado:title:filter")).sendKeys(
				"Tarea 7");
		Thread.sleep(500);

	}

	// PR33: Salir de sesión desde cuenta de administrador.
	@Test
	public void prueba33() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("admin1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("admin1");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("span.ui-icon.ui-icon-triangle-1-s"))
				.click();
		driver.findElement(By.cssSelector("span.ui-icon.ui-icon-triangle-1-s"))
				.click();
		driver.findElement(
				By.xpath("//a[@id='form-cabecera:cerrarSesion']/span")).click();
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver, "Gestor de tareas");
	}

	// PR34: Salir de sesión desde cuenta de usuario normal.
	@Test
	public void prueba34() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario2");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario2");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(By.cssSelector("span.ui-icon.ui-icon-triangle-1-s"))
				.click();
		driver.findElement(By.cssSelector("span.ui-icon.ui-icon-triangle-1-s"))
				.click();
		driver.findElement(
				By.xpath("//a[@id='form-cabecera:cerrarSesion']/span")).click();
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver, "Gestor de tareas");
	}

	// PR35: Cambio del idioma por defecto a un segundo idioma. (Probar algunas
	// vistas)
	@Test
	public void prueba35() throws InterruptedException {
		driver.findElement(By.cssSelector("span.ui-menuitem-text")).click();
		driver.findElement(By.cssSelector("span.ui-menuitem-text")).click();
		driver.findElement(By.linkText("Inglés")).click();
		SeleniumUtils.textoPresentePagina(driver, "Task Manager");
		Thread.sleep(500);
		driver.findElement(By.id("form:register")).click();
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver, "Task Manager - Register");
		// ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp |
		// _self | 30000]]
		driver.findElement(By.id("form:j_idt17")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("admin1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("admin1");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver,
				"Task Manager - Administrator Home");
	}

	// PR36: Cambio del idioma por defecto a un segundo idioma y vuelta al
	// idioma por defecto. (Probar algunas vistas)
	@Test
	public void prueba36() throws InterruptedException {
		driver.findElement(By.cssSelector("span.ui-menuitem-text")).click();
		driver.findElement(By.cssSelector("span.ui-menuitem-text")).click();
		driver.findElement(By.linkText("Inglés")).click();
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver, "Task Manager");
		driver.findElement(By.id("form:register")).click();
		SeleniumUtils.textoPresentePagina(driver, "Task Manager - Register");
		// ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp |
		// _self | 30000]]
		driver.findElement(By.cssSelector("span.ui-menuitem-text")).click();
		driver.findElement(By.cssSelector("span.ui-menuitem-text")).click();
		driver.findElement(By.linkText("Spanish")).click();
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver,
				"Gestor de tareas - Registrarse");
		driver.findElement(By.id("form:j_idt17")).click();
		Thread.sleep(500);
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("admin1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("admin1");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		driver.findElement(
				By.xpath("//div[@id='form-cabecera:j_idt8']/ul/li[2]/a/span[2]"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='form-cabecera:j_idt8']/ul/li[2]/a/span[2]"))
				.click();
		driver.findElement(By.linkText("Inglés")).click();
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver,
				"Task Manager - Administrator Home");
		driver.findElement(
				By.xpath("//div[@id='form-cabecera:j_idt8']/ul/li[2]/a/span[2]"))
				.click();
		driver.findElement(
				By.xpath("//div[@id='form-cabecera:j_idt8']/ul/li[2]/a/span[2]"))
				.click();
		driver.findElement(By.linkText("Spanish")).click();
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver,
				"Gestor de tareas - Principal Administrador");
	}

	// PR37: Intento de acceso a un URL privado de administrador con un usuario
	// autenticado como usuario normal.
	@Test
	public void prueba37() throws InterruptedException {
		driver.findElement(By.id("form:username")).clear();
		driver.findElement(By.id("form:username")).sendKeys("usuario1");
		driver.findElement(By.id("form:password")).clear();
		driver.findElement(By.id("form:password")).sendKeys("usuario1");
		driver.findElement(By.id("form:login")).click();
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver,
				"Gestor de tareas - Principal Usuario");
		driver.get("http://localhost:8180/sdi2-354/restricted/restrictedUser/administratorIndex.xhtml");
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver,
				"Gestor de tareas - Principal Usuario");
	}

	// PR38: Intento de acceso a un URL privado de usuario normal con un usuario
	// no autenticado.
	@Test
	public void prueba38() throws InterruptedException {
		SeleniumUtils.textoPresentePagina(driver, "Gestor de tareas");
		driver.get("http://localhost:8180/sdi2-354/restricted/error.xhtml");
		Thread.sleep(500);
		SeleniumUtils.textoPresentePagina(driver, "Gestor de tareas");
	}

}