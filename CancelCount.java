package TWorks;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CancelCount {

     public void cancelFine(Map oPriceMap,Set orderPrice,Set cancelU,Set cancelPrice){
        //UID 2019-08-08 9:00~12:00 A C
        Iterator iter=cancelU.iterator();
        Set keys=oPriceMap.keySet();
        Set weekend=new HashSet();
        weekend.add("星期六");
        weekend.add("星期日");
        while (iter.hasNext()){
             String k=(String) iter.next();
             if (keys.contains(k)){
                 String pweek=(String) oPriceMap.get(k);
                 String[] PW=pweek.split(" ");
                 int price=Integer.valueOf(PW[0]);
                 if (weekend.contains(PW[1])){
                     double fine=price*0.25;
                     boolean b = keys.remove(k);
                     orderPrice.remove(k+" "+price);
                     String ss=k+" "+"惩罚金"+" "+fine;
                     cancelPrice.add(ss);
                 }else {
                     double fine=price*0.5;
                     boolean b = keys.remove(k);
                     orderPrice.remove(k+" "+price);
                     String ss=k+" "+"惩罚金"+" "+fine;
                     cancelPrice.add(ss);
                 }
             }
         }

     }

}
