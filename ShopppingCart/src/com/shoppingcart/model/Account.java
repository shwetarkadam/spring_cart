package com.shoppingcart.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.shoppingcart.beans.Product;
import com.shoppingcart.beans.Vendor;

@Component("Account")
public class Account {

	private NamedParameterJdbcTemplate jdbc;
	private PasswordEncoder passenc;
	
	@Autowired
	public void setPassenc(PasswordEncoder passenc) {
		this.passenc = passenc;
	}

	@Autowired
	public void setDataSource(DataSource datasource) {//this ds comes from Beans org.apache Basic DataSource hence we autowire it
		jdbc=new NamedParameterJdbcTemplate(datasource);
	}
	
	public List<Product> getAllProducts() {
		return jdbc.query("select * from product", new RowMapper<Product>(){

			@Override
			public Product mapRow(ResultSet rs, int arg1) throws SQLException {
				Product p=new Product();
				
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getString("price"));
				p.setDesc(rs.getString("description"));
				
				return p;
			}
			
		});
		
	}
	public Product getSingleProduct(int id) {
    // SQL Injection vulnerability: user input is directly concatenated into the query string
    String query = "select * from product where id=" + id;

    return jdbc.queryForObject(query, new RowMapper<Product>() {

        @Override
        public Product mapRow(ResultSet rs, int arg1) throws SQLException {
            Product p = new Product();

            p.setId(rs.getInt("id"));
            p.setName(rs.getString("name"));
            p.setPrice(rs.getString("price"));
            p.setDesc(rs.getString("description"));

            return p;
        }

    });
}

	public void createVendor(Vendor v) {
	//BeanPropertySqlParameterSource param=new BeanPropertySqlParameterSource(v);
	MapSqlParameterSource map=new MapSqlParameterSource();
	map.addValue("name", v.getName());
	map.addValue("city", v.getCity());
	map.addValue("email", v.getEmail());
	map.addValue("password", passenc.encode(v.getPassword()));
	map.addValue("enabled", v.getEnabled());
	map.addValue("authority", v.getAuthority());
	
	jdbc.update("insert into vendor(name,city,email) values(:name,:city,:email)", map);
	jdbc.update("insert into users(username,password,enabled) values(:email,:password,:enabled)", map);
	jdbc.update("insert into authorities(username,authority) values(:email,:authority)", map);
	
	/*
	 * 	jdbc.update("insert into vendor(name,city,email) values(:name,:city,:email)", param);
	jdbc.update("insert into users(username,password,enabled) values(:email,:password,:enabled)", param);
	jdbc.update("insert into authorities(username,authority) values(:email,:authority)", param);*/
	}
}
