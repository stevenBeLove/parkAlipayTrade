package com.qt.shiro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.qt.shiro.entity.UrlFilter;

/**
 * <p>User: Zhang yinghui
 * <p>Version: 1.0
 */
@Repository
public class UrlFilterDaoImpl implements UrlFilterDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public UrlFilter createUrlFilter(final UrlFilter urlFilter)throws Exception {
        final String sql = "insert into tb_fans_sys_filter(id, name, url, roles, permissions) values(seq_sysSaleSeq.nextval,?,?,?,?)";

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement psst = connection.prepareStatement(sql, new String[]{"id"});
                int count = 1;
                psst.setString(count++, urlFilter.getName());
                psst.setString(count++, urlFilter.getUrl());
                psst.setString(count++, urlFilter.getRoles());
                psst.setString(count++, urlFilter.getPermissions());
                return psst;
            }
        }, keyHolder);
        urlFilter.setId(keyHolder.getKey().intValue());
        return urlFilter;
    }

    @Override
    public UrlFilter updateUrlFilter(UrlFilter urlFilter) {
        final String sql = "update tb_fans_sys_filter set name=?,url=?,roles=?,permissions=? where id=?";
        jdbcTemplate.update(
                sql,
                urlFilter.getName(), urlFilter.getUrl(), urlFilter.getRoles(), urlFilter.getPermissions(), urlFilter.getId());
        return urlFilter;
    }

    public void deleteUrlFilter(Long urlFilterId) {
        final String sql = "delete from tb_fans_sys_filter where id=?";
        jdbcTemplate.update(sql, urlFilterId);
    }


    @Override
    public UrlFilter findOne(Long urlFilterId) {
        final String sql = "select id, name, url, roles, permissions from tb_fans_sys_filter where id=?";
        List<UrlFilter> urlFilterList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(UrlFilter.class), urlFilterId);
        if(urlFilterList.size() == 0) {
            return null;
        }
        return urlFilterList.get(0);
    }

    @Override
    public List<UrlFilter> findAll() {
        final String sql = "select id, name, url, roles, permissions from tb_fans_sys_filter";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper(UrlFilter.class));
    }

}
