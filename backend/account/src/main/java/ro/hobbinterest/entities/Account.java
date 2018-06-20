package ro.hobbinterest.entities;


import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@DynamoDBTable(tableName = "account")
public class Account {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    private String id;

    @NotEmpty(message = "{firstName.notEmpty}")
    @DynamoDBAttribute
    private String firstName;

    @NotEmpty(message = "{lastName.notEmpty}")
    @DynamoDBAttribute
    private String lastName;

    @NotEmpty(message = "{password.notEmpty}")
    @DynamoDBAttribute
    private String password;

    @NotEmpty(message = "{email.notEmpty}")
    @Email(message = "{email.format}")
    @DynamoDBAttribute
    private String email;

    @DynamoDBAttribute
    private boolean suspended;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return isSuspended() == account.isSuspended() &&
                Objects.equals(getId(), account.getId()) &&
                Objects.equals(getFirstName(), account.getFirstName()) &&
                Objects.equals(getLastName(), account.getLastName()) &&
                Objects.equals(getPassword(), account.getPassword()) &&
                Objects.equals(getEmail(), account.getEmail());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getFirstName(), getLastName(), getPassword(), getEmail(), isSuspended());
    }

    public boolean isSuspended() {

        return suspended;
    }

    public void setSuspended(boolean suspended) {
        this.suspended = suspended;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", suspended=" + suspended +
                '}';
    }
}
