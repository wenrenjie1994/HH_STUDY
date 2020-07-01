package com.spdb.study.design.principle.liskosubstitution.abstracted;

/**
 * @author Mr.Longyx
 * @date 2020年06月17日 21:38
 */
public class NormalTest {
    /**
     * 该方法只能传长方形(杜绝了继承的泛滥)
     * @author Mr.Longyx
     * @date 2020/6/17 21:45
     * @param rectangle
     */
    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth() >= rectangle.getHeight()){
            rectangle.setHeight(rectangle.getHeight()+1);
            System.out.println("Width: "+rectangle.getWidth() + ",Height: "+rectangle.getHeight());
        }
        System.out.println("Resize End, Width: "+rectangle.getWidth() + ",Height: "+rectangle.getHeight());
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(30L);
        rectangle.setHeight(18L);

        resize(rectangle);
    }
}
