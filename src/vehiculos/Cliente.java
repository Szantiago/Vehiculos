
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
 * Esta clase sirve para manejar el mapeo entre el formulario de insertar cliente y la tabla tabl_clie
 */

    public class Cliente {

            private int cons_clie;
            private String nume_iden = new String();
            private String prim_nomb = new String();
            private String segu_nomb = new String();
            private String prim_apel = new String();
            private String segu_apel = new String();
            private String gene_clie = new String();
            private String cent_pobl = new String();
            private String estado = new String();

//-------------------------------------------------------------------------------
//Constructores
 
        //Constructor vacio
            public Cliente(){

            }
        //Constructor que pide todos los parametros

            public Cliente(int Icons_clie, String Inume_iden, String Iprim_nomb, String Isegu_nomb, String Iprim_apel, 
                    String Isegu_apel, String Igene_clie, String Icent_pobl, String Iestado){
            cons_clie = Icons_clie;
            nume_iden = Inume_iden;
            prim_nomb = Iprim_nomb;
            segu_nomb = Isegu_nomb;
            prim_apel = Iprim_apel;
            segu_apel = Isegu_apel;
            gene_clie = Igene_clie;
            cent_pobl = Icent_pobl;
            estado = Iestado;
            }
        /**
        * Costructor que filtra por el concecutivo y crea la instancia con el registro*/    
            public Cliente(int Ccons_clie){
                this.CrudBuscarCliente(Ccons_clie);
            }
            
//-------------------------------------------------------------------------------
//Métodos GET y SET
   
            public int getcons_clie(){
                    return cons_clie;
            }

            public void setcons_clie(int newVal){
                    cons_clie = newVal;
            }

            public String getnume_iden(){
                    return nume_iden;
            }

            public void setnume_iden(String newVal){
                    nume_iden = newVal;
            }

            public String getprim_nomb(){
                    return prim_nomb;
            }

            public void setprim_nomb(String newVal){
                    prim_nomb = newVal;
            }

            public String getsegu_nomb(){
                    return segu_nomb;
            }

            public void setsegu_nomb(String newVal){
                    segu_nomb = newVal;
            }

            public String getprim_apel (){
                    return prim_apel ;
            }

            public void setprim_apel (String newVal){
                    prim_apel  = newVal;
            }

            public String getsegu_apel(){
                    return segu_apel;
            }

            public void setsegu_apel(String newVal){
                    segu_apel = newVal;
            }

            public String getgene_clie(){
                    return gene_clie;
            }

            public void setgene_clie(String newVal){
                    gene_clie = newVal;
            }
            
            public String getcent_pobl(){
                    return cent_pobl;
            }

            public void setcent_pobl(String newVal){
                    cent_pobl = newVal;
            }
            
            public String getestado(){
                    return estado;
            }

            public void setestado(String newVal){
                    estado = newVal;
            }
                
            
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Métodos CRUD
        
	/**Para crear registros en la tabla tbCliente*/

             public void CrudInsertarCliente(String Inume_iden, String Iprim_nomb, String Isegu_nomb, String Iprim_apel, String Isegu_apel, 
                                            String Igene_clie, String Icent_pobl, String Iestado){
                
                Conexion IC = new Conexion();
                
                int intAux;
                intAux = IC.queryUpdate("INSERT INTO tabl_clie(nume_iden,"
                        + "prim_nomb, segu_nomb, prim_apel, segu_apel, "
                        + "gene_clie, cent_pobl, estado) "
                        + "VALUES (" + Inume_iden +",'"+ Iprim_nomb 
                        +"','"+ Isegu_nomb +"','"+ Iprim_apel 
                        +"','"+ Isegu_apel +"','"+ Igene_clie 
                        +"','"+ Icent_pobl +"','"+ Iestado + "')");
                JOptionPane.showMessageDialog(null, "Se creo el registro con exito", "MENSAJE", 2);
            }
            
//...............................................................................
	/** para mostrar un cliente filtrando por el concecutivo
	 * @param Fcons_clie	 */
            public void CrudBuscarCliente(int Fcons_clie){
              
                Conexion BC = new Conexion();
                String[][]strResultado = BC.resultadoQuery(BC.queryConsulta("SELECT cons_clie, nume_iden, "
                        + "prim_nomb, segu_nomb, prim_apel, segu_apel, gene_clie, cent_pobl, estado FROM tabl_clie WHERE cons_clie = "
                        + "" + Fcons_clie + ";" ));

                cons_clie = Integer.parseInt(strResultado[0][0]);
                nume_iden = strResultado[0][1];
                prim_nomb = strResultado[0][2];
                segu_nomb = strResultado[0][3];
                prim_apel = strResultado[0][4];                        
                segu_apel = strResultado[0][5];
                gene_clie = strResultado[0][6];
                cent_pobl = strResultado[0][7];
                estado = strResultado[0][8];

            }
//...............................................................................
	//Para modificar el registro de un cliente

            
            public void CrudActualizarCliente(int Ncons_clie, String Nnume_iden, String Nprim_nomb, 
                    String Nsegu_nomb, String Nprim_apel, String Nsegu_apel, 
                    String Ngene_clie, String Ncent_pobl, String Nestado){
                Conexion AC = new Conexion();

                String[][]strResultado = AC.resultadoQuery(AC.queryConsulta("SELECT cons_clie, nume_iden, "
                        + "prim_nomb, segu_nomb, prim_apel, segu_apel,gene_clie, cent_pobl, estado FROM tabl_clie WHERE cons_clie = " + Ncons_clie + ";" ));
                if (strResultado[0][0]!= null){
                AC.queryUpdate("UPDATE tabl_clie SET nume_iden = " + Nnume_iden + ", "
                        + "prim_nomb = '" + Nprim_nomb + "', segu_nomb = '" 
                        + Nsegu_nomb + "', prim_apel = '" + Nprim_apel 
                        + "', segu_apel = '" + Nsegu_apel + "', gene_clie = '" 
                        + Ngene_clie + "', cent_pobl = '" + Ncent_pobl + "', estado = '" + Nestado + "' WHERE cons_clie = " + Ncons_clie + ";");
                        

                nume_iden = Nnume_iden;
                prim_nomb = Nprim_nomb;
                segu_nomb = Nsegu_nomb;
                prim_apel = Nprim_apel;
                segu_apel = Nsegu_apel;
                gene_clie = Ngene_clie;
                cent_pobl = Ncent_pobl;
                estado = Nestado;

                String strMensaje = "Se modifico el cliente con éxito";
                   JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR CLIENTE", 2);

               }
               else
               {
                   String strMensaje = "No se pudo modificar el cliente";
                   JOptionPane.showMessageDialog(null, strMensaje,  "MODIFICAR CLIENTE", 0);

               }
            }
//...............................................................................
        //	Para mostrar la lista de la tabla tb_clientes
            public Cliente[] CrudListaCliente(){
  
            int intCont;
            int intTama=0;

            Conexion CC = new Conexion();

            try{
            String [][]strRes = CC.resultadoQuery(CC.queryConsulta("SELECT COUNT(cons_clie) "
                + "AS TANTOS FROM tabl_clie;"));
            
            intTama = Integer.parseInt(strRes[0][0]);
            System.out.print("\n El tamaño es:" + intTama + "\n");
            
            Cliente [] mClientes = new Cliente[intTama]; //Constructor Arreglo
                        
            strRes = CC.resultadoQuery(CC.queryConsulta("SELECT cons_clie, nume_iden, prim_nomb, segu_nomb, prim_apel, "
                    + "segu_apel, gene_clie, cent_pobl, estado FROM tabl_clie order by cons_clie"));

            for (intCont=0; intCont<(intTama); intCont++){
                    Cliente tabl_clieAux = new Cliente (Integer.parseInt(strRes[intCont][0]), 
                    strRes[intCont][1], strRes[intCont][2], strRes[intCont][3], strRes[intCont][4],
                    strRes[intCont][5], strRes[intCont][6], strRes[intCont][7], strRes[intCont][8]); // Crea instancia
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
            
       	/** para eliminar un cliente filtrando por el concecutivo
	 * @param Econs_clie	 */
            public void CrudEliminarCliente(int Econs_clie){
              
                Conexion EC = new Conexion();
                String[][]strResultado = EC.resultadoQuery(EC.queryConsulta("DELETE FROM tabl_clie WHERE cons_clie= " + Econs_clie + ";" ));

                String strMensaje = "se ELIMINÓ el cliente";
                JOptionPane.showMessageDialog(null, strMensaje,  "ELIMINAR CLIENTE", 2);

            }     
            
                      
            
//==========================================================================================================================
// Main para hacer pruebas             

        public static void main(String[] args) {
                Cliente mR =new Cliente();
        //...................................................................................   
        //Prueba insertar un Cliente 
 //               mR.CrudInsertarCliente(1, "655445", "Andres", "David", "Rodriguez", "Daza", "345565666", "Carrera 11 # 24-3a");     
        //...................................................................................
        //pueba para buscar un Cliente
                mR.CrudBuscarCliente(1); 
        //mR.CrudBuscarCliente(1);
//            cons_clie
//            nume_iden
//            prim_nomb
//            segu_nomb 
//            prim_apel 
//            segu_apel 
//            gene_clie 
//            cent_pobl  
                System.out.print("\n-El nuevo Cliente es: " + mR.getnume_iden()+ " - " + mR.getprim_nomb() + " - " + mR.getsegu_nomb()+ " - " +  mR.getprim_apel() +" - " + mR.getsegu_apel() +" - " + mR.getgene_clie() +" - " + mR.getcent_pobl() + "\n");
        //...................................................................................
        //Prueba para actualizar un Cliente
        //mR.CrudActualizarCliente(1, 1, "20468776", "Andres", "Arturo", "jimenez", "Daza", "3203456798", "Carrera 10 # 12-3a");
        // miR.CrudActualizarCliente(1);        
        //System.out.print("\n-El Cliente modificado es: " +  mR.getintTipoDocumentoCliente() + " - " + mR.getstrDocumentoIdentidad()+ " - " +  mR.getstrPrimerNombreCliente() +" - " + mR.getstrSegundoNombreCliente() +" - " + mR.getstrPrimerApellidoCliente() +" - " + mR.getstrSegundoApellidoCliente() + " - " + mR.getstrTelefonoCliente() + " - " + mR.getstrDireccionCliente() + "\n");
       
       
                      
        }
    }
