package Triplos;
import java.util.Stack;


public class Pila {

    Character getTopOfOperator(Stack<Character> stack){
        if (stack.isEmpty()){
            return 'e';
        }

        Character top=stack.peek();
        return top;
    }

}
