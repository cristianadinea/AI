public class NumeValoare {

	private String nume,valoare;
	
	public NumeValoare(String nume, String valoare) {
		
		this.nume    = nume;
		this.valoare = valoare;
	}

	public boolean verifica(Raspunsuri raspunsuriPosibile, Raspunsuri raspunsuriCunoscute, Reguli reguliAuxiliare, Reguli reguliPrincipale, Aplicatie aplicatie) throws AplicatieException {
		
		if(raspunsuriPosibile.cautaRaspuns(nume) == null) {
			
			if(reguliAuxiliare.verificaRegula(nume, valoare, raspunsuriPosibile, raspunsuriCunoscute, reguliAuxiliare, reguliPrincipale, aplicatie)) {
				
				return true;
			}
			
			if(reguliPrincipale.verificaRegula(nume, valoare, raspunsuriPosibile, raspunsuriCunoscute, reguliAuxiliare, reguliPrincipale, aplicatie)) { 
				
				return true;
			}
			
			return false;
		}
		else {
			
			String valoareCunoscuta = raspunsuriCunoscute.cautaRaspuns(nume);
			
			if(valoareCunoscuta != null) {
				
				if(valoareCunoscuta.equals(valoare)) {
					
					return true;
				}
				else {
					
					return false;
				}
			}
			else {
				
				String raspuns = aplicatie.intreaba(nume, raspunsuriPosibile.preiaAlternative(nume));
				
				if(raspuns != null) {
					
					raspunsuriCunoscute.adaugaRaspuns(nume, raspuns);
				
					if(raspuns.equals(valoare)) {
					
						return true;
					}
					else {
						
						return false;
					}
				}
				else {
				
					throw new AplicatieException("Executie oprita.");
				}
			}
		}
	}
	
	public String toString() {
		
		return this.nume+"(" + this.valoare + ")";
	}
	
}
