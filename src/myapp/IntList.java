package myapp;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class IntList{
  public static void main(String[] args) {
    Integer range = 100;
    Random rnd = new SecureRandom();
    Integer max = 10;

    List<Integer> numList = new LinkedList<>();
    for (Integer i=0; i<max; i++){
      numList.add(rnd.nextInt(range));
    }

    System.out.println(">>> numList: " + numList);
    filter(numList);
  }

  public static void filter(List<Integer> numList){
    System.out.println("==========Filter===========");
    //filter
    List<Integer> resultList = new LinkedList<>();
    for (Integer n: numList){
      if(0 != (n % 3)){
        continue;
      }
      resultList.add(n);

    }
    System.out.println(">>> resultList: " + resultList);


    resultList = numList.stream()
      .filter((n)->{return (n%3)==0;})
      .distinct()
      .sorted()
      .limit(5)
      .collect(Collectors.toList());

    System.out.println(">>> Stream resultList: " + resultList);
    
    String listing = numList.stream().map(n->(Integer.toString(n))).collect(Collectors.joining());
    System.out.println(listing);
    // resultList.stream().filter((i)-> i%3!=0});
    //filter takes the data and return a boolean

  }
}