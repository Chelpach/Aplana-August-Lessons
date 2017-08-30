package ThirdLesson;

public class GiftProperties {
    private Double summaryWeight=0.0;
    private Double summaryPrice = 0.0;

    public Double getSummaryPrice(Double price) {
        return this.summaryPrice += price;
    }

    public Double getSummaryWeight(Double weight) {
        return this.summaryWeight += weight;
    }
}
