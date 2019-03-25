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
                idk.addLast(idk.removeLast() + idk.removeLast());
            } else if(i == "-"){
                idk.addLast((parseInt(idk.removeLast()) - parseInt(idk.removeLast())) * -1);
            } else if(i == "*"){
                idk.addLast(parseInt(idk.removeLast()) * parseInt(idk.removeLast()));
            } else if(i == "/"){
                idk.addLast(1/(idk.removeLast() / idk.removeLast()));
            }
        }
    }
}
