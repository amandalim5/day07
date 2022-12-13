package myapp;

import java.util.List;
import java.util.stream.Collectors;

public class TerminalOps {
  public static void map(List<Integer> numList) {
    System.out.println("=======Joining=======");
    List<Integer> listOfNums = numList.stream().collect(Collectors.toList());
  }
  
}
