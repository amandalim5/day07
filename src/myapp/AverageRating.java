package myapp;

import java.io.BufferedReader;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.nio.BufferOverflowException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class AverageRating {
  public static void main(String[] args) throws Exception{
    // read in the csv file
    String filename = args[0];

    FileReader fr = new FileReader(filename);
    BufferedReader br = new BufferedReader(fr);

    List<String[]> csvFile = new LinkedList<>();
    String line;
    line = br.readLine();
    System.out.println(line);
    while(true){
      line = br.readLine();
      if(line == null){
        break;
      }
      String[] data = line.split(",");
      String[] instance = {data[2], data[1]}; // rating and cat
      // System.out.print(instance[1]+instance[0]);
      csvFile.add(instance);
    }

    br.close();
    fr.close();
    Double sum = 0.0;
    Integer count =0;
    for(int i=0; i<csvFile.size(); i++){
      if(csvFile.get(i)[1].equals("ART_AND_DESIGN")){
        Double num = Double.parseDouble(csvFile.get(i)[0]);
        if(num.isNaN()){
          num=0.0;
          count--;
        }
        System.out.println("sum now:" + sum);
        sum += num;
        count ++;
      }
    }
    System.out.println("sum is: " + sum);
    System.out.println("Average is " + sum/count);

  
    Optional<Double> filing = csvFile.stream().filter((e)->{return e[1].equals("ART_AND_DESIGN");}).map((e)->{ Double n = Double.parseDouble(e[0]);System.out.println(n); if(n.isNaN()){ return 0.0;} else {return (double)n;}}).collect(Collectors.reducing((total,i)->{return total + i;}));
// the number is wrong because the csv file's first col has some commas
System.out.println(filing);
  }

  
  
}
