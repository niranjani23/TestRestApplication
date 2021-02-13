import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TestJokeFactory{
    /*
        Validate that the returned Joke is of type "programming".
     */
    @Test
    public void verifyJokeIsOfProgrammingType() {
        given().
                when().
                get("https://official-joke-api.appspot.com/jokes/programming/random").
                then().
                assertThat().
                body("type", hasItem("programming"));
    }

    /*
        Validate that 10 jokes are returned.
        Validate that all jokes are of type "programming".
     */
    @Test
    public void verifyTenJokes() {
        given().
                when().
                get("https://official-joke-api.appspot.com/jokes/programming/ten").
                then().
                assertThat().
                body("size()", is(10)).
                assertThat().
                body("type", hasItem("programming"));
    }
}