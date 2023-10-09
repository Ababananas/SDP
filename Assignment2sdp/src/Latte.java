public class  Latte extends Coffee {
    String description = "Description: Latte";
    double cost = 7.0;
    public Latte() {
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double cost() {
        return cost;
    }
}
