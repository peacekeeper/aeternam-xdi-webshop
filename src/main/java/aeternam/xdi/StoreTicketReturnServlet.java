package aeternam.xdi;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import xdi2.core.Graph;
import xdi2.core.exceptions.Xdi2ParseException;
import xdi2.core.impl.memory.MemoryGraphFactory;

public class StoreTicketReturnServlet extends HttpServlet {

	private static final long serialVersionUID = 4126442137479049262L;

	private static final Log log = LogFactory.getLog(StoreTicketReturnServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String xdiresponse = request.getParameter("xdi");

		Graph ticketGraph;

		try {

			ticketGraph = MemoryGraphFactory.getInstance().loadGraph(WebshopConnectionRequest.class.getResourceAsStream("/ticket.xdi"));
		} catch (Xdi2ParseException ex) {

			throw new ServletException(ex.getMessage(), ex);
		}

		Properties parameters = new Properties();
		parameters.put("pretty", "1");
		request.setAttribute("ticket", ticketGraph.toString("JXD", parameters));
		request.getRequestDispatcher("store-ticket-return.jsp").forward(request, response);
	}
}
