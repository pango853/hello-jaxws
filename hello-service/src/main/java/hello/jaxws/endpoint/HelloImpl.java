/*
 * 2. Create a service endpoint implementation class
 */

package hello.jaxws.endpoint;

import javax.jws.WebService;

@WebService(endpointInterface="hello.jaxws.endpoint.Hello")
public class HelloImpl implements Hello{
	private final String message = "Hello, ";

	public HelloImpl() {
	}

	@Override
	public String sayHello(String name) {
		return message + name + ".";
	}
}

