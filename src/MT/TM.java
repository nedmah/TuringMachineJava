package MT;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TM {
    private Q currentstate = new q1();
    private String line;
    private int countQ1 = 0;
    private int countQ2 = 0;
    private int countKletka = 0;
    private int countVector = 0;
    private int takt = 0;
    char a10;
    char a20;
    char a30;
    Set<Integer> oboz = new HashSet<>(); //сет чтобы не повторялось
    TM(){}
    TM(String line){
        this.line=line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    private Stack<Character> pushToBack(Stack<Character> line){ //добавляем пустой символ в начало стека на случай если влево надо уйти
        Stack<Character> help=new Stack<>();
        for (int i = line.size()-1; i >=0 ; i--) { //с конца потому что стек
            help.push(line.get(i));
        }
        help.push('#');
        Stack<Character> res = new Stack<>();
        for (int i = help.size()-1; i >=0 ; i--) {
            res.push(help.get(i));
        }
        return res;
    }

    public int getCountQ1() {
        return countQ1;
    }

    public int getCountQ2() {
        return countQ2;
    }

    public int getCountVector() {
        return countVector;
    }

    public int getCountKletka() {
        return countKletka;
    }

    public Stack<Character> start(Stack<Character> line){
        int i = 0;
        Stack<Character> reversed = new Stack<>();
        String previousVector = "";
        while (currentstate!=null){
            boolean trulio = false;
            if (currentstate instanceof q1) countQ1++;
            else if (currentstate instanceof q2) countQ2++;
            char symbol = line.get(i);
            line.set(i, (Character) currentstate.trans(symbol).get(0)); //меняем собственно символ на новый по состоянию из листа trans
            Q state = (Q) currentstate.trans(symbol).get(2); //меняем состояние на новое из trans
            if (currentstate.trans(symbol).get(1).equals("L")){
                if (previousVector=="R") countVector++;
                previousVector="L";
                trulio=true;
                i-=1;
            }
            else if (currentstate.trans(symbol).get(1).equals("R")){
                if (previousVector=="L") countVector++;
                previousVector="R";
                i+=1;
            }
            if (i== line.size()){ //если справа нет ничего
                line.push('#');
            }
            else if (i<0){  //если уходим налево но слева нет ничего
                line=pushToBack(line);
                i+=1;
            }
            oboz.add(i);
            currentstate = state;
            if (currentstate instanceof q2 && symbol=='*' || trulio) countKletka++;
            takt++;

            if(takt == 3){
                a10 = line.get(0);
            }
            if(takt == 5){
                a20 = line.get(0);
            }
            if(takt == 7){
                a30 = line.get(0);
            }
        }
        return line;
    }
}
