package ar.edu.itba.sds;

import ar.edu.itba.sds.domain.IndexCell;
import ar.edu.itba.sds.domain.Particle;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        Particle p1 = new Particle(0.,0., .1);
        Particle p2 = new Particle(0.,4., .1);
        Particle p3 = new Particle(1.2,1.2, .1);
        Particle p4 = new Particle(1.4,1.4, .1);
        Particle p5 = new Particle(2.8,2.8, .1);
        Particle p6 = new Particle(2.9,2.9, .1);
        Particle p7 = new Particle(2.,5., .1);

        List<Particle> particles = Arrays.asList(p1,p2,p3,p4,p5,p6,p7);
        Double L = 5.1;
        Integer M = 2;

        String printedFile = printFile(particles);

        IndexCell icm = new IndexCell(M,L,2.,particles);
        Map<Particle, List<Particle>> output = icm.calculate();

    }

    public static String printFile(List<Particle> particles){
        StringBuffer sb = new StringBuffer();
        sb.append(particles.size()+"\n");
        sb.append(particles.size()+"\n");
        sb.append(
                particles.stream()
                .map(p -> String.format("%.6f %.6f %.6f", p.getX(),p.getY(), p.getRadix()))
                .collect(Collectors.joining("\n")).replaceAll(",","\\.")
        );
        return sb.toString();
    }

}
