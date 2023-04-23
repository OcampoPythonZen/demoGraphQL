package com.example.demo

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface DataSourceCORepository : MongoRepository<DataSourceCO, String> {

    @Query("{rpp_user_id: ?0}")
    fun findByRppUserId(rppUserId: String): DataSourceCO
}
