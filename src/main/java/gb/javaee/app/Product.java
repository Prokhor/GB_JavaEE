package gb.javaee.app;

public class Product {

    private int id;
    private String title;
    private double cost;

    public Product() {
        this.id = -1;
        this.title = "";
        this.cost = 0.;
    }

    public Product(int id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public String getTitle() {
        return title;
    }

    public double getCost() {
        return cost;
    }
}
