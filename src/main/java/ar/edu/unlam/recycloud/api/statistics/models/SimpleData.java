package ar.edu.unlam.recycloud.api.statistics.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SimpleData {
    private String name;
    private Object value;
}
