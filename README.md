## 前言

这个文件夹用来保存我学习用的笔记，这个文件用来记录markdown的基础语法。  

## 标题

\#这个符号用来表示标题，几个\#就是几个标题。最多六个。  

## 段落格式

1. 段落格式：没有特殊的段落格式。段落的换行是两个以上的空格加上回车。   
2. 字体：(这里因为两种格式混在一起用了，所以有点问题)  

		*斜体文本*   
		_斜体文本_   
		**粗体文本**  
		__粗体文本__  
		***粗斜体文本***  
		___粗斜体文本___  
3. 分割线：(行内不能有其他东西。这里因为也是混用，所以会有点问题)  
***
* * *
*****
- - -
---------
4. 删除线：在文字两端加上波浪线```~~```即可  

		~~baidu.com~~  
5. 下划线：通过HTMl的```<u></u>```标签实现  

		<u>带下划线文本</u>  
6. 脚注:  

	格式如下像这样[^1].  
[^1]: 冒号后面是脚注补充的。    

## 列表

1. Markdown支持有序列列表和无序列列表。  

2. 无序列使用\*、\+、\-加空格再加后面的文字作为列表标记.如：  
    * 第一项  
    * 第二项  
    * 第三项  

3. 有序列表使用数字加上\.号来表示，如：  
    1. 第一项  
    2. 第二项  
    3. 第三项  

4. 列表嵌套：只需在子列表中的选项添加四个空格即可：  
    1. 第一项：  
        - 第一项嵌套第一个元素  
        - 第一项嵌套第二个元素  
    2. 第二项：  
	    - 第二项嵌套第一个元素  
	    - 第二项嵌套第二个元素  

## 区块

1. 区块引用是在段落开头使用\>符号,然后后面紧跟一个空格符号：  
> 区块引用  
> README.md  

2. 区块是可以嵌套的，一个\>符号是最外层，两个\>是第一层嵌套，以此类推:  
>最外层  
>> 第一层  
>>
>> > 第二层  

3. 区块中使用列表：  

    > 1. 第一项  
    > 2. 第二项  
    > * 第一项  
    > * 第二项  

4. 列表中使用区块：  
    * 第一项  
    > 第一个区块  
    > 第二个区块   
    * 第二项 
    >  

## 代码

1.如果是段落上的一个函数或者片段的代码可以用反引号把他包起来(\`),例如：  
`printf()`函数

2.代码区块(代码区块使用四个空格或者一个制表符(TAB键))。  

	#include <iostream>
	int main()
	{
		std::cout << "Hello,World!" << std::endl;
		return 0;
	}

3. 代码区域2：也可以用\`\`\`来包裹一段代码，并指定一种语言,也可以不指定  
```C++
#include <iostream>
int main()
{
	std::cout << "Hello,World!" << std::endl;
	return 0;
}
```

## 链接

1. 使用方法：\[链接名称\]\(链接地址\)  
或者\<链接地址\>  
例如：这是一个链接[百度](https://www.baidu.com)  

	直接使用链接地址：<https://www.baidu.com>  

2. 链接也可以用变量来代替，文档末尾附带变量地址：  
这个链接用1作为网址变量[baidu][1]  
这个变量用baidu作为网址变量[baidu][baidu]  
然后在文档的结尾为变量赋值(网址)  
[1]: https://www.baidu.com/
[baidu]: https://www.baidu.com/

## 图片

1. 语法格式：\!\[alt 属性文本\](图片地址)  

			\!\[alt 属性文本\](图片地址 "可选标题")  
实例：  
	![图片](./Images/TEST.jpg)  

2. 也可以像网址那样对图片网址使用变量  
这个链接用2作为网址变量[TEST][2].  
[2]: ./Images/TEST.jpg

3. Markdown 无法指定图片的高度与宽度，如果需要，可以使用普通的<img\>标签:  
<img src="./Images/TEST.jpg" width="50%">  

## 表格

1. 制作表格使用\|来分隔不同的单元格,使用\-来分隔表头和其他行。  
格式：  

|  表头   | 表头  |
|  ----  | ----  |
| 单元格  | 单元格 |
| 单元格  | 单元格 |

2. 设置对齐方式：  

	-:设置内容和标题栏居右对齐。  
	:-设置内容和标题栏居左对齐。  
	:-:设置内容和标题栏居中对齐。  
	实例：

|  表头   | 表头  | 表头 |
|  :----  | ----: | :----: |
| 单元格  | 单元格 | 单元格 |
| 单元格  | 单元格 | 单元格 |

## 高级技巧

1. 支持的HTML元素  

	不在Markdown涵盖范围之内的标签，都可以直接在文档里面用HTML写。  
	目前支持的HTML元素有:< kbd>< b>< i>< em>< sup>< sub>< br>等,如：  
	使用 <kbd>Ctrl</kbd> + <kbd>Alt</kbd> + <kbd>Del</kbd> 重启电脑  

2. 使用反斜杠转义特殊字符。 

3. 公式

	当你需要在编辑器中插入数学公式时，可以使用两个美元符$$包裹TeX或LaTeX格式的数学公式来实现。提交后，问答和文章页会根据需要加载Mathjax对数学公式进行渲染。如：  

$$
\mathbf{V}_1 \times \mathbf{V}_2 =  \begin{vmatrix}   
\mathbf{i} & \mathbf{j} & \mathbf{k} \\  
\frac{\partial X}{\partial u} &  \frac{\partial Y}{\partial u} & 0 \\  
\frac{\partial X}{\partial v} &  \frac{\partial Y}{\partial v} & 0 \\  
\end{vmatrix}  
${$tep1}{\style{visibility:hidden}{(x+1)(x+1)}}
$$