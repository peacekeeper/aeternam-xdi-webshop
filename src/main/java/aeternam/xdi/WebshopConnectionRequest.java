package aeternam.xdi;

import java.net.URI;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import xdi2.connect.core.ConnectionRequest;
import xdi2.core.impl.memory.MemoryGraphFactory;
import xdi2.core.syntax.CloudName;
import xdi2.messaging.MessageEnvelope;

public class WebshopConnectionRequest {

	public static ConnectionRequest CONNECTION_REQUEST1 = null;
	public static ConnectionRequest CONNECTION_REQUEST2 = null;

	private static Logger log = LoggerFactory.getLogger(WebshopConnectionRequest.class);

	public static ConnectionRequest requestAddressConnectionRequest(ServletContext servletContext) {

		if (CONNECTION_REQUEST1 == null) {

			try {

				String baseReturnUri = servletContext.getInitParameter("baseReturnUri");

				CONNECTION_REQUEST1 = ConnectionRequest.fromMessageEnvelope(MessageEnvelope.fromGraph(MemoryGraphFactory.getInstance().loadGraph(WebshopConnectionRequest.class.getResourceAsStream("/message-request-address.xdi"))));
				log.info("Connection request: " + CONNECTION_REQUEST1.getMessageEnvelope().getGraph().toString());
				CONNECTION_REQUEST1.sign(CloudName.create("+webshop"), "alice");
				CONNECTION_REQUEST1.setReturnUri(URI.create(baseReturnUri + "request-address-return"));
				log.info("Connection request ready: " + CONNECTION_REQUEST1.getMessageEnvelope().getGraph().toString());
			} catch (Exception ex) {

				CONNECTION_REQUEST1 = null;
				throw new RuntimeException(ex.getMessage(), ex);
			}
		}

		return CONNECTION_REQUEST1;
	}

	public static ConnectionRequest storeTicketConnectionRequest(ServletContext servletContext) {

		if (CONNECTION_REQUEST2 == null) {

			try {

				String baseReturnUri = servletContext.getInitParameter("baseReturnUri");

				CONNECTION_REQUEST2 = ConnectionRequest.fromMessageEnvelope(MessageEnvelope.fromGraph(MemoryGraphFactory.getInstance().loadGraph(WebshopConnectionRequest.class.getResourceAsStream("/message-store-ticket.xdi"))));
				log.info("Connection request: " + CONNECTION_REQUEST2.getMessageEnvelope().getGraph().toString());
				CONNECTION_REQUEST2.sign(CloudName.create("+webshop"), "alice");
				CONNECTION_REQUEST2.setReturnUri(URI.create(baseReturnUri + "store-ticket-return"));
				log.info("Connection request ready: " + CONNECTION_REQUEST2.getMessageEnvelope().getGraph().toString());
			} catch (Exception ex) {

				CONNECTION_REQUEST2 = null;
				throw new RuntimeException(ex.getMessage(), ex);
			}
		}

		return CONNECTION_REQUEST2;
	}
}
