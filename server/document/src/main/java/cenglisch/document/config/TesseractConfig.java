package cenglisch.document.config;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class TesseractConfig {

    @Bean
    public Tesseract tesseract() {
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("/app/tessdata");
        tesseract.setLanguage("deu");
        tesseract.setTessVariable("user_defined_dpi", "300");
        return tesseract;
    }
}
