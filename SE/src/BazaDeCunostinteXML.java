import java.net.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class BazaDeCunostinteXML {

    public void incarcaValori(URL url,Raspunsuri raspunsuriPosibile,Reguli reguliAuxiliare,Reguli reguliPrincipale) throws AplicatieException {
    	
        Document document = incarcaXML(url + "BazaDeCunostinte.xml");
        
        traverseazaDocument(document, raspunsuriPosibile, reguliAuxiliare, reguliPrincipale);
    }

    private Document incarcaXML(String path) throws AplicatieException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    
        try {
        
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            Document document = builder.parse(path);
            
            return document;
        } 
        catch (Exception e) {
        
        	throw new AplicatieException("Eroare la citirea bazei de cunostinte.");
        }
    }

    private void traverseazaDocument(Document document, Raspunsuri raspunsuriPosibile, Reguli reguliAuxiliare, Reguli reguliPrincipale) throws AplicatieException {

        Element root = document.getDocumentElement();
        
        if(root.getTagName().equals("baza_de_cunostinte")) {
        	
        	NodeList nl;
        	Element reguli;
        	int length;
        	
        	nl = root.getElementsByTagName("reguli_auxiliare");
        	
        	length  = nl.getLength();
        	
        	if(length > 1) {
        		
        		throw new AplicatieException("Nu ete respectata structura impusa pentru baza de cunostiinte.");
        	}
        		
        	if(length == 1) {
        		
        		reguli = (Element)nl.item(0);
        		
        		adaugaReguli(reguli, raspunsuriPosibile, reguliAuxiliare);
        	}
        	
        	nl = root.getElementsByTagName("reguli_principale");
        	
        	length  = nl.getLength();
        	
        	if(length > 1) {
        		
        		throw new AplicatieException("Nu ete respectata structura impusa pentru baza de cunostiinte.");
        	}
        		
        	if(length == 1) {
        		
        		reguli = (Element)nl.item(0);
        		
        		adaugaReguli(reguli, raspunsuriPosibile, reguliPrincipale);
        	}
        	else {
        	
        		throw new AplicatieException("Nu ete respectata structura impusa pentru baza de cunostiinte.");
        	}
        }
        else {
        	
        	throw new AplicatieException("Nu ete respectata structura impusa pentru baza de cunostiinte.");
        }
    }

	private void adaugaReguli(Element reg, Raspunsuri raspunsuriPosibile, Reguli reguli) throws AplicatieException {
			
		NodeList nl = reg.getChildNodes();
		
	    for (int i = 0; i < nl.getLength(); i++) {
	    
	    	if(nl.item(i).getNodeType() == Node.ELEMENT_NODE){
	    	
	    		Element e1 = (Element) nl.item(i);
	    	    	    		
	    		String element     = e1.getTagName();
	    		
	    		if(!e1.hasAttribute("nume")) {
	    			
	    			throw new AplicatieException("Nu ete respectata structura impusa pentru baza de cunostiinte.");
	    		}
	    		
	    		String elementName = e1.getAttribute("nume");
	    		
	    		List<NumeValoare> listaNumeValoare = new LinkedList<NumeValoare>();
	    		
	    		NodeList nl2 = e1.getChildNodes();
	    		
	    		for (int j = 0; j < nl2.getLength(); j++) {
	                 
	    			if(nl2.item(j).getNodeType() == Node.ELEMENT_NODE){
	             	
	    				Element e2 = (Element) nl2.item(j);
	             	                  
	    				String tagName = e2.getTagName();
	    				
	    				NumeValoare numeValoare;
	    				
	    				if(tagName.equals("atribut")) {
	    					
	    					if(!e2.hasAttribute("nume") || !e2.hasAttribute("nume")) {
	    		    			
	    		    			throw new AplicatieException("Nu ete respectata structura impusa pentru baza de cunostiinte.");
	    		    		}
	    					
	    					String nume    = e2.getAttribute("nume");
	    					String valoare = e2.getAttribute("valoare"); 
	    						    					
	    					numeValoare = new NumeValoare(nume, valoare);
	    					
	    					if(valoare.equals("da") || valoare.equals("nu")) {
	    						
	    						raspunsuriPosibile.adaugaRaspuns(nume, "nu");
	    						raspunsuriPosibile.adaugaRaspuns(nume, "da");
	    					}
	    					
	    					raspunsuriPosibile.adaugaRaspuns(nume, valoare);
	    				}
	    				else {
	    					
	    					if(!e2.hasAttribute("nume")) {
	    		    			
	    		    			throw new AplicatieException("Nu ete respectata structura impusa pentru baza de cunostiinte.");
	    		    		}
	    					
	    					String nume    = e2.getAttribute("nume");
	    					
	    					numeValoare = new NumeValoare(tagName, nume);
	    				}
	    				
	    				listaNumeValoare.add(numeValoare);
	    			}
	    		}
	    		
	    		reguli.adaugaRegula(element, elementName, listaNumeValoare);
	    	}
	    }
	}
	
}