package week3.day4;

public class APIClient {

	public void sendRequest(String endpoint) {
		System.out.println("sendRequest(String endpoint) method called");
		System.out.println("Endpoint: " + endpoint);
	}

	public void sendRequest(String endpoint, String requestBody, boolean requestStatus) {
		System.out.println("sendRequest(String endpoint, String requestBody, boolean requestStatus) method called");
		System.out.println("Endpoint: " + endpoint);
		System.out.println("Request Body: " + requestBody);
		System.out.println("Request Status: " + requestStatus);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		APIClient apiClientObj = new APIClient();
		apiClientObj.sendRequest("https://google.com");
		apiClientObj.sendRequest("https://google.com", "{'searchText':'testing'}", true);
	}

}
