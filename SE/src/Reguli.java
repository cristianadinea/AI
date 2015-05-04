import java.util.*;

public class Reguli {

	private Map<String, Map<String,List<List<NumeValoare>>>> mapare;
	
	public Reguli() {
		
		mapare = new LinkedHashMap<String,Map<String,List<List<NumeValoare>>>>(); 
	}
	
	public void adaugaRegula(String element, String elementName, List<NumeValoare> listaNumeValoare) {
		
		Map<String, List<List<NumeValoare>>> map = mapare.get(element);
		
		if(map == null) {
			
			List<List<NumeValoare>> newList = new LinkedList<List<NumeValoare>>();
			newList.add(listaNumeValoare);
			
			Map<String, List<List<NumeValoare>>> newMap = new LinkedHashMap<String, List<List<NumeValoare>>>();
			newMap.put(elementName, newList);
			
			mapare.put(element,newMap);
		}
		else {
			
			List<List<NumeValoare>> list = map.get(elementName);
			
			if(list == null) {
				
				List<List<NumeValoare>> newList = new LinkedList<List<NumeValoare>>();
				newList.add(listaNumeValoare);
				
				map.put(elementName, newList);
			}
			else {
				
				list.add(listaNumeValoare);
			}
		}
	}

	public void verificaFrunza(String nume, Raspunsuri raspunsuriPosibile, Raspunsuri raspunsuriCunoscute, Reguli reguliAuxiliare, Reguli reguliPrincipale, Aplicatie aplicatie) {
		
		Map<String, List<List<NumeValoare>>> map = mapare.get(nume);
		
		if(map == null) {
			
			aplicatie.afisareMesaj("Nu exista facultate potrivita la nivelul bazei de cunostiinte.");
		} 
		else {
			
			Set<String> keySet = map.keySet();
			
			Iterator<String> iterator = keySet.iterator();
		
			while(iterator.hasNext()) {
				
				String valoare = iterator.next();
				
				List<List<NumeValoare>> list1 = map.get(valoare);
				
				try {
					
					if (verificaPartiDrepte(list1, raspunsuriPosibile, raspunsuriCunoscute, reguliAuxiliare, reguliPrincipale, aplicatie)) {
						
						aplicatie.afisareMesaj("Facultatea potrivita: " + valoare);
						
						return;
					}
				} 
				catch (AplicatieException e) {
				
					aplicatie.afisareMesaj(e.getMessage());
					
					return;
				}
			}
			
			aplicatie.afisareMesaj("Nu exista facultate potrivita la nivelul bazei de cunostiinte.");
		}
	}
	
	public boolean verificaRegula(String nume, String valoare, Raspunsuri raspunsuriPosibile, Raspunsuri raspunsuriCunoscute, Reguli reguliAuxiliare, Reguli reguliPrincipale, Aplicatie aplicatie) throws AplicatieException {
		
		Map<String, List<List<NumeValoare>>> map = mapare.get(nume);
		
		if(map == null) {
			
			return false;
		}
		else {
			
			List<List<NumeValoare>> list1 = map.get(valoare);
			
			if(list1 == null) {
				
				return false;
			}
			else {
			
				return verificaPartiDrepte(list1, raspunsuriPosibile, raspunsuriCunoscute, reguliAuxiliare, reguliPrincipale, aplicatie);
			}
		}
	}
	
	private boolean verificaPartiDrepte(List<List<NumeValoare>> list1, Raspunsuri raspunsuriPosibile, Raspunsuri raspunsuriCunoscute, Reguli reguliAuxiliare, Reguli reguliPrincipale, Aplicatie aplicatie) throws AplicatieException {
		
		int verifica;
		
		for(int i=0;i<list1.size();i++) {
			
			verifica = 0;
			
			List<NumeValoare> list2 = list1.get(i);
			
			for(int j=0;j<list2.size();j++) {
				
				NumeValoare numeValoare = list2.get(j);

				if(!numeValoare.verifica(raspunsuriPosibile, raspunsuriCunoscute, reguliAuxiliare, reguliPrincipale, aplicatie)) {
					
					break;
				}
				
				verifica++;
			}
			
			if(verifica == list2.size()) {
				
				return true;
			}
		}
		
		return false;
	}

	public void afiseaza() {
		
		Set<String> keySet1 = mapare.keySet();
		
		Iterator<String> iterator1 = keySet1.iterator();
		
		while(iterator1.hasNext()) {
			
			String element = iterator1.next();
			
			Map<String,List<List<NumeValoare>>> map = mapare.get(element);
			
			Set<String> keySet2 = map.keySet();
			
			Iterator<String> iterator2 = keySet2.iterator();
			
			while(iterator2.hasNext()) {
				
				String elementName = iterator2.next();
				
				System.out.println(element + "(" + elementName + ")");

				List<List<NumeValoare>> list1 = map.get(elementName);
				
				for(int i=0;i<list1.size();i++) {
						
					List<NumeValoare> list2 = list1.get(i);
					
					System.out.print("\t");
					
					for(int j=0;j<list2.size();j++) {
						
						NumeValoare nv = list2.get(j);
						
						System.out.print(nv + " ");
					}
					
					System.out.print("\n");
				}
			}
		}
	}
	
}
