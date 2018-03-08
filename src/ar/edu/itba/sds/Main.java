package ar.edu.itba.sds;

import ar.edu.itba.sds.domain.CellIndexMethod;
import ar.edu.itba.sds.domain.Particle;
import ar.edu.itba.sds.helper.MethodComparator;
import ar.edu.itba.sds.helper.ParticleGenerator;
import ar.edu.itba.sds.helper.Printer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final Double RADIX = .1;

    public static void main(String[] args) {

       /* Particle p1 = new Particle(0.,0., .1);
        Particle p2 = new Particle(0.,4., .1);
        Particle p3 = new Particle(1.2,1.2, .1);
        Particle p4 = new Particle(1.4,1.4, .1);
        Particle p5 = new Particle(2.8,2.8, .1);
        Particle p6 = new Particle(2.9,2.9, .1);
        Particle p7 = new Particle(2.,5., .1);

        List<Particle> particles = Arrays.asList(p1,p2,p3,p4,p5,p6,p7);*/
        Integer N = 50;
        Double L = 5.1;
        Integer M = 2;
        boolean periodicContourCondition = false;

        List<Particle> particles = new ParticleGenerator().generate(N,L,RADIX);
        Printer printer = new Printer(particles,L, M,2.,periodicContourCondition,0);
        printer.printFiles();

        MethodComparator mc = new MethodComparator(20., M, 1.);
        List<MethodComparator.ComparisonResult> r= mc.testOverParticles(500,100,2000);
        String output = r.stream().map(cr -> cr.toString()).collect(Collectors.joining("\n"));
        System.out.print(output);
    }






}
