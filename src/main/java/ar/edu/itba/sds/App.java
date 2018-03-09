package ar.edu.itba.sds;

import ar.edu.itba.sds.domain.Particle;
import ar.edu.itba.sds.helper.ParticleGenerator;
import ar.edu.itba.sds.helper.Printer;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    private static final Double RADIX = .1;

    public static void main(String[] args) {
        Integer N, M;
        Double L, rc;
        boolean periodicContourCondition;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("N:");
                N = sc.nextInt();

                System.out.print("L:");
                L = sc.nextDouble();

                System.out.print("M:");
                M = sc.nextInt();

                System.out.print("rc:");
                rc = sc.nextDouble();

                System.out.print("periodicContourCondition:");
                periodicContourCondition = sc.nextBoolean();
                break;
            } catch (Exception e) {
                System.out.println("Vuelva a intentar introducir los valores");
            }
        }

        List<Particle> particles = new ParticleGenerator().generate(N, L, RADIX);
        Printer printer = new Printer(particles, L, M, rc, periodicContourCondition, 0);
        printer.printFiles();

    }
}