package com.example.metrics;


import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class TimerMetricWriter {

    @Autowired
    private MetricRegistry metricRegistry;

    public <T> T time(String name, Supplier<T> s) {
        Timer timer = metricRegistry.timer(name);
        final Timer.Context context = timer.time();
        T result = null;
        try {
            result = s.get();
        } finally {
            context.stop();
        }
        return result;
    }
}
