package TWorks;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.util.*;
import static TWorks.CheckConflict.checkOverlap;
import static TWorks.CheckConflict.checkEffectCancel;
class FieldFormat{
    public static boolean parse(String str){
        if (str.equals("A")||str.equals("B")||str.equals("C")||str.equals("D")){
            return true;
        }
        else return false;
    }
}
public class Booking {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        Map<String,List> map=new HashMap();
        Set orderU =new HashSet();
        Set orderPrice =new HashSet();
        Set cancelU =new HashSet();
        Set cancelPrice =new HashSet();
        JudegeInput ji=new JudegeInput();
        while (sc.hasNext()){
            boolean  flagO=false;
            //Date
            String string=sc.nextLine();
            if (string.equals("##")){
                break;
            }
            boolean inputTrue=ji.judge(string);
            if (inputTrue){
                String[] inf=string.split(" ");
                if (inf.length==4){
                    String keys=inf[1]+" "+inf[3];
                    if (map.keySet().contains(keys)){
                        String s=inf[2];
                        flagO=checkOverlap(map,keys,s);
                    }
                    else {
                        List list=new ArrayList();
                        list.add(inf[2]);
                        map.put(keys,list);
                        flagO=true;
                    }
//时间冲突
                    if (flagO){
                        orderU.add(string);
                        System.out.println("Success:the booking is accepted!" );
                    }else {
                        System.out.println("Error: the booking is invalid!");
                    }
                }
                if (inf.length==5){
                    if (checkEffectCancel(orderU,string,cancelU)){
                        System.out.println("Success:the booking is accepted!");
                    }
                    else {
                       System.out.println(" Error: the booking being cancelled does not exist!");
                    }
                }
            }
            //将场地和日期考虑
        }
        sc.close();
        OrderCount orderCnt=new OrderCount();
        Map oPriceMap=orderCnt.OrderSucessMoney(orderU,orderPrice);
        CancelCount cancelCnt=new CancelCount();
        cancelCnt.cancelFine(oPriceMap,orderPrice,cancelU,cancelPrice);
        //
        StasticProfit st=new StasticProfit();
        Map mapList=st.getProfit(orderPrice,cancelPrice);
        Set setkeys=mapList.keySet();
        Iterator iter=setkeys.iterator();
        int Sumdata=0;
        while (iter.hasNext()){
            String key=(String) iter.next();
            System.out.println(key);
            List list1=(List) mapList.get(key);
            int sum=0;
            for (int i=0;i<list1.size();i++){
                String sprint=(String) list1.get(i);
                System.out.print(sprint+"元");
                System.out.println();
                String [] cal=sprint.split("\\ ");
                sum+=Double.valueOf(cal[cal.length-1]);
            }
            System.out.print("小计: "+sum+"元");
            System.out.println();
            System.out.println();
            Sumdata+=sum;
        }
        System.out.println("---");
        System.out.print("总计："+Sumdata+"元");
    }



}


