package it.epicode.be.godfather.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@AllArgsConstructor
@Slf4j
public class Ordine {
	private int numeroOrdine;
	private int numeroCoperti;
	private Tavolo tavolo;
	private LocalDateTime oraDiAcquisizione;
	private StatoOrdine StatoOrdine;
	private List<ElementiOrdine> listaElementi;

	public double calcoloImporto() {
		double totaleElementi = listaElementi.stream().mapToDouble(e -> e.getMenuItem().getPrice()).sum();
		return totaleElementi += costoCoperto();
	}

	public double costoCoperto() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Ordine.class);

		CostoCoperto valoreCoperto = ctx.getBean(CostoCoperto.class);

		ctx.close();
		return valoreCoperto.getMyvalue() * numeroCoperti;
	}

}
