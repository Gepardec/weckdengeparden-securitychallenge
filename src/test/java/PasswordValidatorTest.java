import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordValidatorTest {
    private PasswordValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    void shouldReturnFalseGivenPasswordWithoutDigit(){
        validator.passwordIsValid("W#JFfkaeiE");
    }

    @Test
    void shouldReturnFalseGivenPasswordWithoutSpecialCharacter(){
        validator.passwordIsValid("W1JFfkaeiE");
    }
    @Test
    void shouldReturnFalseGivenShorterPassword(){
        validator.passwordIsValid("W1$1");
    }

    @Test
    void shouldReturnFalseGivenLongerPassword(){
        validator.passwordIsValid("W#2FfkaeiE1");
    }

    @Test
    void shouldReturnTrueGivenValidPassword(){
        validator.passwordIsValid("W#2FfkaeiE");
    }

}