import com.ruanlx.boot.MyselfBootApplication;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author ruanlx
 * @date 2019/9/1 15:06
 */
public class MyselfBootApplicationUnitTest {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Test
    public void testMyselfBootApplication() {
        ConfigurableApplicationContext context = MyselfBootApplication.run(SimpleWebConfig.class, new String[]{});
        Assert.assertNotNull(outputCapture.toString().concat(":: Spring Boot :: "));
        Assert.assertNotNull(outputCapture.toString().concat("$"));
        context.close();
    }

    @Test
    public void testMyselfBootApplicationForWeb() {
        SpringApplication application = MyselfBootApplication.getDefaultSpringApplication(SimpleWebConfig.class);
        ConfigurableApplicationContext context = application.run(new String[]{});
        Assert.assertNotNull(outputCapture.toString().concat(":: Spring Boot :: "));
        Assert.assertNotNull(outputCapture.toString().concat("$"));
        context.close();
    }

    @Configuration
    @Import({
            DispatcherServletAutoConfiguration.class,
            ServletWebServerFactoryAutoConfiguration.class
    })
    static class SimpleWebConfig {
    }
}