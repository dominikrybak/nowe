package com.sda.lists;

public class SdaLinkedList {

    private SdaLinkedNode head;

    public SdaLinkedList(String value) {
        this.head = new SdaLinkedNode(value);
    }

    public void add(String value) {
    	SdaLinkedNode newNode = new SdaLinkedNode(value);
    	SdaLinkedNode last= null;
    	if(this.head == null){
    		this.head = newNode;
    		} else {
    		 last = head;
    		 while( last.next != null){
    			 last = last.next;
    		 }
    		 last.next = newNode;	
    		}
    			
    }			
    			
    			
        // Zaimplementuj mnie


    public String get(int index) {
        String value = null;
        if(index >= this.size() || index <0){
        	throw new IndexOutOfBoundsException();
        } else if (head ==null){
        	
        } else if (index ==0){
        	value = head.value;
        } else {
        	SdaLinkedNode temp = head.next;
        while(index > 0){
        	value = temp.value;
        	index = index - 1;
        }
    	
    	
        }	
    	
    	
        return value;
    }

    public void remove(String value) {
        // Zaimplementuj mnie
    }
    
    public int size() {
        int size=0;
        if (head == null){
        	
        }
    	
    	
        return 0;
    }

    private static class SdaLinkedNode {

        String value;
        SdaLinkedNode next;
       
        public SdaLinkedNode(String node) {
            this.value = node;
            
            
        }


    }

}
