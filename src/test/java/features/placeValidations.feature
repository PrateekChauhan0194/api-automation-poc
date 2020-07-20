Feature: Validating Place APIs
	Scenario Outline: Verify the successful addition of place using "<serviceName>"
		Given Logger file "<serviceName>_log" is ready for logging
		And user has request payload ready for "<serviceName>"
			|expectedStatusCode		|contentType 	|accuracy |address 						|language  |phoneNumber 		|website 						|name			|longitude	|latitude	|
			|<expectedStatusCode>	|<contentType>	|50       |29, side layout, cohen 09	|French-IN |(+91) 983 893 3937	|https://rahulshettyacademy.com |Frontline house|33.427362  |-38.383494 |
		When user calls "<serviceName>" with POST http request
		Then API call is successful with status code <expectedStatusCode>
		And "status" in response body is "<expectedStatus>"
		And "scope" in response body is "<expectedScope>"

		Examples:
		|serviceName |contentType |expectedStatusCode |expectedStatus |expectedScope |
		|AddPlaceAPI |JSON        |200                |OK             |APP           |

