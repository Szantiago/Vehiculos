/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculos;

import javax.swing.JOptionPane;
import vehiculos.*;
/**
 *
 * @author L3Li
 */
public class Concesionario {
    	private int cons_cons;
	private String nomb_cons = new String();
	private int cons_muni ;
        private String codi_pobl = new String();
	private int tele_cons;
	private String dire_cons = new String();
        private String nombre_muni = new String();
        private int cons_conse;
        private String estado = new String();
	private Conexion conMiconexion;
        
        public Concesionario (){
        }
        
        public Concesionario(int Ccons_cons, String Cnomb_cons, String Ccodi_pobl, int Ctele_cons, String Cdire_cons, String Cestado){
         
        cons_cons = Ccons_cons;
        nomb_cons=Cnomb_cons;
        codi_pobl=Ccodi_pobl;
        tele_cons=Ctele_cons;
        dire_cons=Cdire_cons;
        estado=Cestado;
        
        }
        
        public Concesionario(int Ccons_muni, String Ccodi_pobl, String Cnombre_muni){
        cons_muni = Ccons_muni;
        codi_pobl=Ccodi_pobl;
        nombre_muni= Cnombre_muni;
        }
       
        
        //<Metodos get y set>
        
    
         public int getcons_cons(){
		return cons_cons;
         }
         
         public void setcons_cons(int newVal){
		cons_cons = newVal;
	}
           
         public String getnomb_cons(){
		return nomb_cons;
         }
         
         public void setnomb_cons(String newVal){
		nomb_cons = newVal;
           }        
         
         public String getcodi_pobl(){
		return codi_pobl;
         }
         
         public void setcodi_pobl(String newVal){
		nomb_cons = newVal;
           } 
         
         public int getcons_muni(){
		return cons_muni;
         }
         
         public void setcons_muni(){
             
         }
         
         public String getnombre_muni (){
                return nombre_muni;
         }
         
          public void setnombre_muni(String newVal){
		nombre_muni = newVal;
           } 
          
         public int gettele_cons(){
		return tele_cons;
         }
         
         public void settele_cons(int newVal){
		tele_cons = newVal;
	}
         
         public String getdire_cons(){
		return dire_cons;
         }
         
         public void setdire_cons(String newVal){
		dire_cons = newVal;
           }      
           
         public int getcons_conse(){
		return cons_conse;
         }
         
         public void setcons_conse(int newVal){
		cons_conse = newVal;
	}
         
         public String getestado(){
                    return estado;
        }

         public void setestado(String newVal){
                    estado = newVal;
        }
                
         
        public void crudCrearConsencionario(String strnomb_cons, String strcodi_pobl, int Inttele_cons, 
                String strdire_cons, String strestado){
        
            conMiconexion = new Conexion();
            //int intAux;          
            conMiconexion.queryUpdate("INSERT INTO tabl_cons( nomb_cons, codi_pobl,"
                    + " tele_cons, dire_cons, estado) VALUES('" +strnomb_cons +"' , '" +
                    strcodi_pobl + "',"+ Inttele_cons + ",'" + strdire_cons + "','" + strestado +"');");
            
            String strMensaje = "Se creo con éxito";
            JOptionPane.showMessageDialog (null, strMensaje,  "Crear Consecionario ", 2);   
         }
        
