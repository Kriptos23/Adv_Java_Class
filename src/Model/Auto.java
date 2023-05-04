package Model;

import java.io.*;
import java.util.Arrays;

public class Auto implements Serializable
{
    private String name;
    private double basePrice;
    private OptionSet[] optS;

    Auto(String name, double basePrice, int size) throws IOException {
        this.name = name;
        this.basePrice = basePrice;
        if(size == 0){
            this.optS = null;
        }
        else {
            this.optS = new OptionSet[size];
        }

    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("Name: ");
        sb.append(getName());
        sb.append(", Base price: ");
        sb.append(getBasePrice());
        sb.append(", OptionSet (Array): ");
        sb.append(Arrays.toString(getOptS()));

        return sb.toString();
    }

//    public OptionSet FindColorOptionSet() {
//        return this.FindSet("color");
//    }
//            OptionSet color = Ford.FindSet("color");
//            OptionSet color = Ford.FindColorOptionSet();

    public OptionSet FindSet(String name)
    {
        for (OptionSet i : this.getOptS())
        {

            if (i.getOptionSetName().equals(name))
            {
                System.out.println(name + " OptionSet found Successfully");
                return i;
            }
        }
        System.out.println("No such OptionSet with the name "  + name);
        return null;
    }

    public OptionSet.Options FindOption(String name)
    {
        for (OptionSet i : this.getOptS())
        {
            for (OptionSet.Options j : i.getOpt())
            {
                if (j.getOptName().equals(name))
                {
                    System.out.println(name + " Option found successfully");
                    return j;
                }
            }
        }
        System.out.println("No such Option with that name");
        return null;
    }

    public OptionSet.Options FindOption(String name, String optionSetName)
    {
        for (OptionSet i : this.getOptS())
        {
            if(i.getOptionSetName().equals(optionSetName))
            {
                for (OptionSet.Options j : i.getOpt())
                {
                    if (j.getOptName().equals(name))
                    {
                        System.out.println(name + " Option found successfully");
                        return j;
                    }
                }
            }
        }
        System.out.println("No such Option with that name");
        return null;
    }


    public void DeleteSet(String name)
    {
        boolean found = false;//To indicate that we found the Set
        int length = optS.length;
        int ind = 0;//index
        OptionSet del; // = new Options(); We don't really need this but let it stay here
        for (int i = 0; i < length - 1; i++)
        {
            if (optS[i].getOptionSetName().equals(name))//To find
            {
                System.out.println(name + " Option with name found successfully to delete");
                del = optS[i];//We don't use it but let it be here
                ind = i;
                found = true;
                break;
            }
        }

        if (!found){
            System.out.println("No such OptionSet with the name "  + name + " to delete");
        }
        else{
            //We create temp OptionSet to swap Set we need to delete
//        Options temp = new Options();
            OptionSet temp = optS[length-1];
            optS[length-1] = optS[ind];
            optS[ind] = temp;

            OptionSet[] NewArr = new OptionSet[length-1];//Process of deletion
            for(int i = 0; i < NewArr.length; i++)
            {
                NewArr[i] = optS[i];
            }
            this.setOptS(NewArr);
        }
    }

    public void DeleteOption(String nameD, String SetName)
    {
        for(OptionSet i : optS)
        {
            if (i.getOptionSetName().equals(SetName))//To find
            {
                for (OptionSet.Options j : i.getOpt())//Goes into the Options
                {
                   if (j.getOptName().equals(nameD))//To find
                   {
                       i.deleteOption(nameD);//Process of deletion
                       break;
                   }
                }
            }
        }
    }

    public void UpdateSet(String name, String NewName, int NewPrice, OptionSet.Options[] arr)
    {
        for (OptionSet i : this.getOptS())
        {
            if (i.getOptionSetName().equals(name))
            {
                i.setOptionSetName(NewName);
                i.setOpt(arr);
                System.out.println(name + " OptionSet found Successfully");

            }
        }
        System.out.println("No such OptionSet with the name "  + name);
    }

    public void UpdateOption(String name, String NewName, int NewPrice)
    {
        boolean found = false;
        for (OptionSet i : this.getOptS())
        {
            for (OptionSet.Options j : i.getOpt())
            {
                if (j.getOptName().equals(name))
                {
                    j.setOptName(NewName);
                    j.setOptPrice(NewPrice);
                    System.out.println(name + " Option updated successfully");
                    found = true;
                }
            }
        }
        if (!found)
        {
            System.out.println("No such Option with that name");
        }
    }
////////////////// PRINT FUNCTIONS ////////////////////////////////////////////////////////////////////////////////////

