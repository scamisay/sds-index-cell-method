package ar.edu.itba.sds.helper;

import ar.edu.itba.sds.domain.Particle;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by scamisay on 08/03/18.
 */
public class ParticleGenerator {

    public List<Particle> generate(Integer N, Double L, Double radix) {
        Long seed = new Double(Math.random()*100000).longValue();
        Random generator = new Random(seed);
        return IntStream.range(0,N)
                .mapToObj(i ->new Particle(generator.nextDouble()*L, generator.nextDouble()*L, radix))
                .collect(Collectors.toList());
    }
}