        public void crudActualizarConsencionario(int Intcons_cons, String strnomb_cons, String strcodi_pobl, int Inttele_cons, 
                String strdire_cons, String strestado) {

            conMiconexion = new Conexion();
	   String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta("SELECT cons_cons, nomb_cons, "
                   + "codi_pobl, tele_cons, dire_cons, estado FROM tabl_cons WHERE cons_cons =" + Intcons_cons +  ";"));
	   if(strReg[0][0] != null)
	   {
               
               conMiconexion.queryUpdate("UPDATE tabl_cons SET  nomb_cons= '"
                       + strnomb_cons + "', codi_pobl= '"+ strcodi_pobl
                       + "', tele_cons= "+ Inttele_cons + ", dire_cons= '"+ strdire_cons + "', estado= '"+ strestado 
                       +  "' WHERE  cons_cons = " + Intcons_cons +";");
               
                cons_conse = Intcons_cons;
                nomb_cons = strnomb_cons;
                codi_pobl= strcodi_pobl;
                tele_cons = Inttele_cons;
                dire_cons = strdire_cons;
                estado = strestado;
        
                
             
               String strMensaje = "Se modifico con éxito";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR ", 2);
	   }
	   else
	   {
               String strMensaje = "No se pudo modificar ";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR ", 0);

	   }
            
	}
        
        public void crudMostrarConsecionario(int consecutivo_cons){

            conMiconexion = new Conexion();

            String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta(
                                    "SELECT  cons_cons, nomb_cons, codi_pobl, tele_cons, dire_cons, estado "
                                            + "FROM tabl_cons WHERE  cons_cons = " + consecutivo_cons +  ";")); 
           
            cons_cons = Integer.parseInt(strReg[0][0]);
            nomb_cons = strReg[0][1];
            codi_pobl = strReg[0][2];
            tele_cons = Integer.parseInt(strReg[0][3]);
            dire_cons = strReg[0][4];
            estado = strReg[0][5];
            
	}
        
        public Concesionario[] crudListaPoblado(){
		
            int intCont;
            int intTama = 0;
            conMiconexion = new Conexion();

            try
            {
                String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta( 
                                                "SELECT COUNT(cons_muni) AS TAL FROM tabl_muni where cons_muni < 101;"));

                intTama = Integer.parseInt(strReg[0][0]);
                System.out.print("\n el tamaño es:" + intTama + "\n");
                
                strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta(
                        "SELECT cons_muni, codi_pobl,nomb_muni FROM tabl_muni where cons_muni < 101 ORDER BY cons_muni;"));                

                Concesionario [] Lista = new Concesionario[intTama];

                for (intCont = 0; intCont <(intTama); intCont++)
                {
                    Concesionario PobladoAux = new Concesionario (Integer.parseInt(strReg[intCont][0]), 
                            strReg[intCont][1],strReg[intCont][2]);
                                        
                    Lista[intCont] = PobladoAux;

                }
                return Lista;
            }
            catch(Exception ex)
            {
                String strMensaje = "Se presento un problema con la lista de Poblado 1";
                JOptionPane.showMessageDialog(null, strMensaje,  "PROBLEMA CON LA LISTA", 0);
                System.out.print(ex);
                return null;
            }          
	}
        
        public Concesionario[] crudListaConsecionario(){
		
            int intCont;
            int intTama = 0;
            conMiconexion = new Conexion();

            try
            {
                String [][]strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta( 
                                                "SELECT COUNT(cons_cons) AS TAL FROM tabl_cons ;"));

                intTama = Integer.parseInt(strReg[0][0]);
                //System.out.print("\n el tamaño es:" + intTama + "\n");
                
                strReg = conMiconexion.resultadoQuery(conMiconexion.queryConsulta(
                        "SELECT cons_cons, nomb_cons, codi_pobl, tele_cons, dire_cons, estado FROM tabl_cons "
                                + "ORDER BY cons_cons;"));                

                Concesionario [] Lista = new Concesionario[intTama];

                for (intCont = 0; intCont <(intTama); intCont++)
                {
                    Concesionario ConsecioAux = new Concesionario (Integer.parseInt(strReg[intCont][0]), 
                    strReg[intCont][1], strReg[intCont][2], Integer.parseInt(strReg[intCont][3]), 
                    strReg[intCont][4], strReg[intCont][5]);
                                        
                    Lista[intCont] = ConsecioAux;

                }
                return Lista;
            }
            catch(Exception ex)
            {
                String strMensaje = "Se presento un problema con la lista de Consecionario";
                JOptionPane.showMessageDialog(null, strMensaje,  "PROBLEMA CON LA LISTA", 0);
                System.out.print(ex);
                return null;
            }          
	}
        
        
        public static void main(String[] args) {
          
//prueba para la conexi�n
//        Conexion CC = new Conexion();
//        String R[][] = CC.resultadoQuery(CC.queryConsulta("SELECT `codi_pobl` FROM `tabl_cons` WHERE `codi_pobl`=25;"));
//        System.out.print("\n Código Poblado: " + R[0][0] + " - " + R[0][4] + "\n");
        
//-------------------------------------------------------------------------------
  
//Prueba clase Concesionario
    
        Concesionario miObjeto = new Concesionario();
        
 //...................................................................................
      

//se crea el vector para recibir el vector de Poblado
        Concesionario[] lisTabla = miObjeto.crudListaConsecionario();
        
        System.out.print("\n\t\t La lista de poblado: \n" );
        
//Bucle para listar los colores del vector
        
        for(int intCont=0; intCont < lisTabla.length; intCont++)
        {
            System.out.print("\n" + lisTabla[intCont].getcons_cons() + " - " +lisTabla[intCont].getnomb_cons());
        }
    }
}
