package com.Pruebas;

import com.jcraft.jsch.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;



	public class ConexionSShFull {

	       Session session = null;
	       ChannelExec channel=null;

	       public ConexionSShFull(){

	       }
	       
	       

	       public static void main(String... args) throws JSchException, IOException {
	    	   	
	           ConexionSShFull up = new ConexionSShFull();
	           up.connect();

//	           up.executeCommand("cd /ESB/log/trace/mqsitransit/; ls -1tr | tail -1");
	           up.executeCommand("grep -i d0506146f6fe11eaaad65a0405110000d05062eaf6fe11ea /ESB/log/trace/mqsitransit/trazabilidad20200914144529.log");
	          
	           up.disconnect();
	       }
	       

	       public void connect(){
	       try {

	               JSch jsch = new JSch();
	               session = jsch.getSession("mqbrk", "90.4.5.17", 22);
	               session.setPassword("Sep*Integraci0n");
	               java.util.Properties config = new java.util.Properties();
	               config.put("StrictHostKeyChecking", "no");
	               session.setConfig(config);
	               session.connect();
	           } catch (Exception ex) {
	               ex.printStackTrace();
	           }
	       }

	       public void executeCommand(String script) throws JSchException, IOException{
	           System.out.println("Execute sudo");
	           String sudo_pass = "test";
	           channel = (ChannelExec) session.openChannel("exec");
	           ((ChannelExec) channel).setCommand( script);

	           InputStream in = channel.getInputStream();
	           OutputStream out = channel.getOutputStream();
	           ((ChannelExec) channel).setErrStream(System.err);

	           channel.connect();
	         //  out.write((sudo_pass + "\n").getBytes());
	           out.flush();
	           List<String> data= new ArrayList<String>();
	           String rueba ="";
	           byte[] tmp = new byte[1024];
	           while (true) {
	               while (in.available() > 0) {
	                   int i = in.read(tmp, 0, 1024);
	                   if (i < 0)
	                       break;
	                  data.add(new String(tmp, 0,i));
	                  rueba =rueba+new String(tmp, 0,i);
	                   //System.out.print(new String(tmp, 0, i));
	               }
	               if (channel.isClosed()) {
	                   System.out.println("exit-status: " + channel.getExitStatus());
	                   break;
	               }
	               try {
	                   Thread.sleep(1000);
	               } catch (Exception ee) {
	                   System.out.println(ee);
	               }
	           }

	           
	           System.out.print("------------------------- \n");
	           try {

		           System.out.print("prueb "+rueba);
			} catch (Exception e) {
				System.out.println("Eror "+e.getMessage());
			}



	       }

	       public void disconnect(){
	    	   channel.disconnect();
	           session.disconnect();
	       }



	}
