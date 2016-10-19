package com.sda.lists;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

/**
 * W tej klasie zapoznamy sie z podstawowymi operacjami, ktore dostarcza nam
 * interface @{code List}
 *
 */
public class BasicOperations {

    @Test
    public void addingAndRetreiving() {
        // Inicjalizacja listy, dokladnie ArrayListy.
        List<String> originalList = new ArrayList<String>();

        // Do listy mozemy dodawacć element
        originalList.add("Hello");
        System.out.println(originalList);

        // Mozemy równiez dodac drugi ten sam element.
        originalList.add("Hello");
        System.out.println(originalList);

        // Mozemy sie wkurzyc i wyczyscic liste
        originalList.clear();
        System.out.println(originalList);

        // Mozemy dodac wszystkie elementy z innej listy.
        List<String> listTwo = new ArrayList<String>();
        listTwo.add("Mercedes");
        listTwo.add("Lexus");
        originalList.addAll(listTwo);
        System.out.println(originalList);

        // Mozemy nawet dodac liste do samej siebie.
        originalList.addAll(originalList);

        // Mozemy sprawdzic, czy lista zawiera dany elemnt
        boolean contains = originalList.contains("Mercedes");
        System.out.println(contains);

        // Mozemy rowniez, czy lista zawiera kilka elementow
        List<String> toBeContained = new ArrayList<String>();
        toBeContained.add("Lexus");
        toBeContained.add("Mercedes");
        boolean containsAll = originalList.containsAll(toBeContained);
        System.out.println(containsAll);
        /*
         * Lista niestety nie ma "kluczy", jak w wypadku mapy - nie moze miec,
         * gdyz wartosci nie sa unikalne. Do elementow listy odwolujemy sie
         * poprzez index elementu. Indeks jest to miejsce elementu w liscie,
         * zaczynajac od zera. Np dla listy Stringow ["Pies", "Kot", "Mysz"]
         * indeksy beda nastepujące: "Pies" - 0 "Kot" - 1 "Mysz" 2
         */
        System.out.println(originalList.get(0));
        System.out.println(originalList.get(3));

        /*
         * Nasuwa sie pytanie
         * "Co sie stanie jak dam wiekszy indeks niz rozmiar listy - 1" Zostanie
         * rzucony wyjatek - spojrzmy.
         */
        try {
            originalList.get(10);
        } catch (IndexOutOfBoundsException iobe) {
            System.out.println(iobe);
        }

        /*
         * Mozemy przeiterowac po liscie, jesli nie wiemy jak jest dluga.
         */
        for (int i = 0; i < originalList.size(); i++) {
            System.out.println(originalList.get(i));
        }
        for (String s : originalList) {
            System.out.println(s);
        }
    }

    @Test
    public void indexWorkAndRemoving() {
        /*
         * Okej, jak juz wiemy w liscie mamy do czynienia z indeksami,
         * (Analogicznie jak w tablicy, tj. Array). Spojrzmy teraz na funkcje,
         * ktore uzywaja indeksu.
         */

        // Tworzymy liste i dodajemy do niej dwa elementy.
        List<String> carList = this.emptyArrayStringList();
        carList.add("mercedes");
        carList.add("lexus");
        carList.add("jeep");
        carList.add("mini");
        carList.add("bmw");

        // Mozemy usuwac elementy przy pomocy indeksu
        carList.remove(0);
        System.out.println(carList);

        /*
         * Oczywiscie nie zawsze znamy indeks, czasem znamy tylko wartosc. Nie
         * wyklucza to usuniecia takiej wartosci. np:
         */
        this.removeElement(carList, "lexus");
        System.out.println(carList);
        // Jako, ze ta operacja jest bardzo popularna Lista ma taką metodę.
        carList.remove("bmw");

        /*
         * Mozemy rowniez dodac elemnt do listy w wybrany przez nas index. Jak
         * mozna zauwazyc kolejne elemnty beda przesuniete "w prawo", tj. ich
         * index zostanie zwiekszony o jeden.
         */
        System.out.println(carList);
        carList.add(1, "ferrari");
        System.out.println(carList);

        /*
         * Zaczynajac od danego indexu mozemy rowniez dodac inna lista
         */
        List<String> otherCars = this.emptyArrayStringList();
        otherCars.add("toyota");
        otherCars.add("mitshubishi");
        otherCars.add("kia");
        System.out.println("carList: " + carList);
        System.out.println("otherCars: " + otherCars);
        carList.addAll(2, otherCars);
        System.out.println("After adding: " + carList);

        /*
         * Z listy mozemy rowniez tworzyc subListy!
         * Zwroc uwage, ktory indeks jest wlaczny, a ktory wylaczony.
         */
        List<String> subList = carList.subList(2, 4);
        System.out.println(subList);
    }

    private void removeElement(List<String> carList, String toBeRemoved) {
        for (int i = 0; i < carList.size(); i++) {
            String listValue = carList.get(i);
            if (listValue.equals(toBeRemoved)) {
                carList.remove(i);
            }
        }

    }

    private ArrayList<String> emptyArrayStringList() {
        return new ArrayList<String>();
    }

}
