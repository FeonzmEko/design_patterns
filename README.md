# UML图

## 类图表示法

### 类的表示方式

![image-20251128144456417](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20251128144456417.png)

## 类间关系的表示方式



# 软件设计原则

在软件开发中，为了提高软件系统的可维护性和可复用性，增加软件的可拓展性和灵活性，遵守以下6条原则拉力开发程序，从而提高软件开发效率，节约软件开发成本和维护成本

## 开闭原则

**对拓展开放，对修改关闭。**

在程序需要进行拓展的时候，不能去修改原有代码，实现一个热插拔的效果。简言之，是为了是程序的扩展性更强，易于维护和升级。

## 里氏代换原则

**任何基类可以出现的地方，子类一定可以出现。**

通俗的说：子类可以扩展父类的功能，但不能够改变父类原有的功能。子类继承父类时，处添加新的方法完成新增功能外，尽量不要重写父类的方法。

## 依赖倒转原则

**高层模块不应该依赖于底层模块，两者都应该依赖于抽象。**

**抽象不应该依赖于细节，细节应该依赖于抽象。**

## 接口隔离原则

**客户端不应该依赖它不需要的接口。**

接口要小而专

## 迪米特法则

**一个对象应该对其他对象有最少的了解。**

eg：controller，service，dao层

## 合成复用原则

**尽量使用 组合 (Composition) 或 聚合 (Aggregation)的方式实现代码复用，而不是使用 继承 (Inheritance)。**

# 分类

## 创建型模式

> 用于描述“怎么样创建对象”，特点是对象的创建和使用分离

共有五种

分别是 单例，原型，工厂方法，抽象工厂，建造者

## 结构型模式

> 描述如何将类或对象按某种布局组成更大的结构

共有七种

分别是 代理，适配器，桥接，装饰者，外观，享元，组合

## 行为型模式

> 描述类或对象之间怎样互相协作共同完成单个对象无法完成的任务，以及怎样分配职责

共有十一种

分别是 模板方法，策略，命令，职责链，状态，观察者，中介者，迭代器，访问者，备忘录，解释器



# 创建者模式

创建者模式的主要关注点是“怎样创建对象？”，它的主要关注点是“将对象的创建与使用分离”。

这样可以降低系统的耦合度，使用者不需要关注对象的创建细节。

分类以下五种模式：

* 单例模式
* 工厂方法模式
* 抽象工程模式
* 原型模式
* 建造者模式

## 单例模式

提供了一种创建对象的最佳方式。

这种模式涉及一个单一的类，该类负责创建自己的对象，同时确保只有单个对象会被创建。

### 实现

分为两种：

* 饿汉式：类加载就会导致该单实例对象被创建
* 懒汉式：类加载不会导致该单实例对象被创建，而是首次使用时才会被创建



1. 饿汉式-方式1（静态变量方式）

2. 饿汉式-方式2（静态代码块方式）

3. 饿汉式-方式3（枚举）

   ```java
   public enum Singleton{
       INSTANCE;
   }
   ```

   

4. 懒汉式-方式1（线程不安全）

5. 懒汉式-方式2（双检锁线程安全）

   ```java
   public class Singleton {
   
       private Singleton(){}
       private static volatile Singleton instance;
   
       public static Singleton getInstance(){
           if(instance == null){
               synchronized (Singleton.class){
                   if(instance == null){
                       instance = new Singleton();
                   }
               }
           }
           return instance;
       }
   }
   ```

   

6. 懒汉式-方式4（静态内部类方式）

   ```java
   public class Singleton {
   
       private Singleton() {}
   
       private static class SingletonHolder{
           private static final Singleton INSTANCE = new Singleton();
       }
   
       public static Singleton getInstance(){
           return SingletonHolder.INSTANCE;
       }
   
   }
   ```

### 问题

破坏单例：

- 序列化与反序列化：单例类实现Serializable接口，将对象写入文件后读取，每次读取到的是不同对象
- 反射：将无参构造通过反射设置为可见，然后创建对象，创建得到的是不同对象

反破坏单例：

- 序列化与反序列化：单例类中定义private Object readResolve()方法，方法返回单例对象。因为在反序列化时如果类中有个叫readResolve的方法，就会执行这个方法并返回结果。
- 反射：私有构造方法进行单例对象的非空判断即可，如果不为空，说明已经存在单例对象了，还想反射创建新的单例对象是不允许的，抛异常；为空，允许创建。

单例模式较为简单，但实现方法较多，需要根据不同场景下选择不同方式实现。

## 工厂模式

### 概述

java中，万物皆对象，对象需要创建时，都需要new出来，导致耦合严重，违背了软件设计的开闭原则。当我们运行工厂，只需要和工厂进行打交道，彻底和对象解耦，需要更换对象时，直接在工厂内更换对象，达到了与对象解耦的目的

工厂模式的最大优点：**解耦。**

### 简单工厂模式

简单工厂并非设计模式，更像一种编程习惯。

把类中创建对象的方法抽离到一个工厂中，相当于加了一层。

### 静态工厂模式

把工厂方法设置为静态`static`

### 工厂方法模式

