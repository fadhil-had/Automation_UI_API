package api;


import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class fakerCompanies {
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

        int size = response.jsonPath().getList("data").size();
        Assert.assertEquals(size,quantity, "Company number not match");
        System.out.println("Total size from API: "+size+ " with expected "+quantity);
    }
}
