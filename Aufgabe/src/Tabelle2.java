import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Tabelle2 extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void erzeugeTabelle() {
        Tabelle2 testJFrame = new Tabelle2();

        List<List<String>> tabellenWerte = Aufgabe.zeilen;
        List<String> headstring = tabellenWerte.get(0);

  
        /*for (int i = 0; i < 100; i++) {
            values.add(new String[] {"val"+i+" col1","val"+i+" col2","val"+i+" col3"});
        }*/
        
        int counter = 1;
        List<String[]> inhalt = new ArrayList<String[]>();
        
        for(int i = 0; i < 100; i++) {        	
        
         String listString = String.join(",", tabellenWerte.get(counter));
   	 	System.out.println(listString);
       
               
        inhalt.add(new String[] {listString});
        counter++;
        }

        TableModel tableModel = new DefaultTableModel(inhalt.toArray(new Object[][] {}), headstring.toArray());
        JTable table = new JTable(tableModel);
        testJFrame.setLayout(new BorderLayout());
        testJFrame.add(new JScrollPane(table), BorderLayout.CENTER);

        testJFrame.add(table.getTableHeader(), BorderLayout.NORTH);

        testJFrame.setVisible(true);
        testJFrame.setSize(1600,1200);
    }

}