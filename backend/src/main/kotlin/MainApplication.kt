package hu.sssl.fozos.web

import hu.sssl.fozos.web.data.Q10User
import hu.sssl.fozos.web.data.Q10UserRepository
import hu.sssl.fozos.web.data.RecipeRepository
import hu.sssl.fozos.web.data.ServerConfig
import java.io.IOException
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
@Slf4j
class MainApplication : CommandLineRunner {

    @Autowired
    private lateinit var repository: Q10UserRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    @Autowired
    private lateinit var recipeRepository: RecipeRepository

    @Autowired
    private lateinit var config: ServerConfig

    @Throws(IOException::class)
    override fun run(vararg args: String) {
        populateDefaultData(config)
    }

    private fun populateDefaultData(conf: ServerConfig) {
        val user = Q10User()
        user.name = conf.rootUserName
        user.password = passwordEncoder.encode(conf.rootUserPassword)
        user.roles = mutableListOf(Q10User.DELETE_CONTENT)
        repository.saveAndFlush(user)
    }

}

fun main(args: Array<String>) {
    SpringApplication.run(MainApplication::class.java, *args)
}
