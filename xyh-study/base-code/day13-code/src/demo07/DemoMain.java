package demo07;

public class DemoMain {
    public static void main(String[] args) {
        Usb usb=new Phone();
        useUsb(usb);
    }
   public static  void  useUsb(Usb usb){
       System.out.println("สนำร"+usb.type());

   }

}
