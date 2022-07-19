# 福運泰四面佛



## 一、雷區:
1. 專案build起來的時候(intellij) -> sdk用1.8
2. 前端給的main.js,要自己加initPage....
3. 前端給的jquery引用可能在下方，建議拉到上方,不然會有引用順序的問題

##  二、local環境注意:
1. common.jsp 會自動轉址到https, local環境記得槓掉
2. windows: web.xml, 不然會有路徑問題
```xhtml
 <param-value>
    file://${catalina.home}/config/fuyuntai/log4j2.xml
 </param-value>
```  
改成
```xhtml
<param-value>
    build/resources/main/Stagging/log4j2.xml
</param-value>
```

##  三、URL:

https://210.65.137.172/fuyuntai/phraphromLove