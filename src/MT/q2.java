package MT;

import java.util.ArrayList;
import java.util.List;

public class q2 extends Q{
    @Override
    public List<Object> trans(char symbol) {
        List<Object> res = new ArrayList<>();
        if (symbol=='#'){
            res.add('*');
            res.add("R");
            res.add(new q1());
        }
        else if (symbol=='*'){
            res.add('#');
            res.add("L");
            res.add(new q1());
        }
        else if (symbol=='0'){
            res.add('1');
            res.add("L");
            res.add(new q1());
        }
        else if (symbol=='1'){
            res.add('0');
            res.add("R");
            res.add(new q2());
        }
        else if (symbol=='2'){
            res.add('1');
            res.add("R");
            res.add(new q2());
        }
        else if (symbol=='3'){
            res.add('0');
            res.add("L");
            res.add(new q1());
        }
        else return null;
        return res;
    }
    @Override
    public String toString() {
        return "q2";
    }
}
