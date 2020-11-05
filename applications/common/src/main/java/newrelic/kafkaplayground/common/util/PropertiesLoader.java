package newrelic.kafkaplayground.common.util;

import java.util.Properties;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertiesLoader {
    
    static final Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);
    
    static final String defaultPropsPath = "/var/app/config/producer.default.properties";
    static final String overridePropsPath = "/var/app/config/producer.override.properties";
    
    public static Properties loadProperties(List<String> paths) {
        
        Properties properties = new Properties();
        
        for (String path : paths) {
            try{
                FileInputStream file = new FileInputStream(path); 
                properties.load(file);
                file.close();
                logger.info("loaded {}", file);
            } catch (FileNotFoundException notFound) {
                logger.error("Unable to find {}, skipping", path);
            } catch (IOException ioe) {
                logger.warn(ioe.getMessage());
            }
        }
        
        logger.info("Final loaded properties:", properties);
        return properties;
    }
    
}