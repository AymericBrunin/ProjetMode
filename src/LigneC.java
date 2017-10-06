
public class LigneC {
	public String action;
	public String val;
	public String val2;
	
	/**
	 * Constructeur d'une ligne de commande avec 1 parametre
	 * @param ac
	 */
	public LigneC(String ac){
		this.action = ac;
	}
	
	/**
	 *  Constructeur d'une ligne de commande avec 2 parametres
	 * @param ac
	 * @param val
	 */
	public LigneC(String ac, String val){
		this.action = ac;
		this.val = val;
	}
	/**
	 *  Constructeur d'une ligne de commande avec 3 parametres
	 * @param ac
	 * @param val
	 * @param val2
	 */
	public LigneC(String ac, String val, String val2){
		this.action = ac;
		this.val = val;
		this.val2 = val2;
	}
}
