package junseok.snr.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class SimpleProducer {
    private static final Logger logger = LoggerFactory.getLogger(SimpleProducer.class);
    private static final String TOPIC_NAME ="test";
    private static final String BOOTSTRAP_SERVER = "test.kafka:9092";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final Properties configs = new Properties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVER);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configs.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomPartitioner.class);

        final KafkaProducer<String, String> producer = new KafkaProducer<>(configs);

        final String messageValue = "testMessage";
        final String messageKey = "Pangyo";
        final int partitionNo = 0;
        final ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC_NAME, messageValue);
        logger.info("=== record : {}", record);
        RecordMetadata recordMetadata = producer.send(record).get();
        logger.info("=== recordMetadata : {}", recordMetadata);
        producer.flush();
        producer.close();
    }
}
