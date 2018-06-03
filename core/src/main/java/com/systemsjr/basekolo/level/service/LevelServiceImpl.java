// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: AndroMDAModel::basekolo::com.systemsjr.basekolo::level::service::LevelService
 * STEREOTYPE:  Service
 */
package com.systemsjr.basekolo.level.service;

import java.util.Collection;
import java.util.List;

import com.systemsjr.basekolo.level.Level;
import com.systemsjr.basekolo.level.vo.LevelSearchCriteria;
import com.systemsjr.basekolo.level.vo.LevelVO;

/**
 * @see com.systemsjr.basekolo.level.service.LevelService
 */
public class LevelServiceImpl
    extends LevelServiceBase
{

    /**
     * @see com.systemsjr.basekolo.level.service.LevelService#findById(Long)
     */
    protected  LevelVO handleFindById(Long id)
        throws Exception
    {
    	Level level = getLevelDao().load(id);
		return getLevelDao().toLevelVO(level);
    }

    /**
     * @see com.systemsjr.basekolo.level.service.LevelService#saveLevel(LevelVO)
     */
    protected  LevelVO handleSaveLevel(LevelVO levelVO)
        throws Exception
    {
    	levelVO.setCode(levelVO.getCode().toUpperCase());
    	Level level = getLevelDao().levelVOToEntity(levelVO);
    	
    	if(levelVO.getId() == null){
    		level = getLevelDao().create(level);
    	} else {
    		//level.setModifiedAt(new Date());
    		//System.out.println("LevelServiceImpl.handleSaveLevel levelVO: " + levelVO);
    		//System.out.println("LevelServiceImpl.handleSaveLevel level: " + level);
    		getLevelDao().update(level);
    	}
    	
    	return getLevelDao().toLevelVO(level);
    }

    /**
     * @see com.systemsjr.basekolo.level.service.LevelService#removeLevel(LevelVO)
     */
    protected  void handleRemoveLevel(LevelVO levelVO)
        throws Exception
    {
        if(levelVO.getId() != null){
        	getLevelDao().remove(levelVO.getId());
        }
    }

    /**
     * @see com.systemsjr.basekolo.level.service.LevelService#getAllLevels()
     */
    protected  Collection<LevelVO> handleGetAllLevels()
        throws Exception
    {
    	Collection<Level> levels = getLevelDao().loadAll();
    	return getLevelDao().toLevelVOCollection(levels);
    }

    /**
     * @see com.systemsjr.basekolo.level.service.LevelService#getAllLevelsArray()
     */
    protected  LevelVO[] handleGetAllLevelsArray()
        throws Exception
    {
    	Collection<Level> levels = getLevelDao().loadAll();
    	return getLevelDao().toLevelVOArray(levels);
    }

	@Override
	protected Collection<LevelVO> handleLevelSearch(LevelSearchCriteria searchCriteria) throws Exception {
		List instances = getLevelDao().findByCriteria(searchCriteria);
		Collection<LevelVO> vos = getLevelDao().toLevelVOCollection(instances);
		
		return vos;
	}

	@Override
	protected LevelVO[] handleLevelSearchArray(LevelSearchCriteria searchCriteria) throws Exception {
		List instances = getLevelDao().findByCriteria(searchCriteria);
		return getLevelDao().toLevelVOArray(instances);
	}

}