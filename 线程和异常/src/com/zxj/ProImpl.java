package com.zxj;

/**
 * @description:
 * @author: zeng
 * @modified By:
 */
public class ProImpl implements Runnable {
    private Resource resource;

    public ProImpl(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true){
            resource.pro();
        }
    }
}
