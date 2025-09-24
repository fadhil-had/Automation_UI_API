package api;


import com.github.fge.jsonschema.main.JsonValidator;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class fakerCompaniesJSON {
    @DataProvider(name = "quantity")
    public Object[][] quantity(){
        return new Object[][] {
                {20},{5},{1}
        };
    }

    @Test(dataProvider = "quantity")
    public void testFakerCompanies(int quantity){
        Response response = given()
                .baseUri("https://fakerapi.it/api/v1")
                .queryParam("_quantity",quantity)
                .when()
                .get("/companies")
                .then()
                .statusCode(200)
                .extract().response();

        List<Integer> ids = response.jsonPath().getList("data.id");
        for (Integer id : ids){
            Assert.assertNotNull(id, "There is null ID in this response");
        }

        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/faker-companies.json"));
    }
}
