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

		Tavolo tavolo1 = new Tavolo(1, 15, StatoTavolo.OCCUPATO);
		Tavolo tavolo = new Tavolo(2, 12, StatoTavolo.LIBERO);

		ElementiOrdine elemento1 = new ElementiOrdine(menu.getMenuPizza().get(0), "senza formaggio");
		ElementiOrdine elemento2 = new ElementiOrdine(menu.getMenuDrink().get(0), null);
		Ordine ordine1 = new Ordine(1, 5, tavolo1, LocalDateTime.now(), StatoOrdine.INCORSO,
				new ArrayList<>(Arrays.asList(elemento1, elemento2)));

		ElementiOrdine elemento3 = new ElementiOrdine(menu.getMenuPizza().get(1), "senza ham");
		ElementiOrdine elemento4 = new ElementiOrdine(menu.getMenuDrink().get(0), null);
		Ordine ordine2 = new Ordine(1, 5, tavolo, LocalDateTime.now(), StatoOrdine.PRONTO,
				new ArrayList<>(Arrays.asList(elemento3, elemento4)));

		System.out.println("============ ORDINE 1 ============");

		System.out.println("Numero ordine: " + ordine1.getNumeroOrdine());
		System.out.println("Numero tavolo: " + tavolo1.getNumeroTavolo());
		System.out.println("Max coperti: " + tavolo1.getCopertiMax());
		System.out.println("Stato tavolo " + tavolo1.getStatoTAvolo());
		System.out.println("Numero coperti: " + ordine1.getNumeroCoperti());
		System.out.println("Ora di acquisto: " + ordine1.getOraDiAcquisizione());
		System.out.println("Stato dell'ordine: " + ordine1.getStatoOrdine());
		System.out.println("Lista elementi dell'ordine: " + ordine1.getListaElementi());
//		System.out.println("Costo coperto: " + ordine1.costoCoperto());
//		System.out.println("Conto: " + ordine1.calcoloImporto());

		System.out.println("============ ORDINE 2 ============");

		System.out.println("Numero ordine: " + ordine2.getNumeroOrdine());
		System.out.println("Numero tavolo: " + tavolo.getNumeroTavolo());
		System.out.println("Max coperti: " + tavolo.getCopertiMax());
		System.out.println("Stato tavolo " + tavolo.getStatoTAvolo());
		System.out.println("Numero coperti: " + ordine2.getNumeroCoperti());
		System.out.println("Ora di acquisto: " + ordine2.getOraDiAcquisizione());
//		System.out.println("Stato dell'ordine: " + ordine2.getStatoOrdine());
//		System.out.println("Lista elementi dell'ordine: " + ordine2.getListaElementi());

	}

}
