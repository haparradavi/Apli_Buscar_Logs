package com.Globales;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.Session;

public class Globalvar {
	
	public static Session sessionGlobal ;
	public static ChannelSftp sftpChannel;
	public static int tipoAmbiente=0;
	public static int indFechaInicioglobal =0;
	
	

	public static Session getSessionGlobal() {
		return sessionGlobal;
	}

	public static void setSessionGlobal(Session sessionGlobal) {
		Globalvar.sessionGlobal = sessionGlobal;
	}

	public static ChannelSftp getSftpChannel() {
		return sftpChannel;
	}

	public static void setSftpChannel(ChannelSftp sftpChannel) {
		Globalvar.sftpChannel = sftpChannel;
	}

	public static int getTipoAmbiente() {
		return tipoAmbiente;
	}

	public static void setTipoAmbiente(int tipoAmbiente) {
		Globalvar.tipoAmbiente = tipoAmbiente;
	}

	public static int getIndFechaInicioglobal() {
		return indFechaInicioglobal;
	}

	public static void setIndFechaInicioglobal(int indFechaInicioglobal) {
		Globalvar.indFechaInicioglobal = indFechaInicioglobal;
	}

	
	


}
