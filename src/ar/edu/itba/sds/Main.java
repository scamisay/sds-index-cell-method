package ar.edu.itba.sds;

import ar.edu.itba.sds.domain.CellIndexMethod;
import ar.edu.itba.sds.domain.Particle;
import ar.edu.itba.sds.helper.MethodComparator;
import ar.edu.itba.sds.helper.ParticleGenerator;
import ar.edu.itba.sds.helper.Printer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static final Double RADIX = .1;

    public static void main(String[] args) {
        Integer N,M;
        Double L;
        boolean periodicContourCondition;
        while(true){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.print("N:");
                N = sc.nextInt();

                System.out.print("L:");
                L = sc.nextDouble();

                System.out.print("M:");
                M = sc.nextInt();

                System.out.print("periodicContourCondition:");
                periodicContourCondition = sc.nextBoolean();
                break;
            }catch (Exception e){
                System.out.println("Vuelva a intentar introducir los valores");
            }
        }

        /*Integer N = 50;
        Double L = 5.1;
        Integer M = 2;
        boolean periodicContourCondition = false;
*/
        List<Particle> particles = new ParticleGenerator().generate(N,L,RADIX);
        Printer printer = new Printer(particles,L, M,2.,periodicContourCondition,0);
        printer.printFiles();

    }






}