    public void printAutoName(){
        System.out.println(getName());
    }
    public void printAutoPrice(){
        System.out.println(getBasePrice());
    }
    public void printOptionSets(){
        System.out.println(getOptS());
    }
    public void printOneOptionSet(String name){
        System.out.println(getOneOptionSet(name));
    }
    public void printOneOption(int x, String name){
        for (OptionSet i : optS)
        {
            if(i.getOptionSetName().equals(name))
            {
                i.printOneOption(x);
            }
        }
    }
    public void printData(){
        StringBuffer sb = new StringBuffer();
        sb.append("Name: ");
        sb.append(getName());
        sb.append(", Base price: ");
        sb.append(getBasePrice());
        sb.append(", OptionSet (Array): ");
        sb.append(Arrays.toString(getOptS()));
    }




////////////////// GETTERS AND SETTERS ////////////////////////////////////////////////////////////////////////////////
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBasePrice() {
        return basePrice;
    }
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }


    public OptionSet[] getOptS() {
        return optS;
    }
    public void setOptS(OptionSet optS[]) {
        this.optS = optS;
    }
    public OptionSet getOneOptionSet(String name){
        for (OptionSet i : this.getOptS())
        {

            if (i.getOptionSetName().equals(name))
            {
                System.out.println(name + " OptionSet found Successfully");
                return i;
            }
        }
        System.out.println("No such OptionSet with the name "  + name);
        return null;
    }
    //Overload
    public OptionSet getOneOptionSet(int x){
        int count = 1;
        for (OptionSet i : this.getOptS())
        {
            if (count==x)
            {
                System.out.println(name + " OptionSet found Successfully");
                return i;
            }
            count++;
        }
        System.out.println("No such OptionSet with the number "  + x);
        return null;
    }
    public void setOneOptionSet(String name, OptionSet option)
    {
        for(OptionSet i : this.getOptS())
        {
            if(i.getOptionSetName().equals(name))
            {
                System.out.println(name + " OptionSet found Successfully");
                i = option;
                break;
            }
        }
        System.out.println("No such OptionSet with the name "  + name);
    }
    public void setOneOptionSet(int x, OptionSet option)
    {
        int count = 1;
        for (OptionSet i : this.getOptS())
        {
            if (count==x)
            {
                System.out.println(name + " OptionSet found Successfully");
                i = option;
                break;
            }
            count++;
        }
        System.out.println("No such OptionSet with the number "  + x);
    }
    public int getOptionSetLength(){
        return optS.length;
    }
    public int getOptionLength(String name){
        for (OptionSet i : this.getOptS())
        {
            if(i.getOptionSetName().equals(name))
            {
                return i.getOptionsLength();
            }
        }
        System.out.println("No such OptionSet with that name" + name +"to return a OptionSet length");
        return 0;
    }
    //Overload
    public int getOptionLength(int x){
        int count = 1;
        for (OptionSet i : this.getOptS())
        {
            if(count==x)
            {
                return i.getOptionsLength();
            }
            count++;
        }
        System.out.println("No such OptionSet with number" + x + " to return a OptionSet length");
        return 0;
    }
    public String getOptionSetName(int x){
        int count = 1;
        for (OptionSet i : this.getOptS())
        {
            if(count==x)
            {
                return i.getOptionSetName();
            }
            count++;
        }
        System.out.println("No such OptionSet with number" + x + " to return a OptionSet length");
        return null;
    }
    public void setOptionSetName(int x, String name){
        int count = 1;
        for (OptionSet i : this.getOptS())
        {
            if(count==x)
            {
                i.setOptionSetName(name);
                break;
            }
            count++;
        }
        System.out.println("No such OptionSet with number" + x + " to return a OptionSet length");
    }
    public String getOptionName(int x, String OptionSetName){
        int count = 1;
        for (OptionSet i : this.getOptS())
        {
            if(i.getOptionSetName().equals(OptionSetName))
            {
                for (OptionSet.Options j : i.getOpt())
                {
                    if (count==x)
                    {
                        return j.getOptName();
                    }
                }

                count++;
            }
        }
        System.out.println("No such OptionSet with number" + x + " to return a OptionSet length");
        return null;
    }
    public void setOptionName(int x, String OptionSetName, String newName){
        int count = 1;
        for (OptionSet i : this.getOptS())
        {
            if(i.getOptionSetName().equals(OptionSetName))
            {
                for (OptionSet.Options j : i.getOpt())
                {
                    if (count==x)
                    {
                        j.setOptName(newName);
                        break;
                    }
                }

                count++;
            }
        }
        System.out.println("No such OptionSet with number" + x + " to return a OptionSet length");
    }
    public double getOptionPrice(int x, String OptionSetName){
        int count = 1;
        for (OptionSet i : this.getOptS())
        {
            if(i.getOptionSetName().equals(OptionSetName))
            {
                for (OptionSet.Options j : i.getOpt())
                {
                    if (count==x)
                    {
                        return j.getOptPrice();
                    }
                }

                count++;
            }
        }
        System.out.println("No such OptionSet with number" + x + " to return a OptionSet length");
        return 0;
    }
    public void setOptionPrice(int x, String OptionSetName, double newPrice){
        int count = 1;
        for (OptionSet i : this.getOptS())
        {
            if(i.getOptionSetName().equals(OptionSetName))
            {
                for (OptionSet.Options j : i.getOpt())
                {
                    if (count==x)
                    {
                        j.setOptPrice(newPrice);
                        break;
                    }
                }

                count++;
            }
        }
        System.out.println("No such OptionSet with number" + x + " to return a OptionSet length");
    }
    public void setOneOptionSetOption(int x, String name, String newName, double newPrice)
    {
        for(OptionSet i : this.getOptS())
        {
            if(i.getOptionSetName().equals(name))
            {
                int count = 1;
                for (OptionSet.Options j : i.getOpt())
                {
                    if (count==x)
                    {
                        j.setOptName(newName);
                        j.setOptPrice(newPrice);
                        break;
                    }
                    count++;
                }
            }
        }
        System.out.println("No such OptionSet with the name "  + name);
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
