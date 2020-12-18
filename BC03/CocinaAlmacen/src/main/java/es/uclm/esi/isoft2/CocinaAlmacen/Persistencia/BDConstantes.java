package es.uclm.esi.isoft2.CocinaAlmacen.Persistencia;

/**
 * Interface de constantes que reune la informacion necesaria para que el
 * Agente-Broker segun patron Singleton de este modulo se conecte a la Base de
 * Datos JDBC - MySQL.
 * 
 * @author BC03
 *
 */

public interface BDConstantes {

	final static String CONNECTION_IP = "172.20.48.70";
	final static String DBPORT = "3306";
	final static String DBNAME = "BC03dbservice";
	final static String CONNECTION_STRING = "jdbc:mysql://" + CONNECTION_IP + ":" + DBPORT + "/" + DBNAME;
	final static String DBUSER = "BC03";
	final static String DBPASS = "RestauranteLaBlasa.1€";

}
