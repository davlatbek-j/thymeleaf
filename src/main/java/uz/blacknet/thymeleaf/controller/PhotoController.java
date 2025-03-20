package uz.blacknet.thymeleaf.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.blacknet.thymeleaf.entity.Photo;
import uz.blacknet.thymeleaf.payload.ApiResponse;
import uz.blacknet.thymeleaf.payload.PhotoDTO;
import uz.blacknet.thymeleaf.repository.PhotoRepository;
import uz.blacknet.thymeleaf.service.PhotoService;

import java.util.List;

//@RestController
@RequiredArgsConstructor
//@RequestMapping("/api/photo")
public class PhotoController
{

    private final PhotoService photoService;
    private final PhotoRepository photoRepository;
    private final ConversionService conversionService;

    @PostMapping(consumes = {
            MediaType.MULTIPART_FORM_DATA_VALUE
    })
    public ResponseEntity<ApiResponse<List<Photo>>> upload(
            @RequestPart(name = "photo", required = false) List<MultipartFile> photo)
    {
        return photoService.upload(photo);
    }

    @GetMapping("/{name}")
    public ResponseEntity<byte[]> getPhoto(@PathVariable(name = "name") String name)
    {
        return photoService.findByName(name);
    }


    @PutMapping(value = "/{id}", consumes = {"multipart/form-data"})
    public ResponseEntity<ApiResponse<PhotoDTO>> updatePhoto(
            @PathVariable(name = "id")
            Long id,
            @RequestPart(name = "new-photo", required = false) MultipartFile newPhoto)
    {
        return photoService.update(id, newPhoto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<?>> deletePhoto(
            @PathVariable Long id)
    {
        return photoService.delete(id);
    }
}
