package cn.yuhao.web;


import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;
import cn.yuhao.comment.PassToken;
import cn.yuhao.comment.UserLoginToken;
import cn.yuhao.pojo.entity.Userentity;
import cn.yuhao.service.RegisterService;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author imyzt
 * @date 2022/03/21
 * @description 描述信息
 */
@RequestMapping("/hello")
@RestController
//@UserLoginToken
public class HelloWorld {

    @Autowired
    private RegisterService registerService;
    @ResponseBody
    @GetMapping("/world")
    @UserLoginToken
    @PassToken
    public String HelloWorld(){
        Userentity userentity = new Userentity();
        userentity.setRid("1112231112");
        userentity.setUserName("zhangsan");
        userentity.setUserPassword("lissi");
        userentity.setRegisterAccount("123212321313");
        userentity.setRegisterTime(DateUtil.date());
        userentity.setAccountType(1);
        userentity.setGrade(1);
        userentity.setRegisterIp("192.168.1.1");
        registerService.save(userentity);
//        registerService.saveBatch(new ArrayList<Userentity>());
        return "hello world!";
    }

    public static void main(String[] args) {
        //当前时间
        Date date = DateUtil.date();
//当前时间
        Date date2 = DateUtil.date(Calendar.getInstance());
//当前时间
        Date date3 = DateUtil.date(System.currentTimeMillis());
//当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
        String now = DateUtil.now();
//当前日期字符串，格式：yyyy-MM-dd
//        String today= DateUtil.today();
//        System.out.println(date);
//        System.out.println(date2);
//        System.out.println(date3);
//        System.out.println(now);
//        System.out.println(today);
//        String dateStr = "2017-03-01";
//        Date www = DateUtil.parse(dateStr);
//        System.out.println(www);
//        System.out.println(DateUtil.parse(dateStr,"yyyy-MM-dd"));
//        System.out.println(DateUtil.format(www,"yyyy+MM+dd"));
//        String a = "123****8901";
//        System.out.println(a.substring(0,3)+a.substring(7));
//        System.out.println(a.contains("****"));
//        double money = 67556.32;
//
//        //结果为："陆万柒仟伍佰伍拾陆元叁角贰分"
//        String digitUppercase = Convert.digitToChinese(money);
//        System.out.println(digitUppercase);
//
//        String format = Convert.numberToWord(100.23);
//        System.out.println(format);
//        String format1 = Convert.numberToSimple(12000);
//        System.out.println(format1);

        List<String> al = Arrays.asList("a","b","c","d","e");
        for (String  e:al  ){
            System.out.println(e);
        }
        System.out.println("=====================");
        al.forEach(x->{
            System.out.println(x);
        });
        System.out.println("-----------------------");
        al.forEach(System.out::println);

        List<String> num = al.stream().map(n->n+n).collect(Collectors.toList());
        System.out.println(num.toString());

        Integer[] sixNums = {1,2,3,4,5};
        Integer[] evens = Arrays.stream(sixNums).filter(n->n%2 == 0).toArray(Integer[] ::new);
        Arrays.stream(evens).forEach(a-> System.out.println(a));
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );
        Stream<Integer> outputStream = inputStream.
                flatMap((childList) -> childList.stream());
        outputStream.forEach(w-> System.out.print(w));

        // peek 对每个元素执行操作并返回一个新的 Stream
        List<String>  f = Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());
        System.out.println(f.stream().findFirst());

        // 优化：排序前进行 limit 和 skip
        List<Person> persons = new ArrayList();
        for (int i = 1; i <= 5; i++) {
            Person person = new Person(i,"name"+i);
            persons.add(person);
        }
        System.out.println(persons);
        List<Person> personList2 = persons.stream().limit(2).sorted((p1, p2) -> p1.getName().compareTo(p2.getName())).collect(Collectors.toList());
        System.out.println(personList2);

    }
    @Data
    @ToString
    public static class Person{
        private String name;
        public Person(){}
        public Person(int i ,String name){
            this.name = name;
        }


    }
}
