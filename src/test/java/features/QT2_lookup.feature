Feature: Validating QT2s lookup call
  Scenario Outline: Verify that lookup call successfully returns a response
    Given Logger file "<serviceName>_<customerType>_<postcode>_log" is ready for logging
    And user has request payload ready for "<serviceName>"
      |customerType   |postcode   |
      |<customerType> |<postcode> |
    When user calls "<serviceName>" with POST http request
    Then API call is successful with status code 200
    And "electricity.status" in response body is "<expectedStatus>"
    And "electricity.accuracy" in response body is "<expectedAccuracy>"

    Examples:
      |serviceName    |customerType |postcode |expectedStatus |expectedAccuracy |
      |postcodeLookup |RES          |2000     |SUCCESS        |POSTCODE         |
