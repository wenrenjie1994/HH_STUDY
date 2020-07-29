## **==和equals方法**

(内容摘自尚学堂)

### 1. equals

“==”代表比较双方是否相同。如果是基本类型则表示值相等，如果是引用类型则表示地址相等即是同一个对象。

   Object类中定义有：public boolean equals(Object obj)方法，提供定义“对象内容相等”的逻辑。比如，我们在公安系统中认为id相同的人就是同一个人、学籍系统中认为学号相同的人就是同一个人。

   Object 的 equals 方法默认就是比较两个对象的hashcode，是同一个对象的引用时返回 true 否则返回 false。但是，我们可以根据我们自己的要求重写equals方法。



JDK提供的一些类，如String、Date、包装类等，重写了Object的equals方法，调用这些类的equals方法， x.equals (y) ，当x和y所引用的对象是同一类对象且属性内容相等时（并不一定是相同对象），返回 true 否则返回 false。