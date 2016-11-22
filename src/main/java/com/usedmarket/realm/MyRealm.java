package com.usedmarket.realm;

import com.usedmarket.dto.UserInfoCustom;
import com.usedmarket.entity.UserInfo;
import com.usedmarket.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Description：enter your comment
 * Created by Peivxuan on 2016/8/8.
 */
public class MyRealm extends AuthorizingRealm {

	@Autowired
	UserInfoService userInfoService;

	/**
	 * 授权方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		System.out.println("进来 doGetAuthorizationInfo 了");

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();


		//得到用户名
		String username = (String) principalCollection.getPrimaryPrincipal();

		/*
		通过用户名去找到该用户的角色
		 */
		UserInfoCustom userInfoCustom = userInfoService.findUserInfoCustomByUsername( username );

		//付给该用户的角色权限
		authorizationInfo.addRole( userInfoCustom.getRoleName() );

		return authorizationInfo;
	}

	/**
	 * 认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		System.out.println("进来 doGetAuthenticationInfo 了");

		//得到用户名
		String username =(String) token.getPrincipal();

		UserInfo userInfoInDatabase = userInfoService.findByUsername(username);

		if( null == userInfoInDatabase){
			return null;
		}

		String password = userInfoInDatabase.getPassword();

		//当前 Realm 的 name
		String realmName = getName();
		SimpleAuthenticationInfo authcInfo = new SimpleAuthenticationInfo( username, password, realmName);
		return authcInfo;
	}
}
