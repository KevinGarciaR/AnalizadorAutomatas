package Triplos;
import java.beans.Expression;
import java.util.EmptyStackException;
import java.util.Stack;


public class Shunting {
    Shunting operand1;
    Shunting operand2;
    Character charac;
    String name;
    Shunting(Character c){
        charac=c;
        this.name=c+"";

    }

    Shunting(Character num,Shunting e1,Shunting e2,String name){
        operand1=e1;
        operand2=e2;
        charac=num;
        this.name=name;
    }


}
