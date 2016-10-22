import org.zhxu.network.*;

public class ServiceLauncher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SchoolManagementLauncher schMgt = new SchoolManagementLauncher();
		schMgt.go();
		
        ChatServer srv = new ChatServer();
        ChatClient clnt = new ChatClient();
		Thread t1 = new Thread(srv);
		Thread t2 = new Thread(clnt);
		
		t1.setName("ThreadServer");
		t2.setName("ThreadClient");
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		System.out.print("The priority of Server Thread is ");
		System.out.println(t1.getPriority());
		
		System.out.print("The priority of Client Thread is ");
		System.out.println(t2.getPriority());

		t1.start();
		t2.start();

	}

}
