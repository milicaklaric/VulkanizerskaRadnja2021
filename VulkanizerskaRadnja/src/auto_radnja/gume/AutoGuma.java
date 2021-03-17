package auto_radnja.gume;

/**
 * Klasa koja predstavlja auto gumu
 * 
 * Za svaku gumu sistem pamti marku i model, preènik, širinu i visinu
 * 
 * @author MK
 *
 */
public class AutoGuma {

	/**
	 * Marka i model gume kao String
	 */
	private String markaModel = null;
	
	/**
	 * Preènik gume kao ceo broj
	 */
	private int precnik = -1;
	/**
	 * Širina gume kao ceo broj
	 */
	private int sirina = -1;
	/**
	 * Visina gume kao ceo broj
	 */
	private int visina = -1;

	
	/**
	 * Konstruktor koji inicijalizuje objekat parametrima postavljenim na default vrednosti
	 */
	public AutoGuma() {
		
	}

	/**
	 * Parametarski konstruktor koji inicijalizuje objekat i postavlja vrednosti svih parametara
	 * 
	 * @param markaModel Marka i model gume kao string
	 * @param precnik Preènik gume kao ceo broj
	 * @param sirina Širina gume kao ceo broj
	 * @param visina Visina gume kao ceo broj
	 */
	public AutoGuma(String markaModel, int precnik, int sirina, int visina) {
		super();
		setMarkaModel(markaModel);
		setPrecnik(precnik);
		setSirina(sirina);
		setVisina(visina);
	}

	public String getMarkaModel() {
		return markaModel;
	}

	/**
	 * Postavlja marku i model gume na zadatu vrednost
	 * 
	 * @param markaModel Marka i model gume kao string
	 * 
	 * @throws java.lang.NullPointerException ukoliko je prosleðena vrednos za marku i model null
	 * @throws java.lang.RuntimeException ukoliko uneta marka ima manje od 3 karaktera
	 */
	public void setMarkaModel(String markaModel) {
		if (markaModel == null)
			throw new NullPointerException("Morate uneti marku i model");
		if (markaModel.length() < 3)
			throw new RuntimeException("Marka i model moraju sadrzati bar 3 znaka");
		this.markaModel = markaModel;
	}

	public int getPrecnik() {
		return precnik;
	}

	
	/**
	 * Postavlja preènik gume na novu vrednost
	 * 
	 * @param precnik Preènik gume kao ceo broj
	 * 
	 * @throws java.lang.RuntimeException ukoliko je uneti preènik manji od 13 ili veæi od 22
	 */
	public void setPrecnik(int precnik) {
		if (precnik < 13 && precnik > 22)
			throw new RuntimeException("Precnik van opsega");
		this.precnik = precnik;
	}

	public int getSirina() {
		return sirina;
	}

	
	/**
	 * Postavlja širinu gume na novu vrednost
	 * 
	 * @param sirina Širina gume kao ceo broj
	 * 
	 * @throws java.lang.RuntimeException ukoliko je uneta širina manja od 135 ili veæa od 355
	 */
	public void setSirina(int sirina) {
		if (sirina < 135 && sirina > 355)
			throw new RuntimeException("Sirina van opsega");
		this.sirina = sirina;
	}

	public int getVisina() {
		return visina;
	}

	/**
	 * Postavlja visinu gume na novu vrednost
	 * 
	 * @param visina Visina gume kao ceo broj
	 * 
	 * @throws java.lang.RuntimeException ukoliko je uneta visina manja od 25 ili veæa od 95
	 */
	public void setVisina(int visina) {
		if (visina < 25 || visina > 95)
			throw new RuntimeException("Visina van opsega");
		this.visina = visina;
	}

	/**
	 * @return Vraæa string sa svim podacima o gumi
	 */
	@Override
	public String toString() {
		return "AutoGuma [markaModel=" + markaModel + ", precnik=" + precnik + ", sirina=" + sirina + ", visina="
				+ visina + "]";
	}

	/**
	 * Poredi dva objekata klase AutoGuma i vraca TRUE ako su isti i FALSE ako nisu.
	 * 
	 * Gume se porede po vrednostima svih parametara
	 * 
	 * @return 
	 * <ul>
	 * 		<li>true ako su oba objekta klase AutoGuma i vrednosti svih parametara su jednake</li>
	 * 		<li>false u svim ostalim slucajevima</li>
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
