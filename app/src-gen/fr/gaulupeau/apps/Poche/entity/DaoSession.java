package fr.gaulupeau.apps.Poche.entity;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import fr.gaulupeau.apps.Poche.entity.Article;
import fr.gaulupeau.apps.Poche.entity.OfflineURL;

import fr.gaulupeau.apps.Poche.entity.ArticleDao;
import fr.gaulupeau.apps.Poche.entity.OfflineURLDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig articleDaoConfig;
    private final DaoConfig offlineURLDaoConfig;

    private final ArticleDao articleDao;
    private final OfflineURLDao offlineURLDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        articleDaoConfig = daoConfigMap.get(ArticleDao.class).clone();
        articleDaoConfig.initIdentityScope(type);

        offlineURLDaoConfig = daoConfigMap.get(OfflineURLDao.class).clone();
        offlineURLDaoConfig.initIdentityScope(type);

        articleDao = new ArticleDao(articleDaoConfig, this);
        offlineURLDao = new OfflineURLDao(offlineURLDaoConfig, this);

        registerDao(Article.class, articleDao);
        registerDao(OfflineURL.class, offlineURLDao);
    }
    
    public void clear() {
        articleDaoConfig.getIdentityScope().clear();
        offlineURLDaoConfig.getIdentityScope().clear();
    }

    public ArticleDao getArticleDao() {
        return articleDao;
    }

    public OfflineURLDao getOfflineURLDao() {
        return offlineURLDao;
    }

}
