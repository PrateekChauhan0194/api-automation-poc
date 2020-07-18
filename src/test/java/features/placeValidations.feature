Feature: Validating Place APIs
	Scenario Outline: Verify the successful addition of place using "<serviceName>"
		Given Logger file "<serviceName>_log" is ready for logging
		And user has request payload ready
		When user calls "<serviceName>" with POST http request
		Then API call is successful with status code <expectedStatusCode>
		And "status" in response body is "<expectedStatus>"
		And "scope" in response body is "<expectedScope>"

		Examples:
		|serviceName |expectedStatusCode |expectedStatus |expectedScope |
		|AddPlaceAPI |200                |OK             |APP           |

