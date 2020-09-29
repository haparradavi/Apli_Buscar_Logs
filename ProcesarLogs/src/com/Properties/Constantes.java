package com.Properties;

public class Constantes {
	
	public final static String rutaProperties = "src/com/Properties/DatosConexion.properties";
	public final static String rutaicono="/com/Images/logo6.png";
	
	public final static String MsgResultTrazaLog =" No se encontro información en el Log.";
	public final static String MsgResultError = "No se encontro errores de la traza.";
	public final static String MsgIdTransaccion = "";
	public final static String MsgResultTrazaLogOK =" Se genero el log con información";
	public final static String MsgBusquedaTraza ="Error al generar la busqueda de la traza.";
	public final static String MsgConexionAmbientes="Debe generar conexión con alguno de los 3 ambientes para realizar el proceso.";
	public final static String MsgSeleccionFabrica="Debe seleccionar una fabrica para buscar la traza en los logs.";
	public final static String MsgCriterioBusqueda="Debe ingresar al menos un criterio de busqueda.";
	public final static String MsgNofoundSyslog="No se encontro información en el syslog.";
	public final static String Msgselecionarambienteconexion="Debe seleccionar un ambiente para conectarse.";
	public final static String MsgConexionIncorrecta="No se puedo establecer conexión";
	public final static String MsgConexionExitosa="Conexión Exitosa";
	public final static String MsgProcesoEspera="Se esta ejecutando la operación por favor espere";
	public final static String MsgTituloDialog="Procesando...";
	public final static String MsgservicioNoencontradoTraza="Servicio no encontrado, buscar con la fecha de la transaccion en el campo IdTransaccion";
	public final static String MsgservicionoencontradoError="No se proceso el archivo de error debido a que no de encontro informacion del servicio";
	
	public final static String nameAplicacion="Aplicacion Busqueda Logs";
	
	
	public static String getRutaproperties() {
		return rutaProperties;
	} 
	
	
	

}
