import java.io.StreamTokenizer;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;

public class TokenAnalyser {
	private StreamTokenizer st;
	ArrayList<LigneC> commande = new ArrayList<>();
	LigneC ligne;
	public ArrayList<LigneC> TokenAnalyse(String s){
		try{
			st=new StreamTokenizer(new StringReader(s));
			int type;
			while ((type = st.nextToken()) != StreamTokenizer.TT_EOF) {
				
				switch (type) {
				case StreamTokenizer.TT_NUMBER:
					System.out.println(st.nval);
					break;
				case StreamTokenizer.TT_WORD:
					System.out.println(st.sval);
					break;
				}
				commande.add(ligne = new LigneC(st.sval,st.nval+""));
			}
		}

		catch (Exception E){

		}
		return commande;
	}
	
}
