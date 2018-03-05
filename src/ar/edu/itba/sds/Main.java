package ar.edu.itba.sds;

import ar.edu.itba.sds.domain.IndexCell;
import ar.edu.itba.sds.domain.Particle;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        Particle p1 = new Particle(0.,0., 1.);
        Particle p2 = new Particle(0.,4., 2.);
        Particle p3 = new Particle(1.,1., 3.);
        Particle p4 = new Particle(1.,1., 4.);
        Particle p5 = new Particle(2.,2., 5.);
        Particle p6 = new Particle(2.,2., 6.);
        Particle p7 = new Particle(2.,5., 7.);

        List<Particle> particles = Arrays.asList(p1,p2,p3,p4,p5,p6,p7);
        Double L = 6.;
        Integer M =3;

        IndexCell icm = new IndexCell(M,L,2.,particles);
        Map<Particle, List<Particle>> output = icm.calculate();

    }

}
