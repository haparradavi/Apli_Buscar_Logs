package com.procesarlogs;

import java.io.BufferedWriter;
import java.io.InputStream;

public class ParametrosLogsDAO {
	
	private String nombreServicio;
	private int ambienteFabrica;
	private String idtransaccion;
	private int tipoProcesoLog;
	private String canal;
	private String adaptador;
	private String fechaInicio;
	private String fechaFin;
	private String rutaDestinoArchivo;
	private String rutaTraza;
	private String rutaErrorlog;
	private BufferedWriter bufferwrite;
	private int closeFilesearchDate =0;
	private String busquedaparametro  ="";
	private String nameLogcommand  ="";
	private String nameErrorcommand  ="";
	private InputStream stream =null;
	private String fechatransaccion =null;
	private String resultBusquedaLog =null;
	private String resultBusquedaError =null;
	
	
	public String getNombreServicio() {
		return nombreServicio;
	}
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	public int getAmbienteFabrica() {
		return ambienteFabrica;
	}
	public void setAmbienteFabrica(int ambienteFabrica) {
		this.ambienteFabrica = ambienteFabrica;
	}
	public String getIdtransaccion() {
		return idtransaccion;
	}
	public void setIdtransaccion(String idtransaccion) {
		this.idtransaccion = idtransaccion;
	}
	public int getTipoProcesoLog() {
		return tipoProcesoLog;
	}
	public void setTipoProcesoLog(int tipoProcesoLog) {
		this.tipoProcesoLog = tipoProcesoLog;
	}
	public String getCanal() {
		return canal;
	}
	public void setCanal(String canal) {
		this.canal = canal;
	}
	public String getAdaptador() {
		return adaptador;
	}
	public void setAdaptador(String adaptador) {
		this.adaptador = adaptador;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getRutaDestinoArchivo() {
		return rutaDestinoArchivo;
	}
	public void setRutaDestinoArchivo(String rutaDestinoArchivo) {
		this.rutaDestinoArchivo = rutaDestinoArchivo;
	}
	public String getRutaTraza() {
		return rutaTraza;
	}
	public void setRutaTraza(String rutaTraza) {
		this.rutaTraza = rutaTraza;
	}
	public String getRutaErrorlog() {
		return rutaErrorlog;
	}
	public void setRutaErrorlog(String rutaErrorlog) {
		this.rutaErrorlog = rutaErrorlog;
	}
	public BufferedWriter getBufferwrite() {
		return bufferwrite;
	}
	public void setBufferwrite(BufferedWriter bufferwrite) {
		this.bufferwrite = bufferwrite;
	}
	public int getCloseFilesearchDate() {
		return closeFilesearchDate;
	}
	public void setCloseFilesearchDate(int closeFilesearchDate) {
		this.closeFilesearchDate = closeFilesearchDate;
	}
	public String getBusquedaparametro() {
		return busquedaparametro;
	}
	public void setBusquedaparametro(String busquedaparametro) {
		this.busquedaparametro = busquedaparametro;
	}
	public String getNameLogcommand() {
		return nameLogcommand;
	}
	public void setNameLogcommand(String nameLogcommand) {
		this.nameLogcommand = nameLogcommand;
	}
	public String getNameErrorcommand() {
		return nameErrorcommand;
	}
	public void setNameErrorcommand(String nameErrorcommand) {
		this.nameErrorcommand = nameErrorcommand;
	}
	public InputStream getStream() {
		return stream;
	}
	public void setStream(InputStream stream) {
		this.stream = stream;
	}
	public String getFechatransaccion() {
		return fechatransaccion;
	}
	public void setFechatransaccion(String fechatransaccion) {
		this.fechatransaccion = fechatransaccion;
	}
	public String getResultBusquedaLog() {
		return resultBusquedaLog;
	}
	public void setResultBusquedaLog(String resultBusquedaLog) {
		this.resultBusquedaLog = resultBusquedaLog;
	}
	public String getResultBusquedaError() {
		return resultBusquedaError;
	}
	public void setResultBusquedaError(String resultBusquedaError) {
		this.resultBusquedaError = resultBusquedaError;
	}
	
	

}
