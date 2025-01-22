package com.mycompany.simulacioncrud;

import javax.swing.*;

public class MainMenu extends JFrame {

    // Constructor del Menú Principal
    public MainMenu() {
        // Configuración de la ventana principal
        setTitle("Menú Principal");
        setSize(500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Creación de botones para navegar a las pantallas CRUD
        JButton btnCreate = new JButton("Crear");
        JButton btnRead = new JButton("Leer");
        JButton btnUpdate = new JButton("Actualizar");
        JButton btnDelete = new JButton("Eliminar");

        // Configuración de ubicacion y tamaño de los botones
        btnCreate.setBounds(160, 100, 120, 50);
        btnRead.setBounds(160, 180, 120, 50);
        btnUpdate.setBounds(160, 260, 120, 50);
        btnDelete.setBounds(160, 340, 120, 50);
        
        
        /* agregamos la funcionalida a os botones para 
        que abra las ventanos corespondientes.
       */
        
        btnCreate.addActionListener(e -> openInternalJframe(new CreateScreen(this)));
        btnRead.addActionListener(e -> openInternalJframe(new ReadScreen(this)));
        
        // Agregar los botones a la ventana principal
        add(btnCreate);
        add(btnRead);
        add(btnUpdate);
        add(btnDelete);

    }
    
    // metodo para abrir un JinternalFrame dentro del JFrame principal
    
    private void openInternalJframe(JInternalFrame frame){
        JDesktopPane desktopPane = new JDesktopPane();
        //nos ayuda a configurar el contenido del JFrame para incluir el JDesktopPnae
        setContentPane(desktopPane);
        //agrega elJInternalFrame al JDesktopPane
        desktopPane.add(frame);
        // nos ayuda a que este visible el Jinternalframe
        frame.setVisible(true);
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
        new MainMenu().setVisible(true); // Crea una instancia del Menú Principal y lo hace visible
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
