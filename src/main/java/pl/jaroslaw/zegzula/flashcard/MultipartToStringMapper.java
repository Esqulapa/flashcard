package pl.jaroslaw.zegzula.flashcard;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MultipartToStringMapper {
    private final MultipartFile multipartFile;

    public MultipartToStringMapper(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public List<String> toListOfStrings() throws IOException {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(this.multipartFile.getInputStream(), StandardCharsets.UTF_8));
        return reader.lines().toList();
    }
}




