package org.tech20.challenges

import com.typesafe.config.Config
import com.typesafe.config.ConfigBeanFactory
import com.typesafe.config.ConfigFactory

fun main() {
    val config = ConfigFactory.load()
    val appConfig = AppConfig(config)
    println(appConfig.persistenceConfig("entity1"))
}

class AppConfig(private val config: Config){
    private val persistenceConfig = config.getConfig("persistenceConfig")
    fun persistenceConfig(entityName: String): PersistenceConfig {
        val pConfig = persistenceConfig.getConfig(entityName)
        return when(pConfig.getString("type")){
            "BQ" -> ConfigBeanFactory.create(pConfig.getConfig("bqConfig"), BqConfig::class.java)
            else -> ConfigBeanFactory.create(pConfig.getConfig("gcsConfig"), GcsConfig::class.java)
        }
    }
}

open class PersistenceConfig

class BqConfig(
    var dataset: String = "app-dataset",
    var tableName: String = "default-table"
): PersistenceConfig() {
    override fun toString(): String {
        return "BqConfig(dataset='$dataset', tableName='$tableName')"
    }
}

class GcsConfig(
    var bucket: String = "bucket1",
    var fileName: String = "file.csv"
): PersistenceConfig() {
    override fun toString(): String {
        return "GcsConfig(bucket='$bucket', fileName='$fileName')"
    }
}


class StoreConfig(var inventoryItems: List<InventoryItem> = emptyList())

class InventoryItem(
    var category: String = "unknown",
    var items: List<String> = emptyList()
) {

    override fun toString(): String {
        return "InventoryItem(category='$category', items=$items)"
    }
}