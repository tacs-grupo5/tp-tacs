package ar.com.tacs.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.tacs.web.rest.MercadoLibreService;

/**
 * Servlet encargado de consultar el servicio de mercado libre y 
 * forwadear los sites a una jsp.
 */
public class SitesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
    /**
     * Default constructor. 
     */
    public SitesServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MercadoLibreService service = new MercadoLibreService();
		String sites = service.getMercadoLibreSites();
		request.setAttribute("sites", sites);
		getServletConfig().getServletContext().getRequestDispatcher("/mercadoLibreSites.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
