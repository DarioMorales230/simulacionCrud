/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.simulacioncrud;

import javax.swing.*;
import java.awt.*;


public class CreateScreen extends JInternalFrame {

    // Creamos los campos y la estructura que se utilizara para alamcenar los datos
    private JTextField txtName, txtLastName, txtCedula, txtPhone, txtAge;
    private ReadScreen readScreen; // Referencia a ReadScreen
    

    /**
     * Creates new form CreateScreen
     */
    public CreateScreen(JFrame mainMenu, ReadScreen readScreen) {
        
         this.readScreen = readScreen; // Asignar la instancia de ReadScreen
        // configuracion del JInternalFrameForm

        setTitle("Crear Usuario");
        setSize(400, 500);
        setClosable(true); // nos permite cerrar la ventana
        setLayout(new GridLayout(8, 2)); // Organiza componentes en una cuadricua

        // etiquetas y campos de entrada pra los datos
        JLabel lblName = new JLabel("Nombre");
        JLabel lblLastName = new JLabel("Apellido");
        JLabel lblCedula = new JLabel("Cedula");
        JLabel lblPhone = new JLabel("Telefono");
        JLabel lblAge = new JLabel("Edad");

        txtName = new JTextField();
        txtLastName = new JTextField();
        txtCedula = new JTextField();
        txtPhone = new JTextField();
        txtAge = new JTextField();

        JButton btnSave = new JButton("Guardar"); // bootn para guardar los datos
        JButton btnBack = new JButton("Volver"); // Botón para volver al menú principal

        // Agregar componentes al formulario
        add(lblName);
        add(txtName);
        add(lblLastName);
        add(txtLastName);
        add(lblCedula);
        add(txtCedula);
        add(lblPhone);
        add(txtPhone);
        add(lblAge);
        add(txtAge);
        add(new JLabel());
        add(btnSave);
        add(btnSave);
        add(btnBack);

        

        // funcion del boton guardar
        btnSave.addActionListener(e -> saveData());

        // funcionamiento del boton volver
        btnBack.addActionListener(e -> {
            if (mainMenu instanceof MainMenu) {
                ((MainMenu) mainMenu).returnToMenu();
            }
        });

    }
    //metodo para guardar los datos

    private void saveData() {
        String Name = txtName.getText();
        String LastName = txtLastName.getText();
        String Cedula = txtCedula.getText();
        String Phone = txtPhone.getText();
        String Age = txtAge.getText();

        // validaciones para el ingreso de datos 
        if (Name.isEmpty() || LastName.isEmpty() || Cedula.isEmpty() || Age.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Name.matches("[a-zA-Z]+") || !LastName.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "Nombre y Apellido deben contener solo letras", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Cedula.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(this, "La cédula debe tener 10 dígitos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!Age.matches("\\d+")) {
            JOptionPane.showMessageDialog(this, "La edad debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Conversión y almacenamiento de datos
        int age = Integer.parseInt(Age);
        DataRepository.addPerson(new Person(Name, LastName, Cedula, Phone, age));
        JOptionPane.showMessageDialog(this, "Registro agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        
        

        clearFields(); // Limpia los campos después de guardar
    }

    private void clearFields() {
        txtName.setText("");
        txtLastName.setText("");
        txtCedula.setText("");
        txtPhone.setText("");
        txtAge.setText("");

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
