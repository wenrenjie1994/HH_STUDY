package com.testHR;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class BuyImpl implements Runnable{
    private Resource resource;

    public BuyImpl(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true){
            resource.buy();
        }
    }
}
