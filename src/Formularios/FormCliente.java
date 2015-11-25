
package Formularios;
import vehiculos.Cliente;
import vehiculos.Cent_Pobl;
/**
 * UNIVERSIDAD DE CUNDINAMARCA
 * Ingenieria de Sistemas
 * Estudiantes: - Leidy Arevalo
 *              - Santiago Lozano
 *              - Victor Pinzon
 * 
 * Profesor: Diego Arce
 * 
 * @author 
 * @version 1.0
 * 
 */
public class FormCliente extends javax.swing.JFrame {
    Cliente mCliente = new Cliente(); //Crear constructor vacio de la clase tbCliente
    Cliente[] miListaCl = mCliente.CrudListaCliente();

    Cent_Pobl mCent_Pobl = new Cent_Pobl();
    Cent_Pobl[] miListaCP = mCent_Pobl.CrudListaCent_Pobl();
    
    boolean b;
    boolean c;
    /**
     * Creates new form FormCliente
     */
    public FormCliente() {
        
        initComponents();
        this.setLocation(300,120);//En esta instancia(this)cambiar(set)la posición(Location) 
        txtcent_pobl.setVisible(false);
        txtgene.setVisible(false);
//.................................
        //Contador del formulario  

        b=true;
        
        for(int intcont=0; intcont < miListaCl.length; intcont++ ){
        jcomboCl.addItem(miListaCl[intcont].getcons_clie()+" - "+miListaCl[intcont].getnume_iden()
        +" - "+ miListaCl[intcont].getprim_nomb()+" - "+ miListaCl[intcont].getsegu_nomb()
        +" - "+ miListaCl[intcont].getprim_apel()+" - "+ miListaCl[intcont].getsegu_apel()
        +" - "+ miListaCl[intcont].getgene_clie()+" - "+ miListaCl[intcont].getcent_pobl());    
            }
        
        for(int intcont=0; intcont < miListaCP.length; intcont++ ){
        jcomboCP.addItem(miListaCP[intcont].getconsm()+" - "+miListaCP[intcont].getcodi_pobl()+" - "+miListaCP[intcont].getnomb_pobl());  
        jcomboCP.setSelectedIndex(0);
            }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jcomboCl = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        txtnum_doc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtprim_nomb = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtsegu_nomb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtprim_apel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtsegu_apel = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcomboG = new javax.swing.JComboBox<>();
        txtgene = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtcent_pobl = new javax.swing.JTextField();
        jcomboCP = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        btnActualizar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnInsertar = new javax.swing.JButton();
        txtbuscar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jComboEstado = new javax.swing.JComboBox<>();
        txtestado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cliente");

        jcomboCl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboClActionPerformed(evt);
            }
        });

        jLabel2.setText("# Documento");

        txtnum_doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnum_docActionPerformed(evt);
            }
        });

        jLabel3.setText("Primer nombre");

        jLabel4.setText("Segundo nombre");

        jLabel5.setText("Primer apellido");

        txtprim_apel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprim_apelActionPerformed(evt);
            }
        });

        jLabel6.setText("Segundo apellido");

        txtsegu_apel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsegu_apelActionPerformed(evt);
            }
        });

        jLabel7.setText("Género");

        jcomboG.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M" }));
        jcomboG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboGActionPerformed(evt);
            }
        });

        txtgene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgeneActionPerformed(evt);
            }
        });

        jLabel8.setText("Centro poblado");

        txtcent_pobl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcent_poblActionPerformed(evt);
            }
        });

        jcomboCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboCPActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");

        btnInsertar.setText("Insertar");
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });

        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        jLabel9.setText("Estado");

        jComboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        jComboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEstadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcomboG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtgene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jcomboCP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtcent_pobl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtprim_apel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel3))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtprim_nomb, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                                                    .addComponent(txtnum_doc))
                                                .addGap(48, 48, 48)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtsegu_nomb))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtsegu_apel))))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnInsertar)
                                .addGap(4, 4, 4)
                                .addComponent(btnActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnVolver))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnbuscar))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcomboCl, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 153, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcomboCl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnum_doc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtprim_nomb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtsegu_nomb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtprim_apel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtsegu_apel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcomboG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jcomboCP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcent_pobl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizar)
                    .addComponent(btnLimpiar)
                    .addComponent(btnVolver)
                    .addComponent(btnInsertar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcomboClActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboClActionPerformed
        // TODO add your handling code here:
                  if(b){
        
        Cliente[] miListaCl = mCliente.CrudListaCliente();
        mCliente = miListaCl[jcomboCl.getSelectedIndex()];
        
        txtbuscar.setText(""+mCliente.getcons_clie());
        txtnum_doc.setText("" + mCliente.getnume_iden()); // Entrega el valor en los campos de texto
        txtprim_nomb.setText("" + mCliente.getprim_nomb()); // Entrega el valor en los campos de texto
        txtsegu_nomb.setText("" + mCliente.getsegu_nomb()); // Entrega el valor en los campos de texto
        txtprim_apel.setText("" + mCliente.getprim_apel()); // Entrega el valor en los campos de texto
        txtsegu_apel.setText("" + mCliente.getsegu_apel()); // Entrega el valor en los campos de texto
        txtcent_pobl.setText("" + mCliente.getcent_pobl()); // Entrega el valor en los campos de texto
        txtgene.setText("" + mCliente.getgene_clie()); // Entrega el valor en los campos de texto
        btnInsertar.setEnabled(true); // Se mantiene el botón insertar como verdadero
        btnActualizar.setEnabled(true); // Se mantiene el botón actualizar como verdadero      
        }
    }//GEN-LAST:event_jcomboClActionPerformed

    private void txtnum_docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnum_docActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnum_docActionPerformed

    private void txtprim_apelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprim_apelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprim_apelActionPerformed

    private void txtsegu_apelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsegu_apelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsegu_apelActionPerformed

    private void txtcent_poblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcent_poblActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_txtcent_poblActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        
        FormCliente h = new FormCliente();
                
                        
                        h.setVisible(false);
                        setVisible(false);
        
        mCliente.CrudActualizarCliente(mCliente.getcons_clie(),txtnum_doc.getText(),txtprim_nomb.getText(), 
        txtsegu_nomb.getText(),txtprim_apel.getText(),txtsegu_apel.getText(),txtgene.getText(),
        txtcent_pobl.getText(), txtestado.getText()); //Se importa el método y los parámetros necesarios
        

        txtnum_doc.setText(""); // Entrega el valor en los campos de texto
        txtprim_nomb.setText(""); // Entrega el valor en los campos de texto
        txtsegu_nomb.setText(""); // Entrega el valor en los campos de texto
        txtprim_apel.setText(""); // Entrega el valor en los campos de texto
        txtsegu_apel.setText(""); // Entrega el valor en los campos de texto
        txtgene.setText("");// Entrega el valor en los campos de texto
        txtcent_pobl.setText(""); // Entrega el valor en los campos de texto
        txtestado.setText("");
        
        btnInsertar.setEnabled(false); // Se mantiene el botón insertar como falso
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void jcomboGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboGActionPerformed
        // TODO add your handling code here:    
        txtgene.setText(jcomboG.getSelectedItem().toString());

    }//GEN-LAST:event_jcomboGActionPerformed

    private void jcomboCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboCPActionPerformed
        // TODO add your handling code here:
                if(c){
        Cent_Pobl[] miListad = mCent_Pobl.CrudListaCent_Pobl();
        mCent_Pobl = miListad[jcomboCP.getSelectedIndex()];
        
        btnInsertar.setEnabled(true); // Se mantiene el botón insertar como verdadero
        btnActualizar.setEnabled(true); // Se mantiene el botón actualizar como verdadero
        }   

    }//GEN-LAST:event_jcomboCPActionPerformed

    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed
        // TODO add your handling code here:
        FormInicio e =new FormInicio();
        FormCliente h = new FormCliente();
                
        e.setVisible(true);
        h.setVisible(false);
        setVisible(false);      
       
        mCliente.CrudInsertarCliente( txtnum_doc.getText(),
                    txtprim_nomb.getText(), txtsegu_nomb.getText(), txtprim_apel.getText(), 
                    txtsegu_apel.getText(), txtgene.getText(), txtcent_pobl.getText(), txtestado.getText()); //Se importa el método y los parámetros necesarios
        
        jcomboCl.setSelectedIndex(mCliente.getcons_clie());
        
        txtnum_doc.setText(""); // Entrega el valor en los campos de texto
        txtprim_nomb.setText(""); // Entrega el valor en los campos de texto
        txtsegu_nomb.setText(""); // Entrega el valor en los campos de texto
        txtprim_apel.setText(""); // Entrega el valor en los campos de texto
        txtsegu_apel.setText(""); // Entrega el valor en los campos de texto
        txtgene.setText("");// Entrega el valor en los campos de texto
        txtcent_pobl.setText(""); // Entrega el valor en los campos de texto
        txtestado.setText(""); // Entrega el valor en los campos de texto
        

        btnActualizar.setEnabled(false); // Se mantiene el botón actualizar como falso
    }//GEN-LAST:event_btnInsertarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        
        FormInicio e =new FormInicio();
        FormCliente h = new FormCliente();
                
        e.setVisible(true);
        h.setVisible(false);
        setVisible(false);
                        
        b=false; // Se declara la variable booleana como falsa para no realizar la acción
        
        txtnum_doc.setText(""); // Entrega el valor en los campos de texto
        txtprim_nomb.setText(""); // Entrega el valor en los campos de texto
        txtsegu_nomb.setText(""); // Entrega el valor en los campos de texto
        txtprim_apel.setText(""); // Entrega el valor en los campos de texto
        txtsegu_apel.setText(""); // Entrega el valor en los campos de texto
        txtgene.setText(""); // Entrega el valor en los campos de texto
        txtcent_pobl.setText(""); // Entrega el valor en los campos de texto
        jComboEstado.setSelectedIndex(0);
        

        btnInsertar.setEnabled(true); // Se mantiene el botón insertar como verdadero
        btnActualizar.setEnabled(true); // Se mantiene el botón actualizar como verdadero
       
        jcomboCl.removeAllItems(); //Se limpia el formulario.
        jcomboCl.repaint();
        
        // Se crea un for para borrar el formulario y que el jCombo no este vacio
        for(int intcont=0; intcont < miListaCl.length; intcont++ ){
        jcomboCl.addItem(miListaCl[intcont].getcons_clie()+" - "+miListaCl[intcont].getnume_iden()
         +" - "+ miListaCl[intcont].getprim_nomb()+" - "+miListaCl[intcont].getsegu_nomb()
        +" - "+ miListaCl[intcont].getprim_apel()+" - "+ miListaCl[intcont].getsegu_apel()
        +" - "+ miListaCl[intcont].getgene_clie()+" - "+ miListaCl[intcont].getcent_pobl()
        +" - "+ miListaCl[intcont].getestado());  
        jcomboCl.setSelectedIndex(0); // Posiciona el jcombo en la posición 0
            }   
        b=true;
        
        c=false;

        btnInsertar.setEnabled(true); // Se mantiene el botón insertar como verdadero
        btnActualizar.setEnabled(true); // Se mantiene el botón actualizar como verdadero
       
        jcomboCP.removeAllItems(); //Se limpia el formulario.
         
        // Se crea un for para borrar el formulario y que el jCombo no este vacio
        for(int intcont=0; intcont < miListaCP.length; intcont++ ){
        jcomboCP.addItem(miListaCP[intcont].getcodi_pobl()+" - "+miListaCP[intcont].getnomb_pobl());  
        jcomboCP.setSelectedIndex(0); // Posiciona el jcombo en la posició 0
            }
       c=true;
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void txtgeneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgeneActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_txtgeneActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        mCliente.CrudBuscarCliente((Integer.parseInt(txtbuscar.getText())));
        
        jcomboCl.setSelectedIndex(mCliente.getcons_clie());
        txtnum_doc.setText(mCliente.getnume_iden());
        txtprim_nomb.setText(mCliente.getprim_nomb());
        txtsegu_nomb.setText(mCliente.getsegu_nomb());
        txtprim_apel.setText(mCliente.getprim_apel());
        txtsegu_apel.setText(mCliente.getsegu_apel());
        txtgene.setText(mCliente.getgene_clie());
        txtcent_pobl.setText(mCliente.getcent_pobl());
        txtestado.setText(mCliente.getestado());
        jComboEstado.setSelectedIndex(0);
        
        

        
        btnInsertar.setEnabled(false);
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void jComboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEstadoActionPerformed
        // TODO add your handling code here:
        txtestado.setText(jComboEstado.getSelectedItem().toString());
    }//GEN-LAST:event_jComboEstadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JComboBox<String> jComboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> jcomboCP;
    private javax.swing.JComboBox<String> jcomboCl;
    private javax.swing.JComboBox<String> jcomboG;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextField txtcent_pobl;
    private javax.swing.JTextField txtestado;
    private javax.swing.JTextField txtgene;
    private javax.swing.JTextField txtnum_doc;
    private javax.swing.JTextField txtprim_apel;
    private javax.swing.JTextField txtprim_nomb;
    private javax.swing.JTextField txtsegu_apel;
    private javax.swing.JTextField txtsegu_nomb;
    // End of variables declaration//GEN-END:variables
}