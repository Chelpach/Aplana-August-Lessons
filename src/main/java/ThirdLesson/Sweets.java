package ThirdLesson;

/**
 * Created by user on 30.08.2017.
 */
public class Sweets {
    private String name;
    private Double weight;
    private Double price;

    public Sweets(String name) {
        this.name = name;
    }

    public Sweets(String name, Double weight) {
        this.name = name;
        this.weight = weight;
    }

    public Sweets(String name, Double weight, Double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name +
                ", вес конфеты = " + weight +
                ", цена = " + price;
    }
}
