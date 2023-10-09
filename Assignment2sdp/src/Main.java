
import javax.print.attribute.standard.MediaSize;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    Coffee coffee = null;
    String choiceSize;
    Scanner in = new Scanner(System.in);
    System.out.println("Welcome to our Coffee machine");
    System.out.println("Press 1 to choose Espresso");
    System.out.println("Press 2 to choose Latte");
    int choice = in.nextInt();
    switch (choice){
        case 1:
            coffee = new Espresso();
            System.out.println("Press 1 to add Milk");
            choice = in.nextInt();
            if(choice == 1){
                coffee = new Milk(coffee);
            }
            System.out.println("Press 1 to add Sugar");
            choice = in.nextInt();
            if(choice == 1){
                coffee = new Sugar(coffee);
            }

            System.out.println("Press 1 to choose S size");
            System.out.println("Press 2 to choose M size");
            choice = in.nextInt();
            if(choice == 2){
                coffee = new Msize(coffee);
            } else {
                coffee = new Ssize(coffee);
            }
            break;

        case 2:
            coffee = new Latte();
            System.out.println("Press 1 to add Milk");
            choice = in.nextInt();
            if(choice == 1){
                coffee = new Milk(coffee);
            }
            System.out.println("Press 1 to add Sugar");
            choice = in.nextInt();
            if(choice == 1){
                coffee = new Sugar(coffee);
            }

            System.out.println("Press 1 to choose S size");
            System.out.println("Press 2 to choose M size");
            choice = in.nextInt();
            if(choice == 2){
                coffee = new Msize(coffee);
            } else {
                coffee = new Ssize(coffee);
            }
            break;
    }
    System.out.println("Your order:");
    System.out.println(coffee.getDescription());
    System.out.println("Cost: $" + coffee.cost());
}

}