package es.uclm.esi.isoft2.CocinaAlmacen.Persistencia;

/**
 * Interface de constantes que reúne la información necesaria para que el
 * Agente-Broker según patrón Singleton de este módulo se conecte a la Base de
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
