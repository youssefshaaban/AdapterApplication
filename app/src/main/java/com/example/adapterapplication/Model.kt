package com.example.adapterapplication

data class Model(val id: Int, val title: String, var isSelected: Boolean = false)


fun getData(count:Int=20): List<Model> {
    val list = ArrayList<Model>()
    for (i in 0 until count) {
        list.add(Model(i, "Title $i"))
    }
    return list
}