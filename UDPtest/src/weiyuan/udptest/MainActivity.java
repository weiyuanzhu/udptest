package weiyuan.udptest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

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
		final UDPClient client = new UDPClient(str);
		
		Thread t = new Thread(){
			public void run(){
				
				client.send();
			}
			
		};
		t.start();
	}
	
	public void openServer(View view)
	{
		System.out.println("-----Open Server-----");
		ExecutorService exec = Executors.newCachedThreadPool();
		UDPServer server = new UDPServer();
		exec.execute(server);
		
		
	}
	

	
	
	

}
