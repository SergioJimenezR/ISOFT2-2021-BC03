package es.uclm.esi.isoft2.CocinaAlmacen.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Agente implements BDConstantes {

	protected static Agente mInstancia = null;
	protected Connection mBD;

	protected Agente() throws SQLException {
		mBD = DriverManager.getConnection(CONNECTION_STRING, DBUSER, DBPASS);
	}

	public static Agente getAgente() throws SQLException { // Patrón Singleton
		if (mInstancia == null)
			mInstancia = new Agente();
		return mInstancia;
	}

	public int create(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		stmt.close();
		return res;
	}

	public int insert(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		stmt.close();
		return res;
	}

	public int delete(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		stmt.close();
		return res;
	}

	public int update(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		stmt.close();
		return res;
	}

	public int ejecutar(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		stmt.close();
		return res;
	}

	public ResultSet select(String instruccion) throws SQLException {
		Statement stmt = mBD.createStatement();
		ResultSet set = stmt.executeQuery(instruccion);
		return set;
	}

}
