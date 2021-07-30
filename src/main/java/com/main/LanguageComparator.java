package com.main;

import java.util.Comparator;

public class LanguageComparator
implements Comparator<Items> {

@Override
public int compare(Items o1, Items o2) {
if (o1 == null && o2 == null) return 0;
if (o1 == null) return -1;
if (o2 == null) return 1;
return Comparator
        .comparing(Items::getLanguage,
                   Comparator.nullsFirst(Comparator.naturalOrder()))
        .compare(o1, o2);
}
}