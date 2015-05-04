import java.net.*;

public class BazaDeCunostinte {
	
	private Reguli     reguliAuxiliare,reguliPrincipale;
	private Raspunsuri raspunsuriPosibile;
	
	public BazaDeCunostinte() {
		
		reguliAuxiliare      = new Reguli();
		reguliPrincipale     = new Reguli();
		raspunsuriPosibile   = new Raspunsuri();
	}
	
	public void initializeaza(URL url) throws AplicatieException {
		
		BazaDeCunostinteXML bdcXML = new BazaDeCunostinteXML();
		
		bdcXML.incarcaValori(url, raspunsuriPosibile, reguliAuxiliare, reguliPrincipale);
	
		/*
		
		System.out.println("Raspunsuri:");
		System.out.println();
		raspunsuriPosibile.afiseaza();
		System.out.println();
		
		System.out.println("Reguli auxiliare:");
		System.out.println();
		reguliAuxiliare.afiseaza();
		System.out.println();
		
		System.out.println("Reguli principale:");
		System.out.println();
		reguliPrincipale.afiseaza();
		System.out.println();
		
		*/
	}
	
	public void pornesteCautare(Aplicatie aplicatie) {
		
		Raspunsuri raspunsuriCunoscute  = new Raspunsuri();
		
		reguliPrincipale.verificaFrunza("facultate", raspunsuriPosibile, raspunsuriCunoscute, reguliAuxiliare, reguliPrincipale, aplicatie);
	}
	
}
