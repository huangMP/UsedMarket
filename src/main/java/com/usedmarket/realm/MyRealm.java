package com.usedmarket.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Description：enter your comment
 * Created by Peivxuan on 2016/8/8.
 */
public class MyRealm extends AuthorizingRealm {

	/*@Autowired
	private RoleService roleService;

	@Autowired
	private StaffService staffService;*/
	/**
	 * 授权方法
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

	/*
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();


		Object principal = principalCollection.getPrimaryPrincipal();

		Role role = roleService.getRoleNameByNumber((String) principal);
		System.out.println(111);
		System.out.println(role.getRoleName());

		if("行政文员".equals(role.getRoleName())){
			info.addRole("admin");
		}
		if("司机".equals(role.getRoleName())){
			info.addRole("driver");
		}
		info.addRole("user");

		return info;
	 */
		return null;
	}

	/**
	 * 认证方法
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
	/*
		System.out.println(token.getPrincipal());
		System.out.println(token.getCredentials());

		Object principal = token.getPrincipal();


		Staff staff = null;
		try {
			staff = staffService.selectByNumber((String) principal);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String credentials = staff.getPassword();

		//当前 Realm 的 name
		String realmName = getName();
		SimpleAuthenticationInfo info =
				new SimpleAuthenticationInfo(principal, credentials, realmName);

		return info;
	*/
		return null;
	}
}
