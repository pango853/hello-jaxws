package hello.jaxws.client;

import hello.jaxws.endpoint.Hello;
import hello.jaxws.endpoint.HelloImplService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

import java.net.URL;  
import java.net.MalformedURLException;
import javax.xml.namespace.QName;  
import javax.xml.ws.Service;  


@WebServlet(name="HelloServlet", urlPatterns={"/hello"})
public class HelloServlet extends HttpServlet{

	@WebServiceRef(wsdlLocation="http://localhost:8080/WS/HelloService?WSDL")
	private HelloImplService _service;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		processRequest(request, response);
	}

	/**
	 * Processes requests for both HTTP <code>GET</code> 
	 *   and <code>POST</code> methods.
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()){
			
			out.println("<html lang=\"en\">");
			out.println("<head>");
			out.println("<title>Servlet HelloServlet</title>");  
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet HelloServlet at " + request.getContextPath () + "</h1>");
			out.println("<p>" + sayHello("world") + "</p>");
			out.println("</body>");
			out.println("</html>");
		}
	} 

	private static final String WSDL_LOCATION = "http://localhost:8080/WS/HelloImplService?WSDL";
	private static final String SERVICE_URI = "http://endpoint.jaxws.hello/";
	private static final String SERVICE_NAME = "HelloImplService";

	// doGet and doPost methods, which call processRequest, and
	// getServletInfo method
	private String sayHello(String arg0){
		Hello port = null;

		// FIXME WebServiceRef injection above is not working
		if(null == _service){
			try{
				Service service = Service.create(new URL(WSDL_LOCATION), new QName(SERVICE_URI, SERVICE_NAME));
				port = service.getPort(Hello.class);
			}catch(MalformedURLException e){
				e.printStackTrace();
				return "ERROR!";
			}
		}else{
			port = _service.getHelloImplPort();
		}
		return port.sayHello(arg0);
	}
}

