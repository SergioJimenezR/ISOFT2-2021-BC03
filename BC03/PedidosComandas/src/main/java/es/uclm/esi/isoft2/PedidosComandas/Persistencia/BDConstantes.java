package es.uclm.esi.isoft2.PedidosComandas.Persistencia;

public interface BDConstantes {

	final static String CONNECTION_IP = "172.20.48.70";
	final static String DBPORT = "3306";
	final static String DBNAME = "BC03dbservice";
	final static String CONNECTION_STRING = "jdbc:mysql://" + CONNECTION_IP + ":" + DBPORT + "/" + DBNAME;
	final static String DBUSER = "BC03";
	final static String DBPASS = "RestauranteLaBlasa.1€";

}
