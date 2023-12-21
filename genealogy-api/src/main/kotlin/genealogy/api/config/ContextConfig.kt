package genealogy.api.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EntityScan("ru.bicenter")
@EnableJpaRepositories("ru.bicenter")
@ComponentScan("ru.bicenter")
class ContextConfig
