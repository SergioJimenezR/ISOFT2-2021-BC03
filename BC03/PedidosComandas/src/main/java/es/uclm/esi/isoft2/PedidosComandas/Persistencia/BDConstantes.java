package es.uclm.esi.isoft2.PedidosComandas.Persistencia;

public interface BDConstantes {

	final static String CONNECTION_IP = "localhost"; // ADAS "161.67.173.162" / SJR "185.61.205.215" / "localhost"
	final static String DBPORT = "3306";
	final static String DBNAME = "bc03";
	final static String CONNECTION_STRING = "jdbc:mysql://" + CONNECTION_IP + ":" + DBPORT + "/" + DBNAME;
	final static String DBUSER = "sergio";
	final static String DBPASS = "SergioJimenez1999";
}
