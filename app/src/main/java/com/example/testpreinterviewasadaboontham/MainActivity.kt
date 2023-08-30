package com.example.testpreinterviewasadaboontham

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var hashMap: HashMap<String, Int> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /***No.1***/
        val oddEvenList: OddEvenList<Int> = OddEvenList()

        //To call function add.
        initOddValue(oddEvenList)

        //To call function getOdd.
        Log.e("MY_LOG oddEvenList", "getOdd: ${oddEvenList.getOdd()}")

        //To call function getEven.
        Log.e("MY_LOG oddEvenList", "getEven: ${oddEvenList.getEven()}")

        //To call function getRandom.
        Log.e("MY_LOG oddEvenList", "getRandom: ${oddEvenList.getRandom()}")

        //To call function remove odd.
        Log.e("MY_LOG oddEvenList", "remove: ${oddEvenList.remove(5)}")

        /***No.2***/
        val squareDigits = getSquareDigits(9119)
        Log.e("MY_LOG getSquareDigits", "squareDigits: $squareDigits")

        /***No.3***/
        val reverseStr = reverseString(inputString = "Asada Boontham")
        Log.e("MY_LOG reverseString", "reverseStr: $reverseStr")

        /***No.4***/
        initScoreValue()
        val sumStr = getSummaryString(inputString = "boontham asada boontham asada")
        Log.e("MY_LOG sumString", "sumStr: $sumStr")
    }

    /***No.1***/
    private fun initOddValue(oddEvenList: OddEvenList<Int>) {
        for (number in 1..40) {
            oddEvenList.add(number)
        }
    }

    /***No.2***/
    private fun getSquareDigits(n: Int): Int {
        val builder = StringBuilder()
        val splitIntGroup = n.toString().split("")
        splitIntGroup.forEach { number ->
            if (number.isNotEmpty()) {
                val summary = number.toBigInteger().pow(2)
                builder.append(summary)
            }
        }

        return if (builder.isEmpty()) 0 else builder.toString().toInt()
    }

    /***No.3***/
    private fun reverseString(inputString: String): String {
        var reversedStr = ""
        val words = inputString.split(" ".toRegex()).dropLastWhile { _ ->
            inputString.isEmpty()
        }.toTypedArray()

        for (i in words.indices) {
            val word = words[i]
            var reverseWord = ""
            for (j in word.length - 1 downTo 0) {
                reverseWord += word[j]
            }
            reversedStr = "$reversedStr$reverseWord "
        }
        return reversedStr
    }

    /***No.4***/
    private fun initScoreValue() {
        var increase = 0
        for (c in 'a'..'z') {
            increase++
            hashMap[c.toString()] = increase
        }
    }

    private fun getSummaryString(inputString: String): String {
        var sumCharacter: Int
        val splitStringGroup = inputString.split(" ")
        val splitStringCharacterArrayList = ArrayList<List<String>>()
        val sumValueArrayList = ArrayList<Int>()

        splitStringGroup.forEach { str ->
            splitStringCharacterArrayList.add(str.trim().split(""))
        }

        splitStringCharacterArrayList.forEach { strList ->
            sumCharacter = 0
            strList.forEach { wordStr ->
                hashMap.forEach { (key, value) ->
                    if (wordStr == key) {
                        sumCharacter += value
                    }
                }
            }
            sumValueArrayList.add(sumCharacter)
        }
        return getMaxValue(sumValueArrayList)
    }

    private fun getMaxValue(sumValueArrayList: ArrayList<Int>): String {
        val maxValue = sumValueArrayList.sortedDescending().maxBy { it }
        return maxValue.toString()
    }
}