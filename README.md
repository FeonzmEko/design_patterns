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

## 装饰者模式

### 结构

* 抽象构件：FastFood
* 具体构件：FiredNoodles，FiredRice
* 抽象装饰：Garnish，**继承+聚合**
* 具体装饰：Egg，Bacon

![image-20251204134753365](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20251204134753365.png)

若要在上图关系中加入一种新的食物，仅需要继承FastFood即可，可拓展性极强

**好处：**

* 装饰者模式可以带来比继承更加灵活的扩展功能，使用更方便，完美遵循开闭原则
* 装饰类和被装饰类可以独立发展，不会互相耦合，装饰者模式是继承的一个替代模式

## 桥接模式

定义：将抽象与实现分离，使他们可以独立变化。它是用组合关系替代继承关系来实现，从而降低了抽象和实现这两个可变维度的耦合度。

### 结构

* 抽象化角色：OperatingSystem
* 扩展抽象化角色：对抽象化角色的具体实现（mac，win）
* 实现化角色：VideoFile
* 具体实现化角色：对实现化角色的具体实现（avi）

![image-20251204144408753](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20251204144408753.png)

**优点：**

* 桥接模式提高了系统的可扩展性，在两个变化维度中任意扩展一个维度，都不需要修改原有系统。



## 外观模式

核心思想是为子系统中的一组接口提供一个**统一的**、**高层的**接口。这个接口使得子系统更容易使用。

eg：电脑的电源键就是一个外观

## 组合模式

三种角色：

* 抽象根节点：定义系统各层次对象共有方法和属性，可以预先定义一些默认行为和属性
* 树枝节点：定义树枝节点的行为，存储子节点，组合树枝节点和叶子结点形成一个树形结构
* 叶子结点：叶子结点对象，旗下再无分支，是系统层次遍历最小单位

### 分类

* 透明组合模式：让抽象组件类**包含所有**管理子节点的方法
* 安全组合模式：将管理子节点的方法**只定义在容器组件**中

![image-20251204163031954](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20251204163031954.png)

## 享元模式

定义：运用共享技术来有效地支持大量细粒度对象的复用。它通过已经存在的对象来大幅度减少需要创建的对象数量，避免大量相似对象的开销，从而提高系统资源的利用率。

### 结构

* 抽象享元角色
* 具体享元角色
* 非享元（不常见）
* 享元工厂

![image-20251204170956652](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20251204170956652.png)



# 行为型模式

行为型模式用于描述程序在运行时复杂的流程控制，即描述多个类或对象之间怎样相互协作共同完成单个对象都无法单独完成的任务，涉及算法与对象间职责的分配

分为`类行为模式`和`对象行为模式`，对象行为模式采用组合或聚合在对象间分配行为，耦合度更低，更加灵活

行为型模式分为：

* 模板方法模式
* 策略模式
* 命令模式
* 职责链模式
* 状态模式
* 观察者模式
* 中介者模式
* 迭代器模式
* 访问者模式
* 备忘录模式
* 解释器模式

以上11种行为型模式，除了模板方法模式和解释器模式是类行为型模式，其他的全部属于对象行为型模式

## 模板方法模式

定义：

定义一个操作中的算法骨架，而将算法的一些步骤延迟到子类中，使得子类可以不改变算法结构的情况下重定义该算法的某些特定步骤。

### 结构

* 抽象类
* 基本方法
  * 抽象方法
  * 具体方法
  * 钩子方法
* 具体子类

### 优缺点

优点：

* 提高代码复用性

  相同部分放在父类，不懂的放在子类

* 实现了反向控制

  通过子类实现父类中的abstract方法，父类得以调用子类方法，实现了反向控制，且符合“开闭原则”

缺点：

* 每个实现都需定义子类，系统庞大，设计抽象
* 反向的控制结构，提高了代码阅读的难度

### 场景

* 算法整体步骤固定，但个别部分易变，可以把易变部分抽象出来，供子类实现
* 需要通过子类来决定父类算法中某个步骤是否执行，实现反向控制（钩子函数）

## 策略模式

将每个算法封装起来，使它们可以互换使用。

### 结构

* 抽象策略：策略类的接口
* 具体策略：提供算法实现或行为
* 环境类：持有策略类的应用，交给客户端调用功能

### 优缺点

**优点：**

