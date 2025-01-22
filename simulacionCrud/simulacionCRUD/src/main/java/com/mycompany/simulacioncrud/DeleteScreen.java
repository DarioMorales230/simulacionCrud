package com.mycompany.simulacioncrud;

import javax.swing.*;
import java.awt.*;

public class DeleteScreen extends JInternalFrame {

    private JTable table;

    public DeleteScreen(JFrame mainMenu) {
        setTitle("Eliminar Registro");
        setSize(400, 300);
        setClosable(true);
        setLayout(new BorderLayout());

        String[] columnNames = {"Nombre", "Apellido", "Cédula", "Teléfono", "Edad"};
        table = new JTable(new Object[0][0], columnNames);

        JButton btnDelete = new JButton("Eliminar");
        JButton btnBack = new JButton("Volver");
        btnBack.addActionListener(e -> {
            if (mainMenu instanceof MainMenu) {
                ((MainMenu) mainMenu).returnToMenu();
            }
        });

        btnDelete.addActionListener(e -> deleteData());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnDelete);
        bottomPanel.add(btnBack);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
         // Cargar los datos iniciales desde DataRepository
        updateTable(DataRepository.getPersonList());

    }

    public void updateTable(java.util.List<Person> list) {
        Object[][] data = new Object[list.size()][5];

        for (int i = 0; i < list.size(); i++) {
            Person p = list.get(i);
            data[i][0] = p.getName();
            data[i][1] = p.getLastname();
            data[i][2] = p.getCedula();
            data[i][3] = p.getPhone();
            data[i][4] = p.getAge();
        }

        table.setModel(new javax.swing.table.DefaultTableModel(data, new String[]{"Nombre", "Apellido", "Cédula", "Teléfono", "Edad"}));
    }

    private void deleteData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este registro?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                DataRepository.deletePerson(selectedRow);
                updateTable(DataRepository.getPersonList());
                JOptionPane.showMessageDialog(this, "Registro eliminado correctamente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un registro para eliminar.");
        }

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
