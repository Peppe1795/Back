package it.epicode.be.godfather.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
@PropertySource("classpath:application.properties")
public class Ordine {
	private int numeroOrdine;
	private int numeroCoperti;
	private Tavolo tavolo;
	private LocalDateTime oraDiAcquisizione;
	private StatoOrdine StatoOrdine;
	private List<ElementiOrdine> listaElementi;
	@Value("${application.myvalue}")
	double myvalue;

	public Ordine(int numeroOrdine, int numeroCoperti, Tavolo tavolo, LocalDateTime oraDiAcquisizione,
			StatoOrdine statoOrdine, List<ElementiOrdine> listaElementi) {
		this.numeroOrdine = numeroOrdine;
		this.numeroCoperti = numeroCoperti;
		this.tavolo = tavolo;
		this.oraDiAcquisizione = oraDiAcquisizione;
		StatoOrdine = statoOrdine;
		this.listaElementi = listaElementi;
	}

	public double calcoloImporto(int numeroCoperti) {
		double totaleElementi = listaElementi.stream().mapToDouble(e -> e.getMenuItem().getPrice()).sum();
		return totaleElementi += costoCoperto(numeroCoperti);
	}

	public double costoCoperto(int numeroCoperti) {

		return myvalue * numeroCoperti;
	}
}
