package auto_radnja;

import java.util.LinkedList;

import auto_radnja.gume.AutoGuma;

/**
 * Klasa koja opisuje vulkanizersku radnju i sadrzi listu guma.
 * Implementira interfejs Radnja.
 * 
 * @author Maja Colovic
 * @version 0.1
 *
 */
public class VulkanizerskaRadnja implements Radnja {

	/**
	 * Privatni atribut gume kao lista AutoGuma, koja je odmah i inicijalizovana.
	 */
	private LinkedList<AutoGuma> gume = new LinkedList<AutoGuma>();

	@Override
	public void dodajGumu(AutoGuma a) {
		if (a == null)
			throw new NullPointerException("Guma ne sme biti null");
		if (gume.contains(a))
			throw new RuntimeException("Guma vec postoji");
		gume.addFirst(a);
	}

	@Override
	public LinkedList<AutoGuma> pronadjiGumu(String markaModel) {
		if (markaModel == null)
			return null;
		LinkedList<AutoGuma> novaLista = new LinkedList<AutoGuma>();
		for (int i = 0; i < gume.size(); i++)
			if (gume.get(i).equals(markaModel))
				novaLista.add(gume.get(i));
		return novaLista;
	}

}
