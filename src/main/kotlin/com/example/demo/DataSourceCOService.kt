package com.example.demo

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class DataSourceCOService {

    @Autowired
    private lateinit var ds: DataSourceCORepository
    private val logger = LoggerFactory.getLogger(this::class.java)

    fun getDataSourceVars(rppUserId: String): DataSourceCO {
        logger.info(
            "--RPP_RISK_GATEKEEPER-DISPATCHER-MS --getDataSourceByRppUserId --request --rppUserId [{}]",
            rppUserId
        )
        val response = ds.findByRppUserId(rppUserId)
        logger.info(
            "--RPP_RISK_GATEKEEPER-DISPATCHER-MS --getDataSourceByRppUserId --rppUserId [{}] --response [{}]",
            rppUserId,
            response.toJsonString()
        )
        return response
    }

}