package com.example.demo

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest
import org.springframework.graphql.test.tester.GraphQlTester


@GraphQlTest(DataSourceCO::class)
class DataSourceCOControllerTest {

    @Autowired
    private lateinit var graphQlTester: GraphQlTester

    @Test
    fun `Validate the number of params query and response with a rppUserId`() {
        val rppUserId = "fadbf9a5-9054-4aa3-a231-9123bf6083f9"
        val queryOnPostman = """
                query {
                    getDataSourceByRppUserId(rppUserId: "$rppUserId"){
                    rpp_user_id,
                    is_prime,
                    gender
                    }
                }
        """.trimIndent()
        graphQlTester.document(queryOnPostman)
            .variable("rpp_user_id", rppUserId)
            .execute()
            .path("getDataSourceByRppUserId")
            .entity(DataSourceCO::class.java)
            .satisfies { ds ->
                Assertions.assertEquals(rppUserId, ds.rpp_user_id)
            }
    }
}