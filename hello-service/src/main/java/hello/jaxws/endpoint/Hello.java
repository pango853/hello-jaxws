/*
 * 1. Create a service endpoint interface
 */

package hello.jaxws.endpoint;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public interface Hello {
	@WebMethod public String sayHello(String name);
}

