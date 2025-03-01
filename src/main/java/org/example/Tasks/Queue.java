package org.example.Tasks;

/**
 * Класс {@code Queue} представляет собой очередь, реализованную на основе двусвязного списка.
 * Очередь поддерживает операции добавления элемента в конец ({@link #pushBack(String)}) и
 * извлечения элемента из начала ({@link #popFront()}).
 */
public class Queue {
    /**
     * Вложенный класс {@code Item} представляет собой элемент очереди.
     */
    static class Item {
        String str;
        Item itemNext;
        Item itemPrev;

        /**
         * Создаёт новый элемент очереди.
         *
         * @param str данные элемента.
         */
        Item(String str) {
            this.str = str;
            itemNext = null;
            itemPrev = null;
        }
    }

    Item head;
    Item tail;
    int size;

    /**
     * Создаёт пустую очередь.
     */
    public Queue() {
        head = null;
        tail = null;
    }

    /**
     * Добавляет элемент в конец очереди.
     *
     * @param str данные для добавления.
     */
    public void pushBack(String str) {
        Item item = new Item(str);

        if (tail == null) {
            tail = item;
            head = item;
            return;
        }

        item.itemNext = tail;
        tail.itemPrev = item;
        tail = item;
    }

    /**
     * Извлекает элемент из начала очереди.
     *
     * @return данные извлечённого элемента или {@code null}, если очередь пуста.
     */
    public String popFront() {
        if (head == null) {
            return null;
        }

        String out = head.str;
        if (head == tail) {
            head = null;
            tail = null;
            return out;
        }

        head = head.itemPrev;
        head.itemNext.itemPrev = null;
        head.itemNext = null;

        return out;
    }

    /**
     * Возвращает строковое представление очереди.
     *
     * @return строковое представление очереди.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Item ptr = head;

        if (ptr == null) {
            return "Queue is empty";
        }

        while (ptr != null) {
            if (ptr == head && ptr == tail) {
                sb.append(ptr.str).append(" <- head & tail\n");
            } else if (ptr == head) {
                sb.append(ptr.str).append(" <- head\n");
            } else if (ptr == tail) {
                sb.append(ptr.str).append(" <- tail\n");
            } else {
                sb.append(ptr.str).append("\n");
            }
            ptr = ptr.itemPrev;
        }

        return sb.toString();
    }

    /**
     * Внутренний класс {@code Iterator} предоставляет итератор для обхода элементов очереди.
     */
    public class Iterator {
        private Item current;
        private Item lastReturned;

        /**
         * Создаёт итератор, начиная с головы очереди.
         */
        public Iterator() {
            current = head;
            lastReturned = null;
        }

        /**
         * Проверяет, есть ли следующий элемент в очереди.
         *
         * @return {@code true}, если следующий элемент существует, иначе {@code false}.
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Возвращает следующий элемент очереди.
         *
         * @return данные следующего элемента.
         */
        public String next() {
            lastReturned = current;

            String data = current.str;
            current = current.itemPrev;
            return data;
        }

        /**
         * Удаляет последний возвращённый элемент.
         */
        public void remove() {
            if (lastReturned == null) {
                System.out.println("No element to remove");
                return;
            }

            if (lastReturned == head && lastReturned == tail) {
                head = null;
                tail = null;
            } else if (lastReturned == head) {
                head = head.itemPrev;
                head.itemNext = null;
            } else if (lastReturned == tail) {
                tail = tail.itemNext;
                tail.itemPrev = null;
            } else {
                lastReturned.itemNext.itemPrev = lastReturned.itemPrev;
                lastReturned.itemPrev.itemNext = lastReturned.itemNext;
            }
        }
    }

    /**
     * Возвращает итератор для обхода элементов очереди.
     *
     * @return итератор.
     */
    public Iterator iterator() {
        return new Iterator();
    }
}
