/*
 * 3. Create endpoint publisher
 */

package hello.jaxws.endpoint;

import javax.xml.ws.Endpoint;

public class HelloWSPublisher{
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8080/WS/Hello", new HelloImpl());
	}
}

