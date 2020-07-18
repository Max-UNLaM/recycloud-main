package ar.edu.unlam.recycloud.api.statistics.models;

import lombok.Data;

import java.util.List;

@Data
public class LineChart {
    private String[] labels;
    private List<Dataset> datasets;
}
