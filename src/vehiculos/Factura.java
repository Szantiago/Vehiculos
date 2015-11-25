
package vehiculos;

import javax.swing.JOptionPane;

/**
 * @author 
 * @version 1.0
 */

    public class Factura {

            private int cons_fact;
            private String nume_fact = new String();
            private String fech_fact = new String(); 
            private int cons_clie;
            private int cons_vend;
            private int cons_cons;
            private int cons_vehi;
            private String estado = new String();
            private Conexion con;

            public Factura(){

            }

            public Factura(int Icons_fact, String Inume_fact, String Ifech_fact, int Icons_clie, int Icons_vend, int Icons_cons, 
                    int Icons_vehi, String Iestado){
            cons_fact = Icons_fact;
            nume_fact = Inume_fact;
            fech_fact = Ifech_fact;
            cons_clie = Icons_clie;
            cons_vend = Icons_vend;
            cons_cons = Icons_cons;
            cons_vehi = Icons_vehi;
            estado = Iestado;
            }

            public Factura(int Ccons_fact){
                this.CrudBuscarFactura(Ccons_fact);
            }


            public int getcons_fact(){
                    return cons_fact;
            }

            public String getnume_fact(){
                    return nume_fact;
            }

            public void setnume_fact(String newVal){
                    nume_fact = newVal;
            }

            public String getfech_fact(){
                    return fech_fact;
            }

            public void setfech_fact(String newVal){
                    fech_fact = newVal;
            }

            public int getcons_clie(){
                    return cons_clie;
            }

            public void setcons_clie(int newVal){
                    cons_clie = newVal;
            }

            public int getcons_vend(){
                    return cons_vend;
            }

            public void setcons_vend(int newVal){
                    cons_vend = newVal;
            }

            public int getcons_cons(){
                    return cons_cons;
            }

            public void setcons_cons(int newVal){
                    cons_cons = newVal;
            }

            public int getcons_vehi(){
                    return cons_vehi;
            }

            public void setcons_vehi(int newVal){
                    cons_vehi = newVal;
            }
            
            public String getestado(){
                    return estado;
            }

            public void setestado(String newVal){
                    estado = newVal;
            }



             public void CrudInsertarFactura(String Inume_fact, String Ifech_fact, int Icons_clie,
                     int Icons_vend, int Icons_cons, int Icons_vehi, String Iestado){
                
                con= new Conexion();
                con.queryUpdate("INSERT INTO tabl_fact (nume_fact, fech_fact, cons_clie, cons_vend, cons_cons, cons_vehi, estado) "
                    + "VALUES( '" + Inume_fact +"','"+ Ifech_fact +"','"+ Icons_clie +"','"+ Icons_vend +"','"+ Icons_cons +"','"+ Icons_vehi +"','"+ Iestado +"');");
                
            String strMensaje = "Se creo la factura con éxito";
            JOptionPane.showMessageDialog(null, strMensaje,  "CREAR Factura", 2); 
            }
            


            public void CrudBuscarFactura(int Fcons_fact){
                
                con = new Conexion();
                String [][]strReg = con.resultadoQuery(con.queryConsulta("SELECT cons_fact, nume_fact, fech_fact, "
                        + "cons_clie, cons_vend, cons_cons, cons_vehi, estado FROM tabl_fact WHERE cons_fact = " + Fcons_fact + ";"));

                cons_fact = Integer.parseInt(strReg[0][0]);
                nume_fact = strReg[0][1];
                fech_fact = strReg[0][2];
                cons_clie = Integer.parseInt(strReg[0][3]);
                cons_vend = Integer.parseInt(strReg[0][4]);                        
                cons_cons = Integer.parseInt(strReg[0][5]);
                cons_vehi = Integer.parseInt(strReg[0][6]);
                estado = strReg[0][7];
            }
            
            public void CrudActualizarFactura(int Ncons_fact, String Nnume_fact, String Nfech_fact, int Ncons_clie, 
                    int Ncons_vend, int Ncons_cons, int Ncons_vehi, String Nestado){
                con = new Conexion();

                String [][]strReg = con.resultadoQuery(con.queryConsulta("SELECT cons_fact, nume_fact, fech_fact,"
                        + "cons_clie, cons_vend, cons_cons, cons_vehi, estado FROM tabl_fact WHERE cons_fact = " + Ncons_fact + ";" ));

                
                if(strReg[0][0] != null)
	   {
                con.queryUpdate("UPDATE tabl_fact SET nume_fact = '" + Nnume_fact + "', fech_fact = '" + Nfech_fact + "', cons_clie = " + Ncons_clie 
                        + ", cons_vend = " + Ncons_vend + ", cons_cons = " + Ncons_cons + ", cons_vehi = " + Ncons_vehi  
                        + ", estado = '" + Nestado+ "' WHERE cons_fact = " + Ncons_fact);

                nume_fact = Nnume_fact;
                fech_fact = Nfech_fact;
                cons_clie = Ncons_clie;
                cons_vend = Ncons_vend;
                cons_cons = Ncons_cons;
                cons_vehi = Ncons_vehi;
                estado = Nestado;

                String strMensaje = "Se modifico la factura con éxito";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR FACTURA", 2);

	   }
	   else
	   {
               String strMensaje = "No se pudo modificar la factura";
               JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR FACTURA", 0);

                }
            }


        public Factura[] CrudListaFactura(){

            int intCont;
            int intTama=0;

            con = new Conexion();
  
            try{
            String [][]strReg = con.resultadoQuery(con.queryConsulta("SELECT COUNT(cons_fact) "
                + "AS TANTOS FROM tabl_fact ;"));
            
            intTama = Integer.parseInt(strReg[0][0]);
            
            System.out.print("\n El tamaño es:" + intTama + "\n");
            
            Factura[] Lista = new Factura[intTama]; 
                        
            strReg = con.resultadoQuery(con.queryConsulta(
                    "SELECT cons_fact, nume_fact, fech_fact, cons_clie, cons_vend, cons_cons, cons_vehi, estado FROM tabl_fact ORDER BY cons_fact ;"));
            
   
            for (intCont=0; intCont<(intTama); intCont++){
            Factura factAux = new Factura((Integer.parseInt(strReg[intCont][0])), strReg[intCont][1],
                    strReg[intCont][2],(Integer.parseInt(strReg[intCont][3])),
                    (Integer.parseInt(strReg[intCont][4])),(Integer.parseInt(strReg[intCont][5])),
                    (Integer.parseInt(strReg[intCont][6])), strReg[intCont][7]); 
            
                Lista[intCont] = factAux; 
                }
                    return Lista;
            }

            catch(Exception ex){
            String strMensaje = "Se presento un problema con la lista de facturas 1";
            JOptionPane.showMessageDialog(null, strMensaje, "PROBLEMA CON LA LISTA", 0);
            System.out.print(ex);
            return null;
            }
        }
                        
//==========================================================================================================================
// Main para hacer pruebas             

        public static void main(String[] args) {
                Factura mR =new Factura();
//            cons_fact
//            nume_fact
//            fech_fact 
//            cons_clie;
//            cons_vend;
//            cons_cons;
//            cons_vehi;
        //...................................................................................   
        //Prueba insertar un Venta 
//                mR.CrudInsertarVenta(1, 1, 1, 2, 400000000, "20/06/2015");     
        //...................................................................................
        //pueba para buscar una Venta
                mR.CrudBuscarFactura(1); 
        //mR.CrudBuscarVenta(1);
               System.out.print("\n-El nuevo Venta es: " + mR.getcons_fact()+ " - " + mR.getnume_fact() + " - " + mR.getfech_fact()+ " - " +  mR.getcons_clie() +" - " + mR.getcons_vend() +" - " + mR.getcons_cons() +" - " + mR.getcons_vehi() + "\n");
//        //...................................................................................
//        //Prueba para actualizar una Venta
//                mR.CrudActualizarVenta(1, 1, 1, 1, 2, 400000000, "20/06/2015");
//        // miR.CrudActualizarVenta(1);        
//                System.out.print("\n-La Venta modificada es: " +  mR.getintIdUsuario() + " - " + mR.getintIdCliente()+ " - " +  mR.getintIdVehiculo() +" - " + mR.getintCantidadVehiculos() +" - " + mR.getintPrecioTotal() +" - " + mR.getintFechaVenta() + "\n");
       
       
                      
        }
    }

