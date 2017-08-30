package ThirdLesson;

/**
 * Created by user on 30.08.2017.
 */
public class Biscuit extends Sweets {
    private String doughComposition;

    public Biscuit(String name) {
        super(name);
    }

    public Biscuit(String name, Double weight) {
        super(name, weight);
    }

    public Biscuit(String name, Double weight, Double price) {
        super(name, weight, price);
    }

    public Biscuit(String name, Double weight, Double price, String doughComposition) {
        super(name, weight, price);
        this.doughComposition = doughComposition;
    }

    public String getDoughComposition() {
        return doughComposition;
    }

    public void setDoughComposition(String doughComposition) {
        this.doughComposition = doughComposition;
    }

    @Override
    public String toString() {
        return getName() +
                ", вес конфеты = " + getWeight() +
                ", цена = " + getPrice() +
                ", состав теста: " + doughComposition;
    }
}
