package hu.sssl.fozos.web.data

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class ServerConfig {

    @Value("\${rootUserName}")
    var rootUserName: String = ""

    @Value("\${rootUserPassword}")
    var rootUserPassword: String = ""

    @Value("\${domainName}")
    var domainName: String = ""

}
