package ru.rseu.lovkin.mergesort.model.core;

import lombok.experimental.UtilityClass;
import ru.rseu.lovkin.mergesort.model.Model;
import ru.rseu.lovkin.mergesort.model.layeres.ElementGroup;

import java.util.List;

@UtilityClass
public class SortersUtils {
    public ElementGroup createNewElementGroupFromParent(Array array, ElementGroup... parentGroup) {
        ElementGroup elementGroup = new ElementGroup(array);
        elementGroup.setParentGroups(List.of(parentGroup));
        return elementGroup;
    }

    public MultiThreadSorter createNewMultiThreadSorter(Array array, MultiThreadSorter sorter, ElementGroup... parentGroup) {
        ElementGroup elementGroup = createNewElementGroupFromParent(array, parentGroup);
        MultiThreadSorter multiThreadSorter = new MultiThreadSorter(elementGroup);
        multiThreadSorter.setThreadSortersCounter(sorter.getThreadSortersCounter());
        multiThreadSorter.setListenerList(sorter.getListenerList());
        multiThreadSorter.setDelayInMs(sorter.getDelayInMs());
        return multiThreadSorter;
    }

    public OneThreadSorter createNewOneThreadSorter(Array array, OneThreadSorter sorter, ElementGroup... parentGroup) {
        ElementGroup elementGroup = createNewElementGroupFromParent(array, parentGroup);
        OneThreadSorter oneThreadSorter = new OneThreadSorter(elementGroup);
        oneThreadSorter.setListenerList(sorter.getListenerList());
        oneThreadSorter.setDelayInMs(sorter.getDelayInMs());
        return oneThreadSorter;
    }

    public OneThreadSorter createNewOneThreadSorter(Array array, MultiThreadSorter sorter, ElementGroup... parentGroup) {
        ElementGroup elementGroup = createNewElementGroupFromParent(array, parentGroup);
        OneThreadSorter oneThreadSorter = new OneThreadSorter(elementGroup);
        oneThreadSorter.setListenerList(sorter.getListenerList());
        oneThreadSorter.setDelayInMs(sorter.getDelayInMs());
        return oneThreadSorter;
    }
}
