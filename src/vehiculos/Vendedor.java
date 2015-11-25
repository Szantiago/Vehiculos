
package vehiculos;

import javax.swing.JOptionPane;


public class Vendedor {

    
    String nom_Vend = new String();
    int tele_Vend;
    int cons_Cons;
    int cons_Vend;
    String estado = new String();
    
    private Conexion conMicon;
    
    public Vendedor(){
    }
    
    Vendedor(int cCons_Vend ,String cNom_Vend, int cTele_Vend, int cCons_Cons, String cestado){
        nom_Vend = cNom_Vend;
        tele_Vend = cTele_Vend;
        cons_Cons = cCons_Cons;
        cons_Vend = cCons_Vend;
        estado = cestado;
    }
    
    public void setStringNomVend(String newVal){
		nom_Vend = newVal;
	}
    public void setIntTeleVend(int newVal){
		tele_Vend = newVal;
	}
    public void setIntConsCons(int newVal){
		cons_Cons = newVal;
	}
    
    public int getIntConsVend(){
		return cons_Vend;
	}
    
    public int getIntConsCons(){
		return cons_Cons;
	}
    
    public int getIntTeleVend(){
		return tele_Vend;
	}
    public String getStringNomVend(){
		return nom_Vend;
	}
    
    public String getestado(){
                    return estado;
        }

            public void setestado(String newVal){
                    estado = newVal;
        }
    
    public void crudCrearVendedor(String nom_CVend, int tele_CVend, int cons_CCons, String cestado){

            conMicon = new Conexion();
            
            conMicon.queryUpdate("INSERT INTO tabl_vend (nom_vend, tele_vend, cons_cons, estado) "
                    + "VALUES( '" + nom_CVend +"','"+tele_CVend+"','"+cons_CCons +"','"+cestado+ "');");

            String strMensaje = "Se creo el vendedor con éxito";
            JOptionPane.showMessageDialog(null, strMensaje,  "CREAR Vendedor", 2);  
            
	}
    
    public void crudEliminVendedor(int cons_EVend){

            conMicon = new Conexion();
            
            conMicon.queryUpdate("DELETE FROM tabl_vend WHERE cons_vend="+cons_EVend+";");

            String strMensaje = "Se borro el vendedor con éxito";
            JOptionPane.showMessageDialog(null, strMensaje,  "BORRAR Vendedor", 2);  
            
	}
    
    
    public Vendedor[] crudListaVend(){
		
            int intCont;
            int intTama = 0;
            conMicon = new Conexion();

            try
            {
                String [][]strReg = conMicon.resultadoQuery(conMicon.queryConsulta( 
                                                "SELECT COUNT(cons_vend) AS TAL FROM tabl_vend ;"));

                intTama = Integer.parseInt(strReg[0][0]);
                //System.out.print("\n el tamaño es:" + intTama + "\n");
                
                strReg = conMicon.resultadoQuery(conMicon.queryConsulta(
                        "SELECT cons_vend, nom_vend, tele_vend, cons_cons, estado FROM tabl_vend ORDER BY cons_vend ;"));                

                Vendedor [] Lista = new Vendedor[intTama];

                for (intCont = 0; intCont <(intTama); intCont++)
                {
                    Vendedor VendAux = new Vendedor( Integer.parseInt(strReg[intCont][0]), strReg[intCont][1], 
                            Integer.parseInt(strReg[intCont][2]),Integer.parseInt(strReg[intCont][3]),strReg[intCont][4]);
                                        
                    Lista[intCont] = VendAux;

                }
                return Lista;
            }
            catch(Exception ex)
            {
                String strMensaje = "Se presento un problema con la lista de Vendedor 1";
                JOptionPane.showMessageDialog(null, strMensaje,  "PROBLEMA CON LA LISTA", 0);
                System.out.print(ex);
                return null;
            }          
	}
    
    
    public void crudMostrarVend(int cons_MVend){

            conMicon = new Conexion();

            String [][]strReg = conMicon.resultadoQuery(conMicon.queryConsulta(
                                    "SELECT cons_vend, nom_vend , tele_vend, cons_cons, estado FROM tabl_vend "
                                            + "WHERE  cons_vend =" + cons_MVend +  ";")); 
           
            
            cons_Vend = Integer.parseInt(strReg[0][0]);
            nom_Vend=strReg[0][1];
            tele_Vend=Integer.parseInt(strReg[0][2]);
            cons_Cons=Integer.parseInt(strReg[0][3]);
            estado=strReg[0][4];
            
	}
    
    public void crudActualizarVend(int cons_CVend, String nom_CVend, int tele_CVend, int cons_CCons, String Cestado){

           conMicon = new Conexion();

	   String [][]strReg = conMicon.resultadoQuery(conMicon.queryConsulta("SELECT cons_vend, nom_vend , "
                   + "tele_vend, cons_cons, estado FROM tabl_vend WHERE  cons_vend = " + cons_CVend  +  ";"));
           
	   if(strReg[0][0] != null)
	   {
                conMicon.queryUpdate("UPDATE tabl_vend SET nom_vend =  '" + nom_CVend +"' , tele_vend =  " 
                        + tele_CVend+" , cons_cons =  " + cons_CCons +" , estado =  '" + Cestado
                        + "' WHERE  cons_vend = " + cons_CVend + ";");
                
               
               nom_Vend=nom_CVend;
               tele_Vend=tele_CVend;
               cons_Cons=cons_CCons;
               cons_Vend = cons_CVend;
               estado=Cestado;
               
               String strMensaje = "Se modifico el vendedor con éxito";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR VENDEDOR", 2);

	   }
	   else
	   {
               String strMensaje = "No se pudo modificar el vendedor";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR VENDEDOR", 0);

	   }
            
	}
    
    
    public static void main(String[] args) {
        Conexion CC = new Conexion();
        Vendedor miObjeto = new Vendedor();
        
        
        Vendedor[] lisTabla = miObjeto.crudListaVend();
        
        System.out.print("\n\t\tLa lista es: \n" );
        
//Bucle para listar del vector
        for(int intCont=0; intCont < lisTabla.length ; intCont++)
        {
            System.out.print("\n" + lisTabla[intCont].getIntConsVend()+ " - " + lisTabla[intCont].getStringNomVend()+ " - " + lisTabla[intCont].getIntTeleVend() + " - "+ lisTabla[intCont].getIntConsCons() );
        }
        
     }

}
