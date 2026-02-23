package week4.day1;

public class JavaConnection1 extends MySqlConnection {
    
	@Override
	public void connect() {
		System.out.println("Connect method called from JavaConnection");
	}

	@Override
	public void disconnect() {
		System.out.println("Disconnect method called from JavaConnection");
	}

	@Override
	public void executeUpdate() {
		System.out.println("ExecuteUpdate method called from JavaConnection");
	}

	@Override
	public void executeQuery() {
		System.out.println("ExecuteQuery method called from JavaConnection");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaConnection1 javaConnectionObj = new JavaConnection1();
		javaConnectionObj.connect();
		javaConnectionObj.disconnect();
		javaConnectionObj.executeUpdate();
		javaConnectionObj.executeQuery();

	}

}
