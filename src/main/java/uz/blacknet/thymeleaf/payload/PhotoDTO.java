package uz.blacknet.thymeleaf.payload;


import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.blacknet.thymeleaf.entity.Photo;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PhotoDTO
{
    Long id;

    String url;


    public PhotoDTO(Photo entity)
    {
        if (entity == null)
            return;
        this.id = entity.getId();
        this.url = entity.getUrl();
    }
}
