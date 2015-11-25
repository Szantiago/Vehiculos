/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculos;

import javax.swing.JOptionPane;

/**
 *
 * @author peace
 */
public class Telefonos {
    int cons_tele;
    int cons_clie;  
    private String num_tele = new String();
    private String tipo_tele = new String();

    
    
//Constructor vacio  
    public Telefonos(){

            }
    
 //Constructor que pide todos los parametros
    public Telefonos(int Icons_tele, int Icons_clie, String Inum_tele, String Itipo_tele){
            cons_tele= Icons_tele;
            cons_clie = Icons_clie;
            num_tele = Inum_tele; 
            tipo_tele = Itipo_tele;
            }
            public int getcons_tele(){
                    return cons_tele;
            }

            public void setcons_tele(int newVal){
                    cons_tele = newVal;
            }

            public int getcons_clie(){
                    return cons_clie;
            }

            public void setcons_clie(int newVal){
                    cons_clie = newVal;
            }

            public String getnum_tele(){
                    return num_tele;
            }

            public void setnum_tele(String newVal){
                    num_tele = newVal;
            }

            public String gettipo_tele(){
                    return tipo_tele;
            }

            public void settipo_tele(String newVal){
                    tipo_tele = newVal;
            }

           
            
            
    public Telefonos[] CrudListaTelefonos(){
  
            int intCont;
            int intTama=0;

            Conexion CC = new Conexion();

            try{
            String [][]strRes = CC.resultadoQuery(CC.queryConsulta("SELECT COUNT(cons_tele) "
                + "AS TANTOS FROM tabl_tele;"));
            
            intTama = Integer.parseInt(strRes[0][0]);
            System.out.print("\n El tamaño es:" + intTama + "\n");
            
            Telefonos [] mTelefonos = new Telefonos[intTama]; 
                        
            strRes = CC.resultadoQuery(CC.queryConsulta("SELECT cons_tele, cons_clie, num_tele, tipo_tele FROM tabl_tele order by cons_tele"));

            for (intCont=0; intCont<(intTama); intCont++){
                    Telefonos tabl_teleAux = new Telefonos (Integer.parseInt(strRes[intCont][0]), 
                    (Integer.parseInt(strRes[intCont][1])), strRes[intCont][2], strRes[intCont][3]); 
                    mTelefonos[intCont] = tabl_teleAux;
            }
            System.out.print("Fueron " + intTama + " telelfonos");
            
            return mTelefonos;
            
            }

            catch(Exception ex){
            String strMensaje = "Se presento un problema con la lista de telefonos";
            JOptionPane.showMessageDialog(null, strMensaje, "PROBLEMA CON LA LISTA", 0);
            System.out.print(ex);
            return null;
            }
    }  
}
