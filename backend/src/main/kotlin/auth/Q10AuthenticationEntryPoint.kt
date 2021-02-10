package hu.sssl.fozos.web.auth

import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint
import org.springframework.stereotype.Component

@Component
class Q10AuthenticationEntryPoint : BasicAuthenticationEntryPoint() {

    override fun commence(request: HttpServletRequest, response: HttpServletResponse, authEx: AuthenticationException) {
        response.addHeader("WWW-Authenticate", "Basic realm=\"$realmName\"")
        response.status = HttpServletResponse.SC_UNAUTHORIZED
        val writer = response.writer
        writer.println("HTTP Status 401 - " + authEx.message)
    }

    override fun afterPropertiesSet() {
        realmName = "si.hu.hu.q10.xd"
        super.afterPropertiesSet()
    }
}
