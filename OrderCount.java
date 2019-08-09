package TWorks;
import java.text.SimpleDateFormat;
import java.util.*;
public class OrderCount {
        public Map OrderSucessMoney(Set orderU,Set orderPrice) throws Exception{
            SimpleDateFormat formatd = new SimpleDateFormat("yyyy-MM-dd");
            Iterator iter=orderU.iterator();
            Map oPriceMap=new HashMap();
            while (iter.hasNext()){
                String info=(String) iter.next();
                String[] temp=info.split(" ");
                Date date=formatd.parse(temp[1]);
                String week=getWeek(date);
                int price=getPay(temp[2],week);
                String allInfo=info+" "+String.valueOf(price);
                orderPrice.add(allInfo);
                if (!oPriceMap.containsKey(info)){
                    oPriceMap.put(info,price+" "+week);
                }
            }
            return oPriceMap;
        }
        //s--time(9:00~12:00),week--周几
        private int getPay(String s,String week) {
            Set setw = new HashSet();
            Set setweekend = new HashSet();
            setw.add("星期一");
            setw.add("星期二");
            setw.add("星期三");
            setw.add("星期四");
            setw.add("星期五");
            setweekend.add("星期六");
            setweekend.add("星期日");
            String[] str = s.split("~");
            int time1 = Integer.valueOf(str[1].split("\\:")[0]);
            int time2 = Integer.valueOf(str[0].split("\\:")[0]);
            if (setw.contains(week)) {
                int len=4;
                int money=pointVal(time1,len)-pointVal(time2,len);
                return money;
            }else {
                int money=pointVal(time1)-pointVal(time2);
                return money;
            }
        }
       public int pointVal(int x,int len){
            //工作日，4个时间段
           int[] price = {30, 50, 80, 60};
           int[] point = {9, 12, 18, 20, 22};
            int val=0;
            if (x>=point[0]&&x<point[1]){
                val=price[0]*(x-point[0]);
            }
           if (x>=point[1]&&x<point[2]){
               val= 30*3+price[1]*(x-point[1]);
           }
           if (x>=point[2]&&x<point[3]){
               val= 90+50*6+price[2]*(x-point[2]);
           }

           if (x>=point[3]&&x<point[4]){
               val= 90+50*6+2*80+price[3]*(x-point[3]);
           }
           return val;
       }

    public int pointVal(int x){
        //工作日，3个时间段
        int[] price = {40, 50,60};
        int[] point = {9, 12,18,22};
        int i=0;
        int val=0;
        if (i==0&&x>=point[i]&&x<point[i+1]){
            val=price[i]*(x-point[i]);
        }
        i++;
        if (i==1&&x>=point[i]&&x<point[i+1]){
            val= 40*3+price[i]*(x-point[i]);
        }
        i++;
        if (i==2&&x>=point[i]&&x<point[i+1]){
            val= 120+50*6+price[i]*(x-point[i]);
        }
        return val;

    }

    public static String getWeek(Date date){
            String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
            if(week_index<0){
                week_index = 0;
            }
            return weeks[week_index];
        }

//    public static void main(String[] args) throws Exception {
//        Scanner sc=new Scanner(System.in);
//        Map<String,List> map=new HashMap();
//        while (sc.hasNext()){
//            boolean  flag=false;
//            //Date
//            String key=sc.next();
//            if (key.equals("##")){
//                break;
//            }
//            if (map.keySet().contains(key)){
//                String s=sc.next();
//                flag=checkOverlap(map,key,s);
//            }
//            else {
//                List list=new ArrayList();
//                list.add(sc.next());
//                map.put(key,list);
//                flag=true;
//            }
//            //时间冲突
//            if (flag){
//                System.out.println("Success:the booking is accepted!" );
//            }else {
//                System.out.println("Error: the booking is invalid!");
//            }
//
//        }
//        sc.close();
//        OrderCount orderCnt=new OrderCount();
//        int val=orderCnt.OrderSucessMoney(map);
//        System.out.println(val);
//        }

}
