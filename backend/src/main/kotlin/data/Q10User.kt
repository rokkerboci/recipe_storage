package hu.sssl.fozos.web.data

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Q10UserRepository : JpaRepository<Q10User, String>

@Entity
class Q10User {

    @Id
    lateinit var name: String

    @JsonIgnore
    lateinit var password: String

    @ElementCollection(fetch = FetchType.EAGER)
    @JsonIgnore
    lateinit var roles: List<String>

    companion object {
        const val DELETE_CONTENT = "ADMIN"
    }
}
