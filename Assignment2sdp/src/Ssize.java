public class Ssize extends CoffeeDecorator{
    public Ssize(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " ,Size: S";
    }
    @Override
    public double cost() {
        return coffee.cost();
    }
}
