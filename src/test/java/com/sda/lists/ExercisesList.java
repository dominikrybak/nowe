package com.sda.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class ExercisesList {
	

    /**
     * L.1 Celem zadania jest uzupelnienie metody jest
     * {@code ExercisesImpl#fill(String, Integer)} W taki sposob, zeby zwracala
     * ona liste zawierajaca dany string powtorzany n razy. Np:
     * ExercisesImpl.fill("test", 3) powinna zwrocic liste ["test", "test",
     * "test"]
     * 
     * Dla odwaznych nalezy rozwiazac powyzszy problem dla dowolnej klasy T oraz
     * dopisac testy. (metoda ExercisesImpl#fillGeneric).
     */
    @Test
    public void fill() {
        // Testy
        List<String> listOne = ExercisesImpl.fill("test", 3);
        List<String> expectedListOne = new ArrayList<String>();
        expectedListOne.add("test");
        expectedListOne.add("test");
        expectedListOne.add("test");
        Assert.assertThat(listOne, CoreMatchers.is(expectedListOne));

        List<String> listTwo = ExercisesImpl.fill("hello", 5);
        List<String> expectedListTwo = new ArrayList<String>();
        expectedListTwo.add("hello");
        expectedListTwo.add("hello");
        expectedListTwo.add("hello");
        expectedListTwo.add("hello");
        expectedListTwo.add("hello");
        Assert.assertThat(listTwo, CoreMatchers.is(expectedListTwo));
    }

    /**
     * L.2 Celem zadania jest uzupelnienie metody metody ExercisesImpl.swap,
     * ktora bedzie zamieniala ze soba wartosci na danych indexach. Np:
     * ExercisesImpl.swap(["Kot", "Pies", "Mysz"], 0, 2) zwroci ["Mysz", "Pies",
     * "Kot"]
     * 
     * Dla odwaznych uzupelnienie i testy do metody swapGeneric
     */
    @Test
    public void swap() {
        List<String> listOne = new ArrayList<String>();
        listOne.add("Kuna");
        listOne.add("Kon");
        listOne.add("Krowa");
        listOne.add("Malpa");
        listOne.add("Susel");
        ExercisesImpl.swap(listOne, 1, 3);
        List<String> expectedList = new ArrayList<String>();
        expectedList.add("Kuna");
        expectedList.add("Malpa");
        expectedList.add("Krowa");
        expectedList.add("Kon");
        expectedList.add("Susel");
        Assert.assertThat(listOne, CoreMatchers.is(expectedList));
    }

    /**
     * L.3 W tym wypadku mamy zwracać "odwróconą" listę. Np. ["Mysz", "Pies",
     * "Kot"] powinna być przekształcona na ["Kot", "Pies", "Mysz"]. Nalezy
     * uzupelnic metode ExercisesImpl.reverse(List)
     * 
     * Dla odwaznych uzupelnienie i testy do metody reversGeneric.
     */
    @Test
    public void reverse() {
        List<String> list = new ArrayList<String>();
        list.add("Raz");
        list.add("Dwa");
        list.add("Trzy");
        list.add("Cztery");
        list.add("Piec");
        list.add("Szesc");
        ExercisesImpl.reverse(list);
        List<String> reversedList = new ArrayList<String>();
        reversedList.add("Szesc");
        reversedList.add("Piec");
        reversedList.add("Cztery");
        reversedList.add("Trzy");
        reversedList.add("Dwa");
        reversedList.add("Raz");
        Assert.assertThat(list, CoreMatchers.is(reversedList));
    }

    /**
     * L.4 "Rotacja" listy, czyli przesuniecie wartosci. Np. Mamy liste [10, 11,
     * 12, 13, 14] i przesuwamy o 1 otrzymujemy liste [14, 10, 11, 12, 13].
     * Przesuniecie o 3 spowoduje [12, 13, 14, 10, 11].
     */
    @Test
    public void rotate() {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(0);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        ExercisesImpl.rotate(numbers, 2);
        List<Integer> rotated = new ArrayList<Integer>();
        rotated.add(4);
        rotated.add(5);
        rotated.add(0);
        rotated.add(1);
        rotated.add(2);
        rotated.add(3);
        Assert.assertThat(numbers, CoreMatchers.is(rotated));
    }

    /**
     * I przyszedl czas na cos trudniejszego. Najprostszy chyba algorytm
     * sortujacy o wdziecznej nazwie bubble sort - sortowania babelkowe. Polega
     * na porównywaniu dwóch kolejnych elementów i zamianie ich kolejności,
     * jeżeli zaburza ona porządek, w jakim się sortuje tablicę. Sortowanie
     * kończy się, gdy podczas kolejnego przejścia nie dokonano żadnej zmiany.
     * Twoim zadaniem jest zaimplementowanie tego algorytmu.
     * https://pl.wikipedia.org/wiki/Sortowanie_b%C4%85belkowe
     * 
     * PSEUDOKOD:
     * 
     *   procedure bubbleSort( A : lista elementów do posortowania )
     *    n = liczba_elementww(A)
     *     do
     *      for (i = 0; i < n-1; i++) do:
     *        if A[i] > A[i+1] then
     *          swap(A[i], A[i+1])
     *        end if
     *      end for
     *      n = n-1
     *    while n > 1
     *   end procedure
     */
    @Test
    public void bubbleSort() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            list.add(random.nextInt());
        }
        List<Integer> sorted = new ArrayList<Integer>();
        
        Collections.copy(sorted, list);
        Collections.sort(sorted);
        ExercisesImpl.bubbleSort(list);
        Assert.assertThat(list, CoreMatchers.is(sorted));
    }

}
