package es.uclm.esi.isoft2.CocinaAlmacen.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que engloba la figura del Agente Broker, segun un patron Singleton,
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
	 * Conexion de la base de datos.
	 */
	private Connection mBD;

	/**
	 * Constructor privado del Agente. Patron Singleton
	 * 
	 * @throws SQLException
	 */
	private Agente() throws SQLException {
		mBD = DriverManager.getConnection(CONNECTION_STRING, DBUSER, DBPASS);
	}

	/**
	 * Metodo que devuelve la instancia del Agente, segun el patron Singleton.
	 * 
	 * @return Agente Instancia Singleton
	 * @throws SQLException Excepcion provocada por la Base de Datos al momento de
	 *                      su conexion
	 */
	public static Agente getAgente() throws SQLException { // Patron Singleton
		if (mInstancia == null)
			mInstancia = new Agente();
		return mInstancia;
	}

	/**
	 * Metodo que sirve para operar sentencias SQL de creacion de tablas contra el
	 * esquema de la BD. Devuelve un entero de la cantidad de tuplas afectadas.
	 * 
	 * @param instruccion Sentencia SQL para creacion de tablas
	 * @return int Numero de lineas afectadas
	 * @throws SQLException Excepcion provocada por la Base de Datos por distintos
	 *                      tipos de problemas
	 */
	public int create(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		stmt.close();
		return res;
	}

	/**
	 * Metodo que sirve para operar sentencias SQL de insercion de tuplas sobre las
	 * tablas, contra el esquema de la BD. Devuelve un entero de la cantidad de
	 * tuplas afectadas.
	 * 
	 * @param instruccion Sentencia SQL para insercion de tuplas
	 * @return int Numero de lineas afectadas
	 * @throws SQLException Excepcion provocada por la Base de Datos por distintos
	 *                      tipos de problemas
	 */
	public int insert(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		stmt.close();
		return res;
	}

	/**
	 * Metodo que sirve para operar sentencias SQL de eliminacion de tuplas sobre
	 * las tablas, contra el esquema de la BD. Devuelve un entero de la cantidad de
	 * tuplas afectadas.
	 * 
	 * @param instruccion
	 * @return int
	 * @throws SQLException
	 */
	public int delete(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		stmt.close();
		return res;
	}

	/**
	 * Metodo que sirve para operar sentencias SQL de modificacion o actualizacion
	 * (update) de datos de tuplas de las tablas, contra el esquema de la BD.
	 * Devuelve un entero de la cantidad de tuplas afectadas.
	 * 
	 * @param instruccion
	 * @return int
	 * @throws SQLException
	 */
	public int update(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		stmt.close();
		return res;
	}

	/**
	 * Metodo que sirve para operar sentencias SQL no contempladas en los demas
	 * metodos, contra el esquema de la BD. Algunos ejemplos de sentencias son DROP
	 * TABLE, ALTER USER... Devuelve un entero de la cantidad de tuplas afectadas.
	 * 
	 * @param instruccion
	 * @return int
	 * @throws SQLException
	 */
	public int ejecutar(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		stmt.close();
		return res;
	}

	/**
	 * Metodo que sirve para realizar consultas SELECT de los datos de las tablas,
	 * del esquema. Devuelve un ResultSet de la consulta.
	 * 
	 * @param instruccion
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet select(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		ResultSet set = stmt.executeQuery(instruccion);
		return set;
	}

}
