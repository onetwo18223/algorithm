树的模型, 十分契合递归
树中的递归大多都是有返回值, 返回值为Node

结构 : 
判断 node == null, return null;
关于左子节点进行递归 : node.left = fun(node.left)
关于右子节点进行递归 : node.right = fun(node.right)
*这样的形式就像是前序遍历树, 对树进行了重塑*


而若是使用递归时结构 :  
if(node == null) return null;
return fun(node.right);
*这样的形式只会返回某一个点(以及点后面的链(原来就有的)), 而不是像上面的结构, 返回了重构的链*

