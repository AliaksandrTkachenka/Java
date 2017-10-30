package lecture8.ownList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ImmutableList<E> implements Iterable<E> {
    private final List<E> list;

    private ImmutableList(List<E> list) {
        this.list = new ArrayList<>(list);
    }

    public static class ImmutableListBuilder<E> {
        private List<E> list;

        public ImmutableListBuilder() {
            this.list = new ArrayList<>();
        }

        public ImmutableListBuilder(List<E> list) {
            this();
            this.list.addAll(list);
        }

        public ImmutableListBuilder<E> add(E e) {
            this.list.add(e);
            return this;
        }

        public ImmutableListBuilder<E> addAll(Collection<? extends E> c) {
            this.list.addAll(c);
            return this;
        }

        public ImmutableListBuilder<E> remove(E e) {
            if(this.list.contains(e)) {
                this.list.remove(e);
            }
            return this;
        }

        public ImmutableList build() {
            return new ImmutableList(this.list);
        }
    }

    public int size() {
        return this.list.size();
    }

    @Override
    public Iterator<E> iterator() {
        int currentSize = list.size();
        Iterator<E> it = new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < currentSize && list.get(currentIndex) != null;
            }

            @Override
            public E next() {
                if(currentIndex == currentSize) {
                    currentIndex = 0;
                }
                return list.get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    public ImmutableList getList() {
        return new ImmutableList(this.list);
    }

    public E get(int index) {
        return this.list.get(index);
    }
}
