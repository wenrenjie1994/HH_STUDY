package com.longyx.study.design.pattern.composite.course.transparent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 10:30
 */
public class CoursePackage extends CourseComponent {
    private List<CourseComponent> items = new ArrayList<>();

    private String name;
    private Integer level;

    public CoursePackage(String name, Integer level) {
        this.name = name;
        this.level = level;
    }

    @Override
    public void addChild(CourseComponent component) {
       items.add(component);
    }

    @Override
    public void removeChild(CourseComponent component) {
        items.remove(component);
    }

    @Override
    public String getName(CourseComponent component) {
        return this.name;
    }

    @Override
    public void print() {
        System.out.println(this.name);

        for (CourseComponent cp : items){
            if (this.level != null){
                for (int i=0; i<this.level; i++){
                    System.out.print("  ");
                }
                for(int i=0; i<this.level; i++){
                    if (i == 0){
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            cp.print();
        }
    }
}
