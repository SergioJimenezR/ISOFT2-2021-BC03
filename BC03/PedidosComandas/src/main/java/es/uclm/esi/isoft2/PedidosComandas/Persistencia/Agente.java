package es.uclm.esi.isoft2.PedidosComandas.Persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Agente implements BDConstantes {

	protected static Agente mInstancia = null;
	protected Connection mBD;
	protected Statement stmt;
	
	protected Agente() throws SQLException {
		mBD = DriverManager.getConnection(CONNECTION_STRING, DBUSER, DBPASS);
		stmt = mBD.createStatement();
	}

	public static Agente getAgente() throws SQLException { // Patr�n Singleton. ��Es est�tico!!
		if (mInstancia == null)
			mInstancia = new Agente();
		return mInstancia;
	}

	public int insert(String instruccion) throws SQLException {
		//Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		//stmt.close();
		return res;
	}

	public int delete(String instruccion) throws SQLException {
		//Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		//stmt.close();
		return res;
	}

	public int create(String instruccion) throws SQLException {
		//Statement stmt = mBD.createStatement();
		int res = stmt.executeUpdate(instruccion);
		//stmt.close();
		return res;
	}

	public ResultSet select(String instruccion) throws SQLException {
		//Statement stmt = mBD.createStatement();
		ResultSet set = stmt.executeQuery(instruccion);
		return set;
	}

}
