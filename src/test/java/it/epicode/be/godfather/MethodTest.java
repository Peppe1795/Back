package it.epicode.be.godfather;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import it.epicode.be.godfather.config.MenuConfig;
import it.epicode.be.godfather.model.ElementiOrdine;
import it.epicode.be.godfather.model.Menu;
import it.epicode.be.godfather.model.Ordine;
import it.epicode.be.godfather.model.StatoOrdine;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MethodTest {
	private static AnnotationConfigApplicationContext ctx;

	@BeforeAll
	static void config() {
		ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
	}

	@Test
	void testImporto() {

		Menu menu = (Menu) ctx.getBean("menu");

		ElementiOrdine elemento1 = new ElementiOrdine(menu.getMenuPizza().get(0), "senza formaggio");
		ElementiOrdine elemento2 = new ElementiOrdine(menu.getMenuDrink().get(0), null);
		Ordine ordine1 = new Ordine(1, 5, null, LocalDateTime.now(), StatoOrdine.INCORSO,
				new ArrayList<>(Arrays.asList(elemento1, elemento2)));
		log.info("Test1");
		double result = ordine1.calcoloImporto(ordine1.getNumeroCoperti());
		assertEquals(result, 23.78);
	}

	@Test
	void testCoperto() {
		Menu menu = (Menu) ctx.getBean("menu");

		ElementiOrdine elemento1 = new ElementiOrdine(menu.getMenuPizza().get(0), "senza formaggio");
		Ordine ordine1 = new Ordine(1, 5, null, LocalDateTime.now(), StatoOrdine.INCORSO,
				new ArrayList<>(Arrays.asList(elemento1)));
		log.info("Test2");
		double result = ordine1.costoCoperto(ordine1.getNumeroCoperti());
		assertEquals(result, 17.5);
	}

	@AfterAll
	static void cleanUp() {
		ctx.close();
	}
}
