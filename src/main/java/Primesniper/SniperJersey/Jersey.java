package Primesniper.SniperJersey;


import java.util.UUID;

public record Jersey (
        UUID id,
        String team,
        String name,
        Integer number,
        Integer price,
        java.sql.Blob picture,
        String JerseyType
){
}
