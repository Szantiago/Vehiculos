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
public class ConsultaCliente {
    
    int cons_factu; 
    String pnomclien;
    String snomclien;
    String primape;
    String fechfa; 
    String telecl;
    String marcvehic;
    String modelve;
    String vende;
    String munic;
    String depto;
    
    public ConsultaCliente(){}
    public ConsultaCliente(int Icons_fact, String Ipnomclie, String Isnomclie, String Iprimap, String Ifechf, 
                    String Itelec, String Imarcvehi, String Imodelv, String Ivend, String muni, String dpto){
    cons_factu= Icons_fact; 
    pnomclien= Ipnomclie;
    snomclien=Isnomclie;
    primape= Iprimap;
    fechfa= Ifechf; 
    telecl= Itelec;
    marcvehic= Imarcvehi;
    modelve=Imodelv;
    vende=Ivend;
    munic=muni;
    depto=dpto;
    }
    
    
    
    public int getcons_factu(){
    return cons_factu;
    }
    public String getpnomclien(){
    return pnomclien;
    }
    public String getsnomclien(){
    return snomclien;
    }
    public String getprimape (){
    return primape;
    }
    public String getfechfa(){
    return fechfa;
    } 
    public String gettelecl(){
    return telecl;
    }
    public String getmarcvehic(){
    return marcvehic;
    }
    public String getmodelve(){
    return modelve;
    }
    public String getvende(){
    return  vende;
    }
    public String getmunic(){
    return munic;
    }
    public String getdepto(){
    return depto;
    }
    
    public ConsultaCliente[] CrudListaC(){
  
            int intCont;
            int intTama=0;

            Conexion CC = new Conexion();

            try{
            String [][]strRes = CC.resultadoQuery(CC.queryConsulta("SELECT COUNT(cons_fact) "
                + "AS TANTOS FROM tabl_fact;"));
            
            intTama = Integer.parseInt(strRes[0][0]);
            System.out.print("\n El tamaño es:" + intTama + "\n");
            
            ConsultaCliente [] mClientes = new ConsultaCliente[intTama]; //Constructor Arreglo
                        
            strRes = CC.resultadoQuery(CC.queryConsulta("SELECT * from (select f.cons_fact, c.prim_nomb,c.segu_nomb, c.prim_apel, f.fech_fact, (select t.num_tele from tabl_tele t where t.cons_clie = c.cons_clie) as tele, " +
"(select marc_vehi from tabl_vehi vh where vh.cons_vehi=f.cons_vehi), (select mode_vehi from tabl_vehi vh where vh.cons_vehi=f.cons_vehi),(select ven.nom_vend from tabl_vend ven where ven.cons_vend=f.cons_vend)as vend," +
"(select * from (select nomb_muni from tabl_muni m, tabl_cons con where con.cons_cons = f.cons_cons and m.codi_pobl like con.codi_pobl)as mu)," +
"(select * from (select nomb_dpto from tabl_muni m, tabl_cons con where con.cons_cons = f.cons_cons and m.codi_pobl like con.codi_pobl)as dp)" +
"from tabl_clie c, tabl_fact f where c.cons_clie = f.cons_clie) as datos;"));

            for (intCont=0; intCont<(intTama); intCont++){
                    ConsultaCliente tabl_clieAux = new ConsultaCliente (Integer.parseInt(strRes[intCont][0]), 
                    strRes[intCont][1], strRes[intCont][2], strRes[intCont][3], strRes[intCont][4],
                    strRes[intCont][5], strRes[intCont][6], strRes[intCont][7], strRes[intCont][8], strRes[intCont][9], strRes[intCont][10]); // Crea instancia
                    mClientes[intCont] = tabl_clieAux;
            }
            System.out.print("Fueron " + intTama + " clientes");//Muestra cuantos clientes hay
            
            return mClientes;//Retorna los clientes
            
            
            }

            catch(Exception ex){
            String strMensaje = "Se presento un problema con la lista de clientes";
            JOptionPane.showMessageDialog(null, strMensaje, "PROBLEMA CON LA LISTA", 0);
            System.out.print(ex);
            return null;
            }
    }
    
}
