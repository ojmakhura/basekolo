// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: AndroMDAModel::basekolo::com.systemsjr.basekolo::level::service::LevelInstanceService
 * STEREOTYPE:  Service
 */
package com.systemsjr.basekolo.level.instance.service;

import java.util.Collection;
import java.util.List;

import com.systemsjr.basekolo.level.instance.LevelInstance;
import com.systemsjr.basekolo.level.instance.vo.LevelInstanceSearchCriteria;
import com.systemsjr.basekolo.level.instance.vo.LevelInstanceVO;

/**
 * @see com.systemsjr.basekolo.level.service.LevelInstanceService
 */
public class LevelInstanceServiceImpl
    extends LevelInstanceServiceBase
{

    /**
     * @see com.systemsjr.basekolo.level.service.LevelInstanceService#findById(Long)
     */
    protected  LevelInstanceVO handleFindById(Long id)
        throws Exception
    {
    	LevelInstance levelInstance = getLevelInstanceDao().load(id);
    	return getLevelInstanceDao().toLevelInstanceVO(levelInstance);
    }

    /**
     * @see com.systemsjr.basekolo.level.service.LevelInstanceService#saveLevelInstance(LevelInstanceVO)
     */
    protected  LevelInstanceVO handleSaveLevelInstance(LevelInstanceVO levelInstanceVO)
        throws Exception
    {
    	levelInstanceVO.setUniqueCode(levelInstanceVO.getYear() + levelInstanceVO.getLevel().getCode() + levelInstanceVO.getInstance());
    	levelInstanceVO.setInstanceName(levelInstanceVO.getLevel().getLevel() + levelInstanceVO.getInstance());
    	
    	LevelInstance levelInstance = getLevelInstanceDao().levelInstanceVOToEntity(levelInstanceVO);
    	
    	if(levelInstanceVO.getId() == null){    		
    		
    		levelInstance = getLevelInstanceDao().create(levelInstance);
    		
    	} else{
    		getLevelInstanceDao().update(levelInstance);
    	}
    	
    	return getLevelInstanceDao().toLevelInstanceVO(levelInstance);
    	
    }

    /**
     * @see com.systemsjr.basekolo.level.service.LevelInstanceService#removeLevelInstance(LevelInstanceVO)
     */
    protected  void handleRemoveLevelInstance(LevelInstanceVO levelInstanceVO)
        throws Exception
    {
    	if(levelInstanceVO.getId() != null){
    		getLevelInstanceDao().remove(levelInstanceVO.getId());
    	}
    }

    /**
     * @see com.systemsjr.basekolo.level.service.LevelInstanceService#getAllLevelInstances()
     */
    protected  Collection<LevelInstanceVO> handleGetAllLevelInstances()
        throws Exception
    {
    	Collection<LevelInstance> instances = getLevelInstanceDao().loadAll();
    	
    	return getLevelInstanceDao().toLevelInstanceVOCollection(instances);
    	
    }

    /**
     * @see com.systemsjr.basekolo.level.service.LevelInstanceService#getAllLevelInstancesArray()
     */
    protected  LevelInstanceVO[] handleGetAllLevelInstancesArray()
        throws Exception
    {
    	Collection<LevelInstance> instances = getLevelInstanceDao().loadAll();
    	
    	return getLevelInstanceDao().toLevelInstanceVOArray(instances);
    	
    }

    /**
     * @see com.systemsjr.basekolo.level.service.LevelInstanceService#levelInstanceSearch(LevelInstanceSearchCriteria)
     */
    protected  Collection<LevelInstanceVO> handleLevelInstanceSearch(LevelInstanceSearchCriteria searchCriteria)
        throws Exception
    {
    	List<LevelInstance> instances = getLevelInstanceDao().findByCriteria(searchCriteria);
    	return getLevelInstanceDao().toLevelInstanceVOCollection(instances);
    }

    /**
     * @see com.systemsjr.basekolo.level.service.LevelInstanceService#levelInstanceSearchArray(LevelInstanceSearchCriteria)
     */
    protected  LevelInstanceVO[] handleLevelInstanceSearchArray(LevelInstanceSearchCriteria searchCriteria)
        throws Exception
    {
    	List instances = getLevelInstanceDao().findByCriteria(searchCriteria);
    	return getLevelInstanceDao().toLevelInstanceVOArray(instances);
    }

}