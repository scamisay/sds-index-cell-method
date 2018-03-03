package ar.edu.itba.sds.domain;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private Range rangeX;
    private Range rangeY;
    private List<Cell> neigbours = new ArrayList<>();
    private List<Particle> particles = new ArrayList<>();

    public Cell(Range rangeX, Range rangeY) {
        this.rangeX = rangeX;
        this.rangeY = rangeY;
    }

   /*todo: eliminar esto despues del test del main
   public Cell(List<Particle> particles) {
        setParticles(particles);
    }*/

    public void addParticle(Particle particle){
        this.particles.add(particle);
        particle.setCell(this);
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
        return rangeX.isInRange(particle.getX()) && rangeY.isInRange(particle.getY());
    }

    @Override
    public String toString() {
        return String.format("x:%s y:%s particles:%d",rangeX.toString(), rangeY.toString(), particles.size());
    }
}
