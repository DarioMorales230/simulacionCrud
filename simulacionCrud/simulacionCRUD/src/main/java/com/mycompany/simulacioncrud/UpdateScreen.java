package com.mycompany.simulacioncrud;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UpdateScreen extends javax.swing.JInternalFrame {

    private JTable table;
    private ArrayList<Person> personList;

    public UpdateScreen(JFrame mainMenu) {
        setTitle("Actualizar Registro");
        setSize(400, 300);
        setClosable(true);
        setLayout(new BorderLayout());

        personList = new ArrayList<>();

        String[] columnNames = {"Nombre", "Apellido", "Cédula", "Teléfono", "Edad"};
        Object[][] data = {};
        table = new JTable(data, columnNames);

        JButton btnUpdate = new JButton("Actualizar");
        JButton btnBack = new JButton("Volver");
        btnBack.addActionListener(e -> {
            if (mainMenu instanceof MainMenu) {
                ((MainMenu) mainMenu).returnToMenu();
            }
        });

        btnUpdate.addActionListener(e -> updateData());
       

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(btnUpdate);
        bottomPanel.add(btnBack);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

    }

    private void updateTable(ArrayList<Person> list) {
        personList = list;
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

    private void updateData() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow >= 0) {
            Person person = personList.get(selectedRow);

            String newName = JOptionPane.showInputDialog(this, "Nuevo Nombre", person.getName());
            String newLastName = JOptionPane.showInputDialog(this, "Nuevo Apellido", person.getLastname());
            String newPhone = JOptionPane.showInputDialog(this, "Nuevo Teléfono", person.getPhone());

            person.setName(newName);
            person.setLastname(newLastName);
            person.setPhone(newPhone);

            updateTable(personList);
            JOptionPane.showMessageDialog(this, "Registro actualizado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro", "Error", JOptionPane.ERROR_MESSAGE);
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
