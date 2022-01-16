# lab-picpay-clone-backend-api
Backend para o projeto Lab do Clone do PicPay

Originalmente no lab esta api era desenvolvida em java, escolhi desenvolver em kotlin para obter alguma experiência com o kotlin fora da plataforma android.

Para as classes kotlin funcionarem com o jpa, foi necessário adicionar as seguintes linhas ao arquivo de build na sessão de plugins:

	kotlin("plugin.allopen") version "1.4.32"
	kotlin("plugin.jpa") version "1.3.72"

E acima da sessão de "dependencies":

    allOpen {
        annotation("javax.persistence.Entity")
        annotation("javax.persistence.Embeddable")
        annotation("javax.persistence.MappedSuperclass")
    }
