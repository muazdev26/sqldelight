package app.cash.sqldelight.integration

import app.cash.sqldelight.derive.schema.from.migrations.no.queries.NoQueries
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.junit.After
import org.junit.Test
import java.io.File

class IntegrationTests {
  @After fun after() {
    File("test.db").delete()
  }

  @Test fun `creating db works without query files`() {
    val database = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
    NoQueries.Schema.create(database)
  }
}
