package TWorks;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
class  JudegeInput{
    public  boolean judge(String orderInfo){
        SimpleDateFormat formatd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat formath = new SimpleDateFormat("HH:mm~HH:mm");
        String[] strings=orderInfo.split("\\ ");
        boolean flag=false;
        String Uid,date1 = null,hours=null;
        if (strings.length==4 && FieldFormat.parse(strings[3])){
            Uid=strings[0];
            date1=strings[1];
            hours=strings[2];
            try {
                Date date = formatd.parse(date1);
                Date date2=formath.parse(hours);
                flag=true;
            } catch (ParseException e) {
                System.out.println("日期或时间输入不合法");
                e.printStackTrace();
            }
        }
        if (strings.length<4){
            System.out.println("输入信息缺少");
        }
        if (strings.length==5 && FieldFormat.parse(strings[3])&& strings[4].equals("C")){
            Uid=strings[0];
            date1=strings[1];
            hours=strings[2];
            try {
                Date date = formatd.parse(date1);
                Date date2=formath.parse(hours);
                flag=true;
            } catch (ParseException e) {
                System.out.println("日期或时间输入不合法");
                e.printStackTrace();
            }
            if (strings.length<5){
                System.out.println("输入信息缺少");
            }
        }
       return flag;
    }
}