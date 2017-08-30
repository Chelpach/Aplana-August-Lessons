package ThirdLesson;

/**
 * Created by user on 30.08.2017.
 */
public class Chocolate extends Sweets {
    private String formOfChocolate;

    public Chocolate(String name) {
        super(name);
    }

    public Chocolate(String name, Double weight) {
        super(name, weight);
    }

    public Chocolate(String name, Double weight, Double price) {
        super(name, weight, price);
    }

    public Chocolate(String name, Double weight, Double price, String formOfChocolate) {
        super(name, weight, price);
        this.formOfChocolate = formOfChocolate;
    }

    public String getFormOfChocolate() {
        return formOfChocolate;
    }

    public void setFormOfChocolate(String formOfChocolate) {
        this.formOfChocolate = formOfChocolate;
    }

    @Override
    public String toString() {
        return getName() +
                ", вес конфеты = " + getWeight() +
                ", цена = " + getPrice() +
                ", форма шоколада: " + formOfChocolate;
    }
}