* 策略类之间可以自由切换
* 易于扩展
* 避免使用多重条件选择语句if else，体现面向对象

**缺点：**

* 客户端必须知道所有的策略类，并自行决定使用哪一个
* 产生很多策略类，可以通过享元模式在一定程度上减少对象的数量

### 场景

![image-20251204202335693](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20251204202335693.png)

## 命令模式

### 结构

* 抽象命令类：Command
* 具体命令类：OrderCommand
* 实现者/接收者角色：Receiver
* 调用者/请求者角色：Waiter

![image-20251204210640748](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20251204210640748.png)

## 责任链模式

定义：

避免请求发送者与多个请求处理者耦合在一起，将所欲请求的处理者通过前一对象记住下一个对象的引用而连成一条链，当有请求发生时，可将请求沿着这条链传递，直到有对象处理它为止

```java
public static void main(String[] args) {
    // 一个请假条对象
    LeaveRequest leave = new LeaveRequest("小明",9,"抱恙");

    // 各级领导对象
    GroupLeader groupLeader = new GroupLeader();
    Manager manager = new Manager();
    GeneralManager generalManager = new GeneralManager();

    // 设置职责链
    groupLeader.setNextHandler(manager);
    manager.setNextHandler(generalManager);

    // 自底向上进行提交审批
    groupLeader.submit(leave);
}
```

形成职责链：

> groupLeader --> manager --> generalManager

### 优缺点

**优点：**

* 降低对象之间的耦合度
* 增强系统的可扩展性
* 增强了给对象指派职责的灵活性
* 简化对象间的连接
* 责任分担

**缺点：**

* 不能保证每个请求都被处理
* 较长的职责链可能影响性能

## 状态模式

把有状态的对象，把复杂的逻辑判断提取到不同的对象中，允许状态对象在其内部状态发生改变时改变其行为

### 结构

* 环境角色：也称为上下文，维护状态用的
* 抽象状态角色
* 具体状态角色

![image-20251205152617168](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20251205152617168.png)

## 观察者模式

定义：

又被称为`发布-订阅`(Publish/Subscribe)模式，它定义了一种一对多的依赖关系，让多个观察者对象同时监听某一个主题对象。这个主题对象在状态变化时，会通知所有的观察者对象，使他们能够自动更新自己。

### 结构

**Subject（抽象主题/可观察者）**：

- 提供一个接口，用于**注册**（`attach`）、**删除**（`detach`）观察者对象。
- 提供一个接口，用于**通知**（`notify`）所有已注册的观察者。

**ConcreteSubject（具体主题）**：

- 维护自身状态。
- 状态发生变化时，负责调用 `notify` 方法通知所有观察者。

**Observer（抽象观察者）**：

- 定义一个更新接口（`update`），用于在主题状态发生变化时接收通知并更新自身。

**ConcreteObserver（具体观察者）**：

- 实现抽象观察者的 `update` 接口。
- 在接到主题通知后，执行相应的业务逻辑。通常会调用具体主题的方法来获取最新的状态信息。

### 优缺点

1. 优点
   * 降低了目标与观察者之间的耦合关系，两者是抽象耦合关系
   * 被观察者发送通知，所有注册的观察者都会收到信息
2. 缺点
   * 观察者过多，耗时较长
   * 循环依赖问题

### 场景

* 一对多的关系
* 抽象模型有两个方面，一个依赖另一个

## 中介者模式

![image-20251205163736443](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20251205163736443.png)

定义：

又叫调停模式，定义一个中介角色来封装一系列对象之间的交互，使原有对象之间的耦合松散，且可以独立地改变他们之间的交互。

### 结构

* 抽象中介者角色
* 具体中介者角色
* 抽象同事类角色
* 具体同事类角色

## 迭代器模式

定义：

提供一个对象来顺序访问聚合对象中的一系列数据，而不暴露聚合对象的内部表示。

### 结构

* 抽象聚合角色
* 具体聚合角色
* 抽象迭代器角色
* 具体迭代器角色

![image-20251205180155588](C:\Users\Qingfeng\AppData\Roaming\Typora\typora-user-images\image-20251205180155588.png)

> 在开发中使用迭代器模式，只需让自己的容器实现java.util.Iterable并实现其中的iterator()方法使其返回一个java.util.Iterator的实现类就可以了
