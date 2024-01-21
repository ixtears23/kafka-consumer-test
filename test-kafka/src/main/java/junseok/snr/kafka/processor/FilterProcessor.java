package junseok.snr.kafka.processor;

import org.apache.kafka.streams.processor.Processor;
import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.api.Record;

public class FilterProcessor implements Processor<String, String> {
    private ProcessorContext processorContext;

    @Override
    public void init(ProcessorContext context) {
        this.processorContext = context;
    }

    @Override
    public void process(String key, String value) {
        if (value.length() > 5) {
            processorContext.forward(key, value);
        }
        processorContext.commit();
    }

    @Override
    public void close() {
    }
}
