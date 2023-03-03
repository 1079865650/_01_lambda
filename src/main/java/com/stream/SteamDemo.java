package com.stream;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SteamDemo {
    public static void main(String[] args) {
//        List<Author> authors = getAuthors();
//        extracted(authors);
//        test02();
//        test03();
//        test04();
//        test05();
//        test06();
//        test07();
//        test08();
//        test09();
//        test10();
//        test11();
//        test12();
//        test13();
//        test14();
//        test15();
//        test16();
//        test17();
//        test18();
//        test19();
//        test20();
//        test21();
//        test22();
//        test23();
//        test24();
//        test25();
//        test26();

    }

    private static void test26() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(author -> author.getAge())
                .reduce((integer, integer2) -> integer>integer2?integer:integer2);
    }

    private static void test25() {
        List<Author> authors = getAuthors();
        Integer reduce = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MAX_VALUE, (integer, integer2) -> integer > integer2 ? integer : integer2);
        System.out.println(reduce);
    }

    private static void test24() {
        List<Author> authors = getAuthors();
        Integer reduce = authors.stream()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (integer, integer2) -> integer < integer2 ? integer2 : integer);
        // reduce 设置一个全局的变量result 然后遍历stream流
        System.out.println(reduce);
    }

    private static void test23() {
        List<Author> authors = getAuthors();
        Integer reduce = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, (result, element) -> result + element);
        System.out.println(reduce);

    }

    private static void test22() {
        List<Author> authors = getAuthors();
        Optional<Author> first = authors.stream()
                .sorted((o1, o2) -> o1.getAge() - o2.getAge())
                .findFirst();
        first.ifPresent(author -> System.out.println(author.getName()));

    }

    private static void test21() {
        List<Author> authors = getAuthors();
        Optional<Author> any = authors.stream()
                .filter(author -> author.getAge()>18)//为啥是Optional类型
                .findAny();
        any.ifPresent(author -> System.out.println(author.getName()));

    }

    private static void test20() {
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .noneMatch(author -> author.getAge() >= 100);
        System.out.println(b);
    }

    private static void test19() {
        List<Author> authors = getAuthors();
        boolean b = authors.stream()
                .allMatch(author -> author.getAge() >= 18);
        System.out.println(b);

    }

    private static void test18() {
        List<Author> authors = getAuthors();
        //anyMatch判断是否存在这个条件
        boolean b = authors.stream()
                .anyMatch(author -> author.getAge() > 29);
        System.out.println(b);
    }

    private static void test17() {
        List<Author> authors = getAuthors();
        Map<String, List<Book>> map = authors.stream()  //从author里面获取name 获取 books
                .distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));  //toMap需要传递两个参数
        System.out.println(map.getClass());
    }

    private static void test16() {
        List<Author> authors = getAuthors();
        Set<Book> books = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toSet());
        System.out.println(books);
        System.out.println(books.getClass()); // class java.util.HashSet  books.getClass().getName()  java.util.HashSet 是 String类型
    }

    private static void test15() {
        List<Author> authors = getAuthors();
        List<String> nameList = authors.stream()
                .map(author -> author.getName())
                .collect(Collectors.toList()); //流转换为list集合 collect Collectors.toList
        System.out.println(nameList);
    }

    private static void test14() {
        //Stream<Author> -> Stream<Book> -> Stream<Integer> ->求值
        List<Author> authors = getAuthors();
        //指定一个Comparator排序的规则
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max((score1, score2) -> score1 - score2);

        Optional<Integer> min = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .min((score1, score2) -> score1 - score2);
        System.out.println(min.get());
        System.out.println(max.get());
    }

    private static void test13() {
        List<Author> authors = getAuthors();
        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);
    }

    private static void test12() {
        List<Author> authors = getAuthors();
        authors.stream()
                .map(author -> author.getName())
                .distinct()
                .forEach(name -> System.out.println(name));
    }

    private static void test11() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(category -> System.out.println(category));
    }

    private static void test10() {
        List<Author> authors = getAuthors();
        authors.stream()
                .flatMap((Function<Author, Stream<Book>>) author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));
    }

    private static void test09() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted()
                .skip(2) //skip 跳过前N个元素
                .forEach(author -> System.out.println(author.getName()));

    }

    private static void test08() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted()
                .limit(2)
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test07() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .sorted()  // 默认author author没办法 转换为comparable排序
                .forEach(author -> System.out.println(author.getAge()));
    }

    private static void test06() {
        List<Author> authors = getAuthors();
        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));
    }

    private static void test05() {
        // 打印所有作家的姓名
        List<Author> authors = getAuthors();
        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age+10)
                .forEach(age -> System.out.println(age));
    }

    private static void test04() {
        List<Author> authors = getAuthors();
        authors.stream()
                .filter(author -> author.getName().length()>1)
                .forEach(author -> System.out.println(author.getName()));

    }

    private static void test03() {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("蜡笔小新",19);
        map.put("黑子",17);
        map.put("日向翔阳",16);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();// map集合转数组  用 Entry对象封装  Entry<String, Integer>
        Stream<Map.Entry<String, Integer>> stream = entries.stream();
        stream.filter(new Predicate<Map.Entry<String, Integer>>() {
            @Override
            public boolean test(Map.Entry<String, Integer> entry) {
                return entry.getValue()>16;
            }
        }).forEach(new Consumer<Map.Entry<String, Integer>>() {
            @Override
            public void accept(Map.Entry<String, Integer> stringIntegerEntry) {
                System.out.println(stringIntegerEntry.getKey()+"=="+ stringIntegerEntry.getValue());
            }
        });
    }

    private static void test02() {
        Integer[] arr = {1,2,3,4,5};
//        Stream<Integer> stream = Arrays.stream(arr); // arr 是Integer数组 所以传入Integer
        Stream<Integer> stream = Stream.of(arr);
        stream.distinct()
                .filter(integer -> integer>2)
                .forEach(integer -> System.out.println(integer));
    }

    private static void extracted(List<Author> authors) {
        authors.stream()  // 把集合转换成流
                .distinct()
                .filter(author -> {
                    System.out.println("test");
                    return author.getAge() < 18;
                })
                .forEach(author -> System.out.println(author.getName())); // stream需要终结方法 才能调用所有流程
    }

    private static List<Author> getAuthors() {
        //数据初始化
        Author author = new Author(1L,"蒙多",33,"一个从菜刀中明悟哲理的祖安人",null);
        Author author2 = new Author(2L,"亚拉索",15,"狂风也追逐不上他的思考速度",null);
        Author author3 = new Author(3L,"易",14,"是这个世界在限制他的思维",null);
        Author author4 = new Author(3L,"易",14,"是这个世界在限制他的思维",null);

        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L,"刀的两侧是光明与黑暗","哲学,爱情",88,"用一把刀划分了爱恨"));
        books1.add(new Book(2L,"一个人不能死在同一把刀下","个人成长,爱情",99,"讲述如何从失败中明悟真理"));

        books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维去领略世界的尽头"));
        books2.add(new Book(3L,"那风吹不到的地方","哲学",85,"带你用思维去领略世界的尽头"));
        books2.add(new Book(4L,"吹或不吹","爱情,个人传记",56,"一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L,"你的剑就是我的剑","爱情",56,"无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));
        books3.add(new Book(6L,"风与剑","个人传记",100,"两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢？"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author,author2,author3,author4));
        return authorList;
    }
}
