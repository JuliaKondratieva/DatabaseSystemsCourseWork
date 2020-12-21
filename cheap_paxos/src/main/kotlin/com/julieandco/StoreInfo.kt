package com.julieandco

data class StoreInfo (val mainportlist: MutableList<Int> = mutableListOf(8001, 8002, 8003),
                      val auxportlist: MutableList<Int> = mutableListOf(8011, 8012),
                      val quorumsize: Int = 3){
}