package vehiculos;

import javax.swing.JOptionPane;

/**
 * UNIVERSIDAD DE CUNDINAMARCA Ingenieria de Sistemas Estudiantes: - Leidy
 * Arevalo - Santiago Lozano - Victor Pinzon
 *
 * Profesor: Diego Arce
 *
 * @author
 * @version 1.0
 *
 * Esta clase sirve para manejar el mapeo entre el formulario de insertar
 * vehiculo y la tabla tabl_vehi
 */
public class Vehiculo {

    private int cons_vehi;
    private int cons_cons;
    private String marc_vehi = new String();
    private String mode_vehi = new String();
    private String line_vehi = new String();
    private String plac_vehi = new String();
    private String colo_vehi = new String();
    private String estado = new String();
    private Conexion conexion;

//-------------------------------------------------------------------------------
//Constructores
    //Constructor vacio
    public Vehiculo() {

    }
    //Constructor que pide todos los parametros

    public Vehiculo(int Icons_vehi, int Icons_cons, String Imarc_vehi, String Imode_vehi, String Iline_vehi, String Iplac_vehi, String Icolo_vehi, String Iestado) {
        cons_vehi = Icons_vehi;
        cons_cons = Icons_cons;
        marc_vehi = Imarc_vehi;
        mode_vehi = Imode_vehi;
        line_vehi = Iline_vehi;
        plac_vehi = Iplac_vehi;
        colo_vehi = Icolo_vehi;
        estado = Iestado;
    }

    //Costructor que filtra por consecutivo y crea la instancia con el registro   
    public Vehiculo(int CIcons_vehi) {
        this.CrudBuscarVehiculo(CIcons_vehi);
    }

//-------------------------------------------------------------------------------
//Métodos GET y SET
    public int getcons_vehi() {
        return cons_vehi;
    }

    public void setcons_vehi(int newVal) {
        cons_vehi = newVal;
    }

    public int getcons_cons() {
        return cons_cons;
    }

    public void setcons_cons(int newVal) {
        cons_cons = newVal;
    }

    public String getmarc_vehi() {
        return marc_vehi;
    }

    public void setmarc_vehi(String newVal) {
        marc_vehi = newVal;
    }

    public String getmode_vehi() {
        return mode_vehi;
    }

    public void setmode_vehi(String newVal) {
        mode_vehi = newVal;
    }

    public String getline_vehi() {
        return line_vehi;
    }

    public void setline_vehi(String newVal) {
        line_vehi = newVal;
    }

    public String getplac_vehi() {
        return plac_vehi;
    }

    public void setplac_vehi(String newVal) {
        plac_vehi = newVal;
    }

    public String getcolo_vehi() {
        return colo_vehi;
    }

    public void setcolo_vehi(String newVal) {
        colo_vehi = newVal;
    }

    public String getestado() {
        return estado;
    }

    public void setestado(String newVal) {
        estado = newVal;
    }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Métodos CRUD
        
	//Para crear registros en la tabla tabl_vehi       

            
            
             public void CrudInsertarVehiculo(int Icons_cons, String Imarc_vehi, String Imode_vehi, String Iline_vehi, String Iplac_vehi, 
                     String Icolo_vehi, String Iestado){
                
                Conexion IC = new Conexion();
                
                int intAux;
                intAux = IC.queryUpdate("INSERT INTO tabl_vehi (cons_cons"
                        + ",marc_vehi, mode_vehi, line_vehi, plac_vehi, colo_vehi, estado) "
                        + "VALUES (" + Icons_cons +",'"+ Imarc_vehi 
                        +"','"+ Imode_vehi
                        +"','"+ Iline_vehi +"','"+ Iplac_vehi +"','"+ Icolo_vehi + "','"+ Iestado + "')");
                JOptionPane.showMessageDialog(null, "Se creo el registro con exito", "MENSAJE", 2);
            }
            

    


//...............................................................................
    // para mostrar un Vehiculo filtrando por el consecutivo
    public void CrudBuscarVehiculo(int Fcons_vehi) {

        Conexion BC = new Conexion();
        String[][] strResultado = BC.resultadoQuery(BC.queryConsulta("SELECT cons_cons, marc_vehi, mode_vehi, line_vehi, plac_vehi, "
                + "colo_vehi, cons_vehi, estado FROM tabl_vehi WHERE cons_vehi = " + Fcons_vehi + ";"));

        cons_cons = Integer.parseInt(strResultado[0][0]);
        marc_vehi = strResultado[0][1];
        mode_vehi = strResultado[0][2];
        line_vehi = strResultado[0][3];
        plac_vehi = strResultado[0][4];
        colo_vehi = strResultado[0][5];
        cons_vehi = Integer.parseInt(strResultado[0][6]);
        estado = strResultado[0][7];

    }
//...............................................................................
    //Para modificar el registro de un Vehiculo

