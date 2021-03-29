import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @program: SpringCloud
 * @description
 * @author: charon
 * @create: 2020-12-11 22:00
 **/
public class T2 {

    @Test
    public  void test(){
        ZonedDateTime zbj = ZonedDateTime.now(); // 默认时区
        System.out.println(zbj);
        //2020-12-11T22:01:00.869+08:00[GMT+08:00]
    }
}
