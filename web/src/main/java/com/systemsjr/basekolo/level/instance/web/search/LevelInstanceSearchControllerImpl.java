// license-header java merge-point
// Generated by andromda-jsf cartridge (controllers\ControllerImpl.java.vsl) on 03/26/2017 14:17:42+0100
package com.systemsjr.basekolo.level.instance.web.search;

import java.util.Collection;

import javax.faces.context.FacesContext;

import com.systemsjr.basekolo.level.instance.vo.LevelInstanceSearchCriteria;
import com.systemsjr.basekolo.level.instance.vo.LevelInstanceVO;

/**
 * @see com.systemsjr.basekolo.level.web.search.instance.LevelInstanceSearchController
 */
public class LevelInstanceSearchControllerImpl
    extends LevelInstanceSearchController
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 8478094722794621933L;

    /**
     * @see com.systemsjr.basekolo.level.web.search.instance.LevelInstanceSearchController#initialiseSearchScreen(LevelInstanceSearchCriteria searchCriteria)
     */
    @Override
    public void initialiseSearchScreen(InitialiseSearchScreenForm form)
    {
    }

    /**
     * @see com.systemsjr.basekolo.level.web.search.instance.LevelInstanceSearchController#doLevelInstanceDetails(java.lang.Long id, LevelInstanceVO levelInstanceVO)
     */
    @Override
    public void doLevelInstanceDetails(DoLevelInstanceDetailsForm form)
    {
    	LevelInstanceVO levelInstance =  (LevelInstanceVO) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("row");
    	if(levelInstance != null) {
    		levelInstance = getLevelInstanceService().findById(levelInstance.getId());
    		form.setLevelInstanceVO(levelInstance);
    		FacesContext.getCurrentInstance().getExternalContext().getFlash().put("levelInstanceVO", levelInstance);
    	}
    }

    /**
     * @see com.systemsjr.basekolo.level.web.search.instance.LevelInstanceSearchController#doLevelInstanceEdit(java.lang.Long id, LevelInstanceVO levelInstanceVO)
     */
    @Override
    public void doLevelInstanceEdit(DoLevelInstanceEditForm form)
    {
    	LevelInstanceVO levelInstance =  (LevelInstanceVO) FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get("row");
		if(levelInstance != null) {
			levelInstance = getLevelInstanceService().findById(levelInstance.getId());		
			form.setLevelInstanceVO(levelInstance);
			this.getSearchLevelInstancesEditForm().setLevelInstanceVO(levelInstance);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("levelInstanceVO", levelInstance);
		}  	
    }

    /**
     * @see com.systemsjr.basekolo.level.web.search.instance.LevelInstanceSearchController#doLevelInstancesSearch()
     */
    @Override
    public void doLevelInstancesSearch()
    {
    	Collection instances = getLevelInstanceService().levelInstanceSearch(getSearchLevelInstancesSearchForm().getSearchCriteria());
    	//System.out.println(getSearchLevelInstancesSearchForm().getSearchCriteria());
    	getSearchLevelInstancesSearchForm().setLevelInstanceLists(instances);
    	
    }

}