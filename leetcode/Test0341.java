package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Mei Siman
 * @date 2021/1/20 23:14
 *
 * 341. 扁平化嵌套列表迭代器
 *
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 */
public class Test0341 implements Iterator<Integer> {

    interface NestedInteger {
        boolean isInteger();
        Integer getInteger();
        List<NestedInteger> getList();
    }

    List<Integer> list = new ArrayList<>();
    ListIterator<Integer> it;

    public Test0341(List<NestedInteger> nestedList){
        dfs(nestedList);
        it = list.listIterator();
    }

    @Override
    public boolean hasNext() {
        return it.hasNext();
    }

    @Override
    public Integer next() {
        return it.next();
    }

    private void dfs(List<NestedInteger> nestedList){
        for (NestedInteger nestedinteger: nestedList) {
            if (nestedinteger.isInteger()) {
                list.add(nestedinteger.getInteger());
            } else {
                dfs(nestedinteger.getList());
            }
        }
    }
}

