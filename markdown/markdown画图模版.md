
### mermaid-流程图
```mermaid
graph TD;
    A-->B;
    A-->C;
    B-->D;
```




### mermaid-流程图

```mermaid
graph LR

A[方形] -->B(圆角)

    B --> C{条件a}

    C -->|a=1| D[结果1]

    C -->|a=2| E[结果2]

    F[横向流程图]
```

### sequence-时序图
```sequence
对象A->对象B: 对象B你好吗?（请求）

Note right of 对象B: 对象B的描述

Note left of 对象A: 对象A的描述(提示)

对象B-->对象A: 我很好(响应)

对象A->对象B: 你真的好吗？
```


### flow-流程图

```flow
st=>start: 开始框
op=>operation: 处理框
cond=>condition: 判断框(是或否?)
sub1=>subroutine: 子流程
io=>inputoutput: 输入输出框
e=>end: 结束框
st->op->cond
cond(yes)->io->e
cond(no)->sub1(right)->op
```

### flow-流程图

```flow
st=>start: 开始框
op=>operation: 处理框
cond=>condition: 判断框(是或否?)
sub1=>subroutine: 子流程
io=>inputoutput: 输入输出框
e=>end: 结束框
st(right)->op(right)->cond
cond(yes)->io(bottom)->e
cond(no)->sub1(right)->op
```

### sequence-时序图
```sequence
Title: 标题：复杂使用

对象A->对象B: 对象B你好吗?（请求）

Note right of 对象B: 对象B的描述

Note left of 对象A: 对象A的描述(提示)

对象B-->对象A: 我很好(响应)

对象B->小三: 你好吗

小三-->>对象A: 对象B找我了

对象A->对象B: 你真的好吗？

Note over 小三,对象B: 我们是朋友

participant C

Note right of C: 没人陪我玩
```


### mermaid-时序图
```mermaid
%% 时序图例子,-> 直线，-->虚线，->>实线箭头

  sequenceDiagram

    participant 张三

    participant 李四

    张三->王五: 王五你好吗？

    loop 健康检查

        王五->王五: 与疾病战斗

    end

    Note right of 王五: 合理 食物 <br/>看医生...

    李四-->>张三: 很好!

    王五->李四: 你怎么样?

    李四-->王五: 很好!
```

###mermaid-类图

语法解释：`<|--` 表示继承，`+` 表示 `public`，`-` 表示 `private`

```mermaid
classDiagram
      Animal <|-- Duck
      Animal <|-- Fish
      Animal <|-- Zebra
      Animal: +int age
      Animal: +String gender
      Animal: void +isMammal()
      Animal: void +mate()
      class Duck{
          +String beakColor
          +swim()
          +quack()
      }
      class Fish{
          -int sizeInFeet
          -void canEat()
      }
      class Zebra{
          +bool is_wild
          +run()
      }
```

### mermaid-状态图
```mermaid
stateDiagram
    [*] --> s1
    s1 --> [*]
```





```mermaid
classDiagram         
	class 银行账户
  	银行账户: +String 户主
  	银行账户: +BigDecimal 余额
  	银行账户: +存(数量)
  	银行账户: +取(数量) 
```





`<|--`继承关系`*--`组成关系`o--`集合关系`-->`关联关系`--`实现连接`..>`依赖关系`..|>`实现关系`..`虚线连接

```mermaid
classDiagram
  classA <|-- classB
  classC *-- classD
  classE o-- classF
  classG <-- classH
  classI -- classJ
  classK <.. classL
  classM <|.. classN
  classO .. classP
```





### mermaid-甘特图

```mermaid
%% 语法示例

        gantt

        dateFormat  YYYY-MM-DD

        title 软件开发甘特图

        section 设计

        需求                      :done,    des1, 2014-01-06,2014-01-08

        原型                      :active,  des2, 2014-01-09, 3d

        UI设计                     :         des3, after des2, 5d

    未来任务                     :         des4, after des3, 5d

        section 开发

        学习准备理解需求                      :crit, done, 2014-01-06,24h

        设计框架                             :crit, done, after des2, 2d

        开发                                 :crit, active, 3d

        未来任务                              :crit, 5d

        耍                                   :2d

    
        section 测试

        功能测试                              :active, a1, after des3, 3d

        压力测试                               :after a1  , 20h

        测试报告                               : 48h
```

