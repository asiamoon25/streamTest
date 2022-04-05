package me.yeonsang;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class App {
    public static void main( String[] args ) {
        //배열 스트림
//        String[] arr = new String[]{"a","b","c"};
//        Stream<String> stream = Arrays.stream(arr);
//        Stream<String> streamOfArrayPart = Arrays.stream(arr,1,3);
//        System.out.println(Arrays.toString(streamOfArrayPart.toArray()));

        //컬렉션 스트림
//        List<String> list = Arrays.asList("a","b","c");
//        Stream<String> stream2 = list.stream();
//        Stream<String> parallelStream = list.parallelStream(); //병렬처리 스트림

//        System.out.println(Arrays.toString(stream2.toArray())+","+Arrays.toString(parallelStream.toArray()));

        //비어있는 스트림
//        Stream<String> str = streamOf(null);

//        System.out.println(Arrays.toString(str.toArray()));

        //스트림 빌더

        Stream<String> builderStream = Stream.<String>builder()
                .add("Eric").add("Elena").add("JAVA")
                .build();

//        System.out.println(Arrays.toString(builderStream.toArray()));

        //generate()
        Stream<String> generateStream = Stream.generate(() -> "gen").limit(5); //사이즈가 무한대 이므로 특정 사이즈로 최대 크기를 제한한다.

//        System.out.println(Arrays.toString(generateStream.toArray()));

        //iterate() 초기 값과 해당 값을 다루는 람다를 이용해서 스트림에 들어갈 요소를 만든다.
        Stream<Integer> iteratedStream = Stream.iterate(30, n-> n+2).limit(5);

        System.out.println(Arrays.toString(iteratedStream.toArray()));

        // 기본 타입형 스트림
        IntStream intStream = IntStream.range(1,5);

        LongStream longStream = LongStream.rangeClosed(1,5);

        Stream<Integer> boxedIntStream = IntStream.range(1,5).boxed();

        DoubleStream doubles = new Random().doubles(3); //난수 3개 생성

        IntStream charsStream = "Stream".chars(); // [83,116,113,101,97,109]
        

    }

    public static Stream<String> streamOf(List<String> list) {
     return list == null || list.isEmpty() ? Stream.empty() : list.stream();
    }

}
