
package vehiculos;
import javax.swing.JOptionPane;
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
public class Cent_Pobl {
    
    private String codi_pobl = new String();
    private String nomb_pobl = new String();
    int cons_muni;
    
//Constructor vacio  
    public Cent_Pobl(){

            }
    
 //Constructor que pide todos los parametros
    public Cent_Pobl(int cons_cMuni, String Icodi_pobl, String Inomb_pobl){
            cons_muni= cons_cMuni;
            codi_pobl = Icodi_pobl;
            nomb_pobl = Inomb_pobl;         
            }
    public int getconsm(){
                    return cons_muni;
                    }
            public String getcodi_pobl(){
                    return codi_pobl;
                    }
                    
            public String getnomb_pobl(){
                    return nomb_pobl;
                    }
            
    public Cent_Pobl[] CrudListaCent_Pobl(){
  
            int intCont;
            int intTama=0;

            Conexion CC = new Conexion();

            try{
            String [][]strRes = CC.resultadoQuery(CC.queryConsulta("SELECT COUNT(codi_pobl) "
                + "AS TANTOS FROM tabl_muni where cons_muni < 101;"));
            
            intTama = Integer.parseInt(strRes[0][0]);
            System.out.print("\n El tamaño es:" + intTama + "\n");
            strRes = CC.resultadoQuery(CC.queryConsulta("SELECT cons_muni, codi_pobl, nomb_pobl FROM tabl_muni where cons_muni < 101 order by cons_muni"));
            Cent_Pobl [] mCent_Pobl = new Cent_Pobl[intTama]; //Constructor Arreglo
             System.out.print("Fueron " + intTama + " centros poblados");//Muestra cuantos centros poblados hay           
            

            for (intCont=0; intCont<(intTama); intCont++){
                    Cent_Pobl Cent_PoblAux = new Cent_Pobl (Integer.parseInt(strRes[intCont][0]),strRes[intCont][1], strRes[intCont][2]); // Crea instancia
                    mCent_Pobl[intCont] = Cent_PoblAux;
            }
            return mCent_Pobl;//Retorna los centros poblados
            
            }

            catch(Exception ex){
            String strMensaje = "Se presento un problema con la lista de centros poblados";
            JOptionPane.showMessageDialog(null, strMensaje, "PROBLEMA CON LA LISTA", 0);
            System.out.print(ex);
            return null;
            }
        }
    
    public static void main(String[] args) {
    
    Cent_Pobl c = new Cent_Pobl();
    Cent_Pobl[] list =c.CrudListaCent_Pobl();
    for(int i = 0; i <list.length; i++){
    System.out.println( list[i].getcodi_pobl()+" - "+list[i].getnomb_pobl());
    
    }
    
    }
}


            
