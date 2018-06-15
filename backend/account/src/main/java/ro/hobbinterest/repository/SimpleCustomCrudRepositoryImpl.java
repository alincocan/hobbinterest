package ro.hobbinterest.repository;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.hobbinterest.entities.Account;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

@Component("customRepository")
public class SimpleCustomCrudRepositoryImpl<T,ID> implements CustomCrudRepository<T,ID> {

    @Autowired
    private DynamoDB dynamoDB;

    @Override
    public Optional<T> findByIdD(ID id) {
      Type t = getClass().getGenericSuperclass();

//        Table table = dynamoDB.getTable(pClass.getName());
        return Optional.empty();
    }
}
