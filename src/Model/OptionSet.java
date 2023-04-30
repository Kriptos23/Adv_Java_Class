package Model;

import java.util.Arrays;

public class OptionSet
{
    private String OptionSetName;
    private Options[] opt;

    //////// Constructors ////////////
    OptionSet(){
        this.OptionSetName = "";
        this.opt = new Options[0];
    }
    OptionSet(String OptionSetName, int size)
    {
        this.OptionSetName = OptionSetName;
        this.opt = new Options[size];

    }

    /////////////////Methods/////////
    public void addOption(Options NewOpt)//aka build option
    {
        int length = this.opt.length;
        Options[] NewArr = new Options[length+1];//New bigger array
        for(int i = 0; i < length; i++)//Process of copying the old array
        {
            NewArr[i] = opt[i];
        }
        NewArr[length] = NewOpt;//Adding new option
        this.setOpt(NewArr);//Making old array become new one
    }
    //OverLoad
    public void addOption(String SetName, String Oname, double Oprice)//aka build option
    {
        Options NewOpt = new Options(Oname, Oprice);//New Option
        int length = this.opt.length;
        Options[] NewArr = new Options[length+1];//New bigger array
        for(int i = 0; i < length; i++)//Process of copying the old array
        {
            NewArr[i] = opt[i];
        }
        NewArr[length] = NewOpt;//Adding new option
        this.setOpt(NewArr);//Making old array become new one
    }

    public void deleteOption(String name)
    {
        boolean found = false;// To indicate when Option is found
        int length = this.opt.length;
        int ind = 0;//index
        Options del; // = new Options();
        for (int i = 0; i < length - 1; i++)
        {
            if (opt[i].getOptName().equals(name))//To find
            {
                System.out.println(name + " Option with name found successfully to delete");
                del = opt[i];//We don't use it but let it be here
                ind = i;
                found = true;
                break;
            }
            ind++;
        }
        if (!found){
            System.out.println("Option with name " + name + " didn't found to delete");
        }
        else{
            //We create temp Options to swap Option we need to delete with last element
//        Options temp = new Options();
            Options temp = opt[length-1];
            opt[length-1] = opt[ind];
            opt[ind] = temp;

            Options[] NewArr = new Options[length-1];//New Array
            for(int i = 0; i < NewArr.length; i++)//Process of deletion
            {
                NewArr[i] = opt[i];
            }
            this.setOpt(NewArr);
        }
    }

    protected void printOneOption(int x)
    {
        int count = 1;
        for(Options i : opt)
        {
            if(count == x){
                System.out.println(i);
            }
            count++;
        }
        System.out.println("No such Option, printOneOption failed");
    }
    //Overload
    protected void printOneOption(String Oname)
    {
        boolean found = false;// To indicate when Option is found
        int length = this.opt.length;
        for (int i = 0; i < length - 1; i++)
        {
            if (opt[i].getOptName().equals(Oname))//To find
            {
                System.out.println(opt[i]);
            }
        }
        System.out.println("Option with name " + Oname + " No such Option, printOneOption failed");
    }

    @Override
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append("OptionSet name: ");
        sb.append(getOptionSetName());
        sb.append(", OptionSet's Options(Array): ");
        sb.append(Arrays.toString(getOpt()));

        return sb.toString();


    }
