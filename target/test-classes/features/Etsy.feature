@Regression
Feature: Etsy Landing Page Validation

  @Etsy
  Scenario: Validate Etsy main navigation header items
    Given user navigates to "https://www.etsy.com"
    Then user should see below menu item links
  |Father's Day Gifts|
  |Jewellery & Accessories|
  |Clothing & Shoes       |
  |Home & Living          |
  |Wedding & Party        |
  |Toys & Entertainment   |
  |Art & Collectibles     |
  |Craft Supplies         |
  |Gifts                  |