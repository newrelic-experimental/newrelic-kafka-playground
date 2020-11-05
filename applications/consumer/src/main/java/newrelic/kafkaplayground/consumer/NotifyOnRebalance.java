package newrelic.kafkaplayground.consumer;

import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.common.TopicPartition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.stream.Collectors;

public class NotifyOnRebalance implements ConsumerRebalanceListener {

    final static Logger logger = LoggerFactory.getLogger(NotifyOnRebalance.class);

    @Override
    public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
    }

    @Override
    public void onPartitionsLost(Collection<TopicPartition> partitions) {
    }

    @Override
    public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
        String data = partitions.stream().map(p -> p.topic() + "-" + p.partition()).collect(Collectors.joining(","));
        logger.info("Currently subscribed to: [{}]", data);

    }
}