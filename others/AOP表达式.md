# AOP表达式

## 1. execution 表达式
| * | * | * | () |
|:-:|:-:|:-:|:--:|
|方法修饰符(可选)|返回值类型|类全限定名.方法名|参数列表|
| public | void | com.h3c.oasis.ABC.method|(..)|

- 拦截任意public方法
   ```
   execution("public * *(..)")
   match:
   public void method(){}
   ```

- 拦截任意set开头方法
   ```
   execution("* set*(..)")
   match:
   public void setAbc(){}
   ```

- 拦截某个类或接口中的方法
   ```
   execution("* com.xyz.ABC.*(..)")
   match:
   package com.xyz
   class ABC{
       public void method(){}
   }
   ```

- 拦截某个包下类或接口中的方法，不含子包
   ```
   execution("* com.xyz.*.*(..)")
   ```
  
- 拦截某个包下类或接口中的方法，含子包
   ```
   execution("* com.xyz..*.*(..)")
   ```

