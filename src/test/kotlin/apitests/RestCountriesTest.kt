package apitests
import config.LogCustomFilter
import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.hamcrest.Matchers.*
import org.junit.jupiter.api.Test
import util.getUri

class RestCountriesTest{
    @Test
    fun `should get information about the country`() {
        val country = "Brazil"

        Given {
            filter(LogCustomFilter(testName = "should get information about the country"))
            pathParam( "countryName", country)
        }
        .When { get(getUri()) }
        .Then {
            statusCode(200)
            .body("size()", `is`(1))
            .body("[0].name.common", equalTo(country))
        }
    }

    @Test
    fun `should receive a 404 error when country doesn't exist`() {
        val country = "test"

        Given {
            filter(LogCustomFilter(testName = "should receive a 404 error when country doesn't exist"))
            pathParam( "countryName", country)
        }
            .When { get(getUri()) }
            .Then {
                statusCode(404)
                    .body("message", equalTo("Not Found"))
            }
    }
}