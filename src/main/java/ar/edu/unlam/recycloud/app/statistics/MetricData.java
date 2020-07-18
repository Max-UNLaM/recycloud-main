package ar.edu.unlam.recycloud.app.statistics;

import lombok.Data;

@Data
public abstract class MetricData {
    protected int month;
    protected int year;
    protected String metricName;
    protected long date;
    protected Object data;

    public String getMetricName() {
        return metricName;
    }

    public long getDate() {
        return date;
    }
}
