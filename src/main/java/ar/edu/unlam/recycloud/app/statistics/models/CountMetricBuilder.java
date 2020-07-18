package ar.edu.unlam.recycloud.app.statistics.models;

public class CountMetricBuilder {
    public static CountMetric build(String data, long instant, int year, int month, String name) {
        CountMetric countMetric = new CountMetric();
        countMetric.setData(data);
        countMetric.setDate(instant);
        countMetric.setYear(year);
        countMetric.setMonth(month);
        countMetric.setMetricName(name);
        return countMetric;
    }
}
