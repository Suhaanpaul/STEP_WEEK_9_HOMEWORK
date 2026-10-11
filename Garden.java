import java.util.Scanner;
abstract class Plot {
    protected String owner;
    public Plot(String owner) {
        this.owner = owner;
    }
    public abstract double calculateArea();
    public abstract String getShapeName();
    public void printReport() {
        System.out.printf("%s (%s): %.2f\n", owner, getShapeName(), calculateArea());
    }
}
class CirclePlot extends Plot {
    private double radius;
    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }
    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    @Override
    public String getShapeName() {
        return "CIRCLE";
    }
}
class RectanglePlot extends Plot {
    private double length, width;
    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }
    @Override
    public double calculateArea() {
        return length * width;
    }
    @Override
    public String getShapeName() {
        return "RECTANGLE";
    }
}
class TrianglePlot extends Plot {
    private double base, height;
    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
    @Override
    public String getShapeName() {
        return "TRIANGLE";
    }
}
public class Garden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        Plot[] plots = new Plot[n];
        double totalArea = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            String owner = scanner.next();
            if (type.equals("CIRCLE")) {
                double r = scanner.nextDouble();
                plots[i] = new CirclePlot(owner, r);
            } else if (type.equals("RECTANGLE")) {
                double l = scanner.nextDouble();
                double w = scanner.nextDouble();
                plots[i] = new RectanglePlot(owner, l, w);
            } else if (type.equals("TRIANGLE")) {
                double b = scanner.nextDouble();
                double h = scanner.nextDouble();
                plots[i] = new TrianglePlot(owner, b, h);
            }
        }
        scanner.close();
        for (Plot plot : plots) {
            plot.printReport();
            totalArea += plot.calculateArea();
        }
        System.out.printf("Total Area: %.2f\n", totalArea);
    }
}