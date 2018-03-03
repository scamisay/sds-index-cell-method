package ar.edu.itba.sds.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class IndexCell {

    private Integer M;
    private Double L;
    private Double rc;
    private List<Particle> particles = new ArrayList<>();
    private Cell[][] environment;
    private Map<Particle, List<Particle>> output = new HashMap<>();

    public IndexCell(Integer m, Double l, Double rc, List<Particle> particles) {
        M = m;
        L = l;
        this.rc = rc;
        this.particles = particles;

        initializeEnvironment();
    }

    private void initializeEnvironment() {
        //creo cells
        environment = new Cell[M][M];
        Double offset = L/M;

        //calculo rangos del environment
        List<Range> ranges = DoubleStream.iterate(0., d -> d + offset)
                .limit(M).boxed()
                .map(d -> new Range(d, d+ offset))
                .collect(Collectors.toList());

        //inicializo environment con celdas y asigno las particulas a cada celda
        for (Integer x = 0; x < M; x++) {
            for (Integer y = 0; y < M; y++) {
                Range rangex = ranges.get(x);
                Range rangey = ranges.get(y);

                Cell cell = new Cell(rangex, rangey);
                environment[x][y] = cell;

                particles.stream()
                        .filter(cell::isInside)
                        .forEach(cell::addParticle);
            }
        }

        //todo: definir vecinos para cada celda
    }

    public void calculate(){
        output = particles.stream()
                .collect(Collectors.toMap(p->p, this::calculateNeighbours));
    }

    /**
     * traer celdas vecinas
     * por cada celda traer particulas
     * filtrar las particulas que esten a menos de rc de la particle
     */
    private List<Particle> calculateNeighbours(Particle particle){
        return particle.getCell().getNeighbours().stream()
                .map(Cell::getParticles)
                .flatMap(List::stream)
                .filter(p -> particle.isCloseEnough(p, rc))
                .collect(Collectors.toList());
    }
}
