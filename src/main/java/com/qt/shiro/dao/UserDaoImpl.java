package com.qt.shiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.qt.shiro.entity.User;

/**
 * <p>User: Zhang yinghui
 * <p>Version: 1.0
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public User createUser(final User user) {
        final String sql = "insert into tb_fans_sys_user(id,organization_id, nickname,username, password, salt, role_ids, locked) values(seq_sysSaleSeq.nextval,?,?,?,?,?,?,?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                int count = 1;
                psst.setLong(count++, user.getOrganizationId());
                psst.setString(count++, user.getNickname());
                psst.setString(count++, user.getUsername());
                psst.setString(count++, user.getPassword());
                psst.setString(count++, user.getSalt());
                psst.setString(count++, user.getRoleIdsStr());
                psst.setBoolean(count++, user.getLocked());
                return psst;
            }
        }, keyHolder);

        user.setId(keyHolder.getKey().longValue());
        return user;
    }

    public User updateUser(User user)throws Exception {
        String sql = "update tb_fans_sys_user set organization_id=?, nickname=?, username=?, password=?, salt=?, role_ids=?, locked=? where id=?";
        jdbcTemplate.update(
                sql,
                user.getOrganizationId(), user.getNickname(), user.getUsername(), user.getPassword(), user.getSalt(), user.getRoleIdsStr(), user.getLocked(), user.getId());
        return user;
    }

    public void deleteUser(Long userId) {
        String sql = "delete from tb_fans_sys_user where id=?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public User findOne(Long userId) {
        String sql = "select id, organization_id, nickname, username, password, salt, role_ids as roleIdsStr, locked from tb_fans_sys_user where id=?";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class), userId);
        if(userList.size() == 0) {
            return null;
        }
        return userList.get(0);
    }

    @Override
    public int findAllCount(Map<String, Object> map) throws Exception {
        StringBuilder sb = new StringBuilder("select count(*) from tb_fans_sys_user where 1=1 ");
        if (!StringUtils.isEmpty(map.get("nickname"))) {
            sb.append(" and nickname like '%" + map.get("nickname") + "%'");
        }
        if (!StringUtils.isEmpty(map.get("username"))) {
            sb.append(" and username like '%" + map.get("username") + "%'");
        }
        return jdbcTemplate.queryForInt(sb.toString());
    }

    @Override
    public List<User> findAll(Map<String, Object> map) throws Exception {
        StringBuilder sb = new StringBuilder("select * from ( select tmp_page.*, rownum row_id from ( ");
        sb.append("select id, organization_id, nickname, username, password, salt, role_ids as roleIdsStr, locked from tb_fans_sys_user where 1=1 ");
        if (!StringUtils.isEmpty(map.get("nickname"))) {
            sb.append(" and nickname like '%" + map.get("nickname") + "%'");
        }
        if (!StringUtils.isEmpty(map.get("username"))) {
            sb.append(" and username like '%" + map.get("username") + "%'");
        }
        sb.append(" ) tmp_page where rownum <= ? ) where row_id  > ? ");
        return jdbcTemplate.query(sb.toString(), new BeanPropertyRowMapper(User.class), (Integer) map.get("end"), (Integer) map.get("start"));
    }
    

    @Override
    public User findByUsername(String username) {
        String sql = "select id, organization_id, nickname, username, password, salt, role_ids as roleIdsStr, locked from tb_fans_sys_user where username=?";
        List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(User.class), username);
        if(userList.size() == 0) {
            return null;
        }
        return userList.get(0);
    }
}
