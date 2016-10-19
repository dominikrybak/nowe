package com.sda.lists;

import org.junit.Assert;
import org.junit.Test;

public class SdaLinkedListTest {

    @Test
    /**
     * Dobrym sposobem na zrozumienie czegos - jest napisanie tego.
     * My stworzymy bardzo prosta imlpementacje Single Linked List.
     */
    public void linkedList() {
        SdaLinkedList list = new SdaLinkedList("jeden");
        list.add("dwa");
        list.add("trzy");

        Assert.assertEquals(list.size(), 3);
        Assert.assertEquals(list.get(0), "jeden");
        list.remove("jeden");
        Assert.assertEquals(list.size(), 2);
        Assert.assertEquals(list.get(0), "dwa");
        list.add("cztery");
        list.remove("trzy");
        Assert.assertEquals(list.size(), 2);
        Assert.assertEquals(list.get(0), "dwa");
        Assert.assertEquals(list.get(1), "cztery");

        try {
            list.get(Integer.MAX_VALUE);
        } catch (IndexOutOfBoundsException exception) {
            // Sukces!
        }
        try {
            list.get(-1);
        } catch (IndexOutOfBoundsException exception) {
            // Sukces!
        }
    }
}
