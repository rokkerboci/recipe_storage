package hu.sssl.fozos.web.data

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface RecipeRepository : PagingAndSortingRepository<Recipe, Long>

@Entity
class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null
    var title: @NotNull String? = null
    var text: @NotNull String? = null

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("hibernateLazyInitializer", "handler")
    var author: Q10User? = null

    @ElementCollection
    var ingredients: List<IngredientWithAmount>? = null
}
