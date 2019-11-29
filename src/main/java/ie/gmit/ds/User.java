package ie.gmit.ds;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.protobuf.ByteString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {

    @NotNull
    private int userId;

    @NotBlank
    @Length(min=2, max=255)
    private String userName;

    @Pattern(regexp = ".+@.+\\.[a-z]+")
    private String email;

    @NotBlank
    @Length(min=2, max=15)
    private String password;

    private ByteString hashedPassword;
    private ByteString salt;

    public User() {
    }

    public User(int userId, String userName, String email, String password) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public User(int userId, String userName, String email, ByteString hashedPassword, ByteString salt) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
    }

    @JsonProperty
    public int getUserId() {
        return userId;
    }

    @JsonProperty
    public String getUserName() {
        return userName;
    }

    @JsonProperty
    public String getEmail() {
        return email;
    }

    @JsonProperty
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public ByteString getHashedPassword() {
        return hashedPassword;
    }

    @JsonProperty
    public ByteString getSalt() {
        return salt;
    }
}
