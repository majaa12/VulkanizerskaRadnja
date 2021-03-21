package auto_radnja.gume;

/**
 * Klasa koja predstavlja jednu automobilsku gumu.
 * 
 * Sadrzi atribute markaModel, precnik, sirinu i visinu koji opisuju tu gumu.
 * 
 * @author Maja Colovic
 * @version 0.1
 * 
 */
public class AutoGuma {

	/**
	 * Atribut markaModel kao String sa pocetnom vrednosti null.
	 */
	private String markaModel = null;
	
	/**
	 * Atribut precnik tipa int sa pocetnom vrednosti -1.
	 */
	private int precnik = -1;
	
	/**
	 * Atribut sirina tipa int sa pocetnom vrednosti -1.
	 */
	private int sirina = -1;
	
	/**
	 * Atribut visina tipa int sa pocetnom vrednosti -1.
	 */
	private int visina = -1;

	/**
	 * Konstruktor koji inicijalizuje objekat AutoGuma i nema parametre.
	 */
	public AutoGuma() {

	}

	/**
	 * Parametarski konstruktor koji inicijalizuje objekat AutoGuma i postavlja vrednosti za atribute
	 * markaModel, precnik, sirina i visina.
	 * 
	 * @param markaModel MarkaModel auto gume kao String.
	 * @param precnik Precnik auto gume kao int vrednost.
	 * @param sirina Sirina auto gume kao int vrednost.
	 * @param visina Visina auto gume kao int vrednost.
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	/**
	 * Vraca vrednost atributa markaModel.
	 * 
	 * @return markaModel kao String.
	 */
	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja vrednost atributa markaModel na novu zadatu vrednost.
	 * 
	 * @param markaModel MarkaModel auto gume kao String.
	 * 
	 * @throws java.lang.NullPointerException ako je uneta vrednost za markaModel null.
	 * @throws java.lang.RuntimeException ako uneta vrednost za markaModel ima manje od 3 znaka.
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new RuntimeException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	/**
	 * Vraca vrednost atributa precnik.
	 * 
	 * @return precnik gume kao int vrednost.
	 */
	public int getPrecnik() {
		return precnik;
	}

	/**
	 * Postavlja vrednost atributa precnik na novu zadatu int vrednost.
	 * 
	 * @param precnik Precnik auto gume kao int vrednost.
	 * 
	 * @throws java.lang.RuntimeException ako je uneta vrednost za precnik manja od 13 ili veca od 22
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 || precnik > 22)
			throw new RuntimeException("Precnik van opsega");
		this.precnik = precnik;
	}

	/**
	 * Vraca vrednost atributa sirina.
	 * 
	 * @return sirina gume kao int vrednost.
	 */
	public int getSirina() {
		return sirina;
	}

	/**
	 * Postavlja vrednost atributa sirina na novu zadatu int vrednost.
	 * 
	 * @param sirina Sirina auto gume kao int vrednost.
	 * 
	 * @throws java.lang.RuntimeException ako je uneta vrednost za sirinu manja od 135 ili veca od 355
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 || sirina > 355)
			throw new RuntimeException("Sirina van opsega");
		this.sirina = sirina;
	}

	/**
	 * Vraca vrednost atributa visina.
	 * 
	 * @return visina gume kao int vrednost.
	 */
	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja vrednost atributa visina na novu zadatu int vrednost.
	 * 
	 * @param visina Visina auto gume kao int vrednost.
	 * 
	 * @throws java.lang.RuntimeException ako je uneta vrednost za visinu manja od 25 ili veca od 95
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new RuntimeException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * Vraca string vrednost sa svim vrednostima atributa auto gume.
	 * 
	 * @return String sa podacima o auto gumi
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Poredi dve auto gume i vraca true ako su iste, a false ako nisu.
	 * Auto gume se porede po atributima markaModel, sirina, visina, precnik i svi oni moraju da budu isti.
	 * 
	 * @return
	 * <ul>
	 * 		<li>true ako su oba objekta klase AutoGuma i imaju iste vrednosti za iste atribute
	 * 		<li>false u svim ostalim slucajevima
	 * </ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AutoGuma other = (AutoGuma) obj;
		if (markaModel == null) {
			if (other.markaModel != null)
				return false;
		} else if (!markaModel.equals(other.markaModel))
			return false;
		if (precnik != other.precnik)
			return false;
		if (sirina != other.sirina)
			return false;
		if (visina != other.visina)
			return false;
		return true;
	}

}
