package weiyuan.udptest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPClient {

	private static final int SERVER_PORT = 1460;
	
	private DatagramSocket udpSocket = null;
	private DatagramPacket udpPacket = null; 
	private boolean isListen = true;
	
	private String msg;
	
	public UDPClient(String msg)
	{
		super();
		this.msg = msg;
	}
	
	public int send()
	{
		try {
			InetAddress address = InetAddress.getByName("255.255.255.255");
			
			udpSocket = new DatagramSocket();
			
			int msg_len = msg == null? 0 : msg.length();
			
			udpPacket = new DatagramPacket(msg.getBytes(),msg_len,address,SERVER_PORT);
			
			
			
			
		} catch (UnknownHostException | SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			udpSocket.send(udpPacket);
			Runnable receive= new Runnable()
			{

				@Override
				public void run() {

					System.out.println("---------------receiving udp packages------------");
					while(isListen)
					{
						try {
							udpSocket.receive(udpPacket);
							String result = new String(udpPacket.getData(),udpPacket.getOffset(),udpPacket.getLength());
							System.out.println(result);
							
					
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}



			};
			Thread t = new Thread(receive);
			t.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return 0;
	}

	public boolean isListen() {
		return isListen;
	}

	public void setListen(boolean isListen) {
		this.isListen = isListen;
	}
	
	
}
