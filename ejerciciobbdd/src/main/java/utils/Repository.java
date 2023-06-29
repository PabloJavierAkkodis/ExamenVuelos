package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Repository {
	
	Connection conn = null;
	String dbServer = "mssql-133683-0.cloudclusters.net"; // change it to your database server name 
	int dbPort = 19494; // change it to your database server port
	String dbName = "PabloDB";
	String userName = "Pablo";
	String password = "Administrador2";
	String url = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=true", 
			dbServer, dbPort, dbName, userName, password);
	
	Statement stmt;
	
	
	protected static Repository instance;
	
	
	public Repository() {
		instance = this;
		connect();
	}



	
	public static Repository getRepo() {
		if(instance == null) {
			return new Repository();
		} else {
			return instance;
		}
	}
	
	
	
	
	
	private void connect() {
		
		System.out.println("CONECTANDO");
		
		try {
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	
	
	
	
	
	
	
	
	public String readTable(String table) {
		String result = "";
		try {
			
		
		
		
		// query data
        String sql = "select * from " + table;
        ResultSet rs = stmt.executeQuery(sql);
		
        
        
        //read data
        while (rs.next()) {
			for(int i = 1; i < 10; i++){
				try {
					
					System.out.print(rs.getString(i) + "\t");
					result = result + "\t"  + rs.getString(i);
				} catch(Exception e) {
					continue;
				}
				
			}
			System.out.println("");
		}
			
			
			
		} catch (SQLException e) {
			System.out.println("No fue posible leer la tabla " + table);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return result;
	}
	
	
	
	
	
	public boolean borrarPorId(String table, int id) {
		
		boolean result = true;
		try {
			
		
		
		
		// query data
        String sql = "delete from dbo."+table+" where "+table+"_id = " + id;
        ResultSet rs = stmt.executeQuery(sql);
		
			
		} catch (SQLException e) {
        } catch (Exception e) {
            result = false;
        }
		
		return result;
	}
	
	
	
	public boolean insertUser(String nombre, int edad) {
		
		boolean result = true;
		try {
			
		// query data
        String sql = "INSERT INTO usuario (nombre, edad) VALUES (\'"+nombre+"\', "+edad+")";
        ResultSet rs = stmt.executeQuery(sql);
		
		} catch (Exception e) {
			result = false;
        }
		return result;
	}
	
	
	
	public String readTareaUsuario(String usuario) {
		String result = "";
		try {
			
		
		
		
		// query data
        String sql = "select t.tarea_id , t.nombre , t.fecha_limite , c.nombre , u.nombre  from tarea t, asignacion_tarea at2, usuario u, categoria c  where c.categoria_id = t.categoria  AND tarea_id = at2.tarea AND u.usuario_id = at2.usuario AND U.nombre  = \\'"+usuario+"\\'";
        ResultSet rs = stmt.executeQuery(sql);
		
        
        
        //read data
        while (rs.next()) {
			for(int i = 1; i < 10; i++){
				try {
					
					System.out.print(rs.getString(i) + "\t");
					result = result + "\t"  + rs.getString(i);
				} catch(Exception e) {
					continue;
				}
				
			}
			System.out.println("");
		}
			
			
			
		} catch (SQLException e) {
			System.out.println("No fue posible leer la tabla ");
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return result;
	}
	
	
	
	public void closeConn() {

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	

}
