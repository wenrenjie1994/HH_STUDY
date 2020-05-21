## 1.  git拉新分支开发

```bash
$ git clone xxx.git # clone
$ git checkout master # 切换到master分支
$ git pull # 拉取master最新代码
$ git checkout -b dev # 创建并切换到新本地分支
$ git push origin dev # 本地分支push到远端
$ git branch --set-upstream-to=origin/dev # 本地远端关联
$ git pull # 拉最新代码
```



##  2. 拉指定分支

```bash
$ git clone -b [branch-name] [repository-url] 
```



## 3. OkHttp 创建HTTP请求

- GET

    ```java
    import okhttp3.OkHttpClient;
    import okhttp3.Request;
    import okhttp3.Response;
    import org.junit.Test;
    
    import java.io.IOException;
    
    public class TestHttpClient {
        private OkHttpClient client = new OkHttpClient();
        @Test
        public void testOkHttp() throws IOException {
            Request request = new Request.Builder()
                    .url("http://httpbin.org/get")
                    .header("key", "value")
                    .build();
            Response response = null;
            try {
                response = client.newCall(request).execute();
                if (response.body() != null) {
                    System.out.println(response.body().string());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    ```

## 4. FastJSON
- Maven:
```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.53</version>
</dependency>
 ```
- Use
```java
String text = JSON.toJSONString(obj); //序列化
VO vo = JSON.parseObject("{...}", VO.class); //反序列化
```
    
## 5. 获取时间
    
```java
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        String strDate, strTime;
        Date objDate = new Date();
        System.out.println("今天的日期是：" + objDate);
        long time = objDate.getTime();
        System.out.println("自1970年1月1日起以毫秒为单位的时间（GMT）：" + time);
        strDate = objDate.toString();
        //提取 GMT 时间
        strTime = strDate.substring(11, (strDate.length() - 4));
        //按小时、分钟和秒提取时间
        strTime = "时间：" + strTime.substring(0, 8);
        System.out.println(strTime);
        //格式化时间
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(objDate));
    }
}
```
    
    