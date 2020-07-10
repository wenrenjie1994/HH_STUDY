package com.spdb.study.java8.parallel;

import java.util.Objects;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author Mr.Longyx
 * @date 2020年07月08日 23:50
 */
public class SpliteratorInAction {

    private static final String text = "Lorem ipsum dolor sit amet, consetetur adipipscing elit. Etiam in lacinianl"+
            "\n" +
            "Integer dictum,erat ut interdum viverra, erat dui suscipt eros,eget vestibulum mi massa ut"+
            "\n" +
            "Quisque lacinia non enim venenatis efficitur. Duis luctus at ex at java key letus home python"+
            "\n" +
            "Morbi eu conque ispum, ac loborties nulla. Proin cursus tortor lectus nhj php web netty spring springcloud"+
            "\n" +
            "Vivamus interdum aliquet massa nec pharetra. Morbi tristique eleifend fendrit qq wechat weibo Sed in"+
            "\n" +
            "Nam orci arcu, tincidunt quis eros citae,venenatis vehicula dui.Spliter porta suscipt command force"+
            "\n" +
            "baidu pink red yellow cylan-blue blank blue fork parallel accumulate trader lambda stream collector";

    public static void main(String[] args) {
        IntStream intStream = IntStream.rangeClosed(1, 10);
        Spliterator.OfInt spliterator = intStream.spliterator();

        Consumer<Integer> consumer = i -> System.out.println(i);
        spliterator.forEachRemaining(consumer);

        SpliteratorText spliteratorText = new SpliteratorText(text);
        Optional.ofNullable(spliteratorText.stream().count()).ifPresent(System.out::println);
        spliteratorText.stream().forEach(System.out::println);

        System.out.println("================================================================");
        spliteratorText.parallelStream().filter(s->!s.equals("")).forEach(System.out::println);
    }

    static class SpliteratorText{
        private final String[] data;

        public SpliteratorText(String text) {
            Objects.requireNonNull(text, "The parameter can not be null");
            this.data = text.split("\n");
        }

        public Stream<String> stream(){
            //false 表示该Stream是非并行的
            return StreamSupport.stream(new DefinedSpliterator(), false);
        }

        public Stream<String> parallelStream(){
            return StreamSupport.stream(new DefinedSpliterator(),true);
        }

        private class DefinedSpliterator implements Spliterator<String> {

            private int start;
            private int end;

            public DefinedSpliterator(){
                this.start  = 0;
                this.end = SpliteratorText.this.data.length-1;
            }

            public DefinedSpliterator(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public boolean tryAdvance(Consumer<? super String> action) {
                if (start <= end){
                    action.accept(SpliteratorText.this.data[start++]);
                    return true;
                }
                return false;
            }

            @Override
            public Spliterator<String> trySplit() {
                int mid = (end-start)>>1;
                if (mid <= 1){
                    return null;
                }
                int left  = start;
                int right = start + mid;
                start = start + mid +1;
                return new DefinedSpliterator(left,right);
            }

            @Override
            public long estimateSize() {
                return end - start;
            }

            @Override
            public long getExactSizeIfKnown() {
                return estimateSize();
            }

            @Override
            public int characteristics() {
                return IMMUTABLE | SIZED | SUBSIZED;
            }
        }

    }
}
