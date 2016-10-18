package aeternam.xdi;

import java.net.URI;
import java.util.Properties;

import xdi2.client.impl.http.XDIHttpClient;
import xdi2.core.io.XDIWriter;
import xdi2.core.io.XDIWriterRegistry;
import xdi2.core.syntax.CloudNumber;
import xdi2.core.syntax.XDIAddress;

public class Constants {

	public static URI selfEndpoint = URI.create("http://localhost:7202/xdi/graph");

	public static CloudNumber selfCloudNumber = CloudNumber.create("+!:uuid:5badb01b-3b0b-4d06-9ba9-739f5be4fc59");

	public static String secretToken = "alice";

	public static XDIAddress ticketXDIAddress = XDIAddress.create("*!:uuid:972ae814-0120-4361-81dc-473f9e8f7536");

	public static XDIHttpClient selfXDIClient() {

		return new XDIHttpClient(Constants.selfEndpoint);
	}

	public static XDIWriter jxdXDIWriter() {

		Properties parameters = new Properties();
		parameters.setProperty(XDIWriterRegistry.PARAMETER_PRETTY, "1");
		return XDIWriterRegistry.forFormat("JXD", parameters);
	}
}
