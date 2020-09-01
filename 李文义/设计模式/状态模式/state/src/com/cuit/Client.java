package com.cuit;

import com.cuit.state.ClosingState;
import com.cuit.state.Context;

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