    public void CrudActualizarVehiculo(int Ncons_vehi, int Ncons_cons, String Nmarc_vehi, String Nmode_vehi,
            String Nline_vehi, String Nplac_vehi, String Ncolo_vehi, String Nestado) {
        Conexion AC = new Conexion();

        String[][] strResultado = AC.resultadoQuery(AC.queryConsulta("SELECT cons_cons, marc_vehi, mode_vehi, line_vehi, plac_vehi, colo_vehi, \n"
                + " estado FROM tabl_vehi"
                + " WHERE cons_vehi = " + Ncons_vehi + ";"));

        if (strResultado[0][0] != null) {
            AC.queryUpdate("UPDATE tabl_vehi SET cons_cons = " + Ncons_cons + ", marc_vehi = '" + Nmarc_vehi
                    + "', mode_vehi = '" + Nmode_vehi + "', line_vehi = '" + Nline_vehi + "',plac_vehi = '" + Nplac_vehi + "', colo_vehi= '" + Ncolo_vehi
                    + "', estado = '" + Nestado + "' WHERE cons_vehi =" + Ncons_vehi + ";");

            cons_cons = Ncons_cons;
            marc_vehi = Nmarc_vehi;
            mode_vehi = Nmode_vehi;
            line_vehi = Nline_vehi;
            plac_vehi = Nplac_vehi;
            colo_vehi = Ncolo_vehi;
            estado = Nestado;

            String strMensaje = "Se modificó el vehículo con éxito";
            JOptionPane.showMessageDialog(null, strMensaje, "MODIFICAR VEHÍCULO", 2);
        } else {
            String strMensaje = "No se pudo modificar el vehículo";
            JOptionPane.showMessageDialog(null, strMensaje, "MODIFICAR VEHÍCULO", 0);
        }
    }
    //...............................................................................
    //	Para mostrar la lista de la tabla tabl_vehi

    public Vehiculo[] CrudListaVehiculo() {

        int intCont;
        int intTama = 0;

        Conexion CC = new Conexion();

        try {
            String[][] strRes = CC.resultadoQuery(CC.queryConsulta("SELECT COUNT(cons_vehi) "
                    + "AS TANTOS FROM tabl_vehi;"));

            intTama = Integer.parseInt(strRes[0][0]);
            System.out.print("\n El tamaño es:" + intTama + "\n");

            Vehiculo[] mVehiculos = new Vehiculo[intTama]; //Constructor Arreglo

            strRes = CC.resultadoQuery(CC.queryConsulta("SELECT cons_vehi, cons_cons, marc_vehi, mode_vehi, line_vehi,"
                    + "plac_vehi, colo_vehi, estado FROM tabl_vehi "));

            for (intCont = 0; intCont < (intTama); intCont++) {
                Vehiculo tabl_vehiAux = new Vehiculo(Integer.parseInt(strRes[intCont][0]),
                        Integer.parseInt(strRes[intCont][1]), strRes[intCont][2],
                        strRes[intCont][3], strRes[intCont][4],
                        strRes[intCont][5], strRes[intCont][6], strRes[intCont][7]); // Crea instancia
                mVehiculos[intCont] = tabl_vehiAux;
            }

            System.out.print("Fueron " + intTama + " vehículos");//Muestra cuantos vehículos hay
            return mVehiculos;//Retorna los vehículos
        } catch (Exception ex) {
            String strMensaje = "Se presento un problema con la lista de vehículos";
            JOptionPane.showMessageDialog(null, strMensaje, "PROBLEMA CON LA LISTA", 0);
            System.out.print(ex);
            return null;
        }

    }
//==========================================================================================================================
// Main para hacer pruebas             

    public static void main(String[] args) {
        Vehiculo mR = new Vehiculo();

        //...................................................................................   
//        //Prueba insertar un Vehiculo 
//                mR.CrudInsertarVehiculo(1, 1, 1, 1, 20000000, "HFR-545", "200945058", "0009794583", "100cm^3", "2014", "Optra");     
//        //...................................................................................
        //pueba para buscar un Vehiculo
//        mR.CrudBuscarVehiculo(1);
//        System.out.print("\n-El nuevo Vehiculo es: " + mR.getcons_vehi() + " - " + mR.getcons_cons() + " - " + mR.getmarc_vehi() + " - " + mR.getmode_vehi() + " - " + mR.getline_vehi() + " - " + mR.getplac_vehi() + " - " + mR.getcolo_vehi() + " - " + mR.getestado() + "\n");
//        //...................................................................................
//        //Prueba para actualizar un Vehiculo
        mR.CrudActualizarVehiculo(1, 1, "Chevrolet", "999", "8877", "85885", "verde", "activo");
//        // miR.CrudActualizarVehiculo(1);        
        //System.out.print("\n-El Vehiculo modificado es: " +  mR.getintIdMarca() + " - " + mR.getintIdEstilo()+ " - " +  mR.getintIdColor() +" - " + mR.getintTipoCombustible() +" - " + mR.getintPrecio() +" - " + mR.getstrPlaca() + " - " + mR.getstrNumeroChasis() + " - " + mR.getstrNumeroMotor() + " - " + mR.getstrCilindraje() + "\n");
        mR.CrudBuscarVehiculo(1);
        System.out.print("\n-El nuevo Vehiculo es: " + mR.getcons_vehi() + " - " + mR.getcons_cons() + " - " + mR.getmarc_vehi() + " - " + mR.getmode_vehi() + " - " + mR.getline_vehi() + " - " + mR.getplac_vehi() + " - " + mR.getcolo_vehi() + " - " + mR.getestado() + "\n");
//
    }
}
