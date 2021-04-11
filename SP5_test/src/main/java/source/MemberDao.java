package source;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MemberDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Transactional
	public int count() {
		int num = jdbcTemplate.queryForObject("select count(*) from spring5fs.member", Integer.class);
		return num;
	}

	@Transactional
	public Member selectByEmail(String email) {
		Member member;
		try {
		member = jdbcTemplate.queryForObject("select * from spring5fs.member where EMAIL = ?",
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"),
								rs.getString("NAME"), rs.getTimestamp("REGDATE").toLocalDateTime());
						member.setId(rs.getLong("ID"));
						return member;
					}
				}, email);
		}catch(Exception e) {
			member=null;
		}
		
		return member;
	}

	@Transactional
	public Member selectByEmail_Pass(String email,String pass) {
		Member member;
		try {
		member = jdbcTemplate.queryForObject("select * from spring5fs.member where EMAIL = ? and PASSWORD = ?",
				new RowMapper<Member>() {
					@Override
					public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
						Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"),
								rs.getString("NAME"), rs.getTimestamp("REGDATE").toLocalDateTime());
						member.setId(rs.getLong("ID"));
						return member;
					}
				}, email, pass);
		}catch(Exception e) {
			member=null;
		}
		
		return member;
	}
	
	@Transactional
	public Collection<Member> selectAll() {
		List<Member> results = jdbcTemplate.query("select * from spring5fs.member", new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"), rs.getString("NAME"),
						rs.getTimestamp("REGDATE").toLocalDateTime());
				member.setId(rs.getLong("ID"));
				return member;
			}

		});

		return results.isEmpty() ? null : results;
	}

	@Transactional
	public void update(Member member) {
		jdbcTemplate.update("update spring5fs.member set NAME = ?, PASSWORD = ? where EMAIL = ?", member.getName(),
				member.getPassword(), member.getEmail());
	}

	@Transactional
	public void insert(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"insert into spring5fs.member(EMAIL,PASSWORD,NAME,REGDATE) values(?,?,?,?)",
						new String[] { "ID" });
				pstmt.setString(1, member.getEmail());
				pstmt.setString(2, member.getPassword());
				pstmt.setString(3, member.getName());
				pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
				return pstmt;
			}
		}, keyHolder);

		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
	}

}
