import java.util.ArrayList;
import java.util.List;

interface Beverage {
    String getDescription();
    double getCost();
}

class Espresso implements Beverage {
    public String getDescription() {
        return "Эспрессо";
    }

    public double getCost() {
        return 3.0;
    }
}

class Tea implements Beverage {
    public String getDescription() {
        return "Чай";
    }

    public double getCost() {
        return 2.5;
    }
}

class Latte implements Beverage {
    public String getDescription() {
        return "Латте";
    }

    public double getCost() {
        return 4.0;
    }
}

class Mocha implements Beverage {
    public String getDescription() {
        return "Мокко";
    }

    public double getCost() {
        return 4.5;
    }
}

abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription();
    }

    public double getCost() {
        return beverage.getCost();
    }
}

class Milk extends BeverageDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Молоко";
    }

    public double getCost() {
        return beverage.getCost() + 0.5;
    }
}

class Sugar extends BeverageDecorator {
    public Sugar(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Сахар";
    }

    public double getCost() {
        return beverage.getCost() + 0.2;
    }
}

class WhippedCream extends BeverageDecorator {
    public WhippedCream(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Взбитые сливки";
    }

    public double getCost() {
        return beverage.getCost() + 0.7;
    }
}

public class Main {
    public static void main(String[] args) {
        Beverage beverage = new Latte();
        beverage = new Milk(beverage);
        beverage = new Sugar(beverage);
        beverage = new WhippedCream(beverage);

        System.out.println("Описание напитка: " + beverage.getDescription());
        System.out.println("Стоимость напитка: " + beverage.getCost() + " руб.");
    }
}
