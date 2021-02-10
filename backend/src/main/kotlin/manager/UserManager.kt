package hu.sssl.fozos.web.manager

import hu.sssl.fozos.web.data.Q10User
import hu.sssl.fozos.web.data.Q10UserRepository
import hu.sssl.fozos.web.data.UserData
import lombok.extern.slf4j.Slf4j
import org.springframework.beans.BeanUtils
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

interface UserManager {
    fun addUser(userData: UserData)
}

@Service
@Slf4j
class MainUserManager(val repository: Q10UserRepository, val passwordEncoder: PasswordEncoder) : UserManager {

    override fun addUser(userData: UserData) {
        val userOpt = repository.findById(userData.name!!)
        require(!userOpt.isPresent) { "User already exists!" }
        val user = Q10User()
        BeanUtils.copyProperties(user, user)
        user.password = passwordEncoder.encode(user.password)
        repository.saveAndFlush(user)
    }

}