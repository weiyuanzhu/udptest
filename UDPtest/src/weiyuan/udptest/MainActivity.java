package weiyuan.udptest;

import java.util.List;
import java.util.concurrent.*;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	private UDPClient udpClient = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	
	public void send(View view)
	{
		
		System.out.println("send udp package");
		String str = "FIND";
		udpClient = new UDPClient(str);
		
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(udpClient);
		exec.shutdown();
		
		
		
//		Thread t = new Thread(){
//			public void run(){
//				
//				client.send();
//			}
//			
//		};
//		t.start();
	}
	
	public void openServer(View view)
	{
		System.out.println("-----Open Server-----");
		ExecutorService exec = Executors.newCachedThreadPool();
		UDPServer server = new UDPServer();
		exec.execute(server);
		
		
	}
	
	public void printPanelList(View view)
	{
		List<int[]> panelList = udpClient.getPanelList();
		for(int i=0; i<panelList.size();i++)
		{
			System.out.print("\n");
			int[] list =  panelList.get(i);
			for(int j=0; j<list.length;j++)
			{
				
				System.out.print(list[j] + " ");
				
			}
			
		}
		
	}
	
	

}
