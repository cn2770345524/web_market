package cn.liuhao.web_market.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.servlet.AdviceFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class JwtHttpFilter extends AdviceFilter {

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        log.info("request:" + req.getRequestURI());
        return true;
    }
}
