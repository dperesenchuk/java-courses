package app;

import java.util.Iterator;
import java.util.List;

public class Util {
    public static void removeListDuplicates(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            Iterator iterator = list.listIterator(i + 1);
            while (iterator.hasNext()) {
                if (iterator.next().equals(list.get(i))) {
                    iterator.remove();
                }
            }
        }
    }
}
