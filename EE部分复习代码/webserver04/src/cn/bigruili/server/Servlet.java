package cn.bigruili.server;
//服务器脚本接口
public interface Servlet {
    void service(Request rq,Response rs);
}
