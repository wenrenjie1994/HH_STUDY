package com.spdb.study.design.principle.liskosubstitution.simple;

/**
 * 里氏替换原则：父类完全可以用子类来替换，结果不应该受到影响
 * @author Mr.Longyx
 * @date 2020年06月17日 21:11
 */
public class SimpleTest {
    public static void resize(Rectangle rectangle){
        while (rectangle.getWidth() >= rectangle.getHeight()){
            rectangle.setHeight(rectangle.getHeight()+1);
            System.out.println("Width: "+rectangle.getWidth() + ",Height: "+rectangle.getHeight());
        }
        System.out.println("Resize End, Width: "+rectangle.getWidth() + ",Height: "+rectangle.getHeight());
    }

    public static void main(String[] args) {
        /**
         * 长方形的情形
         * @author Mr.Longyx
         * @date 2020/6/17 21:18
         *
         * Rectangle rect = new Rectangle();
         * rect.setWidth(40L);
         * rect.setHeight(20L);
         * resize(rect);
         */

        /**
         * 正方形的情形(破坏了里氏替换原则)
         * @author Mr.Longyx
         * @date 2020/6/17 21:18
         */

        Square square = new Square();
        square.setSideLength(20L);
        resize(square);
    }
}
