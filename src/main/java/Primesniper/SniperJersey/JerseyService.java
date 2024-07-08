package Primesniper.SniperJersey;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface JerseyService {

    public ResponseObject allJerseys();


    public ResponseObject oneJersey(UUID id);

    public int insertJersey(Jersey jersey);

    public int deleteJersey(UUID id);

}
