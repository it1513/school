/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ml
 */
public class test extends javax.swing.JDialog {
    private String actionButton = "Storno";
    private final DefaultTableModel model;
    private Connection spojeni;
    
    

    
    public test(java.awt.Frame parent, boolean modal, String[] slova) {
        super(parent, modal);
        initComponents();
        tabulka.setModel(new javax.swing.table.DefaultTableModel(
                /* Dvourozměrné pole objektů */
                new Object[][]{
                    {null, null, null}
                },
                /* Označení záhlaví sloupců - pole typu String */
                new String[]{
                    "Čeština", "Angličtina","Slovní druh"
                }
        ) {
            /* Definování datových typů pro jednotlivé sloupce */
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class,java.lang.String.class
            };

            /* Metoda vrací datový typ určitého sloupce */
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            /* Vrací informaci, zda je možné buňku editovat */
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        });
        model = (DefaultTableModel) tabulka.getModel();
        
        this.dbConnection();
        this.listData(this.getAllRecords());
        
        
    }
    
    private void listData(ResultSet data) {
        /* Cyklus provede odstranění všech řádků tabulky */
        for (int i = tabulka.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        try {
            /* Cyklus přidává datové řady do tabulky; dokud data.next() nevrátí false (protože už neexistuje žádný další záznam)  */
            while (data.next()) {
                int id = data.getInt(1);
                String cesky = data.getString("cs");
                String anglicky = data.getString("en");
                String slovni_druh = data.getString("slovni_druh");
                /* Přidávaný řádek je objektem, který tvoří hodnoty pro jednotlivé sloupce tabulky */
                model.addRow(new Object[]{cesky /*, anglicky,slovni_druh*/});
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Chyba při komunikaci s databází", "Chyba", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private ResultSet getAllRecords() {
        ResultSet vysledky = null;
        try {
            /* Připravený SQL dotaz */
            PreparedStatement dotaz = this.spojeni.prepareStatement("SELECT * FROM slovnicek ORDER BY RAND() LIMIT 10");
            /* Provedení dotazu a předání výsledků */
            vysledky = dotaz.executeQuery();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Chyba při komunikaci s databází", "Chyba", JOptionPane.ERROR_MESSAGE);
        }
        return vysledky;
    }
    
    private void dbConnection() {
        try {
            /* Připojení k MySQL zajišťuje statická metody getConnection třídy DriveManager
               Parametry metody getConnection jsou adresa MySQL serveru (včetně určení databáze a kódování) + přístupové údaje (uživatel, heslo)
               Po přetypování (Connection) je spojení uloženo do atributu spojeni
             */
            this.spojeni = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/slovnik?useUnicode=true&characterEncoding=utf-8", "root", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Nedošlo k připojení databáze", "Chyba", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    /**
     *
     * @return
     */
    public String showDialog() {
        /* Zviditelní dialogové okno */
        this.setVisible(true);
        /* Vrací název stisnutého tlačítka */
        return actionButton; 
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        odejit = new javax.swing.JButton();
        check = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabulka = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        odejit.setText("ODEJÍT");
        odejit.setToolTipText("");
        odejit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odejitActionPerformed(evt);
            }
        });

        check.setText("KONTROLA");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        tabulka.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "cs", "en", "slovni_druh"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabulka.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tabulkaFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tabulka);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(check)
                        .addGap(18, 18, 18)
                        .addComponent(odejit, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(check)
                    .addComponent(odejit))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
       actionButton = "OK";
       /* Uvolní objekt formuláře z paměti */
       this.dispose();
    }//GEN-LAST:event_checkActionPerformed

    private void odejitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odejitActionPerformed
       actionButton = "Storno";
       this.dispose();
    }//GEN-LAST:event_odejitActionPerformed

    private void tabulkaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tabulkaFocusGained

    }//GEN-LAST:event_tabulkaFocusGained

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton check;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton odejit;
    private javax.swing.JTable tabulka;
    // End of variables declaration//GEN-END:variables
}
