package cmo.mic.test;

import com.mic.service.foo.StuService;
import com.mic.service.foo.TestTransService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TranTest {

    @Autowired
    private StuService stuService;

    @Autowired
    private TestTransService testTransService;

    @Test
    public void  myTest(){
//        stuService
          testTransService.testPropagationTrans();
    }
}
