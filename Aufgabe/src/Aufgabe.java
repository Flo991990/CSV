import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class Aufgabe{
	
	public static List<List<String>> zeilen = new ArrayList<>();
	
	public static void main(String[] args) {
		
		//beliebige CSV einlsen
		
		JFileChooser chooser = new JFileChooser();
		String pfad = "";
		String addZeile = null;
		int auswahl = chooser.showOpenDialog(null);
		
	
		
		if(auswahl == JFileChooser.APPROVE_OPTION) {
			pfad = chooser.getSelectedFile().getAbsolutePath();
			System.out.println("Der Dateipfad ist " + pfad);
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(pfad));
			/*while((line = br.readLine()) != null) {
				String[] werte = line.split(";");
				System.out.println(werte[0]);				
			}*/
			while ((addZeile = br.readLine()) != null) { //csv von Zeile zu Zeile lesen 
				String[] dataLine = addZeile.split(";"); //Zeilen nach Semikolon trennen
				zeilen.add(Arrays.asList(dataLine));     //aufgetrennte Zeilen in Arrayliste schreiben
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			Logger.getLogger(Aufgabe.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		Tabelle2.erzeugeTabelle();
		System.out.println("Liste: " + zeilen.get(0));
	}
}