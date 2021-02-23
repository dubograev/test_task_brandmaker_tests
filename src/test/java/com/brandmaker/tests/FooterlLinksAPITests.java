package com.brandmaker.tests;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

@Tag("api")
@Feature("Main Page")
@Story("Footer -> Solutions links")
public class FooterlLinksAPITests {

    @Test

    @AllureId("1635")
    @DisplayName("Check that \"Brand Management & Localization\" link returns code 200")
    public void brandManagementLocalizationLinkTest() {
        when()
                .get("https://www.brandmaker.com/solutions/brand-management-and-localization/")
                .then()
                .statusCode(200);
    }

    @Test
    @AllureId("1629")
    @DisplayName("Check that \"Budget Planning & Management\" link returns code 200\n")
    public void budgetPlanningManagementLinkTest() {
        when()
                .get("https://www.brandmaker.com/solutions/budget-planning-and-management/")
                .then()
                .statusCode(200);
    }

    @Test
    @AllureId("1633")
    @DisplayName("Check that \"Campaign Planning & Execution\" link returns code 200")
    public void campaignPlanningExecutionLinkTest() {
        when()
                .get("https://www.brandmaker.com/solutions/campaign-planning-and-execution/")
                .then()
                .statusCode(200);
    }

    @Test
    @AllureId("1634")
    @DisplayName("Check that \"Content Creation & Distribution\" link returns code 200")
    public void contentCreationDistributionLinkTest() {
        when()
                .get("https://www.brandmaker.com/solutions/content-creation-and-distribution/")
                .then()
                .statusCode(200);
    }

    @Test
    @AllureId("1636")
    @DisplayName("Check that \"Performance Measurement & Optimization\" link returns code 200")
    public void performanceMeasurementOptimizationLinkTest() {
        when()
                .get("https://www.brandmaker.com/solutions/performance-measurement-and-optimization/")
                .then()
                .statusCode(200);
    }
}
