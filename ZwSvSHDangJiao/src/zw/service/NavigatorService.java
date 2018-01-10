package zw.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zw.dao.NavigatorDao;

@Transactional
@Service
public class NavigatorService {
    
    //注入dao
    @Resource
    private NavigatorDao navigatorDao;

    //获取当前tvn所属的站点的名称
    public String getCurrentTvnSiteName(String tvn) {

	return this.navigatorDao.getCurrentTvnSiteName(tvn);
    }
    
    /**
     * 判断当前tvn号是否存在
     * @param tvn
     * @return true 存在    false  不存在
     */
    public boolean isTvnExist(String tvn) {

	return this.navigatorDao.isTvnExist(tvn);
    }
}
