/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package usuarios.vistas;

import java.awt.Dialog;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import usuarios.modelos.GestorUsuarios;
import usuarios.modelos.ModeloComboPerfil;
import usuarios.modelos.Perfil;
import usuarios.modelos.Usuario;

/**
 *
 * @author tomascabrerabellomo
 */
public class VentanaAMUsuario extends javax.swing.JDialog {
 GestorUsuarios gestor = GestorUsuarios.instanciar();

    /**
     * Creates new form VentanaAMUsuario
     */
    public VentanaAMUsuario(Dialog ventanaPadre) {
        super(ventanaPadre, true);
        initComponents();
        setVisible(true);
        this.configurarperfil();
        this.setLocationRelativeTo(null);
        this.setTitle("Nuevo producto");

        
    }
    private void configurarperfil(){
        ModeloComboPerfil modelo = new ModeloComboPerfil();
        this.comboPerfil.setModel(modelo);
        
    }
    public JTextField verCorreo(){
        return this.txtcorreo;
    }
    public JTextField verApellido(){
        return this.txtapellido;
    }
    public JTextField verNombre(){
        return this.txtnombre;
    }
    public JPasswordField verClave(){
        return this.clave;
    }
    public JPasswordField verClaveRepetida(){
        return this.claverepetida;
      }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField9 = new javax.swing.JTextField();
        correo = new javax.swing.JLabel();
        apellido = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        clavenombre = new javax.swing.JLabel();
        claverepetidanombre = new javax.swing.JLabel();
        Perfil = new javax.swing.JLabel();
        Aceptar_boton = new javax.swing.JButton();
        boton_cancelar = new javax.swing.JButton();
        comboPerfil = new javax.swing.JComboBox<>();
        txtcorreo = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        claverepetida = new javax.swing.JPasswordField();
        clave = new javax.swing.JPasswordField();

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        correo.setText("Correo");

        apellido.setText("Apellido");

        nombre.setText("Nombre");

        clavenombre.setText("Clave");

        claverepetidanombre.setText("Clave Repetida");

        Perfil.setText("Perfil");

        Aceptar_boton.setText("Aceptar");
        Aceptar_boton.setActionCommand("");
        Aceptar_boton.setName(""); // NOI18N
        Aceptar_boton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar_botonActionPerformed(evt);
            }
        });

        boton_cancelar.setText("Cancelar");
        boton_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_cancelarActionPerformed(evt);
            }
        });

        comboPerfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Encargado", "Cliente", "Empleado" }));
        comboPerfil.setToolTipText("Elija el perfil del usuario");
        comboPerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        comboPerfil.setDoubleBuffered(true);
        comboPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPerfilActionPerformed(evt);
            }
        });

        txtcorreo.setToolTipText("escriba el correo del usuario");

        txtnombre.setToolTipText("escriba el nombre del usuario");
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        txtapellido.setToolTipText("escriba el apellido del usuario");
        txtapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoActionPerformed(evt);
            }
        });

        claverepetida.setText("jPasswordField1");
        claverepetida.setToolTipText("escriba la clave repetida");

        clave.setText("jPasswordField1");
        clave.setToolTipText("escriba la clave");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(claverepetidanombre)
                    .addComponent(clavenombre)
                    .addComponent(nombre)
                    .addComponent(correo)
                    .addComponent(apellido)
                    .addComponent(Perfil))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboPerfil, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcorreo)
                    .addComponent(txtnombre)
                    .addComponent(txtapellido, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                    .addComponent(claverepetida)
                    .addComponent(clave, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Aceptar_boton)
                .addGap(18, 18, 18)
                .addComponent(boton_cancelar)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(correo)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apellido)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clavenombre)
                    .addComponent(clave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(claverepetidanombre)
                    .addComponent(claverepetida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Perfil)
                    .addComponent(comboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_cancelar)
                    .addComponent(Aceptar_boton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Aceptar_botonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar_botonActionPerformed
        String correo = this.txtcorreo.getText().trim();
        String apellido = this.txtapellido.getText().trim();
        String nombre = this.txtnombre.getText().trim();
        char[] clave = this.clave.getPassword();
        char[] claveRep = this.claverepetida.getPassword();
        
        Perfil perfil = ((ModeloComboPerfil)this.comboPerfil.getModel()).obtenerPerfil();
        
        System.out.println(gestor.crearUsuario(correo, apellido, nombre, perfil, new String(clave), new String(claveRep)));
    }//GEN-LAST:event_Aceptar_botonActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombreActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void txtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoActionPerformed

    private void boton_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_cancelarActionPerformed
       this.dispose();
    }//GEN-LAST:event_boton_cancelarActionPerformed

    private void comboPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPerfilActionPerformed
            // TODO add your handlicode here:
    }//GEN-LAST:event_comboPerfilActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Aceptar_boton;
    private javax.swing.JLabel Perfil;
    private javax.swing.JLabel apellido;
    private javax.swing.JButton boton_cancelar;
    private javax.swing.JPasswordField clave;
    private javax.swing.JLabel clavenombre;
    private javax.swing.JPasswordField claverepetida;
    private javax.swing.JLabel claverepetidanombre;
    private javax.swing.JComboBox<String> comboPerfil;
    private javax.swing.JLabel correo;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
