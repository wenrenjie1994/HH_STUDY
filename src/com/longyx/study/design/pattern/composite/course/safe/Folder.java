package com.spdb.study.design.pattern.composite.course.safe;

import com.spdb.study.design.pattern.composite.course.transparent.CourseComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mr.Longyx
 * @date 2020年07月06日 11:16
 */
public class Folder extends Directory{
    private List<Directory> dirs;
    private Integer level;

    public Folder(String name,Integer level) {
        super(name);
        this.level = level;
        dirs = new ArrayList<>();
    }

    @Override
    public void show() {
        System.out.println(this.name);

        for (Directory dir : dirs){
            if (this.level != null){
                for (int i=0;i<this.level;i++){
                    System.out.print("  ");
                }
                for(int i=0;i<this.level;i++){
                    if (i == 0){
                        System.out.print("+");
                    }
                    System.out.print("-");
                }
            }
            dir.show();
        }
    }

    public boolean add(Directory dir){
        return this.dirs.add(dir);
    }

    public boolean remove(Directory dir){
        return this.dirs.remove(dir);
    }

    public Directory get(int index){
        return this.dirs.get(index);
    }

    public void list(){
        for (Directory dir : dirs) {
            System.out.println(dir.name);
        }
    }
}
