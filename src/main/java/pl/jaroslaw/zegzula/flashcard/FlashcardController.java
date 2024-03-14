package pl.jaroslaw.zegzula.flashcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("${api.endpoint.base-url}/flashcard")
public class FlashcardController {

  private final FlashcardService flashcardService;

  @Autowired
  public FlashcardController(FlashcardService flashcardServiced) {
    this.flashcardService = flashcardServiced;
  }

  @PostMapping
  public ResponseEntity<String> handleUploadedFile(MultipartFile file) throws IOException {

    List<String> listOfStrings = new MultipartToStringMapper(file).toListOfStrings();

    return ResponseEntity.ok()
        .body(flashcardService.createFlashcardsDeck(listOfStrings).toApkgString());
  }
}
