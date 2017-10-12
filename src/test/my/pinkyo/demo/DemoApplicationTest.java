package my.pinkyo.demo;

import my.pinkyo.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DemoApplication.class)
public class DemoApplicationTest {
    public static final String basePath = "/test";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreate() throws Exception {
        String name = "testCreate";
        User result = createUser(name, "male");
        assertNotNull(result);
    }

    @Test
    public void testGetByName() throws Exception {
        String name = "testGetByName";
        createUser(name, "male");
        User user = restTemplate.getForObject(basePath + "/{name}", User.class, name);
        assertNotNull(user);
    }

    @Test
    public void testUpdate() throws Exception {
        String name = "testUpdate";
        User user = createUser(name, "male");

        user.setSex("female");
        restTemplate.put(basePath, user);
    }

    private User createUser(String name, String sex) {
        User user = new User();
        user.setName(name);
        user.setSex(sex);

        return restTemplate.postForObject(basePath, user, User.class);
    }
}