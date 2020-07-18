Feature: Validating Place APIs
	Scenario: Verify the successful addition of place using AddPlace API
		Given user has request payload ready
		When user calls "AddPlaceAPI" with POST http request
		Then API call is successful with status code 200
		And "status" in response body is "OK"
		And "scope" in response body is "APP"
