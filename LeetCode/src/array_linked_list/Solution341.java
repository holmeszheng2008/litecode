package array_linked_list;

import java.util.Iterator;
import java.util.List;

public class Solution341 {
    private interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        private Iterator<NestedInteger> listIterator;
        private NestedInteger currentNestedInteger;
        private NestedIterator currentNestedIterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.listIterator = nestedList.iterator();
        }

        @Override
        public Integer next() {
            if (currentNestedInteger.isInteger()) {
                Integer value = currentNestedInteger.getInteger();
                currentNestedInteger = null;
                return value;
            } else {
                return currentNestedIterator.next();
            }
        }

        @Override
        public boolean hasNext() {
            if (currentNestedInteger == null) {
                if (!listIterator.hasNext()) {
                    return false;
                }
                NestedInteger nestedInteger = listIterator.next();
                if (nestedInteger.isInteger()) {
                    currentNestedInteger = nestedInteger;
                    return true;
                } else {
                    List<NestedInteger> list = nestedInteger.getList();
                    NestedIterator nestedIterator = new NestedIterator(list);
                    if (nestedIterator.hasNext()) {
                        currentNestedInteger = nestedInteger;
                        currentNestedIterator = nestedIterator;
                        return true;
                    } else {
                        return hasNext();
                    }
                }
            } else {
                if (currentNestedInteger.isInteger()) {
                    return true;
                } else {
                    if (currentNestedIterator.hasNext()) {
                        return true;
                    } else {
                        currentNestedInteger = null;
                        currentNestedIterator = null;
                        return hasNext();
                    }
                }
            }
        }
    }

}
