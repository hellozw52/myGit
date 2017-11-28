package com.ssh.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssh.dao.SiteDao;
import com.ssh.service.SiteService;

@Service("siteServsice")
public class SiteService {

    //注入dao
    @Resource
    private SiteDao siteDao;

    //获取当前tvn所属的站点的名称
    public String getCurrentTvnSiteName(String tvn) {

	return this.siteDao.getCurrentTvnSiteName(tvn);
    }
    
    //判断当前tvn号是否存在
    public boolean isTvnExist(String tvn) {

	return this.siteDao.isTvnExist(tvn);
    }

}
