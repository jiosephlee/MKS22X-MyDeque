import java.lang.*;
import java.io.*;
import java.util.*;
public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
        String[] hold = s.split(s);
        MyDeque<String> idk = new MyDeque<String>();
        for (String i : hold){
            if(i == "+"){
                idk.addLast("" + Double.parseDouble(idk.removeLast()) + Double.parseDouble(idk.removeLast()));
            } else if(i == "-"){
                idk.addLast("" + (Double.parseDouble(idk.removeLast()) - Double.parseDouble(idk.removeLast()) * -1));
            } else if(i == "*"){
                idk.addLast("" + Double.parseDouble(idk.removeLast()) * Double.parseDouble(idk.removeLast()));
            } else if(i == "/"){
                idk.addLast("" + 1/(Double.parseDouble(idk.removeLast()) / Double.parseDouble(idk.removeLast())));
            } else{
                idk.addLast(i);
            }
        }
        return Double.parseDouble(idk.removeLast());
    }
}
