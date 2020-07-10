package com.pan.principle.ocp.improve;

public class Ocp {
    public static void main(String[] args) {

        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Circle());
        graphicEditor.drawShape(new Triangle());
        graphicEditor.drawShape(new OtherGraphic());
    }
}

//适用方
class GraphicEditor {
    public void drawShape(Shape s) {
//        if (s.m_type == 1) drawRectangle(s);
//        else if (s.m_type == 2) drawCircle(s);
//        else if (s.m_type == 3) drawTriangle(s);
        s.draw();
    }

//    public void drawRectangle(Shape r) {
//        System.out.println(" 绘制矩形 ");
//    }
//
//    public void drawCircle(Shape r) {
//        System.out.println(" 绘制圆形 ");
//    }
//
//    public void drawTriangle(Shape t) {
//        System.out.println(" 绘制三角形 ");
//    }

}

abstract class Shape {
//    int m_type;

    public abstract void draw();//抽象方法
}

class Rectangle extends Shape {
//    Rectangle() {
//        super.m_type = 1;
//    }

    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}

class Circle extends Shape {
//    Circle() {
//        super.m_type = 2;
//    }

    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

//新增画三角形
class Triangle extends Shape {
//    Triangle() {
//        super.m_type = 3;
//    }

    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }
}

class OtherGraphic extends Shape{

//    OtherGraphic() {
//        super.m_type = 4;
//    }
    @Override
    public void draw() {
        System.out.println("绘制其他图形");
    }
}
