////////////////// GETTERS AND SETTERS ////////////////////////////////////////////////////////////////////////////////


    protected Options[] getOpt() {
        return opt;
    }

    protected void setOpt(Options[] opt) {
        this.opt = opt;
    }
    protected String getOptionSetName() {
        return OptionSetName;
    }

    protected void setOptionSetName(String optionName) {
        OptionSetName = optionName;
    }

    protected String getOptionName(int x){
        int count = 1;
        for(Options i : opt)
        {
            if(count == x){
                return i.getOptName();
            }
            count++;
        }
        System.out.println("No such Option, getOptionName failed");
        String o = null;
        return o;
    }
    protected void setOptionName(int x, String OName){
        int count = 1;
        for(Options i : opt)
        {
            if(count == x){
                i.setOptName(OName);
            }
            count++;
        }
        System.out.println("No such Option, setOptionName failed");
    }
    protected double getOptionPrice(int x){
        int count = 1;
        for(Options i : opt)
        {
            if(count == x){
                return i.getOptPrice();
            }
            count++;
        }
        System.out.println("No such Option, getOptionPrice failed");
        return 0;
    }
    //Overloaded
    protected double getOptionPrice(String Oname){
        boolean found = false;// To indicate when Option is found
        int length = this.opt.length;
        for (int i = 0; i < length - 1; i++)
        {
            if (opt[i].getOptName().equals(Oname))//To find
            {
                System.out.println(opt[i].getOptPrice());
                return opt[i].getOptPrice();
            }
        }
        System.out.println("Option with name " + Oname + " No such Option, getOptionPrice failed");
        return 0;
    }
    protected void setOptionPrice(int x, double OPrice){
        int count = 1;
        for(Options i : opt)
        {
            if(count == x){
                i.setOptPrice(OPrice);
            }
            count++;
        }
        System.out.println("No such Option, setOptionPrice failed");
    }

    protected Options getOneOpt(String Oname){
        boolean found = false;// To indicate when Option is found
        int length = this.opt.length;
        for (int i = 0; i < length - 1; i++)
        {
            if (opt[i].getOptName().equals(Oname))//To find
            {
                System.out.println(Oname + " Option with name found successfully");
                return opt[i];
            }
        }
        System.out.println("Option with name " + Oname + " didn't found, getOneOption failed");
        return null;
    }
    //Overload
    protected Options getOneOpt(int x){
        int count = 1;
        for(Options i : opt)
        {
            if(count == x){
                return i;
            }
            count++;
        }
        System.out.println("No such Option, getOneOption failed");
        return null;
    }
    protected void setOneOpt(String Oname, Options option){
        String nameToSet = option.getOptName();
        double priceToSet = option.getOptPrice();

        boolean found = false;// To indicate when Option is found
        int length = this.opt.length;
        for (int i = 0; i < length - 1; i++)
        {
            if (opt[i].getOptName().equals(Oname))//To find
            {
                System.out.println(Oname + " Option with name found successfully");
                opt[i].setOptName(nameToSet);
                opt[i].setOptPrice(priceToSet);
                found = true;
            }
        }
        if(!found){
            System.out.println("Option with name " + Oname + " didn't found, getOneOption failed");
        }
    }
    protected void setOneOpt(int x, Options option){
        boolean found = false;
        String nameToSet = option.getOptName();
        double priceToSet = option.getOptPrice();
        int count = 1;
        for(Options i : opt)
        {
            if(count == x){
                System.out.println(x + " Option found successfully");
                i.setOptName(nameToSet);
                i.setOptPrice(priceToSet);
                found = true;
            }
            count++;
        }
        if(!found){
            System.out.println("No such Option, getOneOption failed");
        }
    }

    protected int getOptionsLength(){
        return opt.length;
    }

///////////////////////////////////////New Inner Class/////////////////////////////////////////////////////////////////

    protected class Options
    {
        private String OptName;
        private double OptPrice;
        private static int size; //not used

        //////// Constructors ////////////
        Options()
        {
        }
        Options (String OptName, double OptPrice)
        {
            this.OptName = OptName;
            this.OptPrice = OptPrice;
            size++;

        }
        //Methods
        @Override
        public String toString()
        {
            StringBuffer sb1 = new StringBuffer();
            sb1.append("Name: ");
            sb1.append(getOptName());
            sb1.append(", Price: ");
            sb1.append(getOptPrice());

            return sb1.toString();
        }

////////////////// GETTERS AND SETTERS ////////////////////////////////////////////////////////////////////////////////
        protected String getOptName() {
            return OptName;
        }

        protected void setOptName(String optName) {
            OptName = optName;
        }

        protected double getOptPrice() {
            return OptPrice;
        }

        protected void setOptPrice(double optPrice) {
            OptPrice = optPrice;
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    }





}
