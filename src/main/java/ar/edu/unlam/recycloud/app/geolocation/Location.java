package ar.edu.unlam.recycloud.app.geolocation;

import lombok.Data;

@Data
public class Location {
    String type = "Point";
    double[] coordinates = new double[2];
}
