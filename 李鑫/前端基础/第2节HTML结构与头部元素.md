# HTML结构

一个网页的基本结构如下（注：网页代码不区分大小写）：

```HTML
<!doctype html>  <!--文档类型声明-->
<html>
    <head>  <!--网页头部，设置网页相关信息，如字符编码-->
        <title>网页标题</title>
    </head>

    <body>  <!--网页内容-->
        body标签之间的内容是可见的页面内容，可以包含其他HTML标签。
    </body>
</html>
```

网页第一行为文档类型声明，用DOCTYPE声明文档类型，以便验证文档是否符合文档类型定义（DTD），同时指定了浏览器关于页面使用哪个HTML版本进行编写的指令，如HTML 5中新添加的标签在HTML 4.0类型的网页中是不合法的。

如果不指定文档类型，大部分浏览器按自己的方式来处理网页代码，可能导致CSS样式不能正常显示（如不能水平居中）且JavaScript代码不能正常运行。

### HTML头部元素

head元素是所有头部元素的容器,可包含脚本,指示浏览器在何处可以找到样式,提供元信息,可以添加到head的标签有:\<title>,\<link>,\<meta>,\<script>以及\<style>

\<title>标签定义文档的标题，title元素能够定义浏览器工具栏中的标题；提供页面被添加到收藏夹时显示的标题；显示在搜索引擎结果中的页面标题.

```HTML
<! DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>浦发银行--你的世界银行</title>
    </head>

    <body>
        欢迎访问SPDB!
    </body>
</html>
```

\<meta>标签提供关于HTML文档的元数据。元数据不会显示在页面上，meta元素被用于规定页面的描述、关键词、文档的作者、最后修改时间以及其他元数据。\<meta>标签始终位于head元素中，\<meta>标签的使用格式为：
  
```HTML
<meta 可选属性名="..." content="..." />
```

content是\<meta>标签必选属性,其作用是描述页面的内容.<meta>标签的http-equiv和name可选属性与content属性配合使用指定网页元数据信息，如http-equiv属性与content属性组合使用来指定页面的编码方式：
```HTML
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
```

在HTML 5中设置编码方式的代码为：

```html
<meta charset="utf-8" />
```

http-equiv属性与content属性组合也可以用于网页的自动刷新：

```html
<meta http-equiv="Refresh" content="5" />
```
此代码将使当前页面每隔5秒刷新一次.自动刷新也可以用于网址已经变更的情况下，将用户重定向到另外一个地址:

```html
<! DOCTYPE html>
<html>
    <head>
        <title>SPDB直播间</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta http-equiv="Refresh" content="5; url=http://spdb.com/zhibo/spdb.html" />
    </head>

    <body>
        <p>
            新的直播地址是<a href="http://www.spdb.com.cn">http://http://www.spdb.com.cn</a>
        </p>
        <p>
            您将在5秒内被重定向到新的地址.
        </p>
        <p>
            如果超过5秒后没有跳转,请单击上面的链接.
        </p>
    </body>
</html>
```

\<meta>标签的name属性与content属性组合可以用来指定页面的作者、关键字和描述等信息，将name属性的值设置为“Keywords”，可以在content属性中设置网页的关键字；将name属性的值设置为“Description”，可以在content属性中设置网页的描述：

```html
<meta name="keywords" content="金融 银行" />
<meta name="Description" content="spdb是一家商业股份制银行" />
```

**网页的标题、关键字和描述对网页在搜索引擎中的收录和排名有影响，因此在编辑网页时需要适当设置相关内容**