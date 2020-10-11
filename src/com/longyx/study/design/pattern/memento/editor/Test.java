package com.longyx.study.design.pattern.memento.editor;

/**
 * @author Mr.Longyx
 * @date 2020年07月12日 8:59
 */
public class Test {
    public static void main(String[] args) {
        DraftCareTaker careTaker = new DraftCareTaker();

        Editor editor = new Editor("Java反射详解","本文结合实际框架中的反射应用场景，深入讲解Java中反射的实现机制并以案例进行辅助","reflect.png");

        ArticleMemento memento = editor.save2Memento();
        careTaker.addMemento(memento);

        System.out.println("标题： "+editor.getTitle()+"\n"+"内容： "+editor.getContent()+"\n"+"插图： "+editor.getImgs()+"\n暂存成功");
        System.out.println("完整信息： "+editor);

        /**
         * 首次修改文章
         * @author Mr.Longyx
         * @date 2020/7/12 9:08
         */
        editor.setTitle("【Komi原创】 Java反射详解");
        editor.setContent("本文结合实际框架中的反射应用场景，深入讲解Java中反射的实现机制,Komi著。");
        System.out.println("==========首次修改文章完成=======");
        System.out.println("首次修改后完整内容： "+editor);

        memento = editor.save2Memento();
        //存入草稿箱
        careTaker.addMemento(memento);

        /**
         * 第2次修改文章(未存草稿箱)
         * @author Mr.Longyx
         * @date 2020/7/12 9:08
         */
        editor.setTitle("【Komi原创】 Java反射机制详解");
        editor.setContent("结合实际框架中反射应用场景，深入讲解Java中反射的实现机制");
        System.out.println("==========第2次修改文章完成=======");

        System.out.println("第2次修改后完整内容： "+editor);

        /**
         * 首次撤销回退
         * @author Mr.Longyx
         * @date 2020/7/12 9:18
         */
        memento = careTaker.getMemento();
        editor.undoFromMemento(memento);
        System.out.println("首次撤销后，完整信息： "+editor);

        /**
         * 第2次撤销回退
         * @author Mr.Longyx
         * @date 2020/7/12 9:20
         */
        memento = careTaker.getMemento();
        editor.undoFromMemento(memento);
        System.out.println("第2次撤销后，完整信息： "+editor);
    }
}
