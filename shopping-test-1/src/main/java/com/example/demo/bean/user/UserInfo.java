package com.example.demo.bean.user;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * 用户类
 * @author dy-xx
 *
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo implements UserDetails{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
    private String name;
    private String password;
    private String email;
    private int sex;
    private String location;
    private BigDecimal money;
    private double integral;
    private Date createDate;
    private String phone;
    private int state;
    private String role;
   
	public UserInfo(String name, String password, String phone,String role) {
		super();
		this.name = name;
		this.password = password;
		this.phone = phone;
		this.role=role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<SimpleGrantedAuthority> authorities =new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(this.role));
		return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
    
}
