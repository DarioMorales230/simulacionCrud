
package com.mycompany.simulacioncrud;


import java.awt.Component;
import javax.swing.*;


public class ValidationUtils {
    public static boolean validateFields(String name, String lastName, String cedula, String phone, String age, Component parent) {
        if (name.isEmpty() || lastName.isEmpty() || cedula.isEmpty() || phone.isEmpty() || age.isEmpty()) {
            JOptionPane.showMessageDialog(parent, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!name.matches("[a-zA-Z]+") || !lastName.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(parent, "Nombre y Apellido deben contener solo letras", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!cedula.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(parent, "La cédula debe tener 10 dígitos o contiene letras", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!phone.matches("\\d{10}")) {
            JOptionPane.showMessageDialog(parent, "El número de teléfono debe tener 10 dígitos o contiene letras", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!age.matches("\\d+")) {
            JOptionPane.showMessageDialog(parent, "La edad debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
}
