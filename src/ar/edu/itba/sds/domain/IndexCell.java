package ar.edu.itba.sds.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexCell {

    private Integer M;
    private Integer L;
    private Double rc;
    private List<Particle> particles = new ArrayList<>();
    private List<Cell> cells = new ArrayList<>();
    private Map<Particle, List<Particle>> output = new HashMap<>();

    public IndexCell(Integer m, Integer l, Double rc, List<Particle> particles) {
        M = m;
        L = l;
        this.rc = rc;
        this.particles = particles;

        initializeEnvironment();
    }

    private void initializeEnvironment() {
        //creo cells

        //le asigno particles a cada cell
    }

    public void calculate(){
        for(Particle particle : particles){
            output.put(particle, calculateNeighbours(particle));
        }
    }

    private List<Particle> calculateNeighbours(Particle particle){
        //traer celdas vecinas
        //por cada celda traer particulas
        //filtrar las particulas que esten a menos de rc de la particle

        //return particle.getNeighbourCells().stream()
        //        .map();
        return null;
    }
}
