package hello.jaxws.client;

import hello.jaxws.endpoint.Hello;
import hello.jaxws.endpoint.HelloImplService; // HelloImpl -> HelloImplService

public class HelloClient{

	public static void main(String[] args){
		HelloImplService service = new HelloImplService();
		Hello port = service.getHelloImplPort();
		System.out.println(port.sayHello("Client"));
	}
}

