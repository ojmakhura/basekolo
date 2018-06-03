// license-header java merge-point
// Generated by andromda-jsf cartridge (controllers\ControllerImpl.java.vsl) on 03/25/2017 14:56:57+0000
package com.systemsjr.basekolo.level.instance.web.edit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.systemsjr.basekolo.level.instance.vo.LevelInstanceVO;
import com.systemsjr.basekolo.level.vo.LevelVO;

/**
 * @see com.systemsjr.basekolo.level.web.edit.instance.LevelInstanceEditController
 */
public class LevelInstanceEditControllerImpl
    extends LevelInstanceEditController
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = -499396721864502068L;

    /**
     * @see com.systemsjr.basekolo.level.web.edit.instance.LevelInstanceEditController#populateEditScreen(LevelInstanceVO levelInstanceVO)
     */
    @Override
    public void populateEditScreen(PopulateEditScreenForm form)
    {
    	@SuppressWarnings("unchecked")
		Collection<LevelVO> levels = getLevelService().getAllLevels();

		final Collection<SelectItem> levelBackingList = new ArrayList<SelectItem>();
		for(LevelVO levelVO : levels) {
			levelBackingList.add(new SelectItem(levelVO.getId(), levelVO.getLevel()));
		}

		LevelInstanceVO levelInstanceVO = (LevelInstanceVO) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("levelInstanceVO");
		if(levelInstanceVO != null) {
			if(levelInstanceVO.getId() != null) {
				levelInstanceVO = getLevelInstanceService().findById(levelInstanceVO.getId());
				levelInstanceVO.setStudents(getStudentService().findClassStudents(levelInstanceVO.getId()));
			}
		} else {
			levelInstanceVO = new LevelInstanceVO();
		}

		this.getEditLevelInstanceSaveForm().setLevelInstanceVOLevelBackingList(levelBackingList);
		this.getEditLevelInstanceSaveForm().setLevelInstanceVO(levelInstanceVO);
		
		LevelVO levelVO = getEditLevelInstanceSaveForm().getLevelInstanceVO().getLevel();
		if(levelVO == null || levelVO.getId() == -1){
			this.getEditLevelInstanceSaveForm().getLevelInstanceVO().setLevel(new LevelVO());
		}
    }

    /**
     * @see com.systemsjr.basekolo.level.web.edit.instance.LevelInstanceEditController#saveLevelInstance(LevelInstanceVO levelInstanceVO)
     */
    @Override
    public void saveLevelInstance()
    {
    	LevelInstanceVO instance = getEditLevelInstanceSaveForm().getLevelInstanceVO();    	
    	instance.setLevel(getLevelService().findById(instance.getLevel().getId()));
    	
        if(instance.getId() == null){
        	instance.setCreatedAt(new Date());
        	instance.setCreatedBy("system");
    	} else {
    		instance.setModifiedAt(new Date());
    		instance.setModifiedBy("system");
    	}
        instance = getLevelInstanceService().saveLevelInstance(instance);
        getEditLevelInstanceForm().setLevelInstanceVO(instance);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("levelInstanceVO", instance);
    }

	@Override
	public void newLevelInstance() throws Throwable {
		// TODO Auto-generated method stub
		LevelInstanceVO instance = new LevelInstanceVO();
		getEditLevelInstanceForm().setLevelInstanceVO(instance);
		
	}


}