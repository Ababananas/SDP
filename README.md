# SDP
public class Main {
    public static void main(String[] args) {
        WarehouseSystem warehouse = new Warehouse();
        AccountingSystem accountingSystem = new AccountingAdapter(warehouse);

        warehouse.addToInventory("Лаптоп", 10);
        accountingSystem.recordItem("Лаптоп", 5, 800.0);

        warehouse.removeFromInventory("Лаптоп", 3);
        accountingSystem.recordItem("Лаптоп", 3, 800.0);
    }
}


 public interface WarehouseSystem {
    void addToInventory(String item, int quantity);
    void removeFromInventory(String item, int quantity);
    int checkInventory(String item);
}


import java.util.HashMap;
import java.util.Map;
public class Warehouse implements WarehouseSystem {
    private Map<String, Integer> inventory = new HashMap<>();

    @Override
    public void addToInventory(String item, int quantity) {
        inventory.put(item, inventory.getOrDefault(item, 0) + quantity);
        System.out.println("Добавлено " + quantity + " " + item + " в инвентарь.");
    }

    @Override
    public void removeFromInventory(String item, int quantity) {
        int currentQuantity = inventory.getOrDefault(item, 0);
        if (currentQuantity >= quantity) {
            inventory.put(item, currentQuantity - quantity);
            System.out.println("Убрано " + quantity + " " + item + " из инвентаря.");
        } else {
            System.out.println("Недостаточное количество " + item + " в инвентаре.");
        }
    }

    @Override
    public int checkInventory(String item) {
        return inventory.getOrDefault(item, 0);
    }
}


public class AccountingAdapter implements AccountingSystem {
    private WarehouseSystem warehouse;

    public AccountingAdapter(WarehouseSystem warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public void recordItem(String item, int quantity, double price) {
        int availableQuantity = warehouse.checkInventory(item);
        if (availableQuantity >= quantity) {
            double totalCost = quantity * price;
            System.out.println("Запись в бухгалтерии: " + item + " x " + quantity + " по цене " + price + " = " + totalCost);
        } else {
            System.out.println("Запись в бухгалтерии: Недостаточное количество " + item + " на складе.");
        }
    }
}



public interface AccountingSystem {
    void recordItem(String item, int quantity, double price);
}




