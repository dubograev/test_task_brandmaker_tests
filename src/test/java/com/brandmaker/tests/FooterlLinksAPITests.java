package com.brandmaker.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class FooterlLinksAPITests {

    @Test
    @DisplayName("Check that \"Brand Management & Localization\" link returns code 200")
    public void brandManagementLocalizationLinkTest() {
        when()
                .get("https://www.brandmaker.com/solutions/brand-management-and-localization/")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Check that \"Budget Planning & Management\" link returns code 200\n")
    public void budgetPlanningManagementLinkTest() {
        when()
                .get("https://www.brandmaker.com/solutions/budget-planning-and-management/")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Check that \"Campaign Planning & Execution\" link returns code 200")
    public void campaignPlanningExecutionLinkTest() {
        when()
                .get("https://www.brandmaker.com/solutions/campaign-planning-and-execution/")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Check that \"Content Creation & Distribution\" link returns code 200")
    public void contentCreationDistributionLinkTest() {
        when()
                .get("https://www.brandmaker.com/solutions/content-creation-and-distribution/")
                .then()
                .statusCode(200);
    }

    @Test
    @DisplayName("Check that \"Performance Measurement & Optimization\" link returns code 200")
    public void performanceMeasurementOptimizationLinkTest() {
        when()
                .get("https://www.brandmaker.com/solutions/performance-measurement-and-optimization/")
                .then()
                .statusCode(200);
    }
}
