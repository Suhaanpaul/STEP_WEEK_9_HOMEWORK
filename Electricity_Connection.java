import java.util.Scanner;
abstract class ElectricityConnection {
    protected double units;
    public ElectricityConnection(double units) {
        this.units = units;
    }
    public abstract double calculateBill();
    public abstract String getConnectionType();
    public void printBill() {
        System.out.printf("%s: %.2f\n", getConnectionType(), calculateBill());
    }
}
class HomeConnection extends ElectricityConnection {
    public HomeConnection(double units) {
        super(units);
    }
    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }
    @Override
    public String getConnectionType() {
        return "HOME";
    }
}
class ShopConnection extends ElectricityConnection {
    public ShopConnection(double units) {
        super(units);
    }
    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }
    @Override
    public String getConnectionType() {
        return "SHOP";
    }
}
class FactoryConnection extends ElectricityConnection {
    public FactoryConnection(double units) {
        super(units);
    }
    @Override
    public double calculateBill() {
        double bill = units * 6.0;
        return Math.max(bill, 1000.0);
    }
    @Override
    public String getConnectionType() {
        return "FACTORY";
    }
}
public class Electricity_Connection{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        ElectricityConnection[] connections = new ElectricityConnection[n];
        double total = 0;
        for (int i = 0; i < n; i++) {
            String type = scanner.next();
            double units = scanner.nextDouble();
            if (type.equals("HOME")) {
                connections[i] = new HomeConnection(units);
            } else if (type.equals("SHOP")) {
                connections[i] = new ShopConnection(units);
            } else if (type.equals("FACTORY")) {
                connections[i] = new FactoryConnection(units);
            }
        }
        scanner.close();
        for (ElectricityConnection conn : connections) {
            conn.printBill();
            total += conn.calculateBill();
        }
        System.out.printf("Total: %.2f\n", total);
    }
}