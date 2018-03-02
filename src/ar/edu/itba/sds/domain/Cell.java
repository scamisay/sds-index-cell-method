package ar.edu.itba.sds.domain;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private Range rangeX;
    private Range rangeY;
    private List<Cell> neigbours = new ArrayList<>();
    private List<Particle> particles = new ArrayList<>();

    public Cell(List<Particle> particles) {
        this.particles = particles;
        this.particles.forEach( p -> p.setCell(this));
    }

    public List<Particle> getParticles() {
        return particles;
    }

    public List<Cell> getNeighbours() {
        return neigbours;
    }

    public void setNeigbours(List<Cell> neigbours) {
        this.neigbours = neigbours;
    }

    public boolean isInside(Particle particle){
        return  rangeX.isInRange(particle.getX()) && rangeY.isInRange(particle.getY());
    }
}
