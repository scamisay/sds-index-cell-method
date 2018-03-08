package ar.edu.itba.sds.helper;

import ar.edu.itba.sds.domain.BruteForceMethod;
import ar.edu.itba.sds.domain.CellIndexMethod;
import ar.edu.itba.sds.domain.Particle;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scamisay on 08/03/18.
 */
public class MethodComparator {

    private Double L;
    private Integer M;
    private Double rc;

    private static final Double RADIX = .1;

    public MethodComparator(Double l, Integer m, Double rc) {
        L = l;
        M = m;
        this.rc = rc;
    }

    /**
     * Hago variar N
     */
    public List<ComparisonResult> testOverParticles(Integer from, Integer step, Integer to){
        List<ComparisonResult> results = new ArrayList<>();
        for(Integer N = from; N <= to ; N += step){
            List<Particle> particles = new ParticleGenerator().generate(N, L, RADIX);

            CellIndexMethod cim = new CellIndexMethod(M, L, rc, particles, false);
            cim.calculate();

            BruteForceMethod bf = new BruteForceMethod(rc, particles, false);
            bf.calculate();

            results.add(new ComparisonResult(N, cim.getTimeElapsed(), bf.getTimeElapsed()));
        }
        return results;
    }

    /**
     * Hago variar MxM
     */
    public void testOverCells(Integer from, Integer step, Integer to){

    }

    public class ComparisonResult{
        Integer variableValue;
        Duration cim;
        Duration bf;

        public ComparisonResult(Integer variableValue, Duration cim, Duration bf) {
            this.variableValue = variableValue;
            this.cim = cim;
            this.bf = bf;
        }

        @Override
        public String toString() {
            return String.format("%d, %d, %d", variableValue, cim.toMillis(), bf.toMillis());
        }
    }
}
