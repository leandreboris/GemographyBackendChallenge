package com.main.services;

import java.util.Comparator;

import com.main.models.Items;

// Customization of Comparator in order to compare our data

public class LanguageComparator implements Comparator<Items> {

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