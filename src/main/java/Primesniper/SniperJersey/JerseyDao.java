package Primesniper.SniperJersey;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
public interface JerseyDao {
    ResponseObject allJerseys();
    int insertJersey(Jersey jersey);
    int deleteJersey(UUID id);
    ResponseObject selectJerseyById(UUID id);
}

