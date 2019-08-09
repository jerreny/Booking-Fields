package TWorks;

import java.util.*;

public class StasticProfit {
    public Map getProfit(Set orderPrice,Set cancelPrice){
        Map<String,List> map=new HashMap();
        Iterator iter1=orderPrice.iterator();
        while (iter1.hasNext()){
            String s=(String)iter1.next();
            String[] sd=s.split(" ");
            String fmap=sd[3];
            if (map.keySet().contains(fmap)){
                List list1=map.get(fmap);
                list1.add(sd[1]+" "+sd[2]+" "+sd[4]);
            }
            else {
                List list=new ArrayList();
                list.add(sd[1]+" "+sd[2]+" "+sd[4]);
                map.put(fmap,list);
            }

        }
        Iterator iter2=cancelPrice.iterator();
        while (iter2.hasNext()){
            String s=(String)iter2.next();
            String[] sd=s.split(" ");
            String fmap=sd[3];
            if (map.keySet().contains(fmap)){
                List list1=map.get(fmap);
                list1.add(sd[1]+" "+sd[2]+" "+sd[4]+" "+sd[5]);
            }
            else {
                List list=new ArrayList();
                list.add(sd[1]+" "+sd[2]+" "+sd[4]+" "+sd[5]);
                map.put(fmap,list);
            }

        }


     return  map;
    }
}
