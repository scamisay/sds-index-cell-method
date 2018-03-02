package ar.edu.itba.sds.domain;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private Range rangeX;
    private Range rangeY;
    private List<Cell> neigbours = new ArrayList<>();
    private List<Particle> particles = new ArrayList<>();

    public Cell(List<Cell> neigbours, List<Particle> particles) {
        this.neigbours = neigbours;
        this.particles = particles;
    }
}
