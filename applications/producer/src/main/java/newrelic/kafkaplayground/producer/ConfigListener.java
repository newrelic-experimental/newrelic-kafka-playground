package newrelic.kafkaplayground.producer;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import newrelic.kafkaplayground.common.util.PropertiesLoader;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Properties;

@WebListener
public class ConfigListener implements ServletContextListener {

    final Logger logger = LoggerFactory.getLogger(ConfigListener.class);

    public void contextInitialized(ServletContextEvent event) {

        Properties producerProps = PropertiesLoader.loadProperties(Arrays.asList("/var/webapp/config/producer.default.properties", "/var/webapp/config/producer.override.properties"));
        String envProps = System.getenv("PRODUCER_PROPERTIES");
        if (envProps != null) {
            try {
                producerProps.load(new StringReader(envProps));
            } catch (Exception e) {
                logger.error("Unable to load environment properties", e);
            }
        }

        if (producerProps.getProperty("client.id") == null) {
            producerProps.setProperty("client.id", "producer-" + System.getenv("HOSTNAME"));
        }

        KafkaProducer<String, String> producer = new KafkaProducer<>(producerProps);

        event.getServletContext().setAttribute("producerProps", producerProps);
        event.getServletContext().setAttribute("kafkaProducer", producer);

        logger.info("added kafkaProducer to ServletContext");

        // print logback internal state
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        StatusPrinter.print(lc);
    }

    public void contextDestroyed(ServletContextEvent event) {
    }
}