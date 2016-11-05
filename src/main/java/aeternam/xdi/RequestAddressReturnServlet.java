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

public class RequestAddressReturnServlet extends HttpServlet {

	private static final long serialVersionUID = 3716999752371513442L;

	private static final Log log = LogFactory.getLog(RequestAddressReturnServlet.class);

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String xdiresponse = request.getParameter("xdi");

		Graph resultGraph;

		try {

			resultGraph = MemoryGraphFactory.getInstance().parseGraph(xdiresponse);
		} catch (Xdi2ParseException ex) {

			throw new ServletException(ex.getMessage(), ex);
		}

		Properties parameters = new Properties();
		parameters.put("pretty", "1");
		request.setAttribute("xdiresponse", resultGraph.toString("JXD", parameters));
		request.getRequestDispatcher("request-address-return.jsp").forward(request, response);
	}
}
