package hu.sssl.fozos.web.auth

import hu.sssl.fozos.web.data.Q10UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class Q10UserDetailsService : UserDetailsService {

    @Autowired
    private lateinit var repository: Q10UserRepository


    override fun loadUserByUsername(username: String): UserDetails {
        val user = repository.findById(username)

        if (user.isEmpty) {
            throw UsernameNotFoundException("Username $username was not found in the registered users.")
        }

        return Q10UserDetails(user.get())
    }

}
