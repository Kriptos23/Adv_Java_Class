package Util;

import java.io.*;
import java.util.Arrays;

import Model.Auto;
import Model.OptionSet;

public class FileIO
{
    public static void main(String[] args) throws IOException {
//    public Auto buildAutoObject(String fileName){
//        OptionSet color = null;
//        OptionSet.Options[] colors_arr = null;
//
//        OptionSet Transmission;
//        OptionSet.Options[] trans_arr;
//
//        OptionSet Brakes;
//        OptionSet.Options[] braked_arr;
//
//
//        OptionSet AirBags;
//        OptionSet.Options[] bags_arr;
//
//        OptionSet Moonroof;
//        OptionSet.Options[] roof_arr;
//

//        OptionSet[] FordOptSets;
//
//        String OptionSet1Name = "";
//        String Option1Name = "";
//        int Option1Price;
//
//        int NumberOfOptionOfSet1 = 0;
//        String OptionSet2Name = "";
//        int NumberOfOptionOfSet2 = 0;
//        String OptionSet3Name = "";
//        int NumberOfOptionOfSet3 = 0;
//        String OptionSet4Name = "";
//        int NumberOfOptionOfSet4 = 0;
//        String OptionSet5Name = "";
//        int NumberOfOptionOfSet5 = 0;

        boolean AutoFlag = false;
        boolean OptionSetFlag = false;
        boolean OptionFlag = false;

        Auto new_car = new Auto("",0,0);
        String last_OptionSetName = "";
        String tempOptionName = "";


        try {
            FileReader read = new FileReader("toyota.txt");
//            int data = read.read();
//            while(data != -1)
//            {
//                System.out.print((char)data);
//                data = read.read();
//            }
//            read.close();

            BufferedReader bread = new BufferedReader(read);
            String line;
            int line_number = 1;

            while ((line = bread.readLine()) != null)
            {
//                String tempOptSetName = null;
                int tempOptSetSize;
//                String tempOptionName = null;
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
//                            OptionSet.Options tempOp = color.new Options(tempOptionName, tempOptionSize);
//                            colors_arr[count] = tempOp;
//                            Ford.addOption2();
                            System.out.println("Where?");
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
//                                color = new OptionSet(tempOptSetName, tempOptSetSize);
//                                colors_arr = new OptionSet.Options[tempOptSetSize];

                        }
//                        if (word_in_line[1].equals("Color"))
//                        {
//                            if (word_in_line[0].equals("name"))
//                            {
////                                tempOptSetName = word_in_line[1];
//                                new_car.addOptionSet(word_in_line[1]);
//                                System.out.println("Changed optionSet name to " + word_in_line[1]);
//                            }
//                            else if(word_in_line[0].equals("numberOfOptions"))
//                            {
//                                tempOptSetSize = Integer.parseInt(word_in_line[1]);
////                                color = new OptionSet(tempOptSetName, tempOptSetSize);
////                                colors_arr = new OptionSet.Options[tempOptSetSize];
//
//                            }
//                        }
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

//        return new_car;
    }
    public FileIO() throws IOException {
    }
    public  Auto buildAutoObjects(String fileName, Auto car1)
    {
        boolean AutoFlag = false;
        boolean OptionSetFlag = false;
        boolean OptionFlag = false;

        Auto new_car = null;
        try {
            new_car = new Auto("",0,0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String last_OptionSetName = "";
        String tempOptionName = "";


        try {
            FileReader read = new FileReader("toyota.txt");

            BufferedReader bread = new BufferedReader(read);
            String line;
            int line_number = 1;

            while ((line = bread.readLine()) != null)
            {
//                String tempOptSetName = null;
                int tempOptSetSize;
//                String tempOptionName = null;
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
//                            OptionSet.Options tempOp = color.new Options(tempOptionName, tempOptionSize);
//                            colors_arr[count] = tempOp;
//                            Ford.addOption2();
                            System.out.println("Where?");
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
//                                color = new OptionSet(tempOptSetName, tempOptSetSize);
//                                colors_arr = new OptionSet.Options[tempOptSetSize];

                        }
//                        if (word_in_line[1].equals("Color"))
//                        {
//                            if (word_in_line[0].equals("name"))
//                            {
////                                tempOptSetName = word_in_line[1];
//                                new_car.addOptionSet(word_in_line[1]);
//                                System.out.println("Changed optionSet name to " + word_in_line[1]);
//                            }
//                            else if(word_in_line[0].equals("numberOfOptions"))
//                            {
//                                tempOptSetSize = Integer.parseInt(word_in_line[1]);
////                                color = new OptionSet(tempOptSetName, tempOptSetSize);
////                                colors_arr = new OptionSet.Options[tempOptSetSize];
//
//                            }
//                        }
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
    }
}
