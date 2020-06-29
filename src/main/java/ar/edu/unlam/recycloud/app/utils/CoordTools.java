package ar.edu.unlam.recycloud.app.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CoordTools {

    public List<List<Double>> fromStringArrayToDoubleList(List<String> arrayOfCoords) {
        List<List<Double>> result = new ArrayList<>();
        arrayOfCoords.forEach((pair) -> result.add(fromStringToDoubleList(pair)));
        return result;
    }

    public List<Double> fromStringToDoubleList(String coordAsString) {
        List<Double> result = new ArrayList<>();
        Arrays.asList(coordAsString.split(",")).forEach((el) -> result.add(Double.parseDouble(el)));
        return result;
    }

}
