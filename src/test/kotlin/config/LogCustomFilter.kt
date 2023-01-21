package config

import io.restassured.filter.Filter
import io.restassured.filter.FilterContext
import io.restassured.response.Response
import io.restassured.specification.FilterableRequestSpecification
import io.restassured.specification.FilterableResponseSpecification
import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

class LogCustomFilter(
    private val testName: String
): Filter {

    private val log: Log = LogFactory.getLog(LogCustomFilter::class.java)

    override fun filter(
        requestSpec: FilterableRequestSpecification,
        responseSpec: FilterableResponseSpecification,
        ctx: FilterContext
    ): Response {

        val response = ctx.next(requestSpec, responseSpec)

        if (!response.statusCode.toString().startsWith("2"))
            log.error(logTestInfo(requestSpec, response))

        log.info(logTestInfo(requestSpec, response))

        return response
    }

    private fun logTestInfo(
        requestSpec: FilterableRequestSpecification,
        response: Response
    ): String {
        return "\n${testName}\n${requestSpec.method} ${requestSpec.uri} \nRequest Body => ${requestSpec.getBody<String>()} \nResponse Status => ${response.statusCode} \nResponse Body => ${response.body.prettyPrint()}"
    }
}