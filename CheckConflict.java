package TWorks;
import java.util.*;
/**
 * 判断多个时间段是否出现重叠
 * @author Jerreny
 **/
//考虑日期和时间，若两个场地，场地不同也可以
//若时间和日期不同，均可以

public class CheckConflict{

    public static boolean checkOverlap(Map map, String k, String s){
        boolean flage=true;
        List listg= (List) map.get(k);
        String[] c=s.split("\\~");
        for(int i=0; i<listg.size(); i++){
            String[] d= ((String) listg.get(i)).split("\\~");
            if (compare(c,d)==1){
                continue;
            }else {
                flage=false;
                break;
            }

        }
        if (flage){
            listg.add(s);
        }
        return flage;
    }
    public static int compare(String[] c,String[] d){
        String sComTime=c[0].split("\\:")[0];
        String eComTime=c[1].split("\\:")[0];
        String  sitem=d[0].split("\\:")[0];
        String  eitem=d[1].split("\\:")[0];
        if (Integer.valueOf(sComTime)>=Integer.valueOf(eitem)||
                Integer.valueOf(eComTime)<=Integer.valueOf(sitem)){
            return 1;
        }else
        {
            return 0;
        }

    }
    //判断取消订单是否存在
    public static boolean checkEffectCancel(Set orderU,String s,Set cancelU){
        String[] str=s.split(" ");
        String orderS=str[0]+" "+str[1]+" "+str[2]+" "+str[3];
        if (orderU.contains(orderS))
        {
//            orderU.remove(orderS);
           cancelU.add(orderS);
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Map<String,List> map=new HashMap();
        while (sc.hasNext()){
            boolean  flag=false;
            //Date
            String[] inf=sc.nextLine().split(" ");
            //将场地和日期考虑
            String keys=inf[1]+" "+inf[3];
            if (map.keySet().contains(keys)){
                String s=inf[2];
                flag=checkOverlap(map,keys,s);
            }
            else {
                List list=new ArrayList();
                list.add(inf[2]);
                map.put(keys,list);
                flag=true;
            }
//时间冲突
            if (flag){
                System.out.println("Success:the booking is accepted!" );
            }else {
                System.out.println("Error: the booking is invalid!");
            }

        }


    }
}