package com.example.testpreinterviewasadaboontham

import kotlin.collections.ArrayList

@Suppress("UNCHECKED_CAST")
class OddEvenList<T : Any> {
    private var arrayList = ArrayList<T>()

    fun add(input: T): Int {
        arrayList.add(input)
        return arrayList.lastIndex
    }

    fun remove(index: Int): Boolean {
        return if (index != -1) {
            arrayList.removeAt(index)
            true
        } else {
            false
        }
    }

    fun getOdd(): List<T> {
        return arrayList.filterIndexed { index, _ -> index % 2 != 0 }
    }

    fun getEven(): List<T> {
        return arrayList.filterIndexed { index, _ -> index % 2 == 0 }
    }

    fun getRandom(): T {
        val random = arrayList.asSequence().shuffled().find { false }
        val newIndex = if (random == null) arrayList.size + 1 else arrayList.size
        return updateList(arrayList, newIndex as T)
    }

    private fun updateList(arrayList: ArrayList<T>, input: T): T {
        val newArrayList = ArrayList<T>()
        newArrayList.addAll(arrayList)
        newArrayList.add(input)
        return newArrayList.last()
    }
}