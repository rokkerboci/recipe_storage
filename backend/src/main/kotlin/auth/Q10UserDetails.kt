package hu.sssl.fozos.web.auth

import hu.sssl.fozos.web.data.Q10User
import java.util.stream.Collectors
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class Q10UserDetails(
    private val user: Q10User
) : UserDetails {

    override fun getAuthorities(): Collection<GrantedAuthority?> {
        return user.roles.map {
            SimpleGrantedAuthority(it)
        }
    }

    override fun getPassword(): String {
        return user.password
    }

    override fun getUsername(): String {
        return user.name
    }

    override fun isAccountNonExpired(): Boolean {
        return true
    }

    override fun isAccountNonLocked(): Boolean {
        return true
    }

    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    override fun isEnabled(): Boolean {
        return true
    }

}
