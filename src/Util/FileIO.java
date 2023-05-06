package Util;

import java.io.*;
import java.util.Arrays;

import Model.Auto;
import Model.OptionSet;

public class FileIO
{
    public FileIO() throws IOException {
    }
    public Auto buildAutoObject(String fileName, Auto new_car) throws IOException {
        boolean AutoFlag = false;
        boolean OptionSetFlag = false;
        boolean OptionFlag = false;

        new_car = null;
        new_car = new Auto("",0,0);

        String last_OptionSetName = "";
        String tempOptionName = "";


        try {
            FileReader read = new FileReader(fileName);
            BufferedReader bread = new BufferedReader(read);
            String line;
            int line_number = 1;

            while ((line = bread.readLine()) != null) {
                int tempOptSetSize;
                int tempOptionSize;

                line = line.replaceAll("\\s+", "");
                line = line.replaceAll("_", " ");
                String[] word_in_line = line.split(":"); // ex: line = "name Toyota Dan iel" => array of Strings word_in_line = ["name", "Toyota", "Dan", "iel"]

                if (word_in_line.length == 1) {
                    if (word_in_line[0].equals("Auto")) {
                        if (!AutoFlag) {
                            AutoFlag = true;
                        } else {
                            AutoFlag = false;
                        }
                    } else if (word_in_line[0].equals("OptionSet")) {
                        if (!OptionSetFlag) {
                            OptionSetFlag = true;
                        } else {
                            OptionSetFlag = false;
                        }
                    } else if (word_in_line[0].equals("Option")) {
                        if (!OptionFlag) {
                            OptionFlag = true;
                        } else {
                            OptionFlag = false;
                        }
                    }
                    continue;
                } else if (word_in_line.length == 2) {
                    int count = 0;
                    if (OptionFlag) {
                        if (word_in_line[0].equals("name")) {
                            tempOptionName = word_in_line[1];
                            new_car.addOption(last_OptionSetName, word_in_line[1], 0);
                        } else if (word_in_line[0].equals("price")) {
                            new_car.UpdateOptionWithoutMessage(last_OptionSetName, tempOptionName, tempOptionName, Integer.parseInt(word_in_line[1]));
                            count++;
                        }
                    } else if (OptionSetFlag) {
                        if (word_in_line[0].equals("name")) {
                            last_OptionSetName = word_in_line[1];
                            new_car.addOptionSet(word_in_line[1]);
                        } else if (word_in_line[0].equals("numberOfOptions")) {
                            tempOptSetSize = Integer.parseInt(word_in_line[1]);
                        }
                    } else if (AutoFlag) {
                        if (word_in_line[0].equals("name")) {
                            new_car.setName(word_in_line[1]);
                        } else if (word_in_line[0].equals("basePrice")) {
                            new_car.setBasePrice(Double.parseDouble(word_in_line[1]));
                        } else if (word_in_line[0].equals("numberOfOptionSets")) {
                            //Nothing here
                        }
                    }
                }
                line_number++;
            }
            //System.out.println("Method BuildAuto CheckPoint");
            System.out.println(new_car);
            return new_car;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    //This code could be useful in future, almost the same as the buildAutoObject() method
    /*
    boolean AutoFlag = false;
        boolean OptionSetFlag = false;
        boolean OptionFlag = false;

        Auto new_car = new Auto("",0,0);
        String last_OptionSetName = "";
        String tempOptionName = "";


        try {
            FileReader read = new FileReader("Car.txt");

            BufferedReader bread = new BufferedReader(read);
            String line;
            int line_number = 1;


            while ((line = bread.readLine()) != null)
            {
                int tempOptSetSize;
                int tempOptionSize;

//                System.out.println("Line number: "  + line_number + ", line: " + line) ;
                line = line.replaceAll("\\s+", "");
                String[] word_in_line = line.split(":"); // ex: line = "name Toyota Dan iel" => array of Strings word_in_line = ["name", "Toyota", "Dan", "iel"]
//                System.out.println("\tword_in_line.length: " + word_in_line.length);
                System.out.println("\tword_in_line: " + Arrays.toString(word_in_line));

                if(word_in_line.length == 1)
                {
                    if(word_in_line[0].equals("Auto")){
                        if(!AutoFlag){
                            AutoFlag = true;
                        }else{
                            AutoFlag = false;
                        }
                    }
                    else if(word_in_line[0].equals("OptionSet"))
                    {
                        if(!OptionSetFlag){
                            OptionSetFlag = true;
                        }else{
                            OptionSetFlag = false;
                        }
                    }else if (word_in_line[0].equals("Option"))
                    {
                        if(!OptionFlag){
                            OptionFlag = true;
                        }else{
                            OptionFlag = false;
                        }
                    }
                    continue;
                }

                else if(word_in_line.length == 2)
                {
                    int count = 0;
                    if(OptionFlag)
                    {
                        System.out.println("Inside OptionFlag");
                        if(word_in_line[0].equals("name"))
                        {
                            tempOptionName = word_in_line[1];
                            new_car.addOption(last_OptionSetName, word_in_line[1],0);
                        }
                        else if(word_in_line[0].equals("price"))
                        {
//                            tempOptionSize = Integer.parseInt(word_in_line[1]);
                            new_car.UpdateOption(last_OptionSetName, tempOptionName, tempOptionName, Integer.parseInt(word_in_line[1]));
                            count++;
                        }
                    }
                    else if (OptionSetFlag)
                    {
                        System.out.println("inside OptionSetFlag");
                        if (word_in_line[0].equals("name"))
                        {
//                                tempOptSetName = word_in_line[1];
                            last_OptionSetName = word_in_line[1];
                            new_car.addOptionSet(word_in_line[1]);
                            System.out.println("Changed optionSet name to " + word_in_line[1]);
                        }
                        else if(word_in_line[0].equals("numberOfOptions"))
                        {
                            tempOptSetSize = Integer.parseInt(word_in_line[1]);
                        }
                    }
                    else if (AutoFlag)
                    {
                        System.out.println("inside AutoFlag");
                        if(word_in_line[0].equals("name"))
                        {
                            new_car.setName(word_in_line[1]);
                            System.out.println("Changed auto name to " + word_in_line[1]);
                        }
                        else if (word_in_line[0].equals("basePrice"))
                        {
//                            car_price = Double.parseDouble(word_in_line[1]);
                            new_car.setBasePrice(Double.parseDouble(word_in_line[1]));
                        }
                        else if (word_in_line[0].equals("numberOfOptionSets"))
                        {
//                            FordOptSets = new OptionSet[Integer.parseInt(word_in_line[1])];
                        }
                    }
                }
                line_number++;
            }

            System.out.println("CheckPoint");
            System.out.println(new_car);
//            System.out.println(Arrays.toString(colors_arr));



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
     */
}
