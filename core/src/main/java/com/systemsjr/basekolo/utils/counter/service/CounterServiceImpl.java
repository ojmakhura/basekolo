// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 * TEMPLATE:    SpringServiceImpl.vsl in andromda-spring cartridge
 * MODEL CLASS: AndroMDAModel::basekolo::com.systemsjr.basekolo::utils::counter::service::CounterService
 * STEREOTYPE:  Service
 */
package com.systemsjr.basekolo.utils.counter.service;

import java.util.Collection;

import com.systemsjr.basekolo.utils.counter.Counter;
import com.systemsjr.basekolo.utils.counter.vo.CounterSearchCriteria;
import com.systemsjr.basekolo.utils.counter.vo.CounterVO;

/**
 * @see com.systemsjr.basekolo.utils.counter.service.CounterService
 */
public class CounterServiceImpl
    extends CounterServiceBase
{

    /**
     * @see com.systemsjr.basekolo.utils.counter.service.CounterService#findById(Long)
     */
    @Override
    protected  CounterVO handleFindById(Long id)
        throws Exception
    {
    	return getCounterDao().toCounterVO(getCounterDao().get(id));
    }

    /**
     * @see com.systemsjr.basekolo.utils.counter.service.CounterService#saveCounter(CounterVO)
     */
    @Override
    protected  CounterVO handleSaveCounter(CounterVO counterVO)
        throws Exception
    {
    	Counter counter = getCounterDao().counterVOToEntity(counterVO);
    	if(counterVO.getId() == null) {
    		counter = getCounterDao().create(counter);
    	} else {
    		getCounterDao().update(counter);
    	}
    	
    	return getCounterDao().toCounterVO(counter);
    }

    /**
     * @see com.systemsjr.basekolo.utils.counter.service.CounterService#removeCounter(CounterVO)
     */
    @Override
    protected  void handleRemoveCounter(CounterVO counterVO)
        throws Exception
    {
    	if(counterVO.getId() != null) {
    		getCounterDao().remove(counterVO.getId());
    	}
    }

    /**
     * @see com.systemsjr.basekolo.utils.counter.service.CounterService#getAllCounters()
     */
    @Override
    protected  Collection handleGetAllCounters()
        throws Exception
    {
    	return getCounterDao().toCounterVOCollection(getCounterDao().loadAll());
    }

    /**
     * @see com.systemsjr.basekolo.utils.counter.service.CounterService#getAllCountersArray()
     */
    @Override
    protected  CounterVO[] handleGetAllCountersArray()
        throws Exception
    {
    	return getCounterDao().toCounterVOArray(getCounterDao().loadAll());
    }

    /**
     * @see com.systemsjr.basekolo.utils.counter.service.CounterService#counterSearch(CounterSearchCriteria)
     */
    @Override
    protected  Collection handleCounterSearch(CounterSearchCriteria searchCriteria)
        throws Exception
    {
        // TODO implement protected  Collection handleCounterSearch(CounterSearchCriteria searchCriteria)
        throw new UnsupportedOperationException("com.systemsjr.basekolo.utils.counter.service.CounterService.handleCounterSearch(CounterSearchCriteria searchCriteria) Not implemented!");
    }

    /**
     * @see com.systemsjr.basekolo.utils.counter.service.CounterService#counterSearchArray(CounterSearchCriteria)
     */
    @Override
    protected  CounterVO[] handleCounterSearchArray(CounterSearchCriteria searchCriteria)
        throws Exception
    {
        // TODO implement protected  CounterVO[] handleCounterSearchArray(CounterSearchCriteria searchCriteria)
        throw new UnsupportedOperationException("com.systemsjr.basekolo.utils.counter.service.CounterService.handleCounterSearchArray(CounterSearchCriteria searchCriteria) Not implemented!");
    }

}