package webmvc.guestbook.repository;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import webmvc.guestbook.dto.GuestBookDto;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static webmvc.guestbook.repository.GuestBookDaoSqls.*;
@Repository
public class GuestBookDao {
    private NamedParameterJdbcTemplate jdbc;
    private RowMapper<GuestBookDto> rowMapper = BeanPropertyRowMapper.newInstance(GuestBookDto.class);
    private SimpleJdbcInsert insertAction;

    public GuestBookDao(DataSource dataSource) {
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("guestbook2")
                .usingGeneratedKeyColumns("no");
    }

    public List<GuestBookDto> selectAll() {
        Map<String, Integer> params = new HashMap();

        return jdbc.query(SELECT_ALL, params, rowMapper);
    }

    public Long insert(GuestBookDto guest) {
        SqlParameterSource params = new BeanPropertySqlParameterSource(guest);
        return insertAction.executeAndReturnKey(params).longValue();
    }

    public int delete(Long no) {
        Map<String, ?> params = Collections.singletonMap("no", no);
        return jdbc.update(DELETE_BY_ID, params);
    }

    public String findByNo(Long no){
        Map<String, ?> params = Collections.singletonMap("no", no);
        return jdbc.queryForObject(FIND_PASSWORD,params, String.class);
    }
}
