package ar.edu.unlam.recycloud.app.statistics.models;

import ar.edu.unlam.recycloud.app.geolocation.Location;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonIgnore;


@Data
public class LocationMetric implements Comparable<LocationMetric> {
    private int month;
    private int year;
    private String metricName;
    private long date;
    private Location data;

    @Override
    @BsonIgnore
    public int compareTo(LocationMetric that) {
        if (this.getData() == that.getData()){
            return 0;
        } else {
            return -1;
        }
    }
}