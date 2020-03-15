package com.yuhaowin.tuniu;

import java.util.ArrayList;

public class Test4 {
    public static void printPets(){
        ArrayList<String> listPets = new ArrayList<>();
        listPets.add("dog");
        listPets.add("cat");

        faverNewPets(listPets);

        System.out.println(listPets.toString());
    }

    private static void faverNewPets(ArrayList<String> listPets){
        ArrayList<String> listnew = new ArrayList<>();
        listnew.add("rabbit");
        listnew.add("hamster");
        //listPets = listnew;
        listPets.add("343434");
       // System.out.println(listPets.toString());
    }

    public static void main(String[] args) {
        printPets();
    }


}


// https://www.jianshu.com/p/4586cb11c62d
