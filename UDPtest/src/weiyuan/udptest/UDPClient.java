package weiyuan.udptest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {

	private static final int SERVER_PORT = 6000;
	
	private DatagramSocket udpSocket = null;
	private DatagramPacket udpPacket = null; 
	
	private String msg;
	
	public UDPClient(String msg)
	{
		super();
		this.msg = msg;
	}
	
	public int send()
	{
		try {
			InetAddress address = InetAddress.getByName("localhost");
			
			udpSocket = new DatagramSocket();
			
			int msg_len = msg == null? 0 : msg.length();
			
			udpPacket = new DatagramPacket(msg.getBytes(),msg_len,address,SERVER_PORT);
			
			
			
			
		} catch (UnknownHostException | SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			udpSocket.send(udpPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return 0;
	}
	
	
}
