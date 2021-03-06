
package gupo5.accesodatos;
import java.util.*;
import java.sql.*;

public class Conexion {
    
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://172.30.3.83:1433;databaseName=github";
    String usuario = "ronald";
    String conraseña = "123";
    Connection conexion = null;

       public void conectar() {

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, conraseña);            
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar Driver: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error de SQL: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error en conexion: " + e.getMessage());
        }
    }

    public ResultSet ejecutarQuery(String comandoSQL,  List<Parametro> lst) {
        ResultSet resultado = null;
        try {
            PreparedStatement estado = conexion.prepareStatement(comandoSQL);
            if (lst!= null) {
                for (Parametro valorP : lst) {
                    
                    if (valorP.getValor() instanceof java.util.Date) {
                        estado.setObject(valorP.getPosicion(), new java.sql.Date(((java.util.Date) valorP.getValor()).getTime()));
                    } else {
                        estado.setObject(valorP.getPosicion(), valorP.getValor());
                    }

                }
            }
            resultado = estado.executeQuery();
        }catch (Exception e) {
            System.out.println("Error en Ejecucion SQL: " + e.getMessage());
        }
        return resultado;
    }

    public int ejecutarComando(String sql, List<Parametro> lst) {
        int nFilasAfectadas=0;
        ResultSet resultado = null;
        try {
            PreparedStatement estado = conexion.prepareStatement(sql);
            if (lst != null) {
                for (Parametro valorP : lst) {
                    if (valorP.getValor() instanceof java.util.Date) {
                        estado.setObject(valorP.getPosicion(), new java.sql.Date(((java.util.Date) valorP.getValor()).getTime()));
                    } else {
                        estado.setObject(valorP.getPosicion(), valorP.getValor());
                    }
                }
            }
            nFilasAfectadas=estado.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error en Ejecucion SQL: " + e.getMessage());
        }
        return nFilasAfectadas;
    }

    public void desconectar() {

        try {
            if (conexion != null) {
                if (!conexion.isClosed()) {
                    conexion.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Error de desconexion: " + e.getMessage());
        }

    }

}
