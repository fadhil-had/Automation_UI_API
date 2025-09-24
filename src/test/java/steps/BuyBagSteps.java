package steps;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import utils.DriverFactory;

public class BuyBagSteps {
    AppiumDriver driver;
    CheckoutPage checkoutPage;
    CheckoutPaymentPage checkoutPaymentPage;
    ConfirmationPage confirmationPage;
    LoginPage loginPage;
    OrderPage orderPage;
    ProceedPage proceedPage;
    ProductsPage productsPage;
    ReviewPage reviewPage;

    @When("user selects product {string}")
    public void user_selects_product(String product) throws Exception {
        driver = DriverFactory.getDriver();
        productsPage = new ProductsPage(driver);

        productsPage.selectBackpack();
    }

    @When("user selects product with color {string} and quantity {string}")
    public void user_selects_product_with_color_and_quantity(String color, String quantity) throws Exception {
        orderPage = new OrderPage(driver);

        orderPage.verifyLabel();
        orderPage.selectColor();
        orderPage.setQuantity(quantity);
        orderPage.setAddCart();
    }

    @Then("user proceed order product")
    public void user_proceed_order_product() throws Exception {
        proceedPage = new ProceedPage(driver);

        proceedPage.verifyData();
        proceedPage.verifyTotalPrice();
        proceedPage.proceed();
    }

    @When("user login")
    public void user_login() throws Exception {
        loginPage = new LoginPage(driver);

        loginPage.useExisting();
        loginPage.clickLogin();
    }

    @When("user checkout")
    public void user_checkout() throws Exception {
        checkoutPage = new CheckoutPage(driver);

        checkoutPage.setFullname();
        checkoutPage.setAddress();
        checkoutPage.setCity();
        checkoutPage.setZipCode();
        checkoutPage.setCountry();
        checkoutPage.clickPayment();
    }

    @When("user checkout payment")
    public void user_checkout_payment() throws Exception {
        checkoutPaymentPage = new CheckoutPaymentPage(driver);

        checkoutPaymentPage.setFullname();
        checkoutPaymentPage.setCardNumber();
        checkoutPaymentPage.setExpirationDate();
        checkoutPaymentPage.setSecurityCode();
        checkoutPaymentPage.clickPayment();
    }

    @Then("user review payment")
    public void user_review_payment() throws Exception {
        reviewPage = new ReviewPage(driver);

        reviewPage.verifyData();
        reviewPage.verifyTotalPrice();
        reviewPage.proceed();
    }

    @Then("user confirm payment")
    public void user_confirm_payment() throws Exception {
        confirmationPage = new ConfirmationPage(driver);

        confirmationPage.verifyLabel();
    }
}
