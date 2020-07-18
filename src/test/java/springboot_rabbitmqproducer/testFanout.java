package springboot_rabbitmqproducer;

import com.zhanghui.vue.VueApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = VueApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class testFanout {
    @Test
    public void testfanout() {

    }
}
