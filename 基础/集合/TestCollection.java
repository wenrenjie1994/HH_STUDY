public class TestCollection {
    public static void main(String[] args) {
        Hero heros[] = new Hero[10];

        heros[0] = new Hero("盖伦");
        //放不下要报错
        heros[20] = new Hero("提莫");
        ////////////ArrayList////////////
        //容器类ArrayList，用于存放对象
        ArrayList heros = new ArrayList();
        heros.add( new Hero("盖伦"));
        System.out.println(heros.size());

        //容器的容量"capacity"会随着对象的增加，自动增长
        //只需要不断往容器里增加英雄即可，不用担心会出现数组的边界问题。
        heros.add( new Hero("提莫"));
        System.out.println(heros.size());

    }

    }

}
