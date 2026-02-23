package week4.day1;

public class JavaConnection implements DatabaseConnection {

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

	public static void main(String[] args) {
		JavaConnection javaConnectionObj = new JavaConnection();
		javaConnectionObj.connect();
		javaConnectionObj.disconnect();
		javaConnectionObj.executeUpdate();
	}
}
