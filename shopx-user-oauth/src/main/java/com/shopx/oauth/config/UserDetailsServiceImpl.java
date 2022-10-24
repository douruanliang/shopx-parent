package com.shopx.oauth.config;

import com.shopx.oauth.util.UserJwt;
import com.shopx.user.feign.UserFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/*****
 * 自定义授权认证类
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ClientDetailsService clientDetailsService;

    @Autowired
    UserFeign userFeign;
    /****
     * 自定义授权认证
     * @param clientId
     * @return  此方法会走两次 第一次是客户端查询 第二次是用户信息
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String clientId) throws UsernameNotFoundException {
        //===================客户端信息认证  ---授权模式
        //取出身份，如果身份为空说明没有认证
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //没有认证统一采用httpbasic认证，httpbasic中存储了client_id和client_secret，开始认证client_id和client_secret
        if (authentication == null) {
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
            if (clientDetails != null) {
                //秘钥
                String clientSecret = clientDetails.getClientSecret();
                //静态方式
                /*return new User(username, // 客户端ID
                        new BCryptPasswordEncoder().encode(clientSecret),
                        AuthorityUtils.commaSeparatedStringToAuthorityList(""));*/
                //数据库查找方式
                return new User(clientId,clientSecret, AuthorityUtils.commaSeparatedStringToAuthorityList(""));
            }
        }
        //===================客户端信息认证end
        //===========clientId->userName========用户密码认证

        if (StringUtils.isEmpty(clientId)) {
            return null;
        }

        //根据用户名查询用户信息
        String pwd = userFeign.findByUsername(clientId).getData().getPassword();
        //角色
        String permissions = "admin,goods_list,seckill_list";
        //创建User对象
        UserJwt userDetails = new UserJwt(clientId, pwd, AuthorityUtils.commaSeparatedStringToAuthorityList(permissions));

        //===================用户信息认证end
        return userDetails;
    }
}
