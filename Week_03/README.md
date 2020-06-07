学习笔记

递归代码模板java版本

void recur(int level, int max, T element){
    if(level > max )
        return;
    
    process(element);

    recur(level +1, max, element);

    //清除
}

递归在遇到不知道怎么办的情况下，一定要先写模板。
递归第一步一定要确定返回条件。边界情况要格外注意。