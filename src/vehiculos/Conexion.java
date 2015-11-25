//Clase de conexion con base de datos postgres
package vehiculos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Conexion {


    public String user = "udec";
    public String password = "udec";
    
  
    private String strIp = "localhost" ;                       	//Dirección IP del servidor donde este la base de datos
    private String strPuerto = "5432" ;                             //Puerto del servidor de bases de datos
    private String strTipo = "postgresql" ;                               //Tipo de Servidor
    private String strBD = "udec" ;                                	//Nombre de la base de datos
    private String strClassForName = "org.postgresql.Driver" ;          				//Para crear la clase por nombre segun el tipo y el driver
    private String strUrl;
    
    
    private DatabaseMetaData dbmd;                          //Metadatos de la BD
    private Statement stmt;                                 //Consulta o instrución SQL establecida
    private Connection conexion;                            //Conexión

    public String strError;     
    
    public void setuser(String newVal){
    this.user=newVal;
    }
    public void setpass(String newVal){
    this.password=newVal;
    }
    public String getuser(){
    return user;
    } 
   public String getpass(){
    return password;
    }
   
    public Conexion()
    { //this.user= user;
//      this.password =pass;
		//Valida que los datos de la conexión esten completos 
        if(strIp.compareTo("")==0 || strPuerto.compareTo("")==0 || strTipo.compareTo("")==0 || strBD.compareTo("")==0  
                                                                            || strClassForName.compareTo("")==0)
        {
            System.out.print("No estan todos los parametros o no todos son correctos");
        }
        else
        {	//Arma la URL
             strUrl = "jdbc:" + strTipo + "://" + strIp + ":" + strPuerto + "/" + strBD;

            try
            {   
                Class.forName(strClassForName);
                strError = "Creo la Conexion";
                conexion = DriverManager.getConnection(strUrl, user, password);
                System.out.print("Ya estan todos los parametros\n");

                stmt = conexion.createStatement();
                System.out.println("LISTO YA ME CONECTE ");
            }
            catch (SQLException e)
            {
                strError = strUrl;
                System.out.print("\nError 1 " + e);
            }
            catch (java.lang.ClassNotFoundException e)
            {
                strError = strUrl;
                System.out.print("\nError 2 " + e);
            }
        }
    }
    
    
    public ResultSet queryConsulta(String Consulta)
    {
        ResultSet rs;
        rs = null;

        try
        {
            rs = stmt.executeQuery(Consulta);
        }
        catch (SQLException e)
        {
            System.out.print("\nError 5 " + e);
        }
        return rs;
    }
    
    
    public int queryUpdate(String Consulta)
    {
        int filas;
        filas = 0;

        try
        {
            filas = stmt.executeUpdate(Consulta);
        }
        catch (SQLException e)
        {
            System.out.print("\nError 6 " + e);
        }

        return filas;
    }

    
    public String[][] resultadoQuery(ResultSet rs)
    {
        String [][] elementos;
        elementos = null;
        int i,j;

        try
        {
            ResultSetMetaData rsmd;
            rsmd = rs.getMetaData();
            elementos = new String [100][rsmd.getColumnCount()];
            i=0;
            j=0;

            while(rs.next())
            {
                for(j = 0 ;j<rsmd.getColumnCount();j++)
                {
                    elementos[i][j]=rs.getString(j+1);
                }
                i++;
            }

        }
        catch (SQLException e)
        {
            System.out.print("\nError 7 " + e);
        }

        return elementos;
    }
     
    
    public Connection getConexion()
    {
        return conexion;
    }
    
    public static void main(String[] args) {
        
       
        Conexion C = new Conexion();
        
        

        String R[][] = C.resultadoQuery(C.queryConsulta("select nume_iden, prim_nomb from tabl_clie where cons_clie = 2;"));
        System.out.print("\n: " + R[0][0] + " - " + R[0][1] + "\n");
        
        
        C.queryUpdate("UPDATE tabl_clie SET prim_nomb = 'Andres' WHERE nume_iden::integer = '1002396' ;");
        
    }
    }
    

