package niuke;

/**
 * @author yfy
 * @version : SendValue.java,v 0.1 2019年08月25日 14:24
 */
public class SendValue {
    public String str="6";
    public static void main(String[] args) {
        SendValue sv=new SendValue();
        sv.change(sv.str);
        System.out.println(sv.str);
    }
    public void change(String param) {
        //形参与成员变量不同名，改变的是成员变量
        str="10";
    }

}
