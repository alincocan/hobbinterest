import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ro.hobbinterest.SpringConfiguration;
import ro.hobbinterest.entities.Account;
import ro.hobbinterest.repository.SimpleCustomCrudRepositoryImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class Test {

    @Autowired
    private SimpleCustomCrudRepositoryImpl<Account, String> customRepository;

    @org.junit.Test
    public void test() {
        customRepository.findByIdD("1321321");
    }
}
