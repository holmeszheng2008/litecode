package data_structure_design_to_satisfy;

import java.util.Iterator;

// 284. Peeking Iterator
public class Solution284 {
    class PeekingIterator implements Iterator<Integer> {
        private Iterator<Integer> iterator;
        private Integer buffer;
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if(buffer != null) {
                return buffer;
            }
            buffer = iterator.next();
            return buffer;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if(buffer != null){
                Integer copy = buffer;
                buffer = null;
                return copy;
            }

            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            if(buffer != null){
                return true;
            }
            return iterator.hasNext();
        }
    }
}
