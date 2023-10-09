public class Msize extends CoffeeDecorator {
    public Msize(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " ,Size: M";
    }
    @Override
    public double cost() {
        return coffee.cost() + 3.0;
    }
}
