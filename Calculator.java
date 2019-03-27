import java.lang.*;
import java.io.*;
import java.util.*;
public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static void main(String[] args) {
        System.out.println(eval("10 2.0 +") + " : should be 12");
        System.out.println(eval("11 3 - 4 + 2.5 *") + " : should be 30");
        System.out.println(eval("8 2 + 99 9 - * 2 + 9 -") + " : should be 893");
        System.out.println(eval("1 2 3 4 5 + * - -") + " : should be 26");
    }

    public static double eval(String s){
        String[] hold = s.split(" ");
        //for (String i : hold){
        //    System.out.print(i);
        //}
        //System.out.println();
        MyDeque<String> idk = new MyDeque<String>();
        for (String i : hold){
            if(i.compareTo("+") == 0){
                idk.addLast("" + (Double.parseDouble(idk.removeLast()) + Double.parseDouble(idk.removeLast())));
            } else if(i.compareTo("-") == 0){
                //System.out.println("YELLO:");
                idk.addLast("" + ((Double.parseDouble(idk.removeLast()) - Double.parseDouble(idk.removeLast())) * -1));
            } else if(i.compareTo("*") == 0){
                idk.addLast("" + (Double.parseDouble(idk.removeLast()) * Double.parseDouble(idk.removeLast())));
            } else if(i.compareTo("/") == 0){
                idk.addLast("" + (1/(Double.parseDouble(idk.removeLast()) / Double.parseDouble(idk.removeLast()))));
            } else if(i.compareTo("%") == 0){
                Double first = Double.parseDouble(idk.removeLast());
                Double second = Double.parseDouble(idk.removeLast());
                idk.addLast("" + (second % first));
            } else{
                idk.addLast(i);
            }
            //System.out.println("last: " + idk.getLast());
            //System.out.println("idk: " + idk);
        }
        return Double.parseDouble(idk.removeLast());
    }
}
