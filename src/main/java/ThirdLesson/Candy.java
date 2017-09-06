package ThirdLesson;

/**
 * Created by user on 30.08.2017.
 */
public class Candy extends Sweets {
    private String typeOfCandy;

    public Candy(String name) {
        super(name);
    }

    public Candy(String name, Double weight) {
        super(name, weight);
    }

    public Candy(String name, Double weight, Double price) {
        super(name, weight, price);
    }

    public Candy(String name, Double weight, Double price, String typeOfCandy) {
        super(name, weight, price);
        this.typeOfCandy = typeOfCandy;
    }

    public String getTypeOfCandy() {
        return typeOfCandy;
    }

    public void setTypeOfCandy(String typeOfCandy) {
        this.typeOfCandy = typeOfCandy;
    }

    @Override
    public String toString() {
        return getName() +
                ", вес конфеты = " + getWeight() +
                ", цена = " + getPrice() +
                ", тип конфеты: " + typeOfCandy;
    }
}
