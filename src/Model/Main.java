package Model;

import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Thank you for deciding to buy Ford's Focus Wagon ZTW \nYou have following options " +
                "for your car:");



        OptionSet color = new OptionSet("Colors", 0);
        OptionSet.Options[] colors_arr = new OptionSet.Options[3];
        colors_arr[0] = color.new Options("Blue", 0.0);
        colors_arr[1] = color.new Options("Red", 0.0);
        colors_arr[2]  = color.new Options("Green", 0.0);
        color.setOpt(colors_arr);

        OptionSet Transmission = new OptionSet("Transmission", 0);
        OptionSet.Options[] trans_arr = new OptionSet.Options[2];
        trans_arr[0] = Transmission.new Options("Automatic", 0.0);
        trans_arr[1] = Transmission.new Options("Standard", -815.0);
        Transmission.setOpt(trans_arr);

        OptionSet Brakes = new OptionSet("Brakes", 0);
        OptionSet.Options[] braked_arr = new OptionSet.Options[3];
        braked_arr[0] = Brakes.new Options("Standard", 0);
        braked_arr[1] = Brakes.new Options("ABS", 400.0);
        braked_arr[2] = Brakes.new Options("ABS with Advance Trac", 1625.0);
        Brakes.setOpt(braked_arr);

        OptionSet AirBags = new OptionSet("Air Bags", 0);
        OptionSet.Options[] bags_arr = new OptionSet.Options[2];
        bags_arr[0] = AirBags.new Options("None", 0.0);
        bags_arr[1] = AirBags.new Options("Selected", 350.0);
        AirBags.setOpt(bags_arr);

        OptionSet Moonroof = new OptionSet("Moonroof", 0);
        OptionSet.Options[] roof_arr = new OptionSet.Options[2];
        roof_arr[0] = Moonroof.new Options("None", 0.0);
        roof_arr[1] = Moonroof.new Options("Selected", 595.0);
        Moonroof.setOpt(roof_arr);

        Auto Ford = new Auto("Focus Fagon ZTW", 0, 5);
        OptionSet[] Arr_OptSets = new OptionSet[5];
        Arr_OptSets[0] = color;
        Arr_OptSets[1] = Transmission;
        Arr_OptSets[2] = Brakes;
        Arr_OptSets[3] = AirBags;
        Arr_OptSets[4] = Moonroof;
        Ford.setOptS(Arr_OptSets);






    // Testing find()
        OptionSet a1;
        OptionSet.Options b;

        a1 = Ford.FindSet("Colors");
        b = Ford.FindOption("Red");

//        System.out.println("Checkpoint");
//        Ford.DeleteSet("Brakes");
        OptionSet colorOptionSetOfFord = Ford.FindSet("Colors");



    // Testing delete()
//        Ford.DeleteOption("Red");
//        b = Ford.FindOption("Red");
//
//        Ford.UpdateOption("Deleted", "Red", 0);
//        Ford.FindOption("Red");

    // Testing add and delete for OptionSet
        OptionSet.Options orange = color.new Options("Orange", 0.0);
        System.out.println("Before");
        System.out.println(Arrays.toString(color.getOpt()));

        System.out.println("Adds orange");
        color.addOption(orange);
        System.out.println(Arrays.toString(color.getOpt()));

        color.deleteOption("Blue");
        System.out.println(Arrays.toString(color.getOpt()));

        color.deleteOption("Red");
        System.out.println(Arrays.toString(color.getOpt()));

        color.deleteOption("Black");
        System.out.println(Arrays.toString(color.getOpt()));

        Ford.DeleteOption("Orange", "Colors");
        System.out.println(Arrays.toString(color.getOpt()));

        System.out.println("Adds orange");
        color.addOption(orange);

        System.out.println("Deletes Green");
        Ford.DeleteOption("Green", "Colors");
        System.out.println(Arrays.toString(color.getOpt()));

        //Testing OptionSet Delete
        System.out.println("Deleting OptionSet");
        System.out.println(Arrays.toString(Ford.getOptS()));
        //Works perfectly
//        Ford.DeleteSet("Colors");
//        System.out.println(Arrays.toString(Ford.getOptS()));

        System.out.println("To get a "+Arrays.toString(color.getOpt()));
        OptionSet.Options Ora = color.getOneOpt(1);
        System.out.println(Ora);
        System.out.println(Arrays.toString(color.getOpt()));
        System.out.println("Check");
        System.out.println(Arrays.toString(Ford.getOptS()));

//        setOneOptionSet might have some bugs in it in Auto class
//        Also setOneOptionSetOption might have some bugs in Auto class

    }
}