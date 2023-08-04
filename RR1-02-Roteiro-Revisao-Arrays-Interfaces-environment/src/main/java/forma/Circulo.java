package forma;

public class Circulo implements Forma {
    
    private double lado;

    public Circulo(double lado) {
        super();
        this.lado = lado;
    }

    @Override
    public double area() {
        return this.lado * this.lado;
    }
}
