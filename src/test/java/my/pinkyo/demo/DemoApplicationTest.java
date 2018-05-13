package my.pinkyo.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import my.pinkyo.demo.model.User;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = {DemoApplication.class})
public class DemoApplicationTest {
    public static final String basePath = "/test";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreate() throws Exception {
        String name = "testCreate";
        ResponseEntity<User> result = createUser(name, "male");
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test(expected = Exception.class)
    public void testCreateFail() throws Exception {
        String name = "testCreateException";
        createUser(name, "male");
        createUser(name, "male");

        fail();
    }
    
    @Test
    public void testBadParameter() throws Exception {
    	ResponseEntity<User> result = createUser(null, "male");
    	assertEquals(HttpStatus.BAD_REQUEST, result.getStatusCode());
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
        User user = createUser(name, "male").getBody();

        user.setSex("female");
        restTemplate.put(basePath, user);
    }

    @Test
    public void testDelete() {
        String name = "testDelete";
        createUser(name, "male");

        restTemplate.delete(basePath + "/{name}", name);
    }

    private ResponseEntity<User> createUser(String name, String sex) {
        User user = new User();
        user.setName(name);
        user.setSex(sex);

        return restTemplate.postForEntity(basePath, user, User.class);
    }
}