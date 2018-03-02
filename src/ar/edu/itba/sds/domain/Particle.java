package ar.edu.itba.sds.domain;

import com.sun.org.apache.regexp.internal.RE;

public class Particle {

    private Double x;
    private Double y;
    private Double radix;

    public Particle(Double x, Double y, Double radix) {
        this.x = x;
        this.y = y;
        this.radix = radix;
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public Double getRadix() {
        return radix;
    }

    public Double distanceCenterToCenter(Particle particle){
        Double difx = getX() - this.getX();
        Double dify = getX() - this.getY();
        return Math.sqrt(Math.pow(difx,2)+ Math.pow(dify,2));
    }

    public Double distanceBorderToBorder(Particle particle){
        return distanceCenterToCenter(particle) - (getRadix() + particle.getRadix());
    }
}
