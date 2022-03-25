package cn.yuhao.util;


import cn.yuhao.pojo.entity.Userentity;
import com.google.gson.internal.$Gson$Preconditions;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Random;

/**
 * @author imyzt
 * @date 2022/03/25
 * @description 描述信息
 */
@Slf4j
public class RandomCode {

        /**
         * 生成32位大小写加数字随机数
         * @param
         */
        public static String random() {
            String val = "";
            java.util.Random random = new java.util.Random();
            for (int i = 0; i < 32; i++) {//定义随机数位数
                // 输出字母还是数字
                String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
                // 字符串
                if ("char".equalsIgnoreCase(charOrNum)) {
                    // 取得大写字母还是小写字母
                    int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                    val += (char) (choice + random.nextInt(26));
                } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
                    val += String.valueOf(random.nextInt(10));
                }
            }

            return val;
        }

    /**
     * 生成一个digit位的随机数
     * 第一位不为0
     * @param digit
     * @return
     */
    public static String randomAccount(int digit){
            Random random = new Random();
            int first = 0;
            if((first = random.nextInt(digit)) == 0) first=1;
            StringBuilder builder = new StringBuilder(first);
            for (int i = 0; i < 10; i++) {
                builder.append(random.nextInt(digit));
            }
            return builder.toString();
        }

    public static void main(String[] args) {
        System.out.println(random());
        Userentity userentity = new Userentity();
        userentity.setRegisterTime(new Date());
        System.out.println(userentity.getRegisterTime());

    }

}