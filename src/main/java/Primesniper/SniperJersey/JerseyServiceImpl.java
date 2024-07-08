package Primesniper.SniperJersey;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class JerseyServiceImpl implements JerseyService {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public JerseyServiceImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public ResponseObject allJerseys() {

        var sql = """
                SELECT id, name, jersey_type, number, picture, price, team
                FROM tbl_jersey
                LIMIT 100;
                 """;

        List<Map<String, Object>> jerseys = namedParameterJdbcTemplate.query(sql, (rs , i) -> jerseyMapRow(rs));
        return ResponseUtils.successResponse(jerseys, "successful");
    }


    @Override
    public int insertJersey(Jersey jersey) {

        String sql = """
                INSERT INTO tbl_jersey(name, jersey_type, number, picture, price, team)
                VALUES (:name, :jerseyType, :number, :picture, :price, :team);
                 """;

        Map<String, Object> params = new HashMap<>();
        params.put("name", jersey.name());
        params.put("jerseyType", jersey.JerseyType());
        params.put("number", jersey.number());
        params.put("picture", jersey.picture());
        params.put("price", jersey.price());
        params.put("team", jersey.team());

        return namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public int deleteJersey(UUID id) {
        var sql = """
                DELETE FROM tbl_jersey   
                WHERE id = :id
                """;
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        return namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public ResponseObject oneJersey(UUID id) {
        var sql = """
                SELECT id, name, jersey_type, number, picture, price, team
                FROM tbl_jersey
                WHERE id = :id
                 """;
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);

        List<Object> results = namedParameterJdbcTemplate.query(sql, params, (rs , i) -> jerseyMapRow(rs));
        return ResponseUtils.successResponse(results, "successful");
    }


    private Map<String, Object> jerseyMapRow(ResultSet resultSet) throws SQLException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", resultSet.getObject("id", UUID.class));
        map.put("name", resultSet.getString("name"));
        map.put("jersey_type", resultSet.getString("jersey_type"));
        map.put("number", resultSet.getInt("number"));
        map.put("price", resultSet.getInt("price"));
        map.put("picture", resultSet.getBlob("picture"));
        map.put("team", resultSet.getString("team"));

        return map;
    }


}
