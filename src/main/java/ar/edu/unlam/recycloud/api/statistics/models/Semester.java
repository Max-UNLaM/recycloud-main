package ar.edu.unlam.recycloud.api.statistics.models;

import lombok.Data;

@Data
public class Semester {
    private int id;
    private int[] index;
    private String[] names;
}
