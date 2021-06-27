Homework工程：
LoadHelloFile.java
文件填写的绝对路径，需要修改为自己本地的路径。

注意，不要复写loadClass，而应该复写findClass,因为复写前者，可能影响到原本classloader自带的双亲委派。
如果找不到，会再调用findClass()方法。所以一般复写findClass来查找自定义的类文件。
加载外部类的过程，最终交给了defineClass()方法，从二进制数组中读取数据。查看defineClass的源码，发现会做一些前置、后置的检查，主要是一些安全和证书相关的检查。最终都会走到native层的C/C++里面去执行。
变量与方法的非静态反射，最后都需要调用到object实例。有些场景下需要调用类的newInstance方法来构造类。比如例子中要构造一个Hello类的实例。
