package ar.edu.unlam.recycloud.app.statistics.models;

import lombok.Data;

@Data
public class CountMetric {
    private int month;
    private int year;
    private String metricName;
    private long date;
    private String data;
}
