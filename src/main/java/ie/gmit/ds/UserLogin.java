package ie.gmit.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * POJO class representation of user input login details.
 */
public class UserLogin {
    @NotNull
    private int userId;

    @NotBlank
    private String password;

    /**
     * Default constructor for Jackson deserialization.
     */
    public UserLogin() {
    }

    @JsonProperty
    public int getUserId() {
        return userId;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }
}
