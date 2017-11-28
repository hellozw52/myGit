package com.ssh.httpinterface;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssh.service.SiteService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SiteActionTest {

    // 注入
    @Resource
    private SiteService siteService;

    @Test
    public void testGetTvnSiteName() {
	
	String tvn = "21386072";
	String sitename = siteService.getCurrentTvnSiteName(tvn);
	
	System.out.println("机顶盒的tvn号为："+tvn+"  所属站点名称为："+sitename);
    }
}
