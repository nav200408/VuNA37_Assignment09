import java.util.Arrays
data class Item(val value: Int, val index: Int)
fun main(args: Array<String>){
    print(binarySearch(24, arrayOf(12, 3, 24, 5, 10, 23, 9)))
}

fun binarySearch(element: Int, array: Array<Int>): Int {
    val items = array.mapIndexed { index, i -> Item(i, index) }.sortedBy {it.value } // before: Arrays.sort(array)
    var index: Int = 0
    var end = items.size - 1
    while(index <= end){
        val center: Int = (index + end) / 2
        if (element == items[center].value){
            return items[center].index
        }else if (element < items[center].value){
            end = center - 1
        }else if(element > items[center].value){
            index = center + 1 //before: +2
        }
    }
    return -1
}

/*
The index (which is the start of a list after removing the uncontained part) only need to move forward 1 unit
, so assign the index with index = center + 2 is a logical error, I have changed it to plus 1

The index returned by Binary Search corresponds to the sorted array, not the original array.
To preserve the original  positions, I created an Item class that stores both the value and its original index.
After sorting the items by value, I can perform Binary Search and return the original index of the matched element.

I also remove the unnecessary class declaration
 */