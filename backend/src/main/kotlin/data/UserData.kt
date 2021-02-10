package hu.sssl.fozos.web.data

import javax.validation.constraints.NotNull
import org.jsoup.Jsoup
import org.jsoup.safety.Whitelist

class UserData {
    var name: @NotNull String? = null
        set(name) {
            field = Jsoup.clean(name, Whitelist.basic())
        }

    var password: @NotNull String? = null
}
