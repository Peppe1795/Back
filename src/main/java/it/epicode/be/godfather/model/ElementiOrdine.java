package it.epicode.be.godfather.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ElementiOrdine {

	private MenuItem menuItem;
	private String nota;

	@Override
	public String toString() {
		return menuItem + ", nota=" + nota;
	}
}
