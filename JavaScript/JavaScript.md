# JavaScript笔记  
---  
## JavaScript介绍  

主要是完成页面的数据验证。因此运行再客户端，需要运行浏览器来解析执行JavaScript代码。  
JS是弱类型，Java是强类型。  
特点：
1. 交互性(它可以做的就是信息的动态交互)  
2. 安全性(不允许直接访问本地硬盘)
3. 跨平台性(只要是可以解释JS的浏览器都可以执行，和平台无关)

## JavaScript和Html代码的结合方式  

```Html  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--
        现在需要使用script引入外部的js文件来执行
            src 属性专门用来引入js文件路径(可以是相对路径也可以是绝对路径)

        script标签可以用来定义js代码，也可以用来引入js文件
        但是，两个功能二选一使用，不能同时使用两个功能
    -->
    <script type="text/javascript" src="1.js"></script>
    <script>
        alert("LinuY");
    </script>
</head>
<body>

</body>
</html>
```  

## 变量

1. JavaScript的变量类型：
	* 数值类型：			number
	* 字符串类型：		string
	* 对象类型：			object
	* 布尔类型：			boolean
	* 函数类型：			function

2. JavaScript里特殊的值：
	* undefined			未定义，所有js变量未赋予初始值的时候，默认值都是undefined
	* null				空值
	* NAN				全程是：Not a Number。非数字。非数值。

3. JavaScript中的定义变量格式：
	* var 变量名;
	* var 变量名 = 值;

## 关系（比较）运算

* 等于：		==		等于是简单的做字面值的比较
* 全等于		==		除了做字面值的比较之外，还会比较两个变量的数据类型

## 逻辑运算

* 且运算： &&
	1. 当表达式全为真的时候。返回最后一个表达式的值。  
	2. 当表达式中，有一个为假的时候。返回第一个为假的表达式的值。  
* 或运算： ||
	1. 当表达式全为假时，返回最后一个表达式的值。  
	2. 只要有一个表达式为真。就会返回第一个为真的表达式的值。  
* 取反运算： ！

在JavaScript语言中，所有的变量，都可以做为一个boolean类型的变量去使用。 	只有在值为0、null、undefined、""(空串)都认为是false；

## 数组

1. 数组定义方式  
	格式：  
		var 数组名 = [];	//空数组
		var 数组名 = [1,'abc',true]	//定义数组同时赋值元素

## 函数

1. 函数的两种定义方式
	1. 可以使用function关键字来定义函数。  
		使用的格式：  
		```JavaScript
			function 函数名(形参列表){
				函数体
			}
		```  
		在JavaScript语言中，如何定义带有返回值的函数？   
		只需要在函数体内直接使用return语句返回值即可~   

	2. 格式：  
		```JavaScript
			var 函数名 = function(形参列表){
				函数体
			}
		```   

2. 在JavaScript中函数的重载会直接覆盖掉上一次的定义。  

3. 函数的arguments隐形参数(只在function函数内)  
	就是在function函数中不需要定义，但却可以直接用来获取所有参数的变量。管它叫隐形参数。  
	隐形参数特别像java基础的可变长参数。  

## JS中的自定义对象

1. Object形式的自定义对象  
	* 对象的定义：  
		```JavaScript
			var 变量名 = new Object();		// 对象实例(空对象)
			变量名.属性名 = 值；				// 定义一个属性
			变量名.函数名 = function(){}		// 定义一个函数
		```  
	* 对象的访问：  
		```JavaScript
			变量名.属性/函数名();
		```

2. {}花括号形式的自定义对象  
	```JavaScript
		var 变量名 = {
			属性值: 值,
			函数名: function(){}	
	} 
	```
