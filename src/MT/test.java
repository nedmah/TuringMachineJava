package MT;

import java.util.Stack;

public class test {
    public static void main(String[] args) {
        TM tm = new TM();
        Stack<Character> list = new Stack<>();
        list.push('0');
        list.push('1');
        list.push('*');
        list.push('2');
        list.push('2');
        list.push('*');
        list.push('3');
        System.out.println(list.toString());
        System.out.println("Word size " + list.size());


        System.out.println(tm.start(list).toString());
        System.out.println("A) The number of times the machine was in state q1: "+tm.getCountQ1());
        System.out.println("The number of times the machine was in state q2: "+tm.getCountQ2());
        if (tm.getCountQ1()>0 && tm.getCountQ2()>0) System.out.println("B) Machine was in every state " + Math.min(tm.getCountQ1(), tm.getCountQ2()) + " times");
        else System.out.println("Machine wasn't in its every state");
        System.out.println("C) total reviewed cells: " + tm.oboz.size());
        System.out.println("D) Amount of not empty cells " + numOfNotEmpty(list));
        if (Math.min(tm.getCountQ1(), tm.getCountQ2()) == 0) System.out.println("E) Machine wasn't in its every state ");
        else System.out.println("E) Machine was in every state");
        System.out.println("F) On 3rd measure x0 =  " + tm.a10 + " On 5th measure x0 =  " + tm.a20 + " On 7th measure =  " + tm.a30);
        System.out.println("G) In total, the cell corresponding to the state q2 and the symbol '0' was selected so many times: "+tm.getCountKletka());
        System.out.println("H) Amount of direction changes: "+tm.getCountVector());
    }

    public static int numOfNotEmpty(Stack<Character> stack){ //для г
        int result = 0;
        for(int i=0; i<stack.size(); i++){
            if(!stack.get(i).equals('#')){
                result++;
            }
        }
        return result;
    }
}
