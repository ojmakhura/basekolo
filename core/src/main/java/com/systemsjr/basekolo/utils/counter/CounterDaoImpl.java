// Generated by hibernate/SpringHibernateDaoImpl.vsl in andromda-spring-cartridge on 04/28/2018 19:30:32+0100.
// license-header java merge-point
/**
 * This is only generated once! It will never be overwritten.
 * You can (and have to!) safely modify it by hand.
 */
package com.systemsjr.basekolo.utils.counter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.systemsjr.basekolo.utils.counter.vo.CounterSearchCriteria;
import com.systemsjr.basekolo.utils.counter.vo.CounterVO;

/**
 * @see Counter
 */
public class CounterDaoImpl
    extends CounterDaoBase
{
    /**
     * {@inheritDoc}
     */
    @Override
    protected List handleFindByCriteria(CounterSearchCriteria searchCriteria)
    {
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Counter> query = builder.createQuery(Counter.class);		
		Root<Counter> root = query.from(Counter.class);
		List<Predicate> predicates = new ArrayList<Predicate>();
		
    	if(searchCriteria.getCounterName() != null) {
    		predicates.add(builder.like(root.<String>get("counterName"), "%" + searchCriteria.getCounterName() + "%"));
    	}
    	
    	if(searchCriteria.getCounterLength() != null) {
    		predicates.add(builder.equal(root.<String>get("counterLength"), searchCriteria.getCounterLength()));
    	}

		if(!predicates.isEmpty()) {
			query.where();
	        Predicate[] pr = new Predicate[predicates.size()];
	        predicates.toArray(pr);
	        query.where(pr); 
		}
		
		query.orderBy(builder.asc(root.get("surname")));
		TypedQuery<Counter> typedQuery = getSession().createQuery(query);
		
        return typedQuery.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void toCounterVO(
        Counter source,
        CounterVO target)
    {
        // TODO verify behavior of toCounterVO
        super.toCounterVO(source, target);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public CounterVO toCounterVO(final Counter entity)
    {
        // TODO verify behavior of toCounterVO
        return super.toCounterVO(entity);
    }

    /**
     * Retrieves the entity object that is associated with the specified value object
     * from the object store. If no such entity object exists in the object store,
     * a new, blank entity is created
     */
    private Counter loadCounterFromCounterVO(CounterVO counterVO)
    {
    	Counter counter = Counter.Factory.newInstance();        
        this.counterVOToEntity(counterVO, counter, true);
        
        return counter;
    }

    /**
     * {@inheritDoc}
     */
    public Counter counterVOToEntity(CounterVO counterVO)
    {
        Counter entity = this.loadCounterFromCounterVO(counterVO);
        this.counterVOToEntity(counterVO, entity, true);
        return entity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void counterVOToEntity(
        CounterVO source,
        Counter target,
        boolean copyIfNull)
    {
        super.counterVOToEntity(source, target, copyIfNull);
    }

	@Override
	protected Counter handleFindByName(String counterName) throws Exception {
		    	
		return this.searchUniqueCounterName(counterName);
	}

	@Override
	protected Counter handleInitCounter(String counterName, Integer counterLength, Integer seed) throws Exception {
		
		Counter counter = Counter.Factory.newInstance();
		counter.setCounterLength(counterLength);
		counter.setCounterName(counterName);
		
		String strSeed = "" + seed;
		int multiple = counterLength - strSeed.length();
		long initial = seed * (long)Math.pow(10, multiple);
		counter.setCurrentCount(initial);
		counter.setCreatedBy("system");
		counter.setCreatedAt(new Date());
		counter = this.create(counter);
		return counter;
	}

	@Override
	protected Long handleGetNextCount(String counterName, Integer counterLength, Integer seed) throws Exception {
		Counter counter = handleFindByName(counterName);
		
		if(counter == null) {
			counter = handleInitCounter(counterName, counterLength, seed);
		} 
		
		counter.setCurrentCount(counter.getCurrentCount() + 1);
		this.update(counter);	
		
		return counter.getCurrentCount();
	}
}