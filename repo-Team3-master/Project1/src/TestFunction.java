import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestFunction {
    public static void main(String args[]) {
        ArrayList testlist = new ArrayList();
        String testStr = "[Pike,D],   [Foster ,D],  [Deutsch,  R]";
        Pattern p = Pattern.compile("\\[(.+?)\\]");
        Matcher m = p.matcher(testStr);

        testlist.add(new Party("A", 2,2));
        testlist.add(new Party("B", 1,2));
        testlist.add(new Party("C", 1,2));
        testlist.add(new Party("D", 2,2));
        testlist.add(new Party("E", 1,2));

        Collections.sort(testlist);
        System.out.println(testlist);
//
//
//        while(m.find()) {
//            System.out.println(m.group(1));
//        }
    }
}
