package ar.edu.unlam.recycloud.app.statistics.models;

import ar.edu.unlam.recycloud.app.geolocation.Location;

public class LocationMetricBuilder {
    public static LocationMetric build(Location location, long instant, int year, int month, String name) {
        LocationMetric locationMetric = new LocationMetric();
        locationMetric.setData(location);
        locationMetric.setDate(instant);
        locationMetric.setYear(year);
        locationMetric.setMonth(month);
        locationMetric.setMetricName(name);
        return locationMetric;
    }
}
