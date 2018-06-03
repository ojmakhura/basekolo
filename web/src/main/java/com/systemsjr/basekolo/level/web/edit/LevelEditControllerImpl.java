// license-header java merge-point
// Generated by andromda-jsf cartridge (controllers\ControllerImpl.java.vsl) on 03/25/2017 10:48:03+0000
package com.systemsjr.basekolo.level.web.edit;

import com.systemsjr.basekolo.level.vo.LevelVO;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 * @see com.systemsjr.basekolo.level.web.edit.LevelEditController
 */
public class LevelEditControllerImpl
    extends LevelEditController
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 1161070173772386898L;
    
    @PostConstruct
    public void init(){
    	
    }

    /**
     * @see com.systemsjr.basekolo.level.web.edit.LevelEditController#saveLevel(LevelVO levelVO)
     */
    @Override
    public void doSaveLevel()
    {

        LevelVO levelVO = getEditLevelSaveForm().getLevelVO();
        if(levelVO.getNextLevel() == null || levelVO.getNextLevel().getId() == null || levelVO.getNextLevel().getId() == (long)-1){
        	levelVO.setNextLevel(new LevelVO());
        } else {
        	levelVO.setNextLevel(getLevelService().findById(levelVO.getNextLevel().getId()));
        }
        
        if(levelVO.getPreviousLevel() == null || levelVO.getPreviousLevel().getId() == null || levelVO.getPreviousLevel().getId() == (long)-1){
        	levelVO.setPreviousLevel(new LevelVO());
        }else {
        	levelVO.setPreviousLevel(getLevelService().findById(levelVO.getPreviousLevel().getId()));
        }
        
        if(levelVO.getId() == null){
    		levelVO.setCreatedAt(new Date());
    		levelVO.setCreatedBy("system");
    	} else {
    		levelVO.setModifiedAt(new Date());
    		levelVO.setModifiedBy("system");
    	}
        
        levelVO = getLevelService().saveLevel(levelVO);
		this.getEditLevelSaveForm().getLevelVO().setPreviousLevel(levelVO);
        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("levelVO", levelVO);
    }

	@Override
	public void initialiseEditScreen(InitialiseEditScreenForm form) throws Throwable {
		@SuppressWarnings("unchecked")
		Collection<LevelVO> levels = getLevelService().getAllLevels();
		final Collection<SelectItem> levelBackingList = new ArrayList<SelectItem>();
		for(LevelVO levelVO : levels) {
			if(levelVO.getId() == null) {
				levelBackingList.add(new SelectItem(-1, "--NONE--"));
			} else {
				levelBackingList.add(new SelectItem(levelVO.getId(), levelVO.getLevel()));
			}
		}		
		
		LevelVO levelVO = (LevelVO) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("levelVO");
		if(levelVO != null) {
			if(levelVO.getId() != null)
				levelVO = getLevelService().findById(levelVO.getId());
		} else {
			levelVO = new LevelVO();
		}
		this.getEditLevelSaveForm().setLevelVOBackingList(levelBackingList);
		
		this.getEditLevelSaveForm().setLevelVO(levelVO);
		if(getEditLevelSaveForm().getLevelVO().getNextLevel() == null ){
			this.getEditLevelSaveForm().getLevelVO().setNextLevel(new LevelVO());
		}
		if(getEditLevelSaveForm().getLevelVO().getPreviousLevel() == null){
			this.getEditLevelSaveForm().getLevelVO().setPreviousLevel(new LevelVO());
		}
	}

	@Override
	public void doNewLevel() throws Throwable {
		
		LevelVO level = new LevelVO();
		getEditLevelForm().setLevelVO(level);
		
	}

}