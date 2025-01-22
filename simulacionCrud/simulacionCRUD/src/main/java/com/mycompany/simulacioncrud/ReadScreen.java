
package com.mycompany.simulacioncrud;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ReadScreen extends JInternalFrame {
    
    private JTable table;
    


    /**
     * Creates new form ReadScreen
     */
    public ReadScreen(JFrame mainMenu) {
        
       setTitle("Leer Registros");
        setSize(400, 300);
        setClosable(true);
        setLayout(new BorderLayout());

        

        String[] columnNames = {"Nombre", "Apellido", "Cédula", "Teléfono", "Edad"};
        Object[][] data = {};
        table = new JTable(data, columnNames);

        JButton btnBack = new JButton("Volver");
        btnBack.addActionListener(e -> {
            if (mainMenu instanceof MainMenu) {
                ((MainMenu) mainMenu).returnToMenu();
            }
        });


        add(new JScrollPane(table), BorderLayout.CENTER);
        add(btnBack, BorderLayout.SOUTH);
       
    }
    public void updateTable() {
        ArrayList<Person> personList = DataRepository.getPersonList();
        Object[][] data = new Object[personList.size()][5];

        for (int i = 0; i < personList.size(); i++) {
            Person p = personList.get(i);
            data[i][0] = p.getName();
            data[i][1] = p.getLastname();
            data[i][2] = p.getCedula();
            data[i][3] = p.getPhone();
            data[i][4] = p.getAge();
        }

        table.setModel(new javax.swing.table.DefaultTableModel(data, new String[]{"Nombre", "Apellido", "Cédula", "Teléfono", "Edad"}));
    }

    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 394, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 274, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
