package hu.sssl.fozos.web.api

import hu.sssl.fozos.web.data.UserData
import hu.sssl.fozos.web.manager.UserManager
import java.security.Principal
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserApi {

    @Autowired
    private lateinit var userManager: UserManager

    @GetMapping("/username")
    fun username(principal: Principal?): String {
        checkNotNull(principal) { "You are not logged in!" }
        return principal.name
    }

    @GetMapping("/admin")
    fun admin(): Boolean {
        return true
    }

    @PostMapping(value = ["/users/register"], consumes = ["application/json"])
    fun register(@RequestBody user: UserData) {
        userManager.addUser(user)
    }
}
