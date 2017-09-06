package ThirdLesson;

public class Gift {
    public static void main(String[] args) {
        Double summaryWeight = 0.0;
        Double summaryPrice = 0.0;
        Sweets[] gift = createObjects();
        //печать всех конфет в подарке
        printGift(gift);

        System.out.println();
        printWeightAndPrice(gift);
    }

    private static Sweets[] createObjects() {
        Sweets toffee = new Candy("Золотой ключик", 2.4, 56.0, "ириска");
        Sweets chocoCandy = new Candy("Весенний вальс", 5.1, 86.0, "шоколадная конфета");
        Sweets mars = new Chocolate("Марс", 6.0, 100.3, "батончик");
        Sweets ritterSport = new Chocolate("Риттер Спорт", 12.0, 120.0, "плиточный шоколад");
        Sweets vaffles = new Biscuit("Вафли Дружок", 34.4, 12.9, "вафли");
        Sweets orion = new Biscuit("Орион", 20.3, 200.3, "песочное печенье");
        Sweets[] gift = {toffee, chocoCandy, mars, ritterSport, vaffles, orion};
        return gift;
    }

    private static void printGift(Sweets[] gift) {
        for (Sweets value : gift) {
            System.out.println(value.toString());
        }
    }

    private static void printWeightAndPrice(Sweets[] gift) {
        Double summaryWeight = 0.0;
        Double summaryPrice = 0.0;
        GiftProperties giftProperties = new GiftProperties();
        for (Sweets value : gift) {
            summaryWeight = giftProperties.getSummaryWeight(value.getWeight());
            summaryPrice = giftProperties.getSummaryPrice(value.getPrice());
        }
        System.out.println("Суммарный вес конфет в подарке = " + summaryWeight);
        System.out.println("Суммарная цена конфет в подарке = " + summaryPrice);
    }
}
