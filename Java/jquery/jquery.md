# JQuery  

---  

## 下载和安装  

1. 下载  
    * 从[JQuery官网](https://Jquery.com)下载JQuery库  
    * 从CDN中载入JQuery，如Google中加载JQuery  
    
2. 版本  
    * Production version - 用于实际的网站中，已被精简和压缩  
    * Development version - 用于测试和开发（未压缩，是可读的代码）  
    
3. 导入  
    ```html
       <head>
           <script src="jquery-1.10.2.min.js"></script>
       </head>
    ```
    ```html
       <head>
           <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
           </script>
       </head>
    ```
   
## 语法  

1. 简介  
    通过JQuery，可以选取（查询）HTML元素，并对它们执行“操作”  

2. 基础语法  
    ```$(selector).action()```
    * 美元定义符JQuery  
    * 选择符（selector）“查询”和“查找”HTML元素  
    * JQuery的action()执行对元素的操作  
    * 实例：  
        * ```$(this).hide()``` - 隐藏当前元素  
        * ```$("p").hide()``` - 隐藏所有```<p>``` 元素  
        * ```$("p.test").hide()``` - 隐藏所有```class="test"```的```<p>``` 元素  
        * ```$("#test").hide()``` - 隐藏```id="test"```的元素  
    * 文档就绪事件：  
        ```js
            $(document).ready(function(){
                //开始写 JQuery 代码...
            });
        ```
        简洁写法：  
        ```js
            $(function(){
                //开始写 JQuery 代码...
            });
        ```
