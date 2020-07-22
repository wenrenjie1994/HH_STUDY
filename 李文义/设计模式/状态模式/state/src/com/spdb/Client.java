package com.spdb;

import com.spdb.state.ClosingState;
import com.spdb.state.Context;

/**
 * @author liwenyi
 * @date 2020/7/22
 * desc
 */
public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.setLiftState(new ClosingState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
