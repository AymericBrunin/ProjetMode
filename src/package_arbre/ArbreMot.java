package package_arbre;

import package_vue.Visiteur;

public abstract class ArbreMot {
	/**
	 * Methode Ajout d'un Arbre Mot
	 * @param AM
	 */
	public abstract void add(ArbreMot arbreMot);
	/**
	 * Methode Execution pour chaque ArbreMot
	 */
	public abstract void executer();
	
	public abstract void accept(Visiteur v);
}
