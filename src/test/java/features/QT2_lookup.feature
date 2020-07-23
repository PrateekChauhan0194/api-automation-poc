Feature: Validating QT2s lookup call
  Scenario Outline: Verify that lookup call successfully returns a response
    Given Logger file "<serviceName>_<customerType>_<postcode>_log" is ready for logging
    And user has request payload ready for "<serviceName>"
      |customerType   |postcode   |expectedStatusCode   |
      |<customerType> |<postcode> |<expectedStatusCode> |
    When user calls "<serviceName>" with POST http request
    Then API call is successful with status code <expectedStatusCode>
    And "electricity.status" in response body is "<expectedStatus>"
    And "electricity.accuracy" in response body is "<expectedAccuracy>"

    Examples:
      |serviceName    |customerType |postcode |expectedStatus |expectedAccuracy |expectedStatusCode |
      |postcodeLookup |RES          |2000     |SUCCESS        |POSTCODE         |200                |

  Scenario Outline: Verify that authenticated account lookup call fails when being hit directly
    Given Logger file "<serviceName>_<customerType>_<postcode>_log" is ready for logging
    And user has request payload ready for "<serviceName>"
      |customerType   |postcode   |nmi        |addCurrentPlan |electricityAccountNumber   |qualifications |expectedStatusCode   |
      |<customerType> |<postcode> |<nmi>      |true           |<electricityAccountNumber> |LOYALTY        |<expectedStatusCode> |
    When user calls "<serviceName>" with POST http request
    Then API call is successful with status code <expectedStatusCode>

    Examples:
      |serviceName      |customerType |postcode |nmi        |electricityAccountNumber |expectedStatusCode |
      |accountNmiLookup |RES          |4557     |3120068616 |5492128824               |500                |
