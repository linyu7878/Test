package com.test.main.day20150824;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.qpid.jms.JmsConnectionFactory;

/**
 * @2015年8月24日 by linyj
 */
public class Publisher {

	public static void main(String[] args) throws Exception {
		final String TOPIC_PREFIX = "topic://";

		String user = env("ACTIVEMQ_USER", "admin");
		String password = env("ACTIVEMQ_PASSWORD", "password");
		String host = env("ACTIVEMQ_HOST", "localhost");
		int port = Integer.parseInt(env("ACTIVEMQ_PORT", "5672"));

		String connectionURI = "amqp://" + host + ":" + port;
		String destinationName = arg(args, 0, "topic://event");

		int messages = 1;
		// int size = 256;

		// String DATA = "hello world!";
		// for (int i = 0; i < size; i++) {
		// body += DATA.charAt(i % DATA.length());
		// }
		String body = "hello world!";

		JmsConnectionFactory factory = new JmsConnectionFactory(connectionURI);

		Connection connection = factory.createConnection(user, password);
		connection.start();

		Session session = connection.createSession(false,
				Session.AUTO_ACKNOWLEDGE);

		Destination destination = null;
		if (destinationName.startsWith(TOPIC_PREFIX)) {
			destination = session.createTopic(destinationName
					.substring(TOPIC_PREFIX.length()));
		} else {
			destination = session.createQueue(destinationName);
		}

		MessageProducer producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

		for (int i = 1; i <= messages; i++) {
			TextMessage msg = session.createTextMessage("#:" + i);
			MapMessage map = session.createMapMessage();
			map.setString("col1", "实打实的1@qwe,cin");
			map.setString("id", i + "");
			map.setString("text", body);
			String cmd = "NORMAL";
			// if (i == messages)
			cmd = "SHUTDOWN";
			map.setString("cmd", cmd);
			producer.send(map);
			System.out.println(String.format("Sent %d messages", i));

		}
		Thread.sleep(1000 * 1);
		connection.close();
		System.exit(0);

	}

	private static String env(String key, String defaultValue) {
		String rc = System.getenv(key);
		if (rc == null)
			return defaultValue;
		return rc;
	}

	private static String arg(String[] args, int index, String defaultValue) {
		if (index < args.length)
			return args[index];
		else
			return defaultValue;
	}

}
