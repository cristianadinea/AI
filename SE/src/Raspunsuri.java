import java.util.*;

public class Raspunsuri {
	
	private Map<String, List<String>> mapare;
	
	public Raspunsuri() {
		
		mapare = new LinkedHashMap<String, List<String>>();
	}
	
	public void adaugaRaspuns(String nume, String valoare) {
		
		List<String> list = mapare.get(nume);
		
		if(list == null) {
			
			List<String> newList = new LinkedList<String>();
			
			newList.add(valoare);
			
			mapare.put(nume, newList);
		}
		else {
			
			if(!list.contains(valoare)) {
				
				list.add(valoare);
			}
		}
	}
	
	public String cautaRaspuns(String nume) {
		
		List<String> list = mapare.get(nume);
		
		if(list == null) {
			
			return null;
		}
		else {
				
			return list.get(0);
		}
	}	
	
	public Object[] preiaAlternative(String nume) {
		
		return mapare.get(nume).toArray();
	}
	
	public void afiseaza() {
	
		Set<String> keySet = mapare.keySet();
			
		Iterator<String> iterator = keySet.iterator();
	
		while(iterator.hasNext()) {
			
			String nume = iterator.next();
			
			System.out.println(nume);
			
			List<String> list = mapare.get(nume);
			
			System.out.print("\t");
			
			for(int i=0;i<list.size();i++) {
				
				System.out.print(list.get(i) + " ");
			}
			
			System.out.print("\n");
		}
	}
	
}
