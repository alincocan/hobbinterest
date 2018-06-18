import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import ro.hobbinterest.SpringConfiguration;
import ro.hobbinterest.entities.Account;
import ro.hobbinterest.repository.AccountRepository;
import ro.hobbinterest.service.AccountService;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
@WebAppConfiguration
@ActiveProfiles("local")
public class AccountTest {

    private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @Autowired
    private AccountRepository accountRepository;

    @Before
    public void setup() {

        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);

        CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Account.class);
        tableRequest.setProvisionedThroughput(
                new ProvisionedThroughput(1L, 1L));
        amazonDynamoDB.createTable(tableRequest);

    }

    @After
    public void destroy() {
        dynamoDBMapper.batchDelete(accountRepository.findAll());

        DeleteTableRequest deleteTableRequest = dynamoDBMapper.generateDeleteTableRequest(Account.class);
        amazonDynamoDB.deleteTable(deleteTableRequest);
    }
    @Test
    public void saveAccount() {
        try {
            Account account = new Account();
            account.setEmail("test@test.mail");
            account.setFirstName("First name");
            account.setLastName("Last name");
            account.setPassword("password");
            account = accountRepository.save(account);
            Assert.assertNotNull(account.getId());
        }

        catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

}
