package weiyuan.udptest;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author weiyuan zhu
 * date: 10/04/2014
 * android network UDP server class
 */
public class UDPServer implements Runnable{

	private static final int PORT = 6000;
	
	private byte[] msg = new byte[1024];
	
	private boolean live = true;
	
	
	public UDPServer(){}


	public boolean isLive() {
		return live;
	}


	public void setLive(boolean live) {
		this.live = live;
	}


	@Override
	public void run() {
		
		DatagramSocket udpSocket = null;
		DatagramPacket udpPacket = new DatagramPacket(msg,msg.length);
		
		try {
			udpSocket = new DatagramSocket(PORT);
			while (live)
			{
				try {
					udpSocket.receive(udpPacket);
					String result = new String(udpPacket.getData(),udpPacket.getOffset(),udpPacket.getLength());
					
					System.out.println("Message received------------->" + result );
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			
			
			
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	

	
	
	
}
