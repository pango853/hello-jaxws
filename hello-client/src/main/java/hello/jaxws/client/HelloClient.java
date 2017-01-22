package hello.jaxws.client;

import java.net.URL;
import java.net.MalformedURLException;

import hello.jaxws.endpoint.Hello;
import hello.jaxws.endpoint.HelloImplService; // HelloImpl -> HelloImplService

public class HelloClient{

	public static void main(String[] args){
		try{
			//HelloImplService service = new HelloImplService();
			// Set endpoint location. Otherwise you will get WebServiceException: Unsupported endpoint address: REPLACE_WITH_ACTUAL_URL
			URL endpoint = new URL("http://localhost:8080/WS/Hello?wsdl");
			HelloImplService service = new HelloImplService(endpoint);

			Hello port = service.getHelloImplPort();
			System.out.println(port.sayHello("Client"));
		}catch(MalformedURLException e){
			e.printStackTrace();
		}
	}
}

