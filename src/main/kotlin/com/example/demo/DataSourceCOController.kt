package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class DataSourceCOController {

    @Autowired
    private lateinit var ds: DataSourceCOService

    @QueryMapping
    fun getDataSourceByRppUserId(@Argument rppUserId: String): DataSourceCO {
        return ds.getDataSourceVars(rppUserId)
    }
}
