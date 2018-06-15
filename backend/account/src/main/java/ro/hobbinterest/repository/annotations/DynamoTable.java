package ro.hobbinterest.repository.annotations;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface DynamoTable {
    String tableName();
}
