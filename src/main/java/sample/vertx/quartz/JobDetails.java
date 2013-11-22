package sample.vertx.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.vertx.java.core.json.JsonObject;

import sample.vertx.server.SockJsServer;

public class JobDetails {

	final Logger logger = LoggerFactory.getLogger(JobDetails.class);

	public JobDetails() {
	}

	public void executeJob() {

		try {
			JsonObject joMessage = new JsonObject();

	        long intY = Math.round(Math.random() * 100);
	        long intX = Math.round(Math.random() * 100);

	        joMessage.putString("text", "{\"x\":" + intX + ", \"y\":" + intY + "}");

	        SockJsServer.eb.publish("app.connect", joMessage);

			logger.info("publiched x=" + intX + ", y=" + intY);
		} catch (Exception e) {
			logger.error("Exception >> ", e);
		}
	}

}