package hu.sssl.fozos.web.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.Embeddable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface IngredientRepository : PagingAndSortingRepository<Ingredient, Long>

@Entity
class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var name: String? = null

}

@Embeddable
class IngredientWithAmount {
    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    @JsonIgnoreProperties("hibernateLazyInitializer", "handler")
    var ingredient: Ingredient? = null
    var amount = 0
}
