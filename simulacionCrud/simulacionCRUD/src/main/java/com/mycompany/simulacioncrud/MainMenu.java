package com.mycompany.simulacioncrud;

import javax.swing.*;

public class MainMenu extends JFrame {

    // Constructor del Menú Principal
    public MainMenu() {
        // Configuración de la ventana principal
        setTitle("Menú Principal");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Creación de botones para navegar a las pantallas CRUD
        JButton btnCreate = new JButton("Crear");
        JButton btnRead = new JButton("Leer");
        JButton btnUpdate = new JButton("Actualizar");
        JButton btnDelete = new JButton("Eliminar");

        // Configuración de posición y tamaño de los botones
        btnCreate.setBounds(140, 30, 120, 30);
        btnRead.setBounds(140, 80, 120, 30);
        btnUpdate.setBounds(140, 130, 120, 30);
        btnDelete.setBounds(140, 180, 120, 30);

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
