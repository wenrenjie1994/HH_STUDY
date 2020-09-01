package com.cuit.user;

import com.cuit.mediator.AbstractMediator;

/**
 * @author liwenyi
 * @date 2020/7/21
 * desc
 */
public abstract class AbstractColleague {
    protected AbstractMediator mediator;
    public AbstractColleague(AbstractMediator _mediator){
        this.mediator = _mediator;
    }
}
