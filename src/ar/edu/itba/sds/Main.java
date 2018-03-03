package ar.edu.itba.sds;

import ar.edu.itba.sds.domain.Cell;
import ar.edu.itba.sds.domain.Particle;
import ar.edu.itba.sds.domain.Range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class Main {

    public static void main(String[] args) {

        Particle p1 = new Particle(0.,0., 1.);
        Particle p2 = new Particle(0.,4., 2.);
        Particle p3 = new Particle(1.,1., 3.);
        Particle p4 = new Particle(1.,1., 4.);
        Particle p5 = new Particle(2.,2., 5.);
        Particle p6 = new Particle(2.,2., 6.);
        Particle p7 = new Particle(2.,5., 7.);

        /*Cell c1 = new Cell(Arrays.asList(p1, p2));
        Cell c2 = new Cell(Arrays.asList(p3, p4));
        Cell c3 = new Cell(Arrays.asList(p5, p6, p7));

        c1.setNeigbours(Arrays.asList(c2));
        c2.setNeigbours(Arrays.asList(c1,c3));
        c3.setNeigbours(Arrays.asList(c2));

        p3.getCell().getNeighbours().stream()
                .map(Cell::getParticles)
                .flatMap(List::stream)
                .filter(p -> p3.isCloseEnough(p, 1.))
                .collect(Collectors.toList());
*/
        List<Particle> particles = Arrays.asList(p1,p2,p3,p4,p5,p6,p7);
        Double L = 6.;
        Integer M =3;
        Double offset = L/M;

        List<Range> ranges = DoubleStream.iterate(0., d -> d + offset).limit(M).boxed().map(d -> new Range(d, d+ offset)).collect(Collectors.toList());
        Cell[][] env = new Cell[M][M];
        for (Integer x = 0; x < M; x++) {
            for (Integer y = 0; y < M; y++) {
                Range rangex = ranges.get(x);
                Range rangey = ranges.get(y);
                Cell cell = new Cell(rangex, rangey);
                particles.stream().filter(cell::isInside).forEach(cell::addParticle);
                env[x.intValue()][y.intValue()]=cell;
            }
        }

        int a=1;
    }

    private static void loop(Cell[][] values, BiConsumer<Integer, Integer> consumer) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                consumer.accept(i, j);
            }
        }
    }
}
