package it.epicode.be.godfather.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import it.epicode.be.godfather.config.MenuConfig;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class GestoreOrdini implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
		Menu menu = (Menu) ctx.getBean("menu");

		ElementiOrdine elemento1 = new ElementiOrdine(menu.getMenuPizza().get(0), "senza formaggio");
		ElementiOrdine elemento2 = new ElementiOrdine(menu.getMenuDrink().get(0), null);
		Ordine ordine1 = new Ordine(1, 5, LocalDateTime.now(), StatoOrdine.INCORSO,
				new ArrayList<>(Arrays.asList(elemento1, elemento2)));

		ElementiOrdine elemento3 = new ElementiOrdine(menu.getMenuPizza().get(1), "senza ham");
		ElementiOrdine elemento4 = new ElementiOrdine(menu.getMenuDrink().get(0), null);
		Ordine ordine2 = new Ordine(1, 5, LocalDateTime.now(), StatoOrdine.PRONTO,
				new ArrayList<>(Arrays.asList(elemento3, elemento4)));

		log.info(ordine1.toString());
		log.info(ordine2.toString());

	}

}
