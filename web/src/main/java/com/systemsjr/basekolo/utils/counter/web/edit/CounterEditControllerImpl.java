// license-header java merge-point
// Generated by andromda-jsf cartridge (controllers\ControllerImpl.java.vsl)
package com.systemsjr.basekolo.utils.counter.web.edit;

import com.systemsjr.basekolo.utils.counter.vo.CounterVO;
import java.util.Date;

/**
 * @see com.systemsjr.basekolo.utils.counter.web.edit.CounterEditController
 */
public class CounterEditControllerImpl
    extends CounterEditController
{
    /**
     * The serial version UID of this class. Needed for serialization.
     */
    private static final long serialVersionUID = 3715498681347977060L;

    /**
     * @see com.systemsjr.basekolo.utils.counter.web.edit.CounterEditController#initialiseEditScreen(CounterVO counterVO)
     */
    @Override
    public void initialiseEditScreen(InitialiseEditScreenForm form)
    {
        // populating value with dummy instance
        CounterVO counterVO = new CounterVO();
        counterVO.setCreatedAt(new Date());
        counterVO.setCreatedBy(null);
        counterVO.setModifiedAt(new Date());
        counterVO.setModifiedBy(null);
        counterVO.setId(new Long((long)3355));
        counterVO.setCounterLength(new Integer((int)-677834750));
        counterVO.setCounterName(null);
        counterVO.setCurrentCount(new Long((long)1442916118));
        form.setCounterVO(counterVO);
    }

    /**
     * @see com.systemsjr.basekolo.utils.counter.web.edit.CounterEditController#doNewCounter()
     */
    @Override
    public void doNewCounter()
    {
    }

    /**
     * @see com.systemsjr.basekolo.utils.counter.web.edit.CounterEditController#doSaveCounter()
     */
    @Override
    public void doSaveCounter()
    {
    }

}