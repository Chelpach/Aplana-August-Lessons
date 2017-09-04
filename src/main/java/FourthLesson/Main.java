package FourthLesson;

import java.util.*;
import static java.lang.String.format;

public class Main {
    public static void main(String[] args) {

        Player player1 = new Player("John", 75);
        Player player2 = new Player("Don", 53);
        Player player3 = new Player("Born", 57);
        Player player4 = new Player("Bom-Bom", 44);
        Player player5 = new Player("Gregory", 90);
        Player player6 = new Player("Kris", 1);
        Player player7 = new Player("Manya", 34);

        Map<String, Integer> players = new HashMap<>();
        createMap(players, player1, player2, player3, player4, player5, player6, player7);

        //вывод очков по убыванию
        System.out.println("Сортировка очков по убыванию:");
        printScoreByDesc(players);
        System.out.println();

        // вывод Имён игроков и очков по убыванию
        System.out.println("Сортировка игроков и их очков по убыванию:");
        printNameAndScoreByDesc(players);
        System.out.println();

        //вывод ТОП 3 игроков
        System.out.println("Топ 3 игроков по очкам:");
        printTop3NameAndScoreByDesc(players);
    }

    //создание Map из объектов Player
    private static Map<String, Integer> createMap(Map<String, Integer> players, Player... player) {
        for (int i = 0; i < player.length; i++) {
            players.put(player[i].getName(), player[i].getScore());
        }
        return players;
    }

    //Сортировка по очкам
    private static List<Map.Entry<String, Integer>> sortMap(Map<String, Integer> players) {
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(players.entrySet());
        Collections.sort(sortedList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o1.getValue() < o2.getValue()) ? 1 : (o1.getValue() == o2.getValue()) ? 0 : -1;
            }
        });
        return sortedList;
    }

    //вывод очков по убыванию
    private static void printScoreByDesc(Map<String, Integer> players) {
        for (Map.Entry<String, Integer> item : (sortMap(players))
                ) {
            System.out.println(item.getValue());
        }
    }

    // вывод Имён игроков и очков по убыванию
    private static void printNameAndScoreByDesc(Map<String, Integer> players) {
        for (Map.Entry<String, Integer> item : (sortMap(players))
                ) {
            System.out.println(format("%s %s", item.getKey(), item.getValue()));
        }
    }

    //вывод ТОП 3 игроков
    private static void printTop3NameAndScoreByDesc(Map<String, Integer> players) {
        int i = 0;
        for (Map.Entry<String, Integer> item : (sortMap(players))) {
            if (i < 3) {
                System.out.println(item.getKey());
                i++;
            }
        }
    }
}