用工厂方法模式可以完美解决上述问题，完全遵守开闭原则。

### 抽象工厂模式

**概念：**一种为访问类提供一个创建一组相关或相互依赖对象的接口，且访问类无需指定所要产品的具体类就能得到同组的不同等级的产品的模式结构

抽象工厂模式使工厂方法模式的升级版本，工厂方法模式只生产一个等级的产品，而抽象工厂模式可生产多个等级的产品

### 模式扩展

**简单工厂+配置文件解除耦合**

在工厂类中加载配置文件的全类名，并创建对象进行存储，客户端如果需要对象，直接进行获取即可。

```java
public class CoffeeFactory {
    // 定义容器来存储对象
    private static Map<String,Coffee> map = new HashMap<>();

    // 加载配置文件，加载一次
    static {
        // 创建properties对象
        Properties p = new Properties();
        // 调用load方法进行配置文件的加载
        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");

        try {
            p.load(is);
            // 从p集合获取全类名并获取对象
            Set<Object> keys = p.keySet();
            for (Object key : keys) {
                String className = p.getProperty((String) key);
                // 通过反射技术创建对象
                Class clazz = Class.forName(className);
                Coffee coffee = (Coffee) clazz.newInstance();
                // 将名称和对象存储到容器中
                map.put((String) key,coffee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Coffee createCoffee(String name){
        return map.get(name);
    }
}
```

## 原型模式

### 概述

类似于克隆出新对象

### 结构

包含如下角色：

* 抽象原型类：规定`clone()`方法
* 具体原型类：实现抽象原型类的`clone()`方法，可复制
* 访问类：使用具体原型类中的`clone()`方法复制新对象

### 实现

克隆分为浅克隆和深克隆

> 浅克隆：创建一个新对象，新对象的属性和原来对象完全相同，对于非基本数据类型，仍指向原有属性所指向的对象的内存地址。
>
> 
>
> 深克隆：创建一个新对象，属性中引用的其他对象也会被克隆，不在指向原有对象地址。

## 建造者模式

**将一个复杂对象的构建过程与其表示分离**

![image-20251201173331081](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20251201173331081.png)

```java
public static void main(String[] args) {
        // 创建指挥者对象
        Director director = new Director(new JavaBuilder());
        // 让指挥者组装自行车
        Bike bike = director.construct();
        System.out.println(bike.getFrame());
    }
```

# 结构型模式

结构型模式描述如何将类或对象按某种布局组成更大的结构。

分为 `类结构性模式` 和 `对象结构型模式`,前者采用继承机制来组织接口和类，后者采用组合或聚合来组合对象。

由于组合关系或聚合关系比继承关系耦合度低，满足“合成复用原则”，所以对象结构型模式比类结构性模式具有更大的灵活性。

包含以下7种：

* 代理模式
* 适配器模式
* 装饰者模式
* 桥接模式
* 外观模式
* 组合模式
* 享元模式

## 代理模式

套一层

### 结构

* 抽象主题类
* 真实主题类
* 代理类

### 静态代理

静态代理是最简单直观的实现方式，代理类在**编译阶段**就已经被创建。

### JDK动态代理

```java
public SellTickets getProxyObject(){
    SellTickets proxyObject = (SellTickets) Proxy.newProxyInstance(
        station.getClass().getClassLoader(),
        station.getClass().getInterfaces(),
        new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代售点收取一定的服务费用（jdk动态代理）");
                Object obj = method.invoke(station,args);

                return obj;
            }
        }
    );
    return proxyObject;
}
```

这段代码通过 `Proxy.newProxyInstance()` 方法，**在运行时**动态地创建了一个代理对象 `proxyObject`。这个代理对象和目标对象 `TrainStation` 一样，都实现了 `SellTickets` 接口。当您调用代理对象的 `sell()` 方法时，实际上执行的是 `InvocationHandler` 里的逻辑。

### CGLIB动态代理

在没有定义接口的情况下，无法使用jdk动态代理

CGLIB功能强大，为GDK动态代理提供了很好的补充

### 三种代理方式对比

* jdk && cglib
  * 有接口使用jdk，没接口使用cglib
* 动态代理 && 静态代理
  * 一般使用动态代理

### 优缺点

**优点**

* 中介，保护目标对象
* 扩展目标对象功能
* 降低系统耦合度

**缺点**

* 增加了系统复杂度

## 适配器模式

> 将一个类的接口转换成客户希望的另一个接口，使得原本由于接口不兼容而不能一起工作的那些类能一起工作。

### 结构

* 目标接口
* 适配者类
* 适配器类

### 类适配器模式

![image-20251203210826711](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20251203210826711.png)

思考：当不提供规范接口时候，则无法实现适配器

### 对象适配器模式

不再局限于是否提供规范接口

```java
public class SDAdapterTF extends SDCardImpl {
    private TFCard tfCard = new TFCardImpl();

    @Override
    public String readSD() {
        System.out.println("adapter read tf card");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        tfCard.writeTF(msg);
    }
}
```

### 应用场景

* 兼容旧系统
* 使用第三方提供的组件，但组件接口定义和自己要求的接口定义不同
