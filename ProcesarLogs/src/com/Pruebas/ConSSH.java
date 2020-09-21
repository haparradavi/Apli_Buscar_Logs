package com.Pruebas;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class ConSSH {

	public static void main(String[] args)  {
		JSch jsch = new JSch();
		Session session = null;
        String username = "mqbrk";
        String host = "wmbdes";
        String passwd = "Sep*Integraci0n";
		try {
			session = jsch.getSession(username, host, 22);
			session.setPassword(passwd);
			session.setConfig("StrictHostKeyChecking", "no");			
			session.connect();
			System.out.println("conexion exitosa");
			
			Channel channel = session.openChannel("sftp");
			channel.connect();
			ChannelSftp sftpChannel = (ChannelSftp) channel;
			System.out.println("vamo1s");
			InputStream stream = sftpChannel.get("/ESB/log/trace/mqsitransit/trazabilidad202009090aaaa95303.log");
		System.out.println("vamos");
				BufferedReader br = new BufferedReader(new InputStreamReader(stream));
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					break;
				}



			sftpChannel.exit();
			session.disconnect();
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}
	
}