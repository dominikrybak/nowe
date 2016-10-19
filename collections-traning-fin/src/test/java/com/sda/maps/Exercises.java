package com.sda.maps;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class Exercises {

    /**
     * Na rozgrzewke!
     */
    @Test
    public void warmUp() {
        Map<String, Integer> sampleMap = new HashMap<String, Integer>(); /* 
                                                                          Deklarujemy nowa mape,
                                                                          W ktorej kluczem jest String, a wartosciaÄ… Integer.
                                                                          Np. {Piotrek=24}
                                                                          */
        // Do mapy dodaj 2 elementy

        Assert.assertEquals(2, sampleMap.size());                        /* Asercja majaca sprawdzic, czy napewno dodaliÅ›cie dwa elemnty */
        // UsuÅ„ z mapy 1 element

        Assert.assertEquals(1, sampleMap.size());                        /* Asercja majÄ…ca sprawdziÄ‡, czy napewno usuneliscie jeden elemnt */
        final Integer oldValue = sampleMap.values().iterator().next();   /* 
                                                                         Potrzebne do ostatniej czesci zadania - zanim nadpiszecie wartosc,
                                                                         muszÄ™ ja gdzies przechowac, by sprawdzic czy sie zmienila 
                                                                         */
        // PozostaÅ‚y element nadpisz

        final Integer newValue = sampleMap.values().iterator().next();   /* Po nadpisaniu odzyskuje jedyna (nowa) wartosc przechowana w mapie) */
        Assert.assertNotEquals(oldValue, newValue);                      /* 
                                                                         PorÃ³wnujemy, czy stara wartosc (przed nadpisaniem) oraz nowa wartosc
                                                                         (po nadpisaniu) sa rozne.
                                                                         */
    }

    /**
     * Spojrz na String rawCars. Zawiera on lise marek samochodow
     * wymienionych po przecinku. Twoim zadaniem jest stworzyc taka
     * mape typu Map<String, Integer> w ktorej kluczem
     * bedzie nazwa marki samochodu (np. mini) a wartoscia liczba
     * wystapien danej marki w tekscie. 
     * 
     * !! Uwaga, asercja moze dawac falszywe negatywy. W sysoutuj i upewnij sie.
     * 
     * Przydatne metody:
     *  - {@link String#split(String)}:
     *      Metoda zmiennych typu String, dzielaca String na tablice typu
     *      String[]. Jako parametr przyjmuje String na bazie ktorego ma
     *      sie odbyc podzial.
     *      Np. "mama,tata".split(",") zwrÃ³ci nami ["mama", "tata"]
     *  - {@link Map#getOrDefault(Object, Object)}:
     *      Metoda ta sluzy do zapobiegniecia zwracania nulla, kiedy
     *      dany klucz nie istnieje w mapie. Np. posiadajac mape
     *      przykladMapy = {"Piotr"=24}, gdy uzyjemy metody
     *      przykladyMapy.getOrDefault("Lukasz", 0) zamiast nulla
     *      (gdyz "Lukasz" nie znajduje sie w mapie) otrzymamy wartosc 0.
     *      tip: Jesli w mapie nie jeszcze samochodu danej marki, to znaczy,
     *      ze ile razy wystÄ…piÅ‚ do tej pory?
     *     
     */
    @Test
    public void letterOccurences() {
        String rawCars = "mercedes,lexus,alfa romeo,mercedes,"
            + "lexus,alfa romeo,jeep,mercedes,volvo,volvo,volvo,volvo"  /* "Surowy" tekst, ktory nalezy przetworzyc */
            + ",mini,bmw,bmw";
        Map<String, Integer> carToOccurrencesMap =
                        new HashMap<String, Integer>();                  /* 
                                                                         Nowa, pusta mapa, w ktorej powinny znalezc
                                                                         sie marki aut jako klucze, a liczba ich 
                                                                         wystapien jako wartosc
                                                                         */

        String[] cars = rawCars.split(",");
        for (String car : cars) {
        	int value = carToOccurrencesMap.getOrDefault(car, 0); //
        	carToOccurrencesMap.put(car, value + 1);
        }
        int val = 0;
        for (int v : carToOccurrencesMap.values()) {
        	val += v;
        }
        Assert.assertThat(
            carToOccurrencesMap, 
            CoreMatchers.is(this.letterOccurencesAnswer())
        );                                                              /*
                                                                        Asercja majÄ…ca sprawdziÄ‡, czy Wasza mapa jest taka sama
                                                                        jak ta policzona w tej metodzie (policzna przeze mnie)
                                                                        */
    }

    /**
     * 1. Stwórz Enum reprezentuj¹cy marki samochodów.
     * 2. Sparsuj tekst w taki sposób, by nazwa marki wskazywa³a
	 *	  na liczbê wyst¹pieñ w stringu
     *    Uzyj EnumMapy!!!!!
     */ 
    @Test
    public void enumMap() {
        String rawCars = "mercedes,lexus,mercedes,"
            + "lexus,jeep,mercedes,volvo,volvo,volvo,volvo"  /* "Surowy" tekst, ktory nalezy przetworzyc */
            + ",mini,bmw,bmw";

        Map<Brands, Integer> enumMap = new EnumMap<Brands, Integer>(Brands.class);
        for(String car : rawCars.split(",")) {
        	Brands brand = Brands.valueOf(car.toUpperCase());
        	int value = enumMap.getOrDefault(brand, 0);
        	enumMap.put(brand, value + 1);
        }
        
        System.out.println(enumMap);
    }
    
    private static enum Brands {
    	MERCEDES,
    	LEXUS,
    	JEEP,
    	VOLVO,
    	MINI,
    	BMW
    }

    @Test
    public void weakHashMap() {
        
    }

    @Test
    public void concurrentHashMap() {
    }

    /**
     * Metoda zawierajaca odpowiedz.
     */
    private Map<String, Integer> letterOccurencesAnswer() {
        Map<String, Integer> occurrences = new HashMap<String, Integer>();
        occurrences.put("jeep", 1);
        occurrences.put("mini", 1);
        occurrences.put("mercedes", 3);
        occurrences.put("alfa romeo", 2);
        occurrences.put("lexus", 2);
        occurrences.put("bmw", 2);
        occurrences.put("volvo", 4);
        return occurrences;
    }

    

}
