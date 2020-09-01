package com.spdb.study.java8.stream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Stream 的创建
 * @author Mr.Longyx
 * @date 2020年07月07日 15:02
 */
public class CreateStream {
    public static void main(String[] args) {
        createStreamFromCollection().forEach(System.out::println);

        createStreamFromValues().forEach(System.out::println);

        createStreamFromArrays().forEach(System.out::println);

        createStreamFromFile();

        createStreamFromIterator().forEach(System.out::println);

        createStreamFromGenerator().forEach(System.out::println);

        createObjStreamFromGenerator().forEach(System.out::println);
    }

    /**
     * Generate the stream object from Collection.
     * @author Mr.Longyx
     * @date 2020/7/7 20:00
     * @return java.util.stream.Stream<java.lang.String>
     */
    private static Stream<String> createStreamFromCollection(){
        List<String> ls = Arrays.asList("hello","java","king");
        return ls.stream();
    }
    private static Stream<String> createStreamFromValues(){
        return Stream.of("hello","java","python","php","C++");
    }

    private static Stream<String> createStreamFromArrays(){
        return Arrays.stream(new String[]{"hello","java","python","php","C++"});
    }

    private static Stream<String> createStreamFromFile(){
        //此处需要文件路径
        Path path = Paths.get("E:/github/HH_STUDY/src/com/spdb/study/design/pattern/proxy/dynamicproxy/spdbproxy/$Proxy0.java");
        try(Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
            return lines;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    private static Stream<Integer> createStreamFromIterator(){
        return Stream.iterate(0,n->n+4).limit(20);
    }

    private static Stream<Double> createStreamFromGenerator(){
        return Stream.generate(Math::random).limit(40);
    }

    //自定义Stream
    private static Stream<Obj> createObjStreamFromGenerator(){
        return Stream.generate(new ObjSupplier()).limit(10);
    }

    static class ObjSupplier implements Supplier<Obj>{
        private int index = 0;
        private Random random = new Random(System.currentTimeMillis());

        @Override
        public Obj get() {
            index = random.nextInt(200);

            return new Obj(index, "Name ->"+index);
        }
    }

    /**
     * 内部类
     * @author Mr.Longyx
     * @date 2020/7/7 15:47
     */
    static class Obj{
        private Integer id;
        private String name;

        public Obj(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
