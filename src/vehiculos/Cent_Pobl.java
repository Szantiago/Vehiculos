
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
    
    int cons_muni;
    private String codi_dpto = new String();
    private String codi_muni = new String();
    private String codi_pobl = new String();
    private String nomb_dpto = new String();
    private String nomb_muni = new String();
    private String nomb_pobl = new String();
    private String tipo_pobl = new String();
    
    
//Constructor vacio  
    public Cent_Pobl(){

            }
    
 //Constructor que pide todos los parametros
    public Cent_Pobl(int cons_cMuni, String Icodi_dpto, String Icodi_muni, String Icodi_pobl, String Inomb_dpto, String Inomb_muni, String Inomb_pobl, String Itipo_pobl){
            cons_muni= cons_cMuni;
            codi_dpto = Icodi_dpto;
            codi_muni = Icodi_muni; 
            codi_pobl = Icodi_pobl;
            nomb_dpto = Inomb_dpto;
            nomb_muni = Inomb_muni;
            nomb_pobl = Inomb_pobl;
            tipo_pobl = Itipo_pobl;
                   
            }
    public int getcons_muni(){
                    return cons_muni;
            }

            public void setcons_muni(int newVal){
                    cons_muni = newVal;
            }

            public String getcodi_dpto(){
                    return codi_dpto;
            }

            public void setcodi_dpto(String newVal){
                    codi_dpto = newVal;
            }

            public String getcodi_muni(){
                    return codi_muni;
            }

            public void setcodi_muni(String newVal){
                    codi_muni = newVal;
            }

            public String getcodi_pobl(){
                    return codi_pobl;
            }

            public void setcodi_pobl(String newVal){
                    codi_pobl = newVal;
            }

            public String getnomb_dpto (){
                    return nomb_dpto ;
            }

            public void setnomb_dpto (String newVal){
                    nomb_dpto  = newVal;
            }

            public String getnomb_muni(){
                    return nomb_muni;
            }

            public void setnomb_muni(String newVal){
                    nomb_muni = newVal;
            }

            public String getnomb_pobl(){
                    return nomb_pobl;
            }

            public void setnomb_pobl(String newVal){
                    nomb_pobl = newVal;
            }
            
            public String gettipo_pobl(){
                    return tipo_pobl;
            }

            public void settipo_pobl(String newVal){
                    tipo_pobl = newVal;
            }
            
            
            public Cent_Pobl[] CrudListaCent_Pobl(){
  
            int intCont;
            int intTama=0;

            Conexion CC = new Conexion();

            try{
            String [][]strRes = CC.resultadoQuery(CC.queryConsulta("SELECT COUNT(cons_muni) "
                + "AS TANTOS FROM tabl_muni;"));
            
            intTama = Integer.parseInt(strRes[0][0]);
            System.out.print("\n El tamaño es:" + intTama + "\n");
            
            Cent_Pobl [] mCent_Pobl = new Cent_Pobl[intTama]; 
                        
            strRes = CC.resultadoQuery(CC.queryConsulta("SELECT cons_muni, codi_dpto, codi_muni, codi_pobl, "
                    + "nomb_dpto, nomb_muni, nomb_pobl, tipo_pobl FROM tabl_muni order by cons_muni"));

            for (intCont=0; intCont<(intTama); intCont++){
                    Cent_Pobl tabl_muniAux = new Cent_Pobl (Integer.parseInt(strRes[intCont][0]), 
                    strRes[intCont][1], strRes[intCont][2], strRes[intCont][3], strRes[intCont][4],
                    strRes[intCont][5], strRes[intCont][6], strRes[intCont][7]); 
                    mCent_Pobl[intCont] = tabl_muniAux;
            }
            System.out.print("Fueron " + intTama + " municipios");
            
            return mCent_Pobl;
            
            }

            catch(Exception ex){
            String strMensaje = "Se presento un problema con la lista de municipios";
            JOptionPane.showMessageDialog(null, strMensaje, "PROBLEMA CON LA LISTA", 0);
            System.out.print(ex);
            return null;
            }
    }
    
            public static void main(String[] args) {
            }
    
    }





            
