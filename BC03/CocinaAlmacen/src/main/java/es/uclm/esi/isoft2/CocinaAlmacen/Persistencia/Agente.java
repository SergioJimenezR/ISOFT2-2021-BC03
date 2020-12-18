package es.uclm.esi.isoft2.CocinaAlmacen.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que engloba la figura del Agente Broker, según un patrón Singleton,
 * para las operaciones del programa contra la base de datos.
 * 
 * @author BC03
 *
 */

public class Agente implements BDConstantes {

	/**
	 * Instancia singleton del Agente.
	 */
	private static Agente mInstancia = null;
	/**
	 * Conexión de la base de datos.
	 */
	private Connection mBD;

	/**
	 * Constructor privado del Agente. Patrón Singleton
	 * 
	 * @throws SQLException
	 */
	private Agente() throws SQLException {
		mBD = DriverManager.getConnection(CONNECTION_STRING, DBUSER, DBPASS);
	}

	/**
	 * Método que devuelve la instancia del Agente, según el patrón Singleton.
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Agente getAgente() throws SQLException { // Patron Singleton
		if (mInstancia == null)
			mInstancia = new Agente();
		return mInstancia;
	}

	/**
	 * Método que sirve para operar sentencias SQL de creación de tablas contra el
	 * esquema de la BD. Devuelve un entero de la cantidad de tuplas afectadas.
	 * 
	 * @param instruccion
	 * @return
	 * @throws SQLException
	 */
	public int create(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		stmt.close();
		return res;
	}

	/**
	 * Método que sirve para operar sentencias SQL de inserción de tuplas sobre las
	 * tablas, contra el esquema de la BD. Devuelve un entero de la cantidad de
	 * tuplas afectadas.
	 * 
	 * @param instruccion
	 * @return
	 * @throws SQLException
	 */
	public int insert(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		stmt.close();
		return res;
	}

	/**
	 * Método que sirve para operar sentencias SQL de eliminación de tuplas sobre
	 * las tablas, contra el esquema de la BD. Devuelve un entero de la cantidad de
	 * tuplas afectadas.
	 * 
	 * @param instruccion
	 * @return
	 * @throws SQLException
	 */
	public int delete(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		stmt.close();
		return res;
	}

	/**
	 * Método que sirve para operar sentencias SQL de modificación o actualización
	 * (update) de datos de tuplas de las tablas, contra el esquema de la BD.
	 * Devuelve un entero de la cantidad de tuplas afectadas.
	 * 
	 * @param instruccion
	 * @return
	 * @throws SQLException
	 */
	public int update(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		stmt.close();
		return res;
	}

	/**
	 * Método que sirve para operar sentencias SQL no contempladas en los demás
	 * métodos, contra el esquema de la BD. Algunos ejemplos de sentencias son DROP
	 * TABLE, ALTER USER... Devuelve un entero de la cantidad de tuplas afectadas.
	 * 
	 * @param instruccion
	 * @return
	 * @throws SQLException
	 */
	public int ejecutar(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		stmt.close();
		return res;
	}

	/**
	 * Método que sirve para realizar consultas SELECT de los datos de las tablas,
	 * del esquema. Devuelve un ResultSet de la consulta.
	 * 
	 * @param instruccion
	 * @return
	 * @throws SQLException
	 */
	public ResultSet select(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		ResultSet set = stmt.executeQuery(instruccion);
		return set;
	}

}
