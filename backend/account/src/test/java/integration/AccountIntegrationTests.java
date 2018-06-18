package integration;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.DeleteTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
@WebAppConfiguration
@ActiveProfiles("local")
public class AccountIntegrationTests {

   @Autowired
   private AccountRepository accountRepository;
   @Autowired
   private AmazonDynamoDB amazonDynamoDB;

   private DynamoDBMapper dynamoDBMapper;

   @Before
    public void  setUp() {

       assertNotNull("AccountRepository is null!", accountRepository);
       assertNotNull("AmazonDynamoDB is null", amazonDynamoDB);
       dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
       CreateTableRequest createTableRequest = dynamoDBMapper.generateCreateTableRequest(Account.class);
       createTableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
       amazonDynamoDB.createTable(createTableRequest);
   }

    @Test
    public void save(){
       try {
           Account account = new Account();
           account.setLastName("Last name");
           account.setFirstName("First name");
           account.setEmail("email@email.com");

           account = accountRepository.save(account);
          assertNotNull(account.getEmail(), "Account hasn't been saved!");
       }
       catch(Exception ex) {
           ex.printStackTrace();
           fail("An error occured during the Account save operation " + ex.getMessage());
        }
    }

    @After
    public void cleanUp() {
//        DeleteTableRequest deleteTableRequest = dynamoDBMapper.generateDeleteTableRequest(Account.class);
//        amazonDynamoDB.deleteTable(deleteTableRequest);
    }

}